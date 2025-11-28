package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCompositeCurveSegment
 * SUPERTYPE OF (ONEOF
 * (IfcReparametrisedCompositeCurveSegment))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * Transition : IfcTransitionCode;
 * SameSense : IfcBoolean;
 * ParentCurve : IfcCurve;
 * DERIVE
 * Dim : IfcDimensionCount := ParentCurve.Dim;
 * INVERSE
 * UsingCurves : SET [1:?] OF IfcCompositeCurve FOR Segments;
 * WHERE
 * ParentIsBoundedCurve : ('IFC4.IFCBOUNDEDCURVE' IN TYPEOF(ParentCurve));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccompositecurvesegment.htm">IfcCompositeCurveSegment</a>
 */
public class IfcCompositeCurveSegment extends IfcGeometricRepresentationItem {
    protected IfcTransitionCode transition;
    protected IfcBoolean sameSense;
    protected IfcCurve parentCurve;
    protected Collection<IfcCompositeCurve> usingCurves;

    protected IfcCompositeCurveSegment() { initCollections(); }
    /**
     * Constructs IfcCompositeCurveSegment with all required attributes.
     */
    public IfcCompositeCurveSegment(IfcTransitionCode transition,IfcBoolean sameSense,IfcCurve parentCurve) {
        super();
        this.usingCurves = new ArrayList<>();
        this.transition = transition;
        this.sameSense = sameSense;
        this.parentCurve = parentCurve;
    }
    private void initCollections() {
        this.usingCurves = new ArrayList<>();
    }
    public IfcTransitionCode getTransition() { return this.transition; }
    public void setTransition(IfcTransitionCode value) { this.transition = value; }
    public IfcBoolean getSameSense() { return this.sameSense; }
    public void setSameSense(IfcBoolean value) { this.sameSense = value; }
    public IfcCurve getParentCurve() { return this.parentCurve; }
    public void setParentCurve(IfcCurve value) { this.parentCurve = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived
    public Collection<IfcCompositeCurve> getUsingCurves() { return this.usingCurves; }
    public void setUsingCurves(Collection<IfcCompositeCurve> value) { this.usingCurves = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(transition != null ? StepUtils.toStepValue(transition) : "$");
		parameters.add(sameSense != null ? StepUtils.toStepValue(sameSense) : "$");
		parameters.add(parentCurve != null ? StepUtils.toStepValue(parentCurve) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}