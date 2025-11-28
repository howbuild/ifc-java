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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccenterlineprofiledef.htm">IfcCenterLineProfileDef</a>
 */
public class IfcCenterLineProfileDef extends IfcArbitraryOpenProfileDef {
    protected IfcPositiveLengthMeasure thickness;

    protected IfcCenterLineProfileDef() { initCollections(); }
    /**
     * Constructs IfcCenterLineProfileDef with all required attributes.
     */
    public IfcCenterLineProfileDef(IfcProfileTypeEnum profileType,IfcBoundedCurve curve,IfcPositiveLengthMeasure thickness) {

        super(profileType,curve);
        this.thickness = thickness;
    }
    /**
     * Constructs IfcCenterLineProfileDef with required and optional attributes.
     */
    public IfcCenterLineProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcBoundedCurve curve,IfcPositiveLengthMeasure thickness) {
        super(profileType,profileName,curve);
        this.thickness = thickness;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getThickness() { return this.thickness; }
    public void setThickness(IfcPositiveLengthMeasure value) { this.thickness = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(curve != null ? StepUtils.toStepValue(curve) : "$");
		parameters.add(thickness != null ? StepUtils.toStepValue(thickness) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}