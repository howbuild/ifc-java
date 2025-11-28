package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSurfaceOfRevolution
 * SUBTYPE OF (IfcSweptSurface);
 * AxisPosition : IfcAxis1Placement;
 * DERIVE
 * AxisLine : IfcLine := IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcCurve() || IfcLine(AxisPosition.Location,
 * IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcVector(AxisPosition.Z,1.0));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfaceofrevolution.htm">IfcSurfaceOfRevolution</a>
 */
public class IfcSurfaceOfRevolution extends IfcSweptSurface {
    protected IfcAxis1Placement axisPosition;

    protected IfcSurfaceOfRevolution() { initCollections(); }
    /**
     * Constructs IfcSurfaceOfRevolution with all required attributes.
     */
    public IfcSurfaceOfRevolution(IfcProfileDef sweptCurve,IfcAxis1Placement axisPosition) {

        super(sweptCurve);
        this.axisPosition = axisPosition;
    }
    /**
     * Constructs IfcSurfaceOfRevolution with required and optional attributes.
     */
    public IfcSurfaceOfRevolution(IfcProfileDef sweptCurve,IfcAxis2Placement3D position,IfcAxis1Placement axisPosition) {
        super(sweptCurve,position);
        this.axisPosition = axisPosition;
    }
    private void initCollections() {
    }
    public IfcAxis1Placement getAxisPosition() { return this.axisPosition; }
    public void setAxisPosition(IfcAxis1Placement value) { this.axisPosition = value; }
    public IfcLine getAxisLine() { throw new UnsupportedOperationException("Derived property logic has been implemented for AxisLine."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sweptCurve != null ? StepUtils.toStepValue(sweptCurve) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(axisPosition != null ? StepUtils.toStepValue(axisPosition) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}