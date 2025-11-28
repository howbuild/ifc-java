package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEdge
 * SUPERTYPE OF (ONEOF
 * (IfcEdgeCurve
 * ,IfcOrientedEdge
 * ,IfcSubedge))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * EdgeStart : IfcVertex;
 * EdgeEnd : IfcVertex;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcedge.htm">IfcEdge</a>
 */
public class IfcEdge extends IfcTopologicalRepresentationItem {
    protected IfcVertex edgeStart;
    protected IfcVertex edgeEnd;

    protected IfcEdge() { initCollections(); }
    /**
     * Constructs IfcEdge with all required attributes.
     */
    public IfcEdge(IfcVertex edgeStart,IfcVertex edgeEnd) {
        super();
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
    }
    private void initCollections() {
    }
    public IfcVertex getEdgeStart() { return this.edgeStart; }
    public void setEdgeStart(IfcVertex value) { this.edgeStart = value; }
    public IfcVertex getEdgeEnd() { return this.edgeEnd; }
    public void setEdgeEnd(IfcVertex value) { this.edgeEnd = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(edgeStart != null ? StepUtils.toStepValue(edgeStart) : "$");
		parameters.add(edgeEnd != null ? StepUtils.toStepValue(edgeEnd) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}