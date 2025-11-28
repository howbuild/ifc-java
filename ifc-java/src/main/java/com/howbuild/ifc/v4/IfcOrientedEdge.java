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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcorientededge.htm">IfcOrientedEdge</a>
 */
public class IfcOrientedEdge extends IfcEdge {
    protected IfcEdge edgeElement;
    protected IfcBoolean orientation;

    protected IfcOrientedEdge() { initCollections(); }
    /**
     * Constructs IfcOrientedEdge with all required attributes.
     */
    public IfcOrientedEdge(IfcVertex edgeStart,IfcVertex edgeEnd,IfcEdge edgeElement,IfcBoolean orientation) {
        super(edgeStart,edgeEnd);
        this.edgeElement = edgeElement;
        this.orientation = orientation;
    }
    private void initCollections() {
    }
    public IfcEdge getEdgeElement() { return this.edgeElement; }
    public void setEdgeElement(IfcEdge value) { this.edgeElement = value; }
    public IfcBoolean getOrientation() { return this.orientation; }
    public void setOrientation(IfcBoolean value) { this.orientation = value; }
    public IfcVertex getEdgeStart() { throw new UnsupportedOperationException("Derived property logic has been implemented for EdgeStart."); } // derived
    public IfcVertex getEdgeEnd() { throw new UnsupportedOperationException("Derived property logic has been implemented for EdgeEnd."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add("*");
		parameters.add("*");
		parameters.add(edgeElement != null ? StepUtils.toStepValue(edgeElement) : "$");
		parameters.add(orientation != null ? StepUtils.toStepValue(orientation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}