package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcParameterizedProfileDef
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcAsymmetricIShapeProfileDef
 * ,IfcCShapeProfileDef
 * ,IfcCircleProfileDef
 * ,IfcEllipseProfileDef
 * ,IfcIShapeProfileDef
 * ,IfcLShapeProfileDef
 * ,IfcRectangleProfileDef
 * ,IfcTShapeProfileDef
 * ,IfcTrapeziumProfileDef
 * ,IfcUShapeProfileDef
 * ,IfcZShapeProfileDef))
 * SUBTYPE OF (IfcProfileDef);
 * Position : OPTIONAL IfcAxis2Placement2D;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctrapeziumprofiledef.htm">IfcTrapeziumProfileDef</a>
 */
public class IfcTrapeziumProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure bottomXDim;
    protected IfcPositiveLengthMeasure topXDim;
    protected IfcPositiveLengthMeasure yDim;
    protected IfcLengthMeasure topXOffset;

    protected IfcTrapeziumProfileDef() { initCollections(); }
    /**
     * Constructs IfcTrapeziumProfileDef with all required attributes.
     */
    public IfcTrapeziumProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure bottomXDim,IfcPositiveLengthMeasure topXDim,IfcPositiveLengthMeasure yDim,IfcLengthMeasure topXOffset) {

        super(profileType);
        this.bottomXDim = bottomXDim;
        this.topXDim = topXDim;
        this.yDim = yDim;
        this.topXOffset = topXOffset;
    }
    /**
     * Constructs IfcTrapeziumProfileDef with required and optional attributes.
     */
    public IfcTrapeziumProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure bottomXDim,IfcPositiveLengthMeasure topXDim,IfcPositiveLengthMeasure yDim,IfcLengthMeasure topXOffset) {
        super(profileType,profileName,position);
        this.bottomXDim = bottomXDim;
        this.topXDim = topXDim;
        this.yDim = yDim;
        this.topXOffset = topXOffset;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getBottomXDim() { return this.bottomXDim; }
    public void setBottomXDim(IfcPositiveLengthMeasure value) { this.bottomXDim = value; }
    public IfcPositiveLengthMeasure getTopXDim() { return this.topXDim; }
    public void setTopXDim(IfcPositiveLengthMeasure value) { this.topXDim = value; }
    public IfcPositiveLengthMeasure getYDim() { return this.yDim; }
    public void setYDim(IfcPositiveLengthMeasure value) { this.yDim = value; }
    public IfcLengthMeasure getTopXOffset() { return this.topXOffset; }
    public void setTopXOffset(IfcLengthMeasure value) { this.topXOffset = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(bottomXDim != null ? StepUtils.toStepValue(bottomXDim) : "$");
		parameters.add(topXDim != null ? StepUtils.toStepValue(topXDim) : "$");
		parameters.add(yDim != null ? StepUtils.toStepValue(yDim) : "$");
		parameters.add(topXOffset != null ? StepUtils.toStepValue(topXOffset) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}