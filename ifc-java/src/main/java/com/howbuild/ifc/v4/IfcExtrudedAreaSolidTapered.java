package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExtrudedAreaSolid
 * SUPERTYPE OF (ONEOF
 * (IfcExtrudedAreaSolidTapered))
 * SUBTYPE OF (IfcSweptAreaSolid);
 * ExtrudedDirection : IfcDirection;
 * Depth : IfcPositiveLengthMeasure;
 * WHERE
 * ValidExtrusionDirection : IfcDotProduct(IfcRepresentationItem() || IfcGeometricRepresentationItem() || IfcDirection([0.0,0.0,1.0]), SELF.ExtrudedDirection) <> 0.0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcextrudedareasolidtapered.htm">IfcExtrudedAreaSolidTapered</a>
 */
public class IfcExtrudedAreaSolidTapered extends IfcExtrudedAreaSolid {
    protected IfcProfileDef endSweptArea;

    protected IfcExtrudedAreaSolidTapered() { initCollections(); }
    /**
     * Constructs IfcExtrudedAreaSolidTapered with all required attributes.
     */
    public IfcExtrudedAreaSolidTapered(IfcProfileDef sweptArea,IfcDirection extrudedDirection,IfcPositiveLengthMeasure depth,IfcProfileDef endSweptArea) {

        super(sweptArea,extrudedDirection,depth);
        this.endSweptArea = endSweptArea;
    }
    /**
     * Constructs IfcExtrudedAreaSolidTapered with required and optional attributes.
     */
    public IfcExtrudedAreaSolidTapered(IfcProfileDef sweptArea,IfcAxis2Placement3D position,IfcDirection extrudedDirection,IfcPositiveLengthMeasure depth,IfcProfileDef endSweptArea) {
        super(sweptArea,position,extrudedDirection,depth);
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
		parameters.add(extrudedDirection != null ? StepUtils.toStepValue(extrudedDirection) : "$");
		parameters.add(depth != null ? StepUtils.toStepValue(depth) : "$");
		parameters.add(endSweptArea != null ? StepUtils.toStepValue(endSweptArea) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}