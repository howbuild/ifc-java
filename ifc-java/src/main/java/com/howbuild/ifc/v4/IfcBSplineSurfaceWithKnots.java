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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbsplinesurfacewithknots.htm">IfcBSplineSurfaceWithKnots</a>
 */
public class IfcBSplineSurfaceWithKnots extends IfcBSplineSurface {
    protected Collection<IfcInteger> uMultiplicities;
    protected Collection<IfcInteger> vMultiplicities;
    protected Collection<IfcParameterValue> uKnots;
    protected Collection<IfcParameterValue> vKnots;
    protected IfcKnotType knotSpec;

    protected IfcBSplineSurfaceWithKnots() { initCollections(); }
    /**
     * Constructs IfcBSplineSurfaceWithKnots with all required attributes.
     */
    public IfcBSplineSurfaceWithKnots(IfcInteger uDegree,IfcInteger vDegree,Collection<Collection<IfcCartesianPoint>> controlPointsList,IfcBSplineSurfaceForm surfaceForm,IfcLogical uClosed,IfcLogical vClosed,IfcLogical selfIntersect,Collection<IfcInteger> uMultiplicities,Collection<IfcInteger> vMultiplicities,Collection<IfcParameterValue> uKnots,Collection<IfcParameterValue> vKnots,IfcKnotType knotSpec) {
        super(uDegree,vDegree,controlPointsList,surfaceForm,uClosed,vClosed,selfIntersect);
        this.uMultiplicities = uMultiplicities;
        this.vMultiplicities = vMultiplicities;
        this.uKnots = uKnots;
        this.vKnots = vKnots;
        this.knotSpec = knotSpec;
    }
    private void initCollections() {
        this.uMultiplicities = new ArrayList<>();
        this.vMultiplicities = new ArrayList<>();
        this.uKnots = new ArrayList<>();
        this.vKnots = new ArrayList<>();
    }
    public Collection<IfcInteger> getUMultiplicities() { return this.uMultiplicities; }
    public void setUMultiplicities(Collection<IfcInteger> value) { this.uMultiplicities = value; }
    public Collection<IfcInteger> getVMultiplicities() { return this.vMultiplicities; }
    public void setVMultiplicities(Collection<IfcInteger> value) { this.vMultiplicities = value; }
    public Collection<IfcParameterValue> getUKnots() { return this.uKnots; }
    public void setUKnots(Collection<IfcParameterValue> value) { this.uKnots = value; }
    public Collection<IfcParameterValue> getVKnots() { return this.vKnots; }
    public void setVKnots(Collection<IfcParameterValue> value) { this.vKnots = value; }
    public IfcKnotType getKnotSpec() { return this.knotSpec; }
    public void setKnotSpec(IfcKnotType value) { this.knotSpec = value; }
    public IfcInteger getKnotVUpper() { throw new UnsupportedOperationException("Derived property logic has been implemented for KnotVUpper."); } // derived
    public IfcInteger getKnotUUpper() { throw new UnsupportedOperationException("Derived property logic has been implemented for KnotUUpper."); } // derived

    
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
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}