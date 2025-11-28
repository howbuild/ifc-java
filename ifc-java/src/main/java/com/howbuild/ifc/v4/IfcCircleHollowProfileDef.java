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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccirclehollowprofiledef.htm">IfcCircleHollowProfileDef</a>
 */
public class IfcCircleHollowProfileDef extends IfcCircleProfileDef {
    protected IfcPositiveLengthMeasure wallThickness;

    protected IfcCircleHollowProfileDef() { initCollections(); }
    /**
     * Constructs IfcCircleHollowProfileDef with all required attributes.
     */
    public IfcCircleHollowProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure radius,IfcPositiveLengthMeasure wallThickness) {

        super(profileType,radius);
        this.wallThickness = wallThickness;
    }
    /**
     * Constructs IfcCircleHollowProfileDef with required and optional attributes.
     */
    public IfcCircleHollowProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure radius,IfcPositiveLengthMeasure wallThickness) {
        super(profileType,profileName,position,radius);
        this.wallThickness = wallThickness;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getWallThickness() { return this.wallThickness; }
    public void setWallThickness(IfcPositiveLengthMeasure value) { this.wallThickness = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
		parameters.add(wallThickness != null ? StepUtils.toStepValue(wallThickness) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}