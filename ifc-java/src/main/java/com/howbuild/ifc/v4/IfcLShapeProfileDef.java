package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLShapeProfileDef
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * Depth : IfcPositiveLengthMeasure;
 * Width : OPTIONAL IfcPositiveLengthMeasure;
 * Thickness : IfcPositiveLengthMeasure;
 * FilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * EdgeRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * LegSlope : OPTIONAL IfcPlaneAngleMeasure;
 * WHERE
 * ValidThickness : (Thickness < Depth) AND (NOT(EXISTS(Width)) OR (Thickness < Width));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclshapeprofiledef.htm">IfcLShapeProfileDef</a>
 */
public class IfcLShapeProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure depth;
    protected IfcPositiveLengthMeasure width;
    protected IfcPositiveLengthMeasure thickness;
    protected IfcNonNegativeLengthMeasure filletRadius;
    protected IfcNonNegativeLengthMeasure edgeRadius;
    protected IfcPlaneAngleMeasure legSlope;

    protected IfcLShapeProfileDef() { initCollections(); }
    /**
     * Constructs IfcLShapeProfileDef with all required attributes.
     */
    public IfcLShapeProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure thickness) {

        super(profileType);
        this.depth = depth;
        this.thickness = thickness;
    }
    /**
     * Constructs IfcLShapeProfileDef with required and optional attributes.
     */
    public IfcLShapeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure width,IfcPositiveLengthMeasure thickness,IfcNonNegativeLengthMeasure filletRadius,IfcNonNegativeLengthMeasure edgeRadius,IfcPlaneAngleMeasure legSlope) {
        super(profileType,profileName,position);
        this.depth = depth;
        this.width = width;
        this.thickness = thickness;
        this.filletRadius = filletRadius;
        this.edgeRadius = edgeRadius;
        this.legSlope = legSlope;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getDepth() { return this.depth; }
    public void setDepth(IfcPositiveLengthMeasure value) { this.depth = value; }
    public IfcPositiveLengthMeasure getWidth() { return this.width; }
    public void setWidth(IfcPositiveLengthMeasure value) { this.width = value; } // optional
    public IfcPositiveLengthMeasure getThickness() { return this.thickness; }
    public void setThickness(IfcPositiveLengthMeasure value) { this.thickness = value; }
    public IfcNonNegativeLengthMeasure getFilletRadius() { return this.filletRadius; }
    public void setFilletRadius(IfcNonNegativeLengthMeasure value) { this.filletRadius = value; } // optional
    public IfcNonNegativeLengthMeasure getEdgeRadius() { return this.edgeRadius; }
    public void setEdgeRadius(IfcNonNegativeLengthMeasure value) { this.edgeRadius = value; } // optional
    public IfcPlaneAngleMeasure getLegSlope() { return this.legSlope; }
    public void setLegSlope(IfcPlaneAngleMeasure value) { this.legSlope = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(depth != null ? StepUtils.toStepValue(depth) : "$");
		parameters.add(width != null ? StepUtils.toStepValue(width) : "$");
		parameters.add(thickness != null ? StepUtils.toStepValue(thickness) : "$");
		parameters.add(filletRadius != null ? StepUtils.toStepValue(filletRadius) : "$");
		parameters.add(edgeRadius != null ? StepUtils.toStepValue(edgeRadius) : "$");
		parameters.add(legSlope != null ? StepUtils.toStepValue(legSlope) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}