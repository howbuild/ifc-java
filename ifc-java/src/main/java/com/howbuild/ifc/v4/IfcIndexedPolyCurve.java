package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundedCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineCurve
 * ,IfcCompositeCurve
 * ,IfcIndexedPolyCurve
 * ,IfcPolyline
 * ,IfcTrimmedCurve))
 * SUBTYPE OF (IfcCurve);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcindexedpolycurve.htm">IfcIndexedPolyCurve</a>
 */
public class IfcIndexedPolyCurve extends IfcBoundedCurve {
    protected IfcCartesianPointList points;
    protected Collection<IfcSegmentIndexSelect> segments;
    protected IfcBoolean selfIntersect;

    protected IfcIndexedPolyCurve() { initCollections(); }
    /**
     * Constructs IfcIndexedPolyCurve with all required attributes.
     */
    public IfcIndexedPolyCurve(IfcCartesianPointList points) {

        super();
        this.segments = new ArrayList<>();
        this.points = points;
    }
    /**
     * Constructs IfcIndexedPolyCurve with required and optional attributes.
     */
    public IfcIndexedPolyCurve(IfcCartesianPointList points,Collection<IfcSegmentIndexSelect> segments,IfcBoolean selfIntersect) {
        super();
        this.points = points;
        this.segments = segments;
        this.selfIntersect = selfIntersect;
    }
    private void initCollections() {
        this.segments = new ArrayList<>();
    }
    public IfcCartesianPointList getPoints() { return this.points; }
    public void setPoints(IfcCartesianPointList value) { this.points = value; }
    public Collection<IfcSegmentIndexSelect> getSegments() { return this.segments; }
    public void setSegments(Collection<IfcSegmentIndexSelect> value) { this.segments = value; } // optional
    public IfcBoolean getSelfIntersect() { return this.selfIntersect; }
    public void setSelfIntersect(IfcBoolean value) { this.selfIntersect = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(points != null ? StepUtils.toStepValue(points) : "$");
		parameters.add(segments != null ? StepUtils.toStepValue(segments) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}