package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCShapeProfileDef
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * Depth : IfcPositiveLengthMeasure;
 * Width : IfcPositiveLengthMeasure;
 * WallThickness : IfcPositiveLengthMeasure;
 * Girth : IfcPositiveLengthMeasure;
 * InternalFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * WHERE
 * ValidGirth : Girth < (Depth / 2.);
 * ValidInternalFilletRadius : NOT(EXISTS(InternalFilletRadius)) OR
 * ((InternalFilletRadius <= Width/2. - WallThickness) AND (InternalFilletRadius <= Depth/2. - WallThickness));
 * ValidWallThickness : (WallThickness < Width/2.) AND (WallThickness < Depth/2.);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccshapeprofiledef.htm">IfcCShapeProfileDef</a>
 */
public class IfcCShapeProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure depth;
    protected IfcPositiveLengthMeasure width;
    protected IfcPositiveLengthMeasure wallThickness;
    protected IfcPositiveLengthMeasure girth;
    protected IfcNonNegativeLengthMeasure internalFilletRadius;

    protected IfcCShapeProfileDef() { initCollections(); }
    /**
     * Constructs IfcCShapeProfileDef with all required attributes.
     */
    public IfcCShapeProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure width,IfcPositiveLengthMeasure wallThickness,IfcPositiveLengthMeasure girth) {

        super(profileType);
        this.depth = depth;
        this.width = width;
        this.wallThickness = wallThickness;
        this.girth = girth;
    }
    /**
     * Constructs IfcCShapeProfileDef with required and optional attributes.
     */
    public IfcCShapeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure depth,IfcPositiveLengthMeasure width,IfcPositiveLengthMeasure wallThickness,IfcPositiveLengthMeasure girth,IfcNonNegativeLengthMeasure internalFilletRadius) {
        super(profileType,profileName,position);
        this.depth = depth;
        this.width = width;
        this.wallThickness = wallThickness;
        this.girth = girth;
        this.internalFilletRadius = internalFilletRadius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getDepth() { return this.depth; }
    public void setDepth(IfcPositiveLengthMeasure value) { this.depth = value; }
    public IfcPositiveLengthMeasure getWidth() { return this.width; }
    public void setWidth(IfcPositiveLengthMeasure value) { this.width = value; }
    public IfcPositiveLengthMeasure getWallThickness() { return this.wallThickness; }
    public void setWallThickness(IfcPositiveLengthMeasure value) { this.wallThickness = value; }
    public IfcPositiveLengthMeasure getGirth() { return this.girth; }
    public void setGirth(IfcPositiveLengthMeasure value) { this.girth = value; }
    public IfcNonNegativeLengthMeasure getInternalFilletRadius() { return this.internalFilletRadius; }
    public void setInternalFilletRadius(IfcNonNegativeLengthMeasure value) { this.internalFilletRadius = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(depth != null ? StepUtils.toStepValue(depth) : "$");
		parameters.add(width != null ? StepUtils.toStepValue(width) : "$");
		parameters.add(wallThickness != null ? StepUtils.toStepValue(wallThickness) : "$");
		parameters.add(girth != null ? StepUtils.toStepValue(girth) : "$");
		parameters.add(internalFilletRadius != null ? StepUtils.toStepValue(internalFilletRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}