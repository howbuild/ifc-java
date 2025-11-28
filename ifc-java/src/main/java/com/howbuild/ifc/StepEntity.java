package com.howbuild.ifc;

import java.util.List;

public class StepEntity {
  private final String name;
  private final List<StepToken> args;

  public StepEntity(String name, List<StepToken> args) {
    this.name = name;
    this.args = args;
  }

  public String getName() {
    return name;
  }

  public List<StepToken> getArgs() {
    return args;
  }
}
