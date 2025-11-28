#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
Usage: release-ifc-java.sh [--version <x.y.z>]

Options:
  --version <v>  Override project version for this build (runs mvn versions:set).
  -h        Show this help.

Env:
  GPG_KEY_ID          Required. GPG key ID to sign artifacts.
  GPG_PASSPHRASE      Optional. Passphrase for the key (loopback pinentry).

Result:
  - Bundle: target/central-publishing/central-bundle.zip (root project)
  - No upload/publish is performed. Use Central Portal to upload the bundle manually.
EOF
}

while [[ $# -gt 0 ]]; do
  case "$1" in
    --version)
      shift
      [[ $# -gt 0 ]] || { echo "--version requires a value" >&2; exit 1; }
      NEW_VERSION="$1"
      ;;
    -h|--help) usage; exit 0 ;;
    *) echo "Unknown option: $1" >&2; usage; exit 1 ;;
  esac
  shift
done

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT_DIR"

command -v mvn >/dev/null 2>&1 || { echo "mvn not found" >&2; exit 1; }
command -v gpg >/dev/null 2>&1 || { echo "gpg not found" >&2; exit 1; }

if [[ -z "${GPG_KEY_ID:-}" ]]; then
  echo "Set GPG_KEY_ID env var." >&2
  exit 1
fi

if [[ -n "${NEW_VERSION:-}" ]]; then
  echo "Setting project version to ${NEW_VERSION}"
  mvn -q versions:set -DnewVersion="${NEW_VERSION}" -DprocessAllModules=true -DgenerateBackupPoms=false
fi

# Resolve version (after optional bump)
PROJECT_VERSION="$(mvn -q -DforceStdout help:evaluate -Dexpression=project.version)"

# Regenerate IFC sources (ifc-type-gen) with tests
mvn -pl ifc-type-gen -am clean package

MAVEN_CMD=(
  mvn
  -pl ifc-java -am
  -Pcentral-release
  -Dgpg.keyname="${GPG_KEY_ID}"
  -Dcentral.skipPublishing=true
  -Dcentral.autoPublish=false
  -Dcentral.waitUntil=validated
  -DaltDeploymentRepository=central::default::file:"$ROOT_DIR/target/central-publishing/repo"
  clean deploy
)

echo "Running: ${MAVEN_CMD[*]}"
"${MAVEN_CMD[@]}"

# Build local repo bundle for Portal upload
echo "Assembling central-bundle.zip..."
STAGE="$ROOT_DIR/target/central-publishing/repo"
rm -rf "$STAGE"
mkdir -p "$STAGE/com/howbuild/ifc-parent/$PROJECT_VERSION" "$STAGE/com/howbuild/ifc-java/$PROJECT_VERSION"

copy_artifacts() {
  local group_path="$1"
  local version="$2"
  local dest="$3"
  local src_base="$HOME/.m2/repository/$group_path/$version"
  for f in "$src_base"/*; do
    case "$f" in
      *.lastUpdated|*_remote.repositories|*maven-metadata*) continue ;;
      *) cp "$f" "$dest"/ ;;
    esac
  done
}

copy_artifacts "com/howbuild/ifc-parent" "$PROJECT_VERSION" "$STAGE/com/howbuild/ifc-parent/$PROJECT_VERSION"
copy_artifacts "com/howbuild/ifc-java"   "$PROJECT_VERSION" "$STAGE/com/howbuild/ifc-java/$PROJECT_VERSION"

# generate md5/sha1 for all files (including .asc)
gen_checksums() {
  local dir="$1"
  find "$dir" -type f ! -name "*.md5" ! -name "*.sha1" | while read -r file; do
    md5 -q "$file" > "${file}.md5"
    shasum -a 1 "$file" | awk '{print $1}' > "${file}.sha1"
  done
}

gen_checksums "$STAGE"

rm -f "$ROOT_DIR/target/central-publishing/central-bundle.zip"
(cd "$ROOT_DIR/target/central-publishing/repo" && zip -rq ../central-bundle.zip .)

echo "Done. Bundle ready at: $ROOT_DIR/target/central-publishing/central-bundle.zip"
