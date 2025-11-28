package com.howbuild.ifc;

import com.howbuild.ifc.v4.BaseIfc;
import com.howbuild.ifc.v4.IfcLabel;
import com.howbuild.ifc.v4.IfcRegistry;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class IfcRegistryTest {
  @Test
  public void test() {
    // sanity: newInstance/populate work for a concrete entity
    BaseIfc org = IfcRegistry.newInstance("IfcOrganization");
    org.setStepId(1);
    IfcRegistry.populate(
        "IfcOrganization",
        org,
        Arrays.asList(null, new IfcLabel("Autodesk Revit 2022 (ENG)"), null, null, null));
  }
}
