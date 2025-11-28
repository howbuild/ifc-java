package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConnectionGeometry
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConnectionCurveGeometry
 * ,IfcConnectionPointGeometry
 * ,IfcConnectionSurfaceGeometry
 * ,IfcConnectionVolumeGeometry));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectionpointgeometry.htm">IfcConnectionPointGeometry</a>
 */
public class IfcConnectionPointGeometry extends IfcConnectionGeometry {
    protected IfcPointOrVertexPoint pointOnRelatingElement;
    protected IfcPointOrVertexPoint pointOnRelatedElement;

    protected IfcConnectionPointGeometry() { initCollections(); }
    /**
     * Constructs IfcConnectionPointGeometry with all required attributes.
     */
    public IfcConnectionPointGeometry(IfcPointOrVertexPoint pointOnRelatingElement) {

        super();
        this.pointOnRelatingElement = pointOnRelatingElement;
    }
    /**
     * Constructs IfcConnectionPointGeometry with required and optional attributes.
     */
    public IfcConnectionPointGeometry(IfcPointOrVertexPoint pointOnRelatingElement,IfcPointOrVertexPoint pointOnRelatedElement) {
        super();
        this.pointOnRelatingElement = pointOnRelatingElement;
        this.pointOnRelatedElement = pointOnRelatedElement;
    }
    private void initCollections() {
    }
    public IfcPointOrVertexPoint getPointOnRelatingElement() { return this.pointOnRelatingElement; }
    public void setPointOnRelatingElement(IfcPointOrVertexPoint value) { this.pointOnRelatingElement = value; }
    public IfcPointOrVertexPoint getPointOnRelatedElement() { return this.pointOnRelatedElement; }
    public void setPointOnRelatedElement(IfcPointOrVertexPoint value) { this.pointOnRelatedElement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(pointOnRelatingElement != null ? StepUtils.toStepValue(pointOnRelatingElement) : "$");
		parameters.add(pointOnRelatedElement != null ? StepUtils.toStepValue(pointOnRelatedElement) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}