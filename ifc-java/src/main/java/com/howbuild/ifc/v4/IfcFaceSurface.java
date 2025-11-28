package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAdvancedFace
 * SUBTYPE OF (IfcFaceSurface);
 * WHERE
 * ApplicableSurface : SIZEOF (
 * ['IFC4.IFCELEMENTARYSURFACE',
 * 'IFC4.IFCSWEPTSURFACE',
 * 'IFC4.IFCBSPLINESURFACE'] *
 * TYPEOF(SELF\IfcFaceSurface.FaceSurface)) = 1;
 * RequiresEdgeCurve : SIZEOF(QUERY (ElpFbnds <*
 * QUERY (Bnds <* SELF\IfcFace.Bounds |
 * 'IFC4.IFCEDGELOOP' IN TYPEOF(Bnds.Bound)) |
 * NOT (SIZEOF (QUERY (Oe <* ElpFbnds.Bound\IfcEdgeLoop.EdgeList |
 * NOT('IFC4.IFCEDGECURVE' IN
 * TYPEOF(Oe\IfcOrientedEdge.EdgeElement)
 * ))) = 0
 * ))) = 0;
 * ApplicableEdgeCurves : SIZEOF(QUERY (ElpFbnds <*
 * QUERY (Bnds <* SELF\IfcFace.Bounds |
 * 'IFC4.IFCEDGELOOP' IN TYPEOF(Bnds.Bound)) |
 * NOT (SIZEOF (QUERY (Oe <* ElpFbnds.Bound\IfcEdgeLoop.EdgeList |
 * NOT (SIZEOF (['IFC4.IFCLINE',
 * 'IFC4.IFCCONIC',
 * 'IFC4.IFCPOLYLINE',
 * 'IFC4.IFCBSPLINECURVE'] *
 * TYPEOF(Oe\IfcOrientedEdge.EdgeElement\IfcEdgeCurve.EdgeGeometry)) = 1 )
 * )) = 0
 * ))) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfacesurface.htm">IfcFaceSurface</a>
 */
public class IfcFaceSurface extends IfcFace implements IfcSurfaceOrFaceSurface {
    protected IfcSurface faceSurface;
    protected IfcBoolean sameSense;

    protected IfcFaceSurface() { initCollections(); }
    /**
     * Constructs IfcFaceSurface with all required attributes.
     */
    public IfcFaceSurface(Collection<IfcFaceBound> bounds,IfcSurface faceSurface,IfcBoolean sameSense) {
        super(bounds);
        this.faceSurface = faceSurface;
        this.sameSense = sameSense;
    }
    private void initCollections() {
    }
    public IfcSurface getFaceSurface() { return this.faceSurface; }
    public void setFaceSurface(IfcSurface value) { this.faceSurface = value; }
    public IfcBoolean getSameSense() { return this.sameSense; }
    public void setSameSense(IfcBoolean value) { this.sameSense = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(bounds != null ? StepUtils.toStepValue(bounds) : "$");
		parameters.add(faceSurface != null ? StepUtils.toStepValue(faceSurface) : "$");
		parameters.add(sameSense != null ? StepUtils.toStepValue(sameSense) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}