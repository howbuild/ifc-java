package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBSplineSurfaceWithKnots
 * SUPERTYPE OF (ONEOF
 * (IfcRationalBSplineSurfaceWithKnots))
 * SUBTYPE OF (IfcBSplineSurface);
 * UMultiplicities : LIST [2:?] OF IfcInteger;
 * VMultiplicities : LIST [2:?] OF IfcInteger;
 * UKnots : LIST [2:?] OF IfcParameterValue;
 * VKnots : LIST [2:?] OF IfcParameterValue;
 * KnotSpec : IfcKnotType;
 * DERIVE
 * KnotVUpper : IfcInteger := SIZEOF(VKnots);
 * KnotUUpper : IfcInteger := SIZEOF(UKnots);
 * WHERE
 * UDirectionConstraints : IfcConstraintsParamBSpline (
 * SELF\IfcBSplineSurface.UDegree, KnotUUpper,
 * SELF\IfcBSplineSurface.UUpper, UMultiplicities, UKnots);
 * VDirectionConstraints : IfcConstraintsParamBSpline (
 * SELF\IfcBSplineSurface.VDegree, KnotVUpper,
 * SELF\IfcBSplineSurface.VUpper, VMultiplicities, VKnots);
 * CorrespondingULists : SIZEOF(UMultiplicities) = KnotUUpper;
 * CorrespondingVLists : SIZEOF(VMultiplicities) = KnotVUpper;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrationalbsplinesurfacewithknots.htm">IfcRationalBSplineSurfaceWithKnots</a>
 */
public class IfcRationalBSplineSurfaceWithKnots extends IfcBSplineSurfaceWithKnots {
    protected Collection<Collection<IfcReal>> weightsData;

    protected IfcRationalBSplineSurfaceWithKnots() { initCollections(); }
    /**
     * Constructs IfcRationalBSplineSurfaceWithKnots with all required attributes.
     */
    public IfcRationalBSplineSurfaceWithKnots(IfcInteger uDegree,IfcInteger vDegree,Collection<Collection<IfcCartesianPoint>> controlPointsList,IfcBSplineSurfaceForm surfaceForm,IfcLogical uClosed,IfcLogical vClosed,IfcLogical selfIntersect,Collection<IfcInteger> uMultiplicities,Collection<IfcInteger> vMultiplicities,Collection<IfcParameterValue> uKnots,Collection<IfcParameterValue> vKnots,IfcKnotType knotSpec,Collection<Collection<IfcReal>> weightsData) {
        super(uDegree,vDegree,controlPointsList,surfaceForm,uClosed,vClosed,selfIntersect,uMultiplicities,vMultiplicities,uKnots,vKnots,knotSpec);
        this.weightsData = weightsData;
    }
    private void initCollections() {
        this.weightsData = new ArrayList<>();
    }
    public Collection<Collection<IfcReal>> getWeightsData() { return this.weightsData; }
    public void setWeightsData(Collection<Collection<IfcReal>> value) { this.weightsData = value; }
    public Collection<Collection<IfcReal>> getWeights() { throw new UnsupportedOperationException("Derived property logic has been implemented for Weights."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(uDegree != null ? StepUtils.toStepValue(uDegree) : "$");
		parameters.add(vDegree != null ? StepUtils.toStepValue(vDegree) : "$");
		parameters.add(controlPointsList != null ? StepUtils.toStepValue(controlPointsList) : "$");
		parameters.add(surfaceForm != null ? StepUtils.toStepValue(surfaceForm) : "$");
		parameters.add(uClosed != null ? StepUtils.toStepValue(uClosed) : "$");
		parameters.add(vClosed != null ? StepUtils.toStepValue(vClosed) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
		parameters.add(uMultiplicities != null ? StepUtils.toStepValue(uMultiplicities) : "$");
		parameters.add(vMultiplicities != null ? StepUtils.toStepValue(vMultiplicities) : "$");
		parameters.add(uKnots != null ? StepUtils.toStepValue(uKnots) : "$");
		parameters.add(vKnots != null ? StepUtils.toStepValue(vKnots) : "$");
		parameters.add(knotSpec != null ? StepUtils.toStepValue(knotSpec) : "$");
		parameters.add(weightsData != null ? StepUtils.toStepValue(weightsData) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}