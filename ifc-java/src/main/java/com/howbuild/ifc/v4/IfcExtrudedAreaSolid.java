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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcextrudedareasolid.htm">IfcExtrudedAreaSolid</a>
 */
public class IfcExtrudedAreaSolid extends IfcSweptAreaSolid {
    protected IfcDirection extrudedDirection;
    protected IfcPositiveLengthMeasure depth;

    protected IfcExtrudedAreaSolid() { initCollections(); }
    /**
     * Constructs IfcExtrudedAreaSolid with all required attributes.
     */
    public IfcExtrudedAreaSolid(IfcProfileDef sweptArea,IfcDirection extrudedDirection,IfcPositiveLengthMeasure depth) {

        super(sweptArea);
        this.extrudedDirection = extrudedDirection;
        this.depth = depth;
    }
    /**
     * Constructs IfcExtrudedAreaSolid with required and optional attributes.
     */
    public IfcExtrudedAreaSolid(IfcProfileDef sweptArea,IfcAxis2Placement3D position,IfcDirection extrudedDirection,IfcPositiveLengthMeasure depth) {
        super(sweptArea,position);
        this.extrudedDirection = extrudedDirection;
        this.depth = depth;
    }
    private void initCollections() {
    }
    public IfcDirection getExtrudedDirection() { return this.extrudedDirection; }
    public void setExtrudedDirection(IfcDirection value) { this.extrudedDirection = value; }
    public IfcPositiveLengthMeasure getDepth() { return this.depth; }
    public void setDepth(IfcPositiveLengthMeasure value) { this.depth = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sweptArea != null ? StepUtils.toStepValue(sweptArea) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(extrudedDirection != null ? StepUtils.toStepValue(extrudedDirection) : "$");
		parameters.add(depth != null ? StepUtils.toStepValue(depth) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}