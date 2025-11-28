package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPoint
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCartesianPoint
 * ,IfcPointOnCurve
 * ,IfcPointOnSurface))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpointoncurve.htm">IfcPointOnCurve</a>
 */
public class IfcPointOnCurve extends IfcPoint {
    protected IfcCurve basisCurve;
    protected IfcParameterValue pointParameter;

    protected IfcPointOnCurve() { initCollections(); }
    /**
     * Constructs IfcPointOnCurve with all required attributes.
     */
    public IfcPointOnCurve(IfcCurve basisCurve,IfcParameterValue pointParameter) {
        super();
        this.basisCurve = basisCurve;
        this.pointParameter = pointParameter;
    }
    private void initCollections() {
    }
    public IfcCurve getBasisCurve() { return this.basisCurve; }
    public void setBasisCurve(IfcCurve value) { this.basisCurve = value; }
    public IfcParameterValue getPointParameter() { return this.pointParameter; }
    public void setPointParameter(IfcParameterValue value) { this.pointParameter = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisCurve != null ? StepUtils.toStepValue(basisCurve) : "$");
		parameters.add(pointParameter != null ? StepUtils.toStepValue(pointParameter) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}