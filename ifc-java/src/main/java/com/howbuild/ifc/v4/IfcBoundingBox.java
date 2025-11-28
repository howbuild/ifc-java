package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundingBox
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * Corner : IfcCartesianPoint;
 * XDim : IfcPositiveLengthMeasure;
 * YDim : IfcPositiveLengthMeasure;
 * ZDim : IfcPositiveLengthMeasure;
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundingbox.htm">IfcBoundingBox</a>
 */
public class IfcBoundingBox extends IfcGeometricRepresentationItem {
    protected IfcCartesianPoint corner;
    protected IfcPositiveLengthMeasure xDim;
    protected IfcPositiveLengthMeasure yDim;
    protected IfcPositiveLengthMeasure zDim;

    protected IfcBoundingBox() { initCollections(); }
    /**
     * Constructs IfcBoundingBox with all required attributes.
     */
    public IfcBoundingBox(IfcCartesianPoint corner,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim,IfcPositiveLengthMeasure zDim) {
        super();
        this.corner = corner;
        this.xDim = xDim;
        this.yDim = yDim;
        this.zDim = zDim;
    }
    private void initCollections() {
    }
    public IfcCartesianPoint getCorner() { return this.corner; }
    public void setCorner(IfcCartesianPoint value) { this.corner = value; }
    public IfcPositiveLengthMeasure getXDim() { return this.xDim; }
    public void setXDim(IfcPositiveLengthMeasure value) { this.xDim = value; }
    public IfcPositiveLengthMeasure getYDim() { return this.yDim; }
    public void setYDim(IfcPositiveLengthMeasure value) { this.yDim = value; }
    public IfcPositiveLengthMeasure getZDim() { return this.zDim; }
    public void setZDim(IfcPositiveLengthMeasure value) { this.zDim = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(corner != null ? StepUtils.toStepValue(corner) : "$");
		parameters.add(xDim != null ? StepUtils.toStepValue(xDim) : "$");
		parameters.add(yDim != null ? StepUtils.toStepValue(yDim) : "$");
		parameters.add(zDim != null ? StepUtils.toStepValue(zDim) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}