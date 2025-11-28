package com.howbuild.ifc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class StepParserTest {
  @Test
  void testFileSchema() {
    StepEntity entity = StepParser.parse("FILE_SCHEMA(('IFC4'))");
    assertEquals("FILE_SCHEMA", entity.getName());
    assertEquals(1, entity.getArgs().size());
    assertEquals(StepTokenType.SET, entity.getArgs().get(0).getType());
    List<StepToken> t1x = (List<StepToken>) entity.getArgs().get(0).getLiteral();
    assertEquals(1, t1x.size());
    assertEquals("IFC4", t1x.get(0).getLiteral());
  }

  @Test
  void testEncodingString() {
    StepEntity e =
        StepParser.parse(
            "IFCPROPERTYSINGLEVALUE('Material-02',$,IFCTEXT('\\X2\\CE5CD658ACBDC218C131D398C778D2B8\\X0\\ | \\X2\\B0B4CC9CC7A5\\X0\\,\\X2\\BAB0D0C8\\X0\\,CON''C\\X2\\BA74\\X0\\ | M2'),$);");
    assertEquals("IFCPROPERTYSINGLEVALUE", e.getName());
    assertEquals(4, e.getArgs().size());
    assertEquals(StepTokenType.STRING, e.getArgs().get(0).getType());
    assertEquals("Material-02", e.getArgs().get(0).getLiteral());
    assertEquals(StepTokenType.EMPTY, e.getArgs().get(1).getType());
    assertEquals(StepTokenType.ENTITY, e.getArgs().get(2).getType());
    assertEquals("IFCTEXT", e.getArgs().get(2).getName());
    List<StepToken> ifcText = (List<StepToken>) e.getArgs().get(2).getLiteral();
    assertEquals(1, ifcText.size());
    assertEquals(StepTokenType.STRING, ifcText.get(0).getType());
    assertEquals("친환경수성페인트 | 내천장,몰탈,CON'C면 | M2", ifcText.get(0).getLiteral());
  }

  @Test
  void testQuote() {
    String x =
        "\\X2\\CE5CD658ACBDC218C131D398C778D2B8\\X0\\ | \\X2\\B0B4CC9CC7A5\\X0\\,\\X2\\BAB0D0C8\\X0\\,CON''C\\X2\\BA74\\X0\\ | M2";
    StringDecoder decoder = new StringDecoder(x);
    String decoded = decoder.decode();
    assertEquals("친환경수성페인트 | 내천장,몰탈,CON'C면 | M2", decoded);
  }

  @Test
  void testEncodingString2() {
    StepEntity e = StepParser.parse("IFCORGANIZATION($,'','',$,$);");
    assertEquals("IFCORGANIZATION", e.getName());
    assertEquals(5, e.getArgs().size());
    assertEquals(StepTokenType.EMPTY, e.getArgs().get(0).getType());
    assertEquals(StepTokenType.STRING, e.getArgs().get(1).getType());
    assertEquals("", e.getArgs().get(1).getLiteral());
    assertEquals(StepTokenType.STRING, e.getArgs().get(2).getType());
    assertEquals("", e.getArgs().get(2).getLiteral());
    assertEquals(StepTokenType.EMPTY, e.getArgs().get(3).getType());
    assertEquals(StepTokenType.EMPTY, e.getArgs().get(4).getType());
  }

  @Test
  void testEnum() {
    StepEntity e = StepParser.parse("IFCSIUNIT(*, .MASSUNIT., .KILO., .GRAM.);");
    assertEquals("IFCSIUNIT", e.getName());
    assertEquals(4, e.getArgs().size());
    assertEquals(StepTokenType.UNKNOWN, e.getArgs().get(0).getType());
    assertEquals(StepTokenType.ENUM, e.getArgs().get(1).getType());
    assertEquals("MASSUNIT", e.getArgs().get(1).getLiteral());
    assertEquals(StepTokenType.ENUM, e.getArgs().get(2).getType());
    assertEquals("KILO", e.getArgs().get(2).getLiteral());
    assertEquals(StepTokenType.ENUM, e.getArgs().get(3).getType());
    assertEquals("GRAM", e.getArgs().get(3).getLiteral());
  }

  @Test
  void testEntity() {
    StepEntity e1 = StepParser.parse("IFCORGANIZATION($,'Autodesk Revit 2022 (ENG)',$,$,$);");
    assertEquals("IFCORGANIZATION", e1.getName());
    assertEquals(5, e1.getArgs().size());
    assertEquals(StepTokenType.EMPTY, e1.getArgs().get(0).getType());
    assertEquals(StepTokenType.STRING, e1.getArgs().get(1).getType());
    assertEquals("Autodesk Revit 2022 (ENG)", e1.getArgs().get(1).getLiteral());
    assertEquals(StepTokenType.EMPTY, e1.getArgs().get(2).getType());
    assertEquals(StepTokenType.EMPTY, e1.getArgs().get(3).getType());
    assertEquals(StepTokenType.EMPTY, e1.getArgs().get(4).getType());
  }

  @Test
  void testEntityRef2() {
    StepEntity e = StepParser.parse("IFCCONVERSIONBASEDUNIT(#49,.PLANEANGLEUNIT.,'DEGREE',#50);");
    System.out.println(e);
  }

  @Test
  void testEntity2() {
    StepEntity e = StepParser.parse("IFCMEASUREWITHUNIT(IFCRATIOMEASURE(0.0174532925199433),#48);");
    System.out.println(e);
  }

  @Test
  void testEntityNumber() {
    StepEntity e =
        StepParser.parse(
            "IFCCARTESIANPOINT(0, .0, 0., 1, 1.2,  1.23e4, 1.2E-2, -2.45E2, 9999999999);");
    assertEquals("IFCCARTESIANPOINT", e.getName());
    assertEquals(9, e.getArgs().size());
    assertEquals(StepTokenType.INTEGER, e.getArgs().get(0).getType());
    assertEquals(0L, e.getArgs().get(0).getLiteral());
    assertEquals(StepTokenType.REAL, e.getArgs().get(1).getType());
    assertEquals(0.0, e.getArgs().get(1).getLiteral());
    assertEquals(StepTokenType.REAL, e.getArgs().get(2).getType());
    assertEquals(0.0, e.getArgs().get(2).getLiteral());
    assertEquals(StepTokenType.INTEGER, e.getArgs().get(3).getType());
    assertEquals(1L, e.getArgs().get(3).getLiteral());
    assertEquals(StepTokenType.REAL, e.getArgs().get(4).getType());
    assertEquals(1.2, e.getArgs().get(4).getLiteral());
    assertEquals(StepTokenType.REAL, e.getArgs().get(5).getType());
    assertEquals(12300.0, e.getArgs().get(5).getLiteral());
    assertEquals(StepTokenType.REAL, e.getArgs().get(6).getType());
    assertEquals(0.012, e.getArgs().get(6).getLiteral());
    assertEquals(StepTokenType.REAL, e.getArgs().get(7).getType());
    assertEquals(-245.0, e.getArgs().get(7).getLiteral());
    assertEquals(StepTokenType.INTEGER, e.getArgs().get(8).getType());
    assertEquals(9999999999L, e.getArgs().get(8).getLiteral());
  }

  @Test
  void testEntityRef() {
    StepEntity e =
        StepParser.parse("IFCAPPLICATION(#1,'2022','Autodesk Revit 2022 (ENG)','Revit');");
    assertEquals("IFCAPPLICATION", e.getName());
    assertEquals(4, e.getArgs().size());
    assertEquals(StepTokenType.REF, e.getArgs().get(0).getType());
    assertEquals(1, e.getArgs().get(0).getLiteral());
    assertEquals(StepTokenType.STRING, e.getArgs().get(1).getType());
    assertEquals("2022", e.getArgs().get(1).getLiteral());
    assertEquals(StepTokenType.STRING, e.getArgs().get(2).getType());
    assertEquals("Autodesk Revit 2022 (ENG)", e.getArgs().get(2).getLiteral());
    assertEquals(StepTokenType.STRING, e.getArgs().get(3).getType());
    assertEquals("Revit", e.getArgs().get(3).getLiteral());
  }

  @Test
  void testFileName() {
    StepEntity entity =
        StepParser.parse(
            "FILE_NAME('0001','2022-12-07T16:23:23',(''),(''),'The EXPRESS Data Manager Version 5.02.0100.07 : 28 Aug 2013','22.0.2.392 - Exporter 22.5.0.0 - Alternate UI 22.5.0.0','');");

    assertEquals("FILE_NAME", entity.getName());
    assertEquals(7, entity.getArgs().size());
    assertEquals(StepTokenType.STRING, entity.getArgs().get(0).getType());
    assertEquals("0001", entity.getArgs().get(0).getLiteral());
    assertEquals(StepTokenType.STRING, entity.getArgs().get(1).getType());
    assertEquals("2022-12-07T16:23:23", entity.getArgs().get(1).getLiteral());
    assertEquals(StepTokenType.SET, entity.getArgs().get(2).getType());
    List<StepToken> t1x = (List<StepToken>) entity.getArgs().get(2).getLiteral();
    assertEquals(1, t1x.size());
    assertEquals("", t1x.get(0).getLiteral());
    assertEquals(StepTokenType.SET, entity.getArgs().get(3).getType());
    t1x = (List<StepToken>) entity.getArgs().get(3).getLiteral();
    assertEquals(1, t1x.size());
    assertEquals("", t1x.get(0).getLiteral());
    assertEquals(StepTokenType.STRING, entity.getArgs().get(4).getType());
    assertEquals(
        "The EXPRESS Data Manager Version 5.02.0100.07 : 28 Aug 2013",
        entity.getArgs().get(4).getLiteral());
    assertEquals(StepTokenType.STRING, entity.getArgs().get(5).getType());
    assertEquals(
        "22.0.2.392 - Exporter 22.5.0.0 - Alternate UI 22.5.0.0",
        entity.getArgs().get(5).getLiteral());
    assertEquals(StepTokenType.STRING, entity.getArgs().get(6).getType());
    assertEquals("", entity.getArgs().get(6).getLiteral());
  }

  @Test
  void testFileDescription() {
    StepEntity entity =
        StepParser.parse("FILE_DESCRIPTION(('ViewDefinition [ReferenceView_V1.2]'),'2;1');");
    assertEquals("FILE_DESCRIPTION", entity.getName());
    StepToken t1 = entity.getArgs().get(0);
    assertEquals(StepTokenType.SET, t1.getType());
    List<StepToken> t1x = (List<StepToken>) entity.getArgs().get(0).getLiteral();
    assertEquals(1, t1x.size());
    assertEquals("ViewDefinition [ReferenceView_V1.2]", t1x.get(0).getLiteral());
    assertEquals(StepTokenType.STRING, entity.getArgs().get(1).getType());
    assertEquals("2;1", entity.getArgs().get(1).getLiteral());
  }

  @Test
  void testLogicalEnumU() {
    StepEntity e = StepParser.parse("DUMMY(.U.);");
    assertEquals(1, e.getArgs().size());
    assertEquals(StepTokenType.LOGICAL, e.getArgs().get(0).getType());
    assertEquals(com.howbuild.ifc.v4.IfcLogicalValue.UNKNOWN, e.getArgs().get(0).getLiteral());
  }

  @Test
  void testNestedSets() {
    StepEntity e = StepParser.parse("DUMMY((1,2),(3,$));");
    assertEquals("DUMMY", e.getName());
    assertEquals(2, e.getArgs().size());
    for (StepToken tok : e.getArgs()) {
      assertEquals(StepTokenType.SET, tok.getType());
    }
    List<StepToken> first = (List<StepToken>) e.getArgs().get(0).getLiteral();
    assertEquals(2, first.size());
    assertEquals(1L, first.get(0).getLiteral());
    assertEquals(2L, first.get(1).getLiteral());
    List<StepToken> second = (List<StepToken>) e.getArgs().get(1).getLiteral();
    assertEquals(2, second.size());
    assertEquals(3L, second.get(0).getLiteral());
    assertEquals(StepTokenType.EMPTY, second.get(1).getType());
  }

  @Test
  void testInlineEntityWithUnicode() {
    StepEntity e = StepParser.parse("WRAPPER(IFCTEXT('\\X2\\AC00\\X0\\'),#1);"); // 가
    assertEquals("WRAPPER", e.getName());
    assertEquals(2, e.getArgs().size());
    assertEquals(StepTokenType.ENTITY, e.getArgs().get(0).getType());
    List<StepToken> inner = (List<StepToken>) e.getArgs().get(0).getLiteral();
    assertEquals(1, inner.size());
    assertEquals("가", inner.get(0).getLiteral());
    assertEquals(StepTokenType.REF, e.getArgs().get(1).getType());
    assertEquals(1, e.getArgs().get(1).getLiteral());
  }
}
