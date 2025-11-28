package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCircleHollowProfileDef
 * SUBTYPE OF (IfcCircleProfileDef);
 * WallThickness : IfcPositiveLengthMeasure;
 * WHERE
 * WR1 : WallThickness < SELF\IfcCircleProfileDef.Radius;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccircleprofiledef.htm">IfcCircleProfileDef</a>
 */
public class IfcCircleProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure radius;

    protected IfcCircleProfileDef() { initCollections(); }
    /**
     * Constructs IfcCircleProfileDef with all required attributes.
     */
    public IfcCircleProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure radius) {

        super(profileType);
        this.radius = radius;
    }
    /**
     * Constructs IfcCircleProfileDef with required and optional attributes.
     */
    public IfcCircleProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure radius) {
        super(profileType,profileName,position);
        this.radius = radius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getRadius() { return this.radius; }
    public void setRadius(IfcPositiveLengthMeasure value) { this.radius = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}