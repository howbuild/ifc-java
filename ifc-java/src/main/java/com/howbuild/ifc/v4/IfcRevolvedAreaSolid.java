package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRevolvedAreaSolid
 * SUPERTYPE OF (ONEOF
 * (IfcRevolvedAreaSolidTapered))
 * SUBTYPE OF (IfcSweptAreaSolid);
 * Axis : IfcAxis1Placement;
 * Angle : IfcPlaneAngleMeasure;
 * DERIVE
 * AxisLine : IfcLine := IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcCurve() || IfcLine(Axis.Location,
 * IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcVector(Axis.Z,1.0));
 * WHERE
 * AxisStartInXY : Axis.Location.Coordinates[3] = 0.0;
 * AxisDirectionInXY : Axis.Z.DirectionRatios[3] = 0.0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrevolvedareasolid.htm">IfcRevolvedAreaSolid</a>
 */
public class IfcRevolvedAreaSolid extends IfcSweptAreaSolid {
    protected IfcAxis1Placement axis;
    protected IfcPlaneAngleMeasure angle;

    protected IfcRevolvedAreaSolid() { initCollections(); }
    /**
     * Constructs IfcRevolvedAreaSolid with all required attributes.
     */
    public IfcRevolvedAreaSolid(IfcProfileDef sweptArea,IfcAxis1Placement axis,IfcPlaneAngleMeasure angle) {

        super(sweptArea);
        this.axis = axis;
        this.angle = angle;
    }
    /**
     * Constructs IfcRevolvedAreaSolid with required and optional attributes.
     */
    public IfcRevolvedAreaSolid(IfcProfileDef sweptArea,IfcAxis2Placement3D position,IfcAxis1Placement axis,IfcPlaneAngleMeasure angle) {
        super(sweptArea,position);
        this.axis = axis;
        this.angle = angle;
    }
    private void initCollections() {
    }
    public IfcAxis1Placement getAxis() { return this.axis; }
    public void setAxis(IfcAxis1Placement value) { this.axis = value; }
    public IfcPlaneAngleMeasure getAngle() { return this.angle; }
    public void setAngle(IfcPlaneAngleMeasure value) { this.angle = value; }
    public IfcLine getAxisLine() { throw new UnsupportedOperationException("Derived property logic has been implemented for AxisLine."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sweptArea != null ? StepUtils.toStepValue(sweptArea) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(axis != null ? StepUtils.toStepValue(axis) : "$");
		parameters.add(angle != null ? StepUtils.toStepValue(angle) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}