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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreparametrisedcompositecurvesegment.htm">IfcReparametrisedCompositeCurveSegment</a>
 */
public class IfcReparametrisedCompositeCurveSegment extends IfcCompositeCurveSegment {
    protected IfcParameterValue paramLength;

    protected IfcReparametrisedCompositeCurveSegment() { initCollections(); }
    /**
     * Constructs IfcReparametrisedCompositeCurveSegment with all required attributes.
     */
    public IfcReparametrisedCompositeCurveSegment(IfcTransitionCode transition,IfcBoolean sameSense,IfcCurve parentCurve,IfcParameterValue paramLength) {
        super(transition,sameSense,parentCurve);
        this.paramLength = paramLength;
    }
    private void initCollections() {
    }
    public IfcParameterValue getParamLength() { return this.paramLength; }
    public void setParamLength(IfcParameterValue value) { this.paramLength = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(transition != null ? StepUtils.toStepValue(transition) : "$");
		parameters.add(sameSense != null ? StepUtils.toStepValue(sameSense) : "$");
		parameters.add(parentCurve != null ? StepUtils.toStepValue(parentCurve) : "$");
		parameters.add(paramLength != null ? StepUtils.toStepValue(paramLength) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}