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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrightcircularcylinder.htm">IfcRightCircularCylinder</a>
 */
public class IfcRightCircularCylinder extends IfcCsgPrimitive3D {
    protected IfcPositiveLengthMeasure height;
    protected IfcPositiveLengthMeasure radius;

    protected IfcRightCircularCylinder() { initCollections(); }
    /**
     * Constructs IfcRightCircularCylinder with all required attributes.
     */
    public IfcRightCircularCylinder(IfcAxis2Placement3D position,IfcPositiveLengthMeasure height,IfcPositiveLengthMeasure radius) {
        super(position);
        this.height = height;
        this.radius = radius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getHeight() { return this.height; }
    public void setHeight(IfcPositiveLengthMeasure value) { this.height = value; }
    public IfcPositiveLengthMeasure getRadius() { return this.radius; }
    public void setRadius(IfcPositiveLengthMeasure value) { this.radius = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(height != null ? StepUtils.toStepValue(height) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}