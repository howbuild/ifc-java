package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBSplineSurface
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineSurfaceWithKnots))
 * SUBTYPE OF (IfcBoundedSurface);
 * UDegree : IfcInteger;
 * VDegree : IfcInteger;
 * ControlPointsList : LIST [2:?] OF LIST [2:?] OF IfcCartesianPoint;
 * SurfaceForm : IfcBSplineSurfaceForm;
 * UClosed : IfcLogical;
 * VClosed : IfcLogical;
 * SelfIntersect : IfcLogical;
 * DERIVE
 * UUpper : IfcInteger := SIZEOF(ControlPointsList) - 1;
 * VUpper : IfcInteger := SIZEOF(ControlPointsList[1]) - 1;
 * ControlPoints : ARRAY [0:UUpper] OF ARRAY [0:VUpper] OF IfcCartesianPoint := IfcMakeArrayOfArray(ControlPointsList,
 * 0,UUpper,0,VUpper);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbsplinesurface.htm">IfcBSplineSurface</a>
 */
public abstract class IfcBSplineSurface extends IfcBoundedSurface {
    protected IfcInteger uDegree;
    protected IfcInteger vDegree;
    protected Collection<Collection<IfcCartesianPoint>> controlPointsList;
    protected IfcBSplineSurfaceForm surfaceForm;
    protected IfcLogical uClosed;
    protected IfcLogical vClosed;
    protected IfcLogical selfIntersect;

    protected IfcBSplineSurface() { initCollections(); }
    /**
     * Constructs IfcBSplineSurface with all required attributes.
     */
    public IfcBSplineSurface(IfcInteger uDegree,IfcInteger vDegree,Collection<Collection<IfcCartesianPoint>> controlPointsList,IfcBSplineSurfaceForm surfaceForm,IfcLogical uClosed,IfcLogical vClosed,IfcLogical selfIntersect) {
        super();
        this.uDegree = uDegree;
        this.vDegree = vDegree;
        this.controlPointsList = controlPointsList;
        this.surfaceForm = surfaceForm;
        this.uClosed = uClosed;
        this.vClosed = vClosed;
        this.selfIntersect = selfIntersect;
    }
    private void initCollections() {
        this.controlPointsList = new ArrayList<>();
    }
    public IfcInteger getUDegree() { return this.uDegree; }
    public void setUDegree(IfcInteger value) { this.uDegree = value; }
    public IfcInteger getVDegree() { return this.vDegree; }
    public void setVDegree(IfcInteger value) { this.vDegree = value; }
    public Collection<Collection<IfcCartesianPoint>> getControlPointsList() { return this.controlPointsList; }
    public void setControlPointsList(Collection<Collection<IfcCartesianPoint>> value) { this.controlPointsList = value; }
    public IfcBSplineSurfaceForm getSurfaceForm() { return this.surfaceForm; }
    public void setSurfaceForm(IfcBSplineSurfaceForm value) { this.surfaceForm = value; }
    public IfcLogical getUClosed() { return this.uClosed; }
    public void setUClosed(IfcLogical value) { this.uClosed = value; }
    public IfcLogical getVClosed() { return this.vClosed; }
    public void setVClosed(IfcLogical value) { this.vClosed = value; }
    public IfcLogical getSelfIntersect() { return this.selfIntersect; }
    public void setSelfIntersect(IfcLogical value) { this.selfIntersect = value; }
    public IfcInteger getUUpper() { throw new UnsupportedOperationException("Derived property logic has been implemented for UUpper."); } // derived
    public IfcInteger getVUpper() { throw new UnsupportedOperationException("Derived property logic has been implemented for VUpper."); } // derived
    public Collection<Collection<IfcCartesianPoint>> getControlPoints() { throw new UnsupportedOperationException("Derived property logic has been implemented for ControlPoints."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}