package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBoundedCurve
 * ,IfcConic
 * ,IfcLine
 * ,IfcOffsetCurve2D
 * ,IfcOffsetCurve3D
 * ,IfcPcurve
 * ,IfcSurfaceCurve))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DERIVE
 * Dim : IfcDimensionCount := IfcCurveDim(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcoffsetcurve2d.htm">IfcOffsetCurve2D</a>
 */
public class IfcOffsetCurve2D extends IfcCurve {
    protected IfcCurve basisCurve;
    protected IfcLengthMeasure distance;
    protected IfcLogical selfIntersect;

    protected IfcOffsetCurve2D() { initCollections(); }
    /**
     * Constructs IfcOffsetCurve2D with all required attributes.
     */
    public IfcOffsetCurve2D(IfcCurve basisCurve,IfcLengthMeasure distance,IfcLogical selfIntersect) {
        super();
        this.basisCurve = basisCurve;
        this.distance = distance;
        this.selfIntersect = selfIntersect;
    }
    private void initCollections() {
    }
    public IfcCurve getBasisCurve() { return this.basisCurve; }
    public void setBasisCurve(IfcCurve value) { this.basisCurve = value; }
    public IfcLengthMeasure getDistance() { return this.distance; }
    public void setDistance(IfcLengthMeasure value) { this.distance = value; }
    public IfcLogical getSelfIntersect() { return this.selfIntersect; }
    public void setSelfIntersect(IfcLogical value) { this.selfIntersect = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisCurve != null ? StepUtils.toStepValue(basisCurve) : "$");
		parameters.add(distance != null ? StepUtils.toStepValue(distance) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}