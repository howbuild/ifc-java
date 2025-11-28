package com.howbuild.ifc;

import static org.junit.jupiter.api.Assertions.*;

import com.howbuild.ifc.v4.BaseIfc;
import com.howbuild.ifc.v4.IfcGloballyUniqueId;
import com.howbuild.ifc.v4.IfcProject;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class IfcModelApiTest {
  private static final String ACAD = "src/test/resources/ifc/AC20-FZK-Haus.ifc";

  @Test
  void byGuidAndTraverse() throws Exception {
    IfcModel m = read(ACAD);
    BaseIfc proj = m.byType("IfcProject").get(0);
    IfcGloballyUniqueId gid = ((IfcProject) proj).getGlobalId();
    BaseIfc found = m.byGuid(gid.getValue());
    assertSame(proj, found);

    List<BaseIfc> traversed = m.traverse(proj, 1);
    assertFalse(traversed.isEmpty());
  }

  @Test
  void addAndRemove() throws Exception {
    IfcModel m = read(ACAD);
    int before = m.getEntitiesById().size();
    // create via registry to respect protected ctor
    IfcProject clone = (IfcProject) com.howbuild.ifc.v4.IfcRegistry.newInstance("IFCPROJECT");
    m.add(clone);
    assertEquals(before + 1, m.getEntitiesById().size());
    m.remove(clone);
    assertEquals(before, m.getEntitiesById().size());
  }

  private IfcModel read(String path) throws Exception {
    try (InputStream in = new FileInputStream(path)) {
      return new IfcStepDeserializer().read(in);
    }
  }
}
