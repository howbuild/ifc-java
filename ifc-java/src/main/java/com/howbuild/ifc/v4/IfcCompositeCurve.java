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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccompositecurve.htm">IfcCompositeCurve</a>
 */
public class IfcCompositeCurve extends IfcBoundedCurve {
    protected Collection<IfcCompositeCurveSegment> segments;
    protected IfcLogical selfIntersect;

    protected IfcCompositeCurve() { initCollections(); }
    /**
     * Constructs IfcCompositeCurve with all required attributes.
     */
    public IfcCompositeCurve(Collection<IfcCompositeCurveSegment> segments,IfcLogical selfIntersect) {
        super();
        this.segments = segments;
        this.selfIntersect = selfIntersect;
    }
    private void initCollections() {
        this.segments = new ArrayList<>();
    }
    public Collection<IfcCompositeCurveSegment> getSegments() { return this.segments; }
    public void setSegments(Collection<IfcCompositeCurveSegment> value) { this.segments = value; }
    public IfcLogical getSelfIntersect() { return this.selfIntersect; }
    public void setSelfIntersect(IfcLogical value) { this.selfIntersect = value; }
    public IfcInteger getNSegments() { throw new UnsupportedOperationException("Derived property logic has been implemented for NSegments."); } // derived
    public IfcLogical getClosedCurve() { throw new UnsupportedOperationException("Derived property logic has been implemented for ClosedCurve."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(segments != null ? StepUtils.toStepValue(segments) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcCompositeCurveRelationship(); }
    private void setIfcCompositeCurveRelationship() {
		if (this.segments != null) {
		    for (Object x : this.segments) {
		        if (x instanceof IfcCompositeCurveSegment)
		            ((IfcCompositeCurveSegment)x).usingCurves.add(this);
		    }
		}
    }
}