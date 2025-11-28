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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpointonsurface.htm">IfcPointOnSurface</a>
 */
public class IfcPointOnSurface extends IfcPoint {
    protected IfcSurface basisSurface;
    protected IfcParameterValue pointParameterU;
    protected IfcParameterValue pointParameterV;

    protected IfcPointOnSurface() { initCollections(); }
    /**
     * Constructs IfcPointOnSurface with all required attributes.
     */
    public IfcPointOnSurface(IfcSurface basisSurface,IfcParameterValue pointParameterU,IfcParameterValue pointParameterV) {
        super();
        this.basisSurface = basisSurface;
        this.pointParameterU = pointParameterU;
        this.pointParameterV = pointParameterV;
    }
    private void initCollections() {
    }
    public IfcSurface getBasisSurface() { return this.basisSurface; }
    public void setBasisSurface(IfcSurface value) { this.basisSurface = value; }
    public IfcParameterValue getPointParameterU() { return this.pointParameterU; }
    public void setPointParameterU(IfcParameterValue value) { this.pointParameterU = value; }
    public IfcParameterValue getPointParameterV() { return this.pointParameterV; }
    public void setPointParameterV(IfcParameterValue value) { this.pointParameterV = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisSurface != null ? StepUtils.toStepValue(basisSurface) : "$");
		parameters.add(pointParameterU != null ? StepUtils.toStepValue(pointParameterU) : "$");
		parameters.add(pointParameterV != null ? StepUtils.toStepValue(pointParameterV) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}