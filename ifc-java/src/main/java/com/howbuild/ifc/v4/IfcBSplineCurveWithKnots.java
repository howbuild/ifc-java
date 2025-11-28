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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbsplinecurvewithknots.htm">IfcBSplineCurveWithKnots</a>
 */
public class IfcBSplineCurveWithKnots extends IfcBSplineCurve {
    protected Collection<IfcInteger> knotMultiplicities;
    protected Collection<IfcParameterValue> knots;
    protected IfcKnotType knotSpec;

    protected IfcBSplineCurveWithKnots() { initCollections(); }
    /**
     * Constructs IfcBSplineCurveWithKnots with all required attributes.
     */
    public IfcBSplineCurveWithKnots(IfcInteger degree,Collection<IfcCartesianPoint> controlPointsList,IfcBSplineCurveForm curveForm,IfcLogical closedCurve,IfcLogical selfIntersect,Collection<IfcInteger> knotMultiplicities,Collection<IfcParameterValue> knots,IfcKnotType knotSpec) {
        super(degree,controlPointsList,curveForm,closedCurve,selfIntersect);
        this.knotMultiplicities = knotMultiplicities;
        this.knots = knots;
        this.knotSpec = knotSpec;
    }
    private void initCollections() {
        this.knotMultiplicities = new ArrayList<>();
        this.knots = new ArrayList<>();
    }
    public Collection<IfcInteger> getKnotMultiplicities() { return this.knotMultiplicities; }
    public void setKnotMultiplicities(Collection<IfcInteger> value) { this.knotMultiplicities = value; }
    public Collection<IfcParameterValue> getKnots() { return this.knots; }
    public void setKnots(Collection<IfcParameterValue> value) { this.knots = value; }
    public IfcKnotType getKnotSpec() { return this.knotSpec; }
    public void setKnotSpec(IfcKnotType value) { this.knotSpec = value; }
    public IfcInteger getUpperIndexOnKnots() { throw new UnsupportedOperationException("Derived property logic has been implemented for UpperIndexOnKnots."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(degree != null ? StepUtils.toStepValue(degree) : "$");
		parameters.add(controlPointsList != null ? StepUtils.toStepValue(controlPointsList) : "$");
		parameters.add(curveForm != null ? StepUtils.toStepValue(curveForm) : "$");
		parameters.add(closedCurve != null ? StepUtils.toStepValue(closedCurve) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
		parameters.add(knotMultiplicities != null ? StepUtils.toStepValue(knotMultiplicities) : "$");
		parameters.add(knots != null ? StepUtils.toStepValue(knots) : "$");
		parameters.add(knotSpec != null ? StepUtils.toStepValue(knotSpec) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}