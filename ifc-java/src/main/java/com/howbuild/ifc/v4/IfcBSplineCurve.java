package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBSplineCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineCurveWithKnots))
 * SUBTYPE OF (IfcBoundedCurve);
 * Degree : IfcInteger;
 * ControlPointsList : LIST [2:?] OF IfcCartesianPoint;
 * CurveForm : IfcBSplineCurveForm;
 * ClosedCurve : IfcLogical;
 * SelfIntersect : IfcLogical;
 * DERIVE
 * UpperIndexOnControlPoints : IfcInteger := (SIZEOF(ControlPointsList) - 1);
 * ControlPoints : ARRAY [0:UpperIndexOnControlPoints] OF IfcCartesianPoint := IfcListToArray(ControlPointsList,0,UpperIndexOnControlPoints);
 * WHERE
 * SameDim : SIZEOF(QUERY(Temp <* ControlPointsList |
 * Temp.Dim <> ControlPointsList[1].Dim))
 * = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbsplinecurve.htm">IfcBSplineCurve</a>
 */
public abstract class IfcBSplineCurve extends IfcBoundedCurve {
    protected IfcInteger degree;
    protected Collection<IfcCartesianPoint> controlPointsList;
    protected IfcBSplineCurveForm curveForm;
    protected IfcLogical closedCurve;
    protected IfcLogical selfIntersect;

    protected IfcBSplineCurve() { initCollections(); }
    /**
     * Constructs IfcBSplineCurve with all required attributes.
     */
    public IfcBSplineCurve(IfcInteger degree,Collection<IfcCartesianPoint> controlPointsList,IfcBSplineCurveForm curveForm,IfcLogical closedCurve,IfcLogical selfIntersect) {
        super();
        this.degree = degree;
        this.controlPointsList = controlPointsList;
        this.curveForm = curveForm;
        this.closedCurve = closedCurve;
        this.selfIntersect = selfIntersect;
    }
    private void initCollections() {
        this.controlPointsList = new ArrayList<>();
    }
    public IfcInteger getDegree() { return this.degree; }
    public void setDegree(IfcInteger value) { this.degree = value; }
    public Collection<IfcCartesianPoint> getControlPointsList() { return this.controlPointsList; }
    public void setControlPointsList(Collection<IfcCartesianPoint> value) { this.controlPointsList = value; }
    public IfcBSplineCurveForm getCurveForm() { return this.curveForm; }
    public void setCurveForm(IfcBSplineCurveForm value) { this.curveForm = value; }
    public IfcLogical getClosedCurve() { return this.closedCurve; }
    public void setClosedCurve(IfcLogical value) { this.closedCurve = value; }
    public IfcLogical getSelfIntersect() { return this.selfIntersect; }
    public void setSelfIntersect(IfcLogical value) { this.selfIntersect = value; }
    public IfcInteger getUpperIndexOnControlPoints() { throw new UnsupportedOperationException("Derived property logic has been implemented for UpperIndexOnControlPoints."); } // derived
    public Collection<IfcCartesianPoint> getControlPoints() { throw new UnsupportedOperationException("Derived property logic has been implemented for ControlPoints."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}