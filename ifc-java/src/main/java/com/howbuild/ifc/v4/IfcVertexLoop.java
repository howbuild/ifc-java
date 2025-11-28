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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvertexloop.htm">IfcVertexLoop</a>
 */
public class IfcVertexLoop extends IfcLoop {
    protected IfcVertex loopVertex;

    protected IfcVertexLoop() { initCollections(); }
    /**
     * Constructs IfcVertexLoop with all required attributes.
     */
    public IfcVertexLoop(IfcVertex loopVertex) {
        super();
        this.loopVertex = loopVertex;
    }
    private void initCollections() {
    }
    public IfcVertex getLoopVertex() { return this.loopVertex; }
    public void setLoopVertex(IfcVertex value) { this.loopVertex = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(loopVertex != null ? StepUtils.toStepValue(loopVertex) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}