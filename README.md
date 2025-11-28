# IFC Toolkit Java

A Java toolkit to parse and work with IFC. The `ifc-java` module provides an IFC4 parser/model runtime; `ifc-type-gen` is an EXPRESS-driven code generator used internally. The API surface is still evolving between snapshots, so breaking changes may occur.

## Modules

- `ifc-java`: Runtime parser/model (Apache-2.0). Maven coordinates (target for publish): `com.howbuild:ifc-java:0.1.1`.
- `ifc-type-gen`: IFC code generator (internal use; not planned for distribution).

## Support Scope

- IFC4 schema–generated model/parser.
- Tests cover IFC4 samples; other versions (e.g., IFC2x3) are not supported/validated yet.
- Geometry/attributes: standard STEP string/ENUM/LOGICAL handling and basic geometry fields (coords, polylines, etc.).
 
## Quickstart (Maven)

```xml
<dependency>
  <groupId>com.howbuild</groupId>
  <artifactId>ifc-java</artifactId>
  <version>0.1.1</version>
</dependency>
```

## Usage (parser)

```java
IfcModel model;
try (InputStream in = new FileInputStream("src/test/resources/ifc/AC20-FZK-Haus.ifc")) {
    model = IfcModel.read(in); 
}

// lookup by STEP id
BaseIfc e1 = model.byId(1);

// list by type
List<BaseIfc> walls = model.byType("IfcWall");

// walk references (breadth-first)
BaseIfc root = model.getEntityById(34); // e.g., IfcBuilding
List<BaseIfc> subgraph = model.traverse(root);

// find by GlobalId (GUID)
BaseIfc found = model.byGuid("28hypXUBvBefc20SI8kfA$");

 // inverse: which entities reference a target
List<BaseIfc> referrers = model.getInverse(root);

// alias: lookup by STEP id
BaseIfc e2 = model.byId(1);
```
