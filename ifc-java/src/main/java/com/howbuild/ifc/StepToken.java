package com.howbuild.ifc;

public class StepToken {
  private final StepTokenType type;
  private final String name;
  private final Object literal;

  public StepToken(StepTokenType type) {
    this.type = type;
    this.name = null;
    this.literal = null;
  }

  public StepToken(StepTokenType type, Object literal) {
    this.type = type;
    this.literal = literal;
    this.name = null;
  }

  public StepToken(StepTokenType type, String name, Object literal) {
    this.type = type;
    this.name = name;
    this.literal = literal;
  }

  public StepTokenType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Object getLiteral() {
    return literal;
  }
}
