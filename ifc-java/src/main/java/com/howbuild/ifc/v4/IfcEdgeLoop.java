package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEdgeLoop
 * SUBTYPE OF (IfcLoop);
 * EdgeList : LIST [1:?] OF IfcOrientedEdge;
 * DERIVE
 * Ne : IfcInteger := SIZEOF(EdgeList);
 * WHERE
 * IsClosed : (EdgeList[1].EdgeStart) :=: (EdgeList[Ne].EdgeEnd);
 * IsContinuous : IfcLoopHeadToTail(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcedgeloop.htm">IfcEdgeLoop</a>
 */
public class IfcEdgeLoop extends IfcLoop {
    protected Collection<IfcOrientedEdge> edgeList;

    protected IfcEdgeLoop() { initCollections(); }
    /**
     * Constructs IfcEdgeLoop with all required attributes.
     */
    public IfcEdgeLoop(Collection<IfcOrientedEdge> edgeList) {
        super();
        this.edgeList = edgeList;
    }
    private void initCollections() {
        this.edgeList = new ArrayList<>();
    }
    public Collection<IfcOrientedEdge> getEdgeList() { return this.edgeList; }
    public void setEdgeList(Collection<IfcOrientedEdge> value) { this.edgeList = value; }
    public IfcInteger getNe() { throw new UnsupportedOperationException("Derived property logic has been implemented for Ne."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(edgeList != null ? StepUtils.toStepValue(edgeList) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}