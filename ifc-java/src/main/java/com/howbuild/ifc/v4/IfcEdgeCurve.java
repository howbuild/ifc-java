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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcedgecurve.htm">IfcEdgeCurve</a>
 */
public class IfcEdgeCurve extends IfcEdge implements IfcCurveOrEdgeCurve {
    protected IfcCurve edgeGeometry;
    protected IfcBoolean sameSense;

    protected IfcEdgeCurve() { initCollections(); }
    /**
     * Constructs IfcEdgeCurve with all required attributes.
     */
    public IfcEdgeCurve(IfcVertex edgeStart,IfcVertex edgeEnd,IfcCurve edgeGeometry,IfcBoolean sameSense) {
        super(edgeStart,edgeEnd);
        this.edgeGeometry = edgeGeometry;
        this.sameSense = sameSense;
    }
    private void initCollections() {
    }
    public IfcCurve getEdgeGeometry() { return this.edgeGeometry; }
    public void setEdgeGeometry(IfcCurve value) { this.edgeGeometry = value; }
    public IfcBoolean getSameSense() { return this.sameSense; }
    public void setSameSense(IfcBoolean value) { this.sameSense = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(edgeStart != null ? StepUtils.toStepValue(edgeStart) : "$");
		parameters.add(edgeEnd != null ? StepUtils.toStepValue(edgeEnd) : "$");
		parameters.add(edgeGeometry != null ? StepUtils.toStepValue(edgeGeometry) : "$");
		parameters.add(sameSense != null ? StepUtils.toStepValue(sameSense) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}