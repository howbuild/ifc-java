package com.howbuild.ifc.v4;
public interface ConvertibleToStep {
  String toStepValue(boolean isSelectOption);
  default String toStepValue() {
    return toStepValue(false);
  }
}
