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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpolyline.htm">IfcPolyline</a>
 */
public class IfcPolyline extends IfcBoundedCurve {
    protected Collection<IfcCartesianPoint> points;

    protected IfcPolyline() { initCollections(); }
    /**
     * Constructs IfcPolyline with all required attributes.
     */
    public IfcPolyline(Collection<IfcCartesianPoint> points) {
        super();
        this.points = points;
    }
    private void initCollections() {
        this.points = new ArrayList<>();
    }
    public Collection<IfcCartesianPoint> getPoints() { return this.points; }
    public void setPoints(Collection<IfcCartesianPoint> value) { this.points = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(points != null ? StepUtils.toStepValue(points) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}