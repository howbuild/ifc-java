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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsubedge.htm">IfcSubedge</a>
 */
public class IfcSubedge extends IfcEdge {
    protected IfcEdge parentEdge;

    protected IfcSubedge() { initCollections(); }
    /**
     * Constructs IfcSubedge with all required attributes.
     */
    public IfcSubedge(IfcVertex edgeStart,IfcVertex edgeEnd,IfcEdge parentEdge) {
        super(edgeStart,edgeEnd);
        this.parentEdge = parentEdge;
    }
    private void initCollections() {
    }
    public IfcEdge getParentEdge() { return this.parentEdge; }
    public void setParentEdge(IfcEdge value) { this.parentEdge = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(edgeStart != null ? StepUtils.toStepValue(edgeStart) : "$");
		parameters.add(edgeEnd != null ? StepUtils.toStepValue(edgeEnd) : "$");
		parameters.add(parentEdge != null ? StepUtils.toStepValue(parentEdge) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}