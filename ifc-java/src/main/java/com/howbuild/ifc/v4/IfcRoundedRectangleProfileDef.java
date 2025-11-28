package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRectangleProfileDef
 * SUPERTYPE OF (ONEOF
 * (IfcRectangleHollowProfileDef
 * ,IfcRoundedRectangleProfileDef))
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * XDim : IfcPositiveLengthMeasure;
 * YDim : IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcroundedrectangleprofiledef.htm">IfcRoundedRectangleProfileDef</a>
 */
public class IfcRoundedRectangleProfileDef extends IfcRectangleProfileDef {
    protected IfcPositiveLengthMeasure roundingRadius;

    protected IfcRoundedRectangleProfileDef() { initCollections(); }
    /**
     * Constructs IfcRoundedRectangleProfileDef with all required attributes.
     */
    public IfcRoundedRectangleProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim,IfcPositiveLengthMeasure roundingRadius) {

        super(profileType,xDim,yDim);
        this.roundingRadius = roundingRadius;
    }
    /**
     * Constructs IfcRoundedRectangleProfileDef with required and optional attributes.
     */
    public IfcRoundedRectangleProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim,IfcPositiveLengthMeasure roundingRadius) {
        super(profileType,profileName,position,xDim,yDim);
        this.roundingRadius = roundingRadius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getRoundingRadius() { return this.roundingRadius; }
    public void setRoundingRadius(IfcPositiveLengthMeasure value) { this.roundingRadius = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(xDim != null ? StepUtils.toStepValue(xDim) : "$");
		parameters.add(yDim != null ? StepUtils.toStepValue(yDim) : "$");
		parameters.add(roundingRadius != null ? StepUtils.toStepValue(roundingRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}