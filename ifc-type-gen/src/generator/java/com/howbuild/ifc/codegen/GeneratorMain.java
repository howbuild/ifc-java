package com.howbuild.ifc.codegen;

import com.howbuild.ifc.express.ExpressLexer;
import com.howbuild.ifc.express.ExpressParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/** Generator entry-point used from Maven. */
public class GeneratorMain {
  public static void main(String[] args) throws Exception {
    Map<String, String> options = parseArgs(args);
    String schemaPath = options.getOrDefault("schema", "src/main/resources/schemas/IFC4.exp");
    String outDir = options.getOrDefault("out", "target/generated-sources/ifc");
    String pkg = options.getOrDefault("package", "com.howbuild.ifc.v4");

    ensureDir(outDir);

    // Parse EXPRESS schema
    try (InputStream in = Files.newInputStream(Paths.get(schemaPath))) {
      ExpressLexer lexer = new ExpressLexer(CharStreams.fromStream(in));
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      ExpressParser parser = new ExpressParser(tokens);
      parser.setBuildParseTree(true);
      ExpressParser.SchemaDeclContext tree = parser.schemaDecl();

      JavaLanguageGenerator langGen = new JavaLanguageGenerator("package " + pkg + ";");
      JavaFunctionsGenerator funcGen = new JavaFunctionsGenerator("package " + pkg + ";");
      ExpressListener listener = new ExpressListener(langGen);
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, tree);

      Map<String, SelectType> sd =
          listener.TypeData.entrySet().stream()
              .filter(kvp -> kvp.getValue() instanceof SelectType)
              .collect(Collectors.toMap(Map.Entry::getKey, kvp -> (SelectType) kvp.getValue()));
      langGen.setSelectData(sd);

      Map<String, WrapperType> wd =
          listener.TypeData.entrySet().stream()
              .filter(kvp -> kvp.getValue() instanceof WrapperType)
              .collect(Collectors.toMap(Map.Entry::getKey, kvp -> (WrapperType) kvp.getValue()));
      langGen.setWrapperData(wd);

      Map<String, List<String>> inversedSelectData =
          sd.entrySet().stream()
              .flatMap(
                  kvp ->
                      kvp.getValue().Values.stream()
                          .map(v -> new AbstractMap.SimpleEntry<>(v, kvp.getKey())))
              .collect(
                  Collectors.groupingBy(
                      Map.Entry::getKey,
                      Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
      langGen.setInversedSelectData(inversedSelectData);

      Map<String, EnumType> ed =
          listener.TypeData.entrySet().stream()
              .filter(kvp -> kvp.getValue() instanceof EnumType)
              .collect(Collectors.toMap(Map.Entry::getKey, kvp -> (EnumType) kvp.getValue()));
      langGen.setEnumData(ed);

      langGen.setInverseAttrs(listener.InverseAttrData);
      langGen.setListener(listener);

      // Generate code files
      List<String> names = new ArrayList<>();
      for (Map.Entry<String, TypeData> kvp : listener.TypeData.entrySet()) {
        TypeData td = kvp.getValue();
        Path dest =
            Paths.get(outDir, "com/howbuild/ifc/v4", td.Name + "." + langGen.getFileExtension());
        write(dest, td.toString());
        names.add(td.Name);
      }
      // manifest
      langGen.GenerateManifest(
          Paths.get(outDir, "com/howbuild/ifc/v4").toString(), names, listener.TypeData);

      // Functions (optional)
      funcGen.setSelectData(sd);
      String functions = funcGen.Generate(listener.FunctionData.values());
      write(Paths.get(outDir, "com/howbuild/ifc/v4", funcGen.getFileName()), functions);

      // Copy helper templates
      copyTemplates(pkg, outDir);
    }
  }

  private static Map<String, String> parseArgs(String[] args) {
    Map<String, String> map = new HashMap<>();
    for (String arg : args) {
      if (!arg.contains("=")) continue;
      int idx = arg.indexOf('=');
      map.put(arg.substring(0, idx), arg.substring(idx + 1));
    }
    return map;
  }

  private static void ensureDir(String dir) throws IOException {
    Files.createDirectories(Paths.get(dir));
  }

  private static void copyTemplates(String pkg, String outDir) throws IOException {
    String pkgLine = "package " + pkg + ";";
    String[] templates =
        new String[] {
          "BaseIfc.java",
          "ConvertibleToStep.java",
          "Select.java",
          "SimpleType.java",
          "IfcLogicalValue.java",
          "StepUtils.java",
          "StepStringUtils.java",
          "IfcGloballyUniqueIdGenerator.java"
        };
    for (String template : templates) {
      try (InputStream in =
          GeneratorMain.class.getClassLoader().getResourceAsStream("templates/java/" + template)) {
        if (in == null) throw new IOException("Template not found: " + template);
        String content = new String(readAllBytesCompat(in), StandardCharsets.UTF_8);
        if (!content.startsWith("package")) content = pkgLine + "\n" + content;
        Path dest = Paths.get(outDir, "com/howbuild/ifc/v4", template);
        write(dest, content);
      }
    }
  }

  private static void write(Path dest, String content) throws IOException {
    Files.createDirectories(dest.getParent());
    Files.write(dest, content.getBytes(StandardCharsets.UTF_8));
  }

  private static byte[] readAllBytesCompat(InputStream in) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream(Math.max(4096, in.available()));
    byte[] chunk = new byte[8192];
    int n;
    while ((n = in.read(chunk)) != -1) {
      buffer.write(chunk, 0, n);
    }
    return buffer.toByteArray();
  }
}
