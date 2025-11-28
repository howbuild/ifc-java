package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBSplineCurveWithKnots
 * SUPERTYPE OF (ONEOF
 * (IfcRationalBSplineCurveWithKnots))
 * SUBTYPE OF (IfcBSplineCurve);
 * KnotMultiplicities : LIST [2:?] OF IfcInteger;
 * Knots : LIST [2:?] OF IfcParameterValue;
 * KnotSpec : IfcKnotType;
 * DERIVE
 * UpperIndexOnKnots : IfcInteger := SIZEOF(Knots);
 * WHERE
 * ConsistentBSpline : IfcConstraintsParamBSpline(Degree, UpperIndexOnKnots,
 * UpperIndexOnControlPoints, KnotMultiplicities, Knots);
 * CorrespondingKnotLists : SIZEOF(KnotMultiplicities) = UpperIndexOnKnots;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrationalbsplinecurvewithknots.htm">IfcRationalBSplineCurveWithKnots</a>
 */
public class IfcRationalBSplineCurveWithKnots extends IfcBSplineCurveWithKnots {
    protected Collection<IfcReal> weightsData;

    protected IfcRationalBSplineCurveWithKnots() { initCollections(); }
    /**
     * Constructs IfcRationalBSplineCurveWithKnots with all required attributes.
     */
    public IfcRationalBSplineCurveWithKnots(IfcInteger degree,Collection<IfcCartesianPoint> controlPointsList,IfcBSplineCurveForm curveForm,IfcLogical closedCurve,IfcLogical selfIntersect,Collection<IfcInteger> knotMultiplicities,Collection<IfcParameterValue> knots,IfcKnotType knotSpec,Collection<IfcReal> weightsData) {
        super(degree,controlPointsList,curveForm,closedCurve,selfIntersect,knotMultiplicities,knots,knotSpec);
        this.weightsData = weightsData;
    }
    private void initCollections() {
        this.weightsData = new ArrayList<>();
    }
    public Collection<IfcReal> getWeightsData() { return this.weightsData; }
    public void setWeightsData(Collection<IfcReal> value) { this.weightsData = value; }
    public Collection<IfcReal> getWeights() { throw new UnsupportedOperationException("Derived property logic has been implemented for Weights."); } // derived

    
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
		parameters.add(weightsData != null ? StepUtils.toStepValue(weightsData) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}