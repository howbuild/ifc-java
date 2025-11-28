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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctshapeprofiledef.htm">IfcTShapeProfileDef</a>
 */
public class IfcTShapeProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure depth;
    protected IfcPositiveLengthMeasure flangeWidth;
    protected IfcPositiveLengthMeasure webThickness;
    protected IfcPositiveLengthMeasure flangeThickness;
    protected IfcNonNegativeLengthMeasure filletRadius;
    protected IfcNonNegativeLengthMeasure flangeEdgeRadius;
    protected IfcNonNegativeLengthMeasure webEdgeRadius;
    protected IfcPlaneAngleMeasure webSlope;
    protected IfcPlaneAngleMeasure flangeSlope;

    protected IfcTShapeProfileDef() { initCollections(); }
    /**
     * Constructs IfcTShapeProfileDef with all required attributes.
     */
    public IfcTShapeProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure flangeWidth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure flangeThickness) {

        super(profileType);
        this.depth = depth;
        this.flangeWidth = flangeWidth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
    }
    /**
     * Constructs IfcTShapeProfileDef with required and optional attributes.
     */
    public IfcTShapeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure flangeWidth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure flangeThickness,IfcNonNegativeLengthMeasure filletRadius,IfcNonNegativeLengthMeasure flangeEdgeRadius,IfcNonNegativeLengthMeasure webEdgeRadius,IfcPlaneAngleMeasure webSlope,IfcPlaneAngleMeasure flangeSlope) {
        super(profileType,profileName,position);
        this.depth = depth;
        this.flangeWidth = flangeWidth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
        this.filletRadius = filletRadius;
        this.flangeEdgeRadius = flangeEdgeRadius;
        this.webEdgeRadius = webEdgeRadius;
        this.webSlope = webSlope;
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
    public IfcNonNegativeLengthMeasure getFlangeEdgeRadius() { return this.flangeEdgeRadius; }
    public void setFlangeEdgeRadius(IfcNonNegativeLengthMeasure value) { this.flangeEdgeRadius = value; } // optional
    public IfcNonNegativeLengthMeasure getWebEdgeRadius() { return this.webEdgeRadius; }
    public void setWebEdgeRadius(IfcNonNegativeLengthMeasure value) { this.webEdgeRadius = value; } // optional
    public IfcPlaneAngleMeasure getWebSlope() { return this.webSlope; }
    public void setWebSlope(IfcPlaneAngleMeasure value) { this.webSlope = value; } // optional
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
		parameters.add(flangeEdgeRadius != null ? StepUtils.toStepValue(flangeEdgeRadius) : "$");
		parameters.add(webEdgeRadius != null ? StepUtils.toStepValue(webEdgeRadius) : "$");
		parameters.add(webSlope != null ? StepUtils.toStepValue(webSlope) : "$");
		parameters.add(flangeSlope != null ? StepUtils.toStepValue(flangeSlope) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}