package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcArbitraryClosedProfileDef
 * SUPERTYPE OF (ONEOF
 * (IfcArbitraryProfileDefWithVoids))
 * SUBTYPE OF (IfcProfileDef);
 * OuterCurve : IfcCurve;
 * WHERE
 * WR1 : OuterCurve.Dim = 2;
 * WR2 : NOT('IFC4.IFCLINE' IN TYPEOF(OuterCurve));
 * WR3 : NOT('IFC4.IFCOFFSETCURVE2D' IN TYPEOF(OuterCurve));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcarbitraryclosedprofiledef.htm">IfcArbitraryClosedProfileDef</a>
 */
public class IfcArbitraryClosedProfileDef extends IfcProfileDef {
    protected IfcCurve outerCurve;

    protected IfcArbitraryClosedProfileDef() { initCollections(); }
    /**
     * Constructs IfcArbitraryClosedProfileDef with all required attributes.
     */
    public IfcArbitraryClosedProfileDef(IfcProfileTypeEnum profileType,IfcCurve outerCurve) {

        super(profileType);
        this.outerCurve = outerCurve;
    }
    /**
     * Constructs IfcArbitraryClosedProfileDef with required and optional attributes.
     */
    public IfcArbitraryClosedProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcCurve outerCurve) {
        super(profileType,profileName);
        this.outerCurve = outerCurve;
    }
    private void initCollections() {
    }
    public IfcCurve getOuterCurve() { return this.outerCurve; }
    public void setOuterCurve(IfcCurve value) { this.outerCurve = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(outerCurve != null ? StepUtils.toStepValue(outerCurve) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}