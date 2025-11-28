package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcVertex
 * SUPERTYPE OF (ONEOF
 * (IfcVertexPoint))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvertexpoint.htm">IfcVertexPoint</a>
 */
public class IfcVertexPoint extends IfcVertex implements IfcPointOrVertexPoint {
    protected IfcPoint vertexGeometry;

    protected IfcVertexPoint() { initCollections(); }
    /**
     * Constructs IfcVertexPoint with all required attributes.
     */
    public IfcVertexPoint(IfcPoint vertexGeometry) {
        super();
        this.vertexGeometry = vertexGeometry;
    }
    private void initCollections() {
    }
    public IfcPoint getVertexGeometry() { return this.vertexGeometry; }
    public void setVertexGeometry(IfcPoint value) { this.vertexGeometry = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(vertexGeometry != null ? StepUtils.toStepValue(vertexGeometry) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}