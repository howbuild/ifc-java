package com.howbuild.ifc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.howbuild.ifc.v4.IfcLogicalValue;
import com.howbuild.ifc.v4.StepUtils;
import org.junit.jupiter.api.Test;

class StepUtilsTest {

  @Test
  void logicalUnknownToStep() {
    assertEquals(".U.", StepUtils.toStepValue(IfcLogicalValue.UNKNOWN));
    assertEquals(".T.", StepUtils.toStepValue(IfcLogicalValue.TRUE));
    assertEquals(".F.", StepUtils.toStepValue(IfcLogicalValue.FALSE));
  }

  @Test
  void doubleFormattingKeepsDecimalForIntLike() {
    assertEquals("1.0", StepUtils.toStepValue(1.0));
    assertEquals("1.25", StepUtils.toStepValue(1.25));
  }

  @Test
  void nonFiniteThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> StepUtils.toStepValue(Double.POSITIVE_INFINITY));
    assertThrows(IllegalArgumentException.class, () -> StepUtils.toStepValue(Double.NaN));
  }
}
