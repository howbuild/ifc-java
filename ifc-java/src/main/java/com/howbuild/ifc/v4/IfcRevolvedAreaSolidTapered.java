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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrevolvedareasolidtapered.htm">IfcRevolvedAreaSolidTapered</a>
 */
public class IfcRevolvedAreaSolidTapered extends IfcRevolvedAreaSolid {
    protected IfcProfileDef endSweptArea;

    protected IfcRevolvedAreaSolidTapered() { initCollections(); }
    /**
     * Constructs IfcRevolvedAreaSolidTapered with all required attributes.
     */
    public IfcRevolvedAreaSolidTapered(IfcProfileDef sweptArea,IfcAxis1Placement axis,IfcPlaneAngleMeasure angle,IfcProfileDef endSweptArea) {

        super(sweptArea,axis,angle);
        this.endSweptArea = endSweptArea;
    }
    /**
     * Constructs IfcRevolvedAreaSolidTapered with required and optional attributes.
     */
    public IfcRevolvedAreaSolidTapered(IfcProfileDef sweptArea,IfcAxis2Placement3D position,IfcAxis1Placement axis,IfcPlaneAngleMeasure angle,IfcProfileDef endSweptArea) {
        super(sweptArea,position,axis,angle);
        this.endSweptArea = endSweptArea;
    }
    private void initCollections() {
    }
    public IfcProfileDef getEndSweptArea() { return this.endSweptArea; }
    public void setEndSweptArea(IfcProfileDef value) { this.endSweptArea = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sweptArea != null ? StepUtils.toStepValue(sweptArea) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(axis != null ? StepUtils.toStepValue(axis) : "$");
		parameters.add(angle != null ? StepUtils.toStepValue(angle) : "$");
		parameters.add(endSweptArea != null ? StepUtils.toStepValue(endSweptArea) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}