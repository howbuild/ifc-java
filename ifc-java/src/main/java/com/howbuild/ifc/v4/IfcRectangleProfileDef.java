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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrectangleprofiledef.htm">IfcRectangleProfileDef</a>
 */
public class IfcRectangleProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure xDim;
    protected IfcPositiveLengthMeasure yDim;

    protected IfcRectangleProfileDef() { initCollections(); }
    /**
     * Constructs IfcRectangleProfileDef with all required attributes.
     */
    public IfcRectangleProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim) {

        super(profileType);
        this.xDim = xDim;
        this.yDim = yDim;
    }
    /**
     * Constructs IfcRectangleProfileDef with required and optional attributes.
     */
    public IfcRectangleProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim) {
        super(profileType,profileName,position);
        this.xDim = xDim;
        this.yDim = yDim;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getXDim() { return this.xDim; }
    public void setXDim(IfcPositiveLengthMeasure value) { this.xDim = value; }
    public IfcPositiveLengthMeasure getYDim() { return this.yDim; }
    public void setYDim(IfcPositiveLengthMeasure value) { this.yDim = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(xDim != null ? StepUtils.toStepValue(xDim) : "$");
		parameters.add(yDim != null ? StepUtils.toStepValue(yDim) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}