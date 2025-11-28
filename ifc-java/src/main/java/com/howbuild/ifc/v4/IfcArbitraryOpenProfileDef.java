package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcArbitraryOpenProfileDef
 * SUPERTYPE OF (ONEOF
 * (IfcCenterLineProfileDef))
 * SUBTYPE OF (IfcProfileDef);
 * Curve : IfcBoundedCurve;
 * WHERE
 * WR11 : ('IFC4.IFCCENTERLINEPROFILEDEF' IN TYPEOF(SELF)) OR
 * (SELF\IfcProfileDef.ProfileType = IfcProfileTypeEnum.CURVE);
 * WR12 : Curve.Dim = 2;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcarbitraryopenprofiledef.htm">IfcArbitraryOpenProfileDef</a>
 */
public class IfcArbitraryOpenProfileDef extends IfcProfileDef {
    protected IfcBoundedCurve curve;

    protected IfcArbitraryOpenProfileDef() { initCollections(); }
    /**
     * Constructs IfcArbitraryOpenProfileDef with all required attributes.
     */
    public IfcArbitraryOpenProfileDef(IfcProfileTypeEnum profileType,IfcBoundedCurve curve) {

        super(profileType);
        this.curve = curve;
    }
    /**
     * Constructs IfcArbitraryOpenProfileDef with required and optional attributes.
     */
    public IfcArbitraryOpenProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcBoundedCurve curve) {
        super(profileType,profileName);
        this.curve = curve;
    }
    private void initCollections() {
    }
    public IfcBoundedCurve getCurve() { return this.curve; }
    public void setCurve(IfcBoundedCurve value) { this.curve = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(curve != null ? StepUtils.toStepValue(curve) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}