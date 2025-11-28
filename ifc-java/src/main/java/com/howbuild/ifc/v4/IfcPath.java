package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPath
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * EdgeList : LIST [1:?] OF UNIQUE IfcOrientedEdge;
 * WHERE
 * IsContinuous : IfcPathHeadToTail(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpath.htm">IfcPath</a>
 */
public class IfcPath extends IfcTopologicalRepresentationItem {
    protected Collection<IfcOrientedEdge> edgeList;

    protected IfcPath() { initCollections(); }
    /**
     * Constructs IfcPath with all required attributes.
     */
    public IfcPath(Collection<IfcOrientedEdge> edgeList) {
        super();
        this.edgeList = edgeList;
    }
    private void initCollections() {
        this.edgeList = new ArrayList<>();
    }
    public Collection<IfcOrientedEdge> getEdgeList() { return this.edgeList; }
    public void setEdgeList(Collection<IfcOrientedEdge> value) { this.edgeList = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(edgeList != null ? StepUtils.toStepValue(edgeList) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}