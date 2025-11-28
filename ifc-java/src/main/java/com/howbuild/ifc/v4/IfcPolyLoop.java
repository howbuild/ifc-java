package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLoop
 * SUPERTYPE OF (ONEOF
 * (IfcEdgeLoop
 * ,IfcPolyLoop
 * ,IfcVertexLoop))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpolyloop.htm">IfcPolyLoop</a>
 */
public class IfcPolyLoop extends IfcLoop {
    protected Collection<IfcCartesianPoint> polygon;

    protected IfcPolyLoop() { initCollections(); }
    /**
     * Constructs IfcPolyLoop with all required attributes.
     */
    public IfcPolyLoop(Collection<IfcCartesianPoint> polygon) {
        super();
        this.polygon = polygon;
    }
    private void initCollections() {
        this.polygon = new ArrayList<>();
    }
    public Collection<IfcCartesianPoint> getPolygon() { return this.polygon; }
    public void setPolygon(Collection<IfcCartesianPoint> value) { this.polygon = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(polygon != null ? StepUtils.toStepValue(polygon) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}