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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcarbitraryprofiledefwithvoids.htm">IfcArbitraryProfileDefWithVoids</a>
 */
public class IfcArbitraryProfileDefWithVoids extends IfcArbitraryClosedProfileDef {
    protected Collection<IfcCurve> innerCurves;

    protected IfcArbitraryProfileDefWithVoids() { initCollections(); }
    /**
     * Constructs IfcArbitraryProfileDefWithVoids with all required attributes.
     */
    public IfcArbitraryProfileDefWithVoids(IfcProfileTypeEnum profileType,IfcCurve outerCurve,Collection<IfcCurve> innerCurves) {

        super(profileType,outerCurve);
        this.innerCurves = innerCurves;
    }
    /**
     * Constructs IfcArbitraryProfileDefWithVoids with required and optional attributes.
     */
    public IfcArbitraryProfileDefWithVoids(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcCurve outerCurve,Collection<IfcCurve> innerCurves) {
        super(profileType,profileName,outerCurve);
        this.innerCurves = innerCurves;
    }
    private void initCollections() {
        this.innerCurves = new ArrayList<>();
    }
    public Collection<IfcCurve> getInnerCurves() { return this.innerCurves; }
    public void setInnerCurves(Collection<IfcCurve> value) { this.innerCurves = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(outerCurve != null ? StepUtils.toStepValue(outerCurve) : "$");
		parameters.add(innerCurves != null ? StepUtils.toStepValue(innerCurves) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}