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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrectangularpyramid.htm">IfcRectangularPyramid</a>
 */
public class IfcRectangularPyramid extends IfcCsgPrimitive3D {
    protected IfcPositiveLengthMeasure xLength;
    protected IfcPositiveLengthMeasure yLength;
    protected IfcPositiveLengthMeasure height;

    protected IfcRectangularPyramid() { initCollections(); }
    /**
     * Constructs IfcRectangularPyramid with all required attributes.
     */
    public IfcRectangularPyramid(IfcAxis2Placement3D position,IfcPositiveLengthMeasure xLength,IfcPositiveLengthMeasure yLength,IfcPositiveLengthMeasure height) {
        super(position);
        this.xLength = xLength;
        this.yLength = yLength;
        this.height = height;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getXLength() { return this.xLength; }
    public void setXLength(IfcPositiveLengthMeasure value) { this.xLength = value; }
    public IfcPositiveLengthMeasure getYLength() { return this.yLength; }
    public void setYLength(IfcPositiveLengthMeasure value) { this.yLength = value; }
    public IfcPositiveLengthMeasure getHeight() { return this.height; }
    public void setHeight(IfcPositiveLengthMeasure value) { this.height = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(xLength != null ? StepUtils.toStepValue(xLength) : "$");
		parameters.add(yLength != null ? StepUtils.toStepValue(yLength) : "$");
		parameters.add(height != null ? StepUtils.toStepValue(height) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}