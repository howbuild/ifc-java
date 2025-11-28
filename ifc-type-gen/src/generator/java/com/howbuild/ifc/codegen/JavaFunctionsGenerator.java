package com.howbuild.ifc.codegen;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaFunctionsGenerator {
  private final String pkg;
  private Map<String, SelectType> selectData;

  public JavaFunctionsGenerator(String pkg) {
    this.pkg = pkg;
  }

  public String getFileName() {
    return "Functions.java";
  }

  public Map<String, SelectType> getSelectData() {
    return selectData;
  }

  public void setSelectData(Map<String, SelectType> data) {
    this.selectData = data;
  }

  public String Generate(Collection<FunctionData> functionDatas) {
    return pkg
        + "\n\n"
        + "public final class Functions {\n"
        + functionDatas.stream()
            .map(
                f -> {
                  String parameters =
                      f.Parameters.stream()
                          .map(p -> p.getType() + " " + p.getParameterName())
                          .collect(Collectors.joining(","));
                  String generic = f.ReturnType.IsGeneric ? "<T>" : "";
                  return "    public static "
                      + f.ReturnType.getType()
                      + " "
                      + f.Name
                      + generic
                      + "("
                      + parameters
                      + ") {\n"
                      + "        throw new UnsupportedOperationException();\n    }";
                })
            .collect(Collectors.joining("\n"))
        + "\n}";
  }
}
