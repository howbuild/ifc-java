package com.howbuild.ifc.codegen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class JavaLanguageGenerator {
  private final String pkg;
  private Map<String, SelectType> selectData;
  private Map<String, List<String>> inversedSelectData;
  private Map<String, EnumType> enumData;
  private Map<String, WrapperType> wrapperData;
  private Map<String, List<InverseAttr>> inverseAttrs;
  private ExpressListener listener;

  public JavaLanguageGenerator(String pkg) {
    this.pkg = pkg;
  }

  private static <T> List<List<T>> chunk(List<T> items, int size) {
    List<List<T>> out = new ArrayList<>();
    for (int i = 0; i < items.size(); i += size) {
      out.add(items.subList(i, Math.min(items.size(), i + size)));
    }
    return out;
  }

  private static String fieldName(String x) {
    return Character.toLowerCase(x.charAt(0)) + x.substring(1);
  }

  public String getFileExtension() {
    return "java";
  }

  public Map<String, SelectType> getSelectData() {
    return selectData;
  }

  public void setSelectData(Map<String, SelectType> data) {
    this.selectData = data;
  }

  public Map<String, List<String>> getInversedSelectData() {
    return inversedSelectData;
  }

  public void setInversedSelectData(Map<String, List<String>> data) {
    this.inversedSelectData = data;
  }

  public Map<String, EnumType> getEnumData() {
    return enumData;
  }

  public void setEnumData(Map<String, EnumType> data) {
    this.enumData = data;
  }

  public Map<String, WrapperType> getWrapperData() {
    return wrapperData;
  }

  public void setWrapperData(Map<String, WrapperType> data) {
    this.wrapperData = data;
  }

  public Map<String, List<InverseAttr>> getInverseAttrs() {
    return inverseAttrs;
  }

  public void setInverseAttrs(Map<String, List<InverseAttr>> data) {
    this.inverseAttrs = data;
  }

  public ExpressListener getListener() {
    return listener;
  }

  public void setListener(ExpressListener listener) {
    this.listener = listener;
  }

  public String AttributeDataType(boolean isCollection, int rank, String type, boolean isGeneric) {
    if (isCollection) {
      String prefix = "";
      String suffix = "";
      for (int i = 0; i < rank; i++) {
        prefix += "Collection<";
        suffix += ">";
      }
      return prefix + type + suffix;
    }
    if (isGeneric) return "T";
    if ("IfcSiUnitName".equals(type)) return "IfcSIUnitName"; // IFC quirk
    return type;
  }

  public String AttributeFieldString(AttributeData data) {
    if (data.IsDerived) return "";
    return "    protected " + data.getType() + " " + fieldName(data.Name) + ";";
  }

  public String AttributeAccessorString(AttributeData data) {
    List<String> tags = new ArrayList<>();
    if (data.IsOptional) tags.add("optional");
    if (data.IsInverse) tags.add("inverse");
    if (data.IsDerived) {
      return "    public "
          + data.getType()
          + " get"
          + data.Name
          + "() { throw new UnsupportedOperationException(\"Derived property logic has been implemented for "
          + data.Name
          + ".\"); } // derived";
    }
    String comment = tags.isEmpty() ? "" : " // " + String.join(", ", tags);
    return String.join(
        "\n",
        "    public "
            + data.getType()
            + " get"
            + data.Name
            + "() { return this."
            + fieldName(data.Name)
            + "; }",
        "    public void set"
            + data.Name
            + "("
            + data.getType()
            + " value) { this."
            + fieldName(data.Name)
            + " = value; }"
            + comment);
  }

  // Legacy shim; AttributeData.toString delegates here.
  public String AttributeDataString(AttributeData data) {
    return AttributeAccessorString(data);
  }

  public String AttributeStepString(AttributeData data, boolean isDerivedInChild) {
    String step =
        "\t\tparameters.add("
            + fieldName(data.Name)
            + " != null ? StepUtils.toStepValue("
            + fieldName(data.Name)
            + ") : \"$\");";
    if (isDerivedInChild) return "\t\tparameters.add(\"*\");";
    if (data.getType().endsWith("Enum")
        || data.getType().equals("bool")
        || data.getType().equals("int")
        || data.getType().equals("double"))
      step = "\t\tparameters.add(StepUtils.toStepValue(" + fieldName(data.Name) + "));";
    return step;
  }

  public String SimpleTypeString(WrapperType data) {
    String wrapped = WrappedType(data);
    boolean isFloating =
        wrapped.equals("Double")
            || wrapped.equals("Float")
            || wrapped.equals("double")
            || wrapped.equals("float")
            || wrapped.equals("Number");
    boolean isNumberWrapped =
        isFloating
            || wrapped.equals("Long")
            || wrapped.equals("Integer")
            || wrapped.equals("long")
            || wrapped.equals("int");
    String toStringBody;
    if (isFloating) {
      String isCountLike =
          (data.Name.contains("Count")
                  || data.Name.contains("Integer")
                  || data.Name.contains("Number"))
              ? "true"
              : "false";
      toStringBody =
          "        if (this.value == null) return \"$\";\n"
              + "        double d = ((Number) this.value).doubleValue();\n"
              + (isCountLike.equals("true")
                  ? "        if (d == Math.rint(d)) return String.valueOf((long) d);\n"
                  : "")
              + "        return Double.toString(d);";
    } else if (isNumberWrapped) {
      toStringBody = "        return String.valueOf(this.value);";
    } else {
      toStringBody = "        return String.valueOf(this.value);";
    }
    String doc = docBlock(data.Schema, data.Name);
    return String.join(
        "\n",
        pkg,
        "",
        "import java.util.Collection;",
        "import java.util.List;",
        "import java.util.ArrayList;",
        "",
        doc,
        "public class "
            + data.Name
            + " extends BaseIfc "
            + GetSelectImplementsString(data.Name, false, false, true)
            + "{",
        "    protected " + wrapped + " value;",
        "",
        "    public " + wrapped + " getValue() {",
        "        return this.value;",
        "    }",
        "",
        "    public void setValue(Object value){ this.value = (" + wrapped + ") value; }",
        "    public " + data.Name + "(" + wrapped + " value){ this.value = value; }",
        "    public " + data.Name + "() { }",
        "    public void setValue(" + wrapped + " value){ this.value = value; }",
        "",
        "    ",
        "    public String toString(){",
        toStringBody,
        "    }",
        "",
        "    public String toStepValue(boolean isSelectOption){",
        "        if(isSelectOption) {",
        "            return getClass().getSimpleName().toUpperCase() + \"(\" + StepUtils.toStepValue(this.value, isSelectOption) + \")\";",
        "        } else {",
        "            return StepUtils.toStepValue(this.value, isSelectOption);",
        "        }",
        "    }",
        "    public void finalizeRelationships() { /* no inverse relations */ }",
        "}");
  }

  public String EnumTypeString(EnumType data) {
    String doc = docBlock(data.Schema, data.Name);
    return String.join(
        "\n",
        pkg,
        "",
        "import java.util.Collection;",
        "import java.util.HashMap;",
        "import java.util.List;",
        "import java.util.Map;",
        "import java.util.ArrayList;",
        "",
        doc,
        "public enum " + data.Name + " {" + String.join(",", data.Values) + "}");
  }

  public String SelectTypeString(SelectType data) {
    String doc = docBlock(data.Schema, data.Name);
    return String.join(
        "\n",
        pkg,
        "",
        "import java.util.Collection;",
        "import java.util.HashMap;",
        "import java.util.List;",
        "import java.util.Map;",
        "import java.util.ArrayList;",
        "",
        doc,
        "public interface "
            + data.Name
            + " "
            + GetSelectImplementsString(data.Name, true, true, false)
            + "{",
        "}");
  }

  public String EntityString(Entity data) {
    String superName = "BaseIfc";
    if (!data.Supers.isEmpty()) superName = data.Supers.get(0).Name;
    String modifier = data.IsAbstract ? "abstract class" : "class";
    String processRelationship = "";
    String callProcessRelationship = "";
    if (listener.InverseAttrData.containsKey(data.Name)) {
      List<String> attrProcess = new ArrayList<>();
      for (InverseAttr attr : listener.InverseAttrData.get(data.Name)) {
        AttributeData inverseAttrTypeData =
            data.Attributes.stream()
                .filter(x -> x.Name.equals(attr.inverseAttrName))
                .findFirst()
                .orElse(null);
        Entity targetData = (Entity) listener.TypeData.get(attr.entityName);
        AttributeData targetAttrTypeData =
            targetData.Attributes.stream()
                .filter(x -> x.Name.equals(attr.name))
                .findFirst()
                .orElse(null);
        if (inverseAttrTypeData == null || targetAttrTypeData == null) continue;
        if (inverseAttrTypeData.IsCollection) {
          if (targetAttrTypeData.IsCollection) {
            attrProcess.add(
                "if (this."
                    + inverseAttrTypeData.getParameterName()
                    + " != null) {\n"
                    + "    for (Object x : this."
                    + inverseAttrTypeData.getParameterName()
                    + ") {\n"
                    + "        if (x instanceof "
                    + attr.entityName
                    + ")\n"
                    + "            (("
                    + attr.entityName
                    + ")x)."
                    + targetAttrTypeData.getParameterName()
                    + ".add(this);\n"
                    + "    }\n"
                    + "}");
          } else {
            attrProcess.add(
                "if (this."
                    + inverseAttrTypeData.getParameterName()
                    + " != null) {\n"
                    + "    for (Object x : this."
                    + inverseAttrTypeData.getParameterName()
                    + ") {\n"
                    + "        if (x instanceof "
                    + attr.entityName
                    + ")\n"
                    + "            (("
                    + attr.entityName
                    + ")x)."
                    + targetAttrTypeData.getParameterName()
                    + " = this;\n"
                    + "    }\n"
                    + "}");
          }
        } else {
          if (targetAttrTypeData.IsCollection) {
            attrProcess.add(
                "if (this."
                    + inverseAttrTypeData.getParameterName()
                    + " != null) {\n"
                    + "    if (this."
                    + inverseAttrTypeData.getParameterName()
                    + " instanceof "
                    + attr.entityName
                    + ")\n"
                    + "        (("
                    + attr.entityName
                    + ")this."
                    + inverseAttrTypeData.getParameterName()
                    + ")."
                    + targetAttrTypeData.getParameterName()
                    + ".add(this);\n"
                    + "}");
          } else {
            attrProcess.add(
                "if (this."
                    + inverseAttrTypeData.getParameterName()
                    + " != null) {\n"
                    + "    if (this."
                    + inverseAttrTypeData.getParameterName()
                    + " instanceof "
                    + attr.entityName
                    + ")\n"
                    + "        (("
                    + attr.entityName
                    + ")this."
                    + inverseAttrTypeData.getParameterName()
                    + ")."
                    + targetAttrTypeData.getParameterName()
                    + " = this;\n"
                    + "}");
          }
        }
      }
      String allProcessAssignments =
          attrProcess.stream()
              .map(
                  s ->
                      Arrays.stream(s.split("\n"))
                          .map(l -> "\t\t" + l)
                          .collect(Collectors.joining("\n")))
              .collect(Collectors.joining("\n"));
      processRelationship =
          "    private void set"
              + data.Name
              + "Relationship() {\n"
              + allProcessAssignments
              + "\n    }";
      callProcessRelationship = "";
    }
    boolean hasOptionalParents = hasOptionalAttributes(data.ParentsAndSelf());
    String reqParams = ConstructorParams(data, false);
    String optParams = ConstructorParams(data, true);
    String reqBaseParams = BaseConstructorParams(data, false);
    String optBaseParams = BaseConstructorParams(data, true);

    String constructors;
    if (hasOptionalParents) {
      constructors =
          "    /**\n     * Constructs "
              + data.Name
              + " with all required attributes.\n     */\n    public "
              + data.Name
              + "("
              + reqParams
              + ") {\n\n        super("
              + reqBaseParams
              + ");\n"
              + Allocations(data, true)
              + Assignments(data, false)
              + (reqParams.isEmpty() ? "        initCollections();\n" : "")
              + "    }\n"
              + "    /**\n     * Constructs "
              + data.Name
              + " with required and optional attributes.\n     */\n    public "
              + data.Name
              + "("
              + optParams
              + ") {\n        super("
              + optBaseParams
              + ");\n"
              + Allocations(data, false)
              + Assignments(data, true)
              + (optParams.isEmpty() ? "        initCollections();\n" : "")
              + "    }";
    } else {
      constructors =
          "    /**\n     * Constructs "
              + data.Name
              + " with all required attributes.\n     */\n    public "
              + data.Name
              + "("
              + reqParams
              + ") {\n        super("
              + reqBaseParams
              + ");\n"
              + Allocations(data, true)
              + Assignments(data, false)
              + (reqParams.isEmpty() ? "        initCollections();\n" : "")
              + "    }";
    }

    // Two-phase support helpers
    List<AttributeData> stepAttrs = StepAttributes(data);

    List<AttributeData> initAttrs =
        data.Attributes.stream()
            .filter(a -> !a.IsDerived)
            .filter(a -> a.IsCollection || a.IsInverse)
            .collect(Collectors.toList());
    StringBuilder initCols = new StringBuilder();
    initCols.append("    private void initCollections() {\n");
    for (AttributeData a : initAttrs) {
      String alloc = Allocation(a);
      if (!alloc.isEmpty()) initCols.append("        ").append(alloc).append("\n");
    }
    initCols.append("    }");

    String finalizeRel;
    if (!processRelationship.isEmpty()) {
      finalizeRel =
          "    @Override public void finalizeRelationships() { this.set"
              + data.Name
              + "Relationship(); }";
    } else {
      finalizeRel = "    // inherits no-op finalizeRelationships from BaseIfc";
    }

    String defaultCtor =
        reqParams.isEmpty() ? "" : "    protected " + data.Name + "() { initCollections(); }";

    String doc = docBlock(data.Schema, data.Name);
    String fields = data.Fields();
    String accessors = data.Accessors();

    String classStr =
        String.join(
            "\n",
            pkg,
            "",
            "import java.util.Collection;",
            "import java.util.HashMap;",
            "import java.util.List;",
            "import java.util.Map;",
            "import java.util.ArrayList;",
            "import java.util.Arrays;",
            "",
            doc,
            "public "
                + modifier
                + " "
                + data.Name
                + " extends "
                + superName
                + " "
                + GetSelectImplementsString(data.Name, false, false, false)
                + "{",
            fields,
            defaultCtor,
            constructors,
            initCols.toString(),
            accessors,
            StepParameters(data),
            finalizeRel,
            processRelationship,
            "}");
    return classStr;
  }

  private String docBlock(String schemaText, String name) {
    StringBuilder sb = new StringBuilder();
    sb.append("/**\n");
    if (schemaText != null && !schemaText.isEmpty()) {
      sb.append(" * <pre>{@code\n");
      for (String line : schemaText.replace("\r", "").split("\n")) {
        String trimmed = line.trim();
        if (trimmed.isEmpty()) continue;
        sb.append(" * ").append(trimmed).append("\n");
      }
      sb.append(" * }</pre>\n");
    }
    sb.append(" *\n");
    sb.append(
            " * @see <a href=\"https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/")
        .append(name.toLowerCase())
        .append(".htm\">")
        .append(name)
        .append("</a>\n");
    sb.append(" */");
    return sb.toString();
  }

  public String ParseSimpleType(com.howbuild.ifc.express.ExpressParser.SimpleTypeContext context) {
    String type = "";
    if (context.binaryType() != null) type = "byte[]";
    else if (context.booleanType() != null) type = "Boolean";
    else if (context.integerType() != null) type = "Long";
    else if (context.logicalType() != null) type = "IfcLogicalValue";
    else if (context.numberType() != null) type = "Double";
    else if (context.realType() != null) type = "Double";
    else if (context.stringType() != null) type = "String";
    return type;
  }

  public void GenerateManifest(
      String directory, Collection<String> names, Map<String, TypeData> types) {
    List<String> ctorLines = new ArrayList<>();
    List<String> populateLines = new ArrayList<>();
    List<String> classLines = new ArrayList<>();
    List<String> metaLines = new ArrayList<>();

    for (String name : names) {
      TypeData td = types.get(name);
      if (td instanceof Entity && !((Entity) td).IsAbstract) {
        Entity ent = (Entity) td;
        List<AttributeData> attrs =
            StepAttributes(ent).stream()
                .filter(a -> !a.IsDerived && !a.IsInverse)
                .collect(Collectors.toList());
        long requiredCount = attrs.stream().filter(a -> !a.IsOptional).count();
        ctorLines.add(
            "        CTORS.put(\"" + name.toUpperCase() + "\", () -> new " + name + "());");

        StringBuilder pop = new StringBuilder();
        pop.append("        POPULATORS.put(\"" + name.toUpperCase() + "\", (obj,args) -> {\n");
        pop.append("            " + name + " t = (" + name + ") obj;\n");
        pop.append("            int argCount = args.size();\n");
        pop.append(
            "            if(argCount < "
                + requiredCount
                + " || argCount > "
                + attrs.size()
                + ") throw new IfcDeserializeException(\"Argument size mismatch for "
                + name
                + "\");\n");
        for (int i = 0; i < attrs.size(); i++) {
          AttributeData a = attrs.get(i);
          pop.append(
              "            Object v"
                  + i
                  + " = argCount > "
                  + i
                  + " ? args.get("
                  + i
                  + ") : null;\n");
          pop.append(
              "            t." + fieldName(a.Name) + " = (" + a.getType() + ") v" + i + ";\n");
        }
        pop.append("            t.finalizeRelationships();\n");
        pop.append("        });");
        populateLines.add(pop.toString());

        StringBuilder meta = new StringBuilder();
        meta.append("        ATTR_META.put(\"")
            .append(name.toUpperCase())
            .append("\", new AttrMeta[]{");
        meta.append(
            attrs.stream()
                .map(
                    a -> {
                      ParsedType pt = parseType(a.getType());
                      return "new AttrMeta(" + pt.base + ".class," + pt.depth + ")";
                    })
                .collect(Collectors.joining(",")));
        meta.append("});");
        metaLines.add(meta.toString());
      } else if (td instanceof WrapperType) {
        WrapperType wt = (WrapperType) td;
        String wrapped = WrappedType(wt);
        ctorLines.add(
            "        CTORS.put(\"" + name.toUpperCase() + "\", () -> new " + name + "());");

        StringBuilder pop = new StringBuilder();
        pop.append("        POPULATORS.put(\"" + name.toUpperCase() + "\", (obj,args) -> {\n");
        pop.append("            " + name + " t = (" + name + ") obj;\n");
        pop.append(
            "            if(args.size() != 1) throw new IfcDeserializeException(\"Argument size mismatch for "
                + name
                + "\");\n");
        pop.append("            Object v0 = args.get(0);\n");
        pop.append("            t.value = (" + wrapped + ") v0;\n");
        pop.append("            t.finalizeRelationships();\n");
        pop.append("        });");
        populateLines.add(pop.toString());

        ParsedType pt = parseType(wrapped);
        metaLines.add(
            "        ATTR_META.put(\""
                + name.toUpperCase()
                + "\", new AttrMeta[]{ new AttrMeta("
                + pt.base
                + ".class,"
                + pt.depth
                + ")});");
      }
    }

    StringBuilder ctorChunks = new StringBuilder();
    StringBuilder popChunks = new StringBuilder();
    StringBuilder classChunks = new StringBuilder();
    StringBuilder metaChunks = new StringBuilder();

    int chunkSize = 120;
    int chunkId = 0;
    for (List<String> chunk : chunk(ctorLines, chunkSize)) {
      ctorChunks.append("    private static void initCtors" + chunkId + "() {\n");
      for (String line : chunk) ctorChunks.append(line).append("\n");
      ctorChunks.append("    }\n");
      chunkId++;
    }
    int ctorChunksCount = chunkId;

    chunkId = 0;
    for (List<String> chunk : chunk(populateLines, chunkSize)) {
      popChunks.append("    private static void initPopulators" + chunkId + "() {\n");
      for (String line : chunk) popChunks.append(line).append("\n");
      popChunks.append("    }\n");
      chunkId++;
    }
    int popChunksCount = chunkId;

    int classChunksCount = 0;

    chunkId = 0;
    for (List<String> chunk : chunk(metaLines, chunkSize)) {
      metaChunks.append("    private static void initMeta" + chunkId + "() {\n");
      for (String line : chunk) metaChunks.append(line).append("\n");
      metaChunks.append("    }\n");
      chunkId++;
    }
    int metaChunksCount = chunkId;

    StringBuilder staticInit = new StringBuilder();
    staticInit.append("    static {\n");
    for (int i = 0; i < ctorChunksCount; i++) staticInit.append("        initCtors" + i + "();\n");
    for (int i = 0; i < popChunksCount; i++)
      staticInit.append("        initPopulators" + i + "();\n");
    for (int i = 0; i < metaChunksCount; i++) staticInit.append("        initMeta" + i + "();\n");
    staticInit.append("    }\n");

    String classStr =
        String.join(
            "\n",
            pkg,
            "",
            "import com.howbuild.ifc.IfcDeserializeException;",
            "import com.howbuild.ifc.v4.*;",
            "import java.util.List;",
            "import java.util.Collection;",
            "import java.util.Map;",
            "import java.util.HashMap;",
            "import java.util.function.Supplier;",
            "",
            "public class IfcRegistry {",
            "    @FunctionalInterface interface Populator { void apply(BaseIfc obj, List<Object> args); }",
            "    public static class AttrMeta { public final Class<?> base; public final int depth; public AttrMeta(Class<?> b, int d){ base=b; depth=d; } }",
            "",
            "    private static final Map<String, Supplier<BaseIfc>> CTORS = new HashMap<>();",
            "    private static final Map<String, Populator> POPULATORS = new HashMap<>();",
            "    private static final Map<String, AttrMeta[]> ATTR_META = new HashMap<>();",
            staticInit.toString(),
            ctorChunks.toString(),
            popChunks.toString(),
            metaChunks.toString(),
            "",
            "    public static BaseIfc newInstance(String className) {",
            "        Supplier<BaseIfc> s = CTORS.get(className.toUpperCase());",
            "        return s != null ? s.get() : null;",
            "    }",
            "",
            "    public static AttrMeta[] getAttrMeta(String className) { return ATTR_META.get(className.toUpperCase()); }",
            "",
            "    public static void populate(String className, BaseIfc obj, List<Object> args) {",
            "        Populator p = POPULATORS.get(className.toUpperCase());",
            "        if (p == null) throw new IfcDeserializeException(\"Unknown entity \" + className);",
            "        p.apply(obj, args);",
            "    }",
            "}");
    writeFile(Paths.get(directory, "IfcRegistry.java"), classStr);
  }

  // Helpers
  private boolean hasOptionalAttributes(Iterable<Entity> entities) {
    for (Entity e : entities) {
      for (AttributeData a : e.Attributes) {
        if (a.IsOptional && !a.IsInverse && !a.IsDerived) return true;
      }
    }
    return false;
  }

  private String Assignments(Entity entity, boolean includeOptional) {
    List<AttributeData> attrs =
        includeOptional
            ? AttributesWithOptional(entity.Attributes)
            : AttributesWithoutOptional(entity.Attributes);
    if (attrs.isEmpty()) return "";
    StringBuilder sb = new StringBuilder();
    for (AttributeData a : attrs) sb.append("        ").append(Assignment(a)).append("\n");
    return sb.toString();
  }

  private String Allocations(Entity entity, boolean includeOptional) {
    StringBuilder sb = new StringBuilder();
    List<AttributeData> attrs =
        entity.Attributes.stream()
            .filter(a -> !a.IsDerived)
            .filter(a -> a.IsInverse || (includeOptional && a.IsOptional))
            .collect(Collectors.toList());
    for (AttributeData a : attrs) {
      String alloc = Allocation(a);
      if (!alloc.isEmpty()) sb.append("        ").append(alloc).append("\n");
    }
    return sb.toString();
  }

  private String Assignment(AttributeData data) {
    return "this." + fieldName(data.Name) + " = " + data.getParameterName() + ";";
  }

  private String Allocation(AttributeData data) {
    if (data.IsCollection) {
      String dataType = data.getType();
      if (dataType.startsWith("Collection")) dataType = "ArrayList<>";
      return "this." + fieldName(data.Name) + " = new " + dataType + "();";
    }
    return "";
  }

  private String ConstructorParams(Entity data, boolean includeOptional) {
    return EntityConstructorParams(data, includeOptional);
  }

  private String BaseConstructorParams(Entity data, boolean includeOptional) {
    return EntityBaseConstructorParams(data, includeOptional);
  }

  private String StepParameters(Entity data) {
    if (data.IsAbstract) return "";
    return "    \n    public String getStepParameters() {\n        List<String> parameters = new ArrayList<>();\n"
        + data.StepProperties()
        + "        return String.join(\"\", parameters);\n    }";
  }

  private List<AttributeData> StepAttributes(Entity data) {
    List<AttributeData> attrs = new ArrayList<>();
    for (Entity e : data.ParentsAndSelf()) {
      for (AttributeData a : e.Attributes) {
        if (!a.IsInverse && !a.IsDerived) attrs.add(a);
      }
    }
    return attrs;
  }

  List<AttributeData> AttributesWithOptional(Collection<AttributeData> ads) {
    return ads.stream()
        .filter(a -> !a.IsInverse)
        .filter(a -> !a.IsDerived)
        .collect(Collectors.toList());
  }

  List<AttributeData> AttributesWithoutOptional(Collection<AttributeData> ads) {
    return ads.stream()
        .filter(a -> !a.IsInverse)
        .filter(a -> !a.IsDerived)
        .filter(a -> !a.IsOptional)
        .collect(Collectors.toList());
  }

  private List<String> EntityConstructorTypes(Entity data, boolean includeOptional) {
    List<AttributeData> attrs = new ArrayList<>();
    for (Entity e : data.ParentsAndSelf()) {
      for (AttributeData a : e.Attributes) attrs.add(a);
    }
    List<AttributeData> valid =
        includeOptional ? AttributesWithOptional(attrs) : AttributesWithoutOptional(attrs);
    return valid.stream().map(AttributeData::getType).collect(Collectors.toList());
  }

  private String EntityConstructorParams(Entity data, boolean includeOptional) {
    List<AttributeData> attrs = new ArrayList<>();
    for (Entity e : data.ParentsAndSelf()) for (AttributeData a : e.Attributes) attrs.add(a);
    List<AttributeData> valid =
        includeOptional ? AttributesWithOptional(attrs) : AttributesWithoutOptional(attrs);
    return valid.stream()
        .map(a -> a.getType() + " " + a.getParameterName())
        .collect(Collectors.joining(","));
  }

  private String EntityBaseConstructorParams(Entity data, boolean includeOptional) {
    List<AttributeData> attrs = new ArrayList<>();
    for (Entity e : data.Parents()) for (AttributeData a : e.Attributes) attrs.add(a);
    List<AttributeData> valid =
        includeOptional ? AttributesWithOptional(attrs) : AttributesWithoutOptional(attrs);
    return valid.stream().map(AttributeData::getParameterName).collect(Collectors.joining(","));
  }

  private String GetSelectImplementsString(
      String type, boolean isInterface, boolean isSelect, boolean isWrapped) {
    List<String> interfaces = inversedSelectData.getOrDefault(type, new ArrayList<>());
    interfaces = new ArrayList<>(interfaces); // copy
    if (isSelect) {
      interfaces.add("Select");
      interfaces.add("ConvertibleToStep");
    }
    if (isWrapped) interfaces.add("SimpleType");
    if (interfaces == null || interfaces.isEmpty()) return "";
    if (isInterface) return "extends " + String.join(", ", interfaces) + " ";
    return "implements " + String.join(", ", interfaces) + " ";
  }

  private String WrappedType(WrapperType data) {
    if (data.IsCollectionType) {
      String prefix = "", suffix = "";
      for (int i = 0; i < data.Rank; i++) {
        prefix += "Collection<";
        suffix += ">";
      }
      return prefix + data.WrappedType + suffix;
    }
    return data.WrappedType;
  }

  private void writeFile(Path path, String content) {
    try {
      Files.createDirectories(path.getParent());
      Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private ParsedType parseType(String type) {
    int depth = 0;
    String t = type.trim();
    while (t.contains("Collection<")) {
      int idx = t.indexOf("Collection<");
      String inner = t.substring(idx + "Collection<".length());
      if (inner.endsWith(">")) inner = inner.substring(0, inner.length() - 1);
      t = inner.trim();
      depth++;
    }
    ParsedType pt = new ParsedType();
    pt.base = t;
    pt.depth = depth;
    return pt;
  }

  private static class ParsedType {
    String base;
    int depth;
  }
}
