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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcushapeprofiledef.htm">IfcUShapeProfileDef</a>
 */
public class IfcUShapeProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure depth;
    protected IfcPositiveLengthMeasure flangeWidth;
    protected IfcPositiveLengthMeasure webThickness;
    protected IfcPositiveLengthMeasure flangeThickness;
    protected IfcNonNegativeLengthMeasure filletRadius;
    protected IfcNonNegativeLengthMeasure edgeRadius;
    protected IfcPlaneAngleMeasure flangeSlope;

    protected IfcUShapeProfileDef() { initCollections(); }
    /**
     * Constructs IfcUShapeProfileDef with all required attributes.
     */
    public IfcUShapeProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure flangeWidth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure flangeThickness) {

        super(profileType);
        this.depth = depth;
        this.flangeWidth = flangeWidth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
    }
    /**
     * Constructs IfcUShapeProfileDef with required and optional attributes.
     */
    public IfcUShapeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure flangeWidth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure flangeThickness,IfcNonNegativeLengthMeasure filletRadius,IfcNonNegativeLengthMeasure edgeRadius,IfcPlaneAngleMeasure flangeSlope) {
        super(profileType,profileName,position);
        this.depth = depth;
        this.flangeWidth = flangeWidth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
        this.filletRadius = filletRadius;
        this.edgeRadius = edgeRadius;
        this.flangeSlope = flangeSlope;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getDepth() { return this.depth; }
    public void setDepth(IfcPositiveLengthMeasure value) { this.depth = value; }
    public IfcPositiveLengthMeasure getFlangeWidth() { return this.flangeWidth; }
    public void setFlangeWidth(IfcPositiveLengthMeasure value) { this.flangeWidth = value; }
    public IfcPositiveLengthMeasure getWebThickness() { return this.webThickness; }
    public void setWebThickness(IfcPositiveLengthMeasure value) { this.webThickness = value; }
    public IfcPositiveLengthMeasure getFlangeThickness() { return this.flangeThickness; }
    public void setFlangeThickness(IfcPositiveLengthMeasure value) { this.flangeThickness = value; }
    public IfcNonNegativeLengthMeasure getFilletRadius() { return this.filletRadius; }
    public void setFilletRadius(IfcNonNegativeLengthMeasure value) { this.filletRadius = value; } // optional
    public IfcNonNegativeLengthMeasure getEdgeRadius() { return this.edgeRadius; }
    public void setEdgeRadius(IfcNonNegativeLengthMeasure value) { this.edgeRadius = value; } // optional
    public IfcPlaneAngleMeasure getFlangeSlope() { return this.flangeSlope; }
    public void setFlangeSlope(IfcPlaneAngleMeasure value) { this.flangeSlope = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(depth != null ? StepUtils.toStepValue(depth) : "$");
		parameters.add(flangeWidth != null ? StepUtils.toStepValue(flangeWidth) : "$");
		parameters.add(webThickness != null ? StepUtils.toStepValue(webThickness) : "$");
		parameters.add(flangeThickness != null ? StepUtils.toStepValue(flangeThickness) : "$");
		parameters.add(filletRadius != null ? StepUtils.toStepValue(filletRadius) : "$");
		parameters.add(edgeRadius != null ? StepUtils.toStepValue(edgeRadius) : "$");
		parameters.add(flangeSlope != null ? StepUtils.toStepValue(flangeSlope) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}