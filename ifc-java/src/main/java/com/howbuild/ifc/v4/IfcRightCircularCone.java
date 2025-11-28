package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCsgPrimitive3D
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBlock
 * ,IfcRectangularPyramid
 * ,IfcRightCircularCone
 * ,IfcRightCircularCylinder
 * ,IfcSphere))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * Position : IfcAxis2Placement3D;
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrightcircularcone.htm">IfcRightCircularCone</a>
 */
public class IfcRightCircularCone extends IfcCsgPrimitive3D {
    protected IfcPositiveLengthMeasure height;
    protected IfcPositiveLengthMeasure bottomRadius;

    protected IfcRightCircularCone() { initCollections(); }
    /**
     * Constructs IfcRightCircularCone with all required attributes.
     */
    public IfcRightCircularCone(IfcAxis2Placement3D position,IfcPositiveLengthMeasure height,IfcPositiveLengthMeasure bottomRadius) {
        super(position);
        this.height = height;
        this.bottomRadius = bottomRadius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getHeight() { return this.height; }
    public void setHeight(IfcPositiveLengthMeasure value) { this.height = value; }
    public IfcPositiveLengthMeasure getBottomRadius() { return this.bottomRadius; }
    public void setBottomRadius(IfcPositiveLengthMeasure value) { this.bottomRadius = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(height != null ? StepUtils.toStepValue(height) : "$");
		parameters.add(bottomRadius != null ? StepUtils.toStepValue(bottomRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}