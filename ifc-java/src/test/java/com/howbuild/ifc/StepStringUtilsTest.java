package com.howbuild.ifc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.howbuild.ifc.v4.StepStringUtils;
import org.junit.jupiter.api.Test;

class StepStringUtilsTest {

  @Test
  void encodeAsciiQuotesEscaped() {
    String encoded = StepStringUtils.encode("ABC'123");
    assertEquals("'ABC''123'", encoded);
    assertEquals("ABC'123", StepStringUtils.decode(encoded));
  }

  @Test
  void encodeNonAsciiUsesX2() {
    String src = "한글A";
    String encoded = StepStringUtils.encode(src);
    assertTrue(encoded.contains("\\X2\\"), "should wrap non-ascii in \\X2\\");
    assertEquals(src, StepStringUtils.decode(encoded));
  }

  @Test
  void roundTripMixed() {
    String src = "친환경수성페인트 | 내천장,몰탈,CON'C면 | M2";
    String encoded = StepStringUtils.encode(src);
    String decoded = StepStringUtils.decode(encoded).replace("''", "'");
    assertEquals(src, decoded);
  }
}
