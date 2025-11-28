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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsweptareasolid.htm">IfcSweptAreaSolid</a>
 */
public abstract class IfcSweptAreaSolid extends IfcSolidModel {
    protected IfcProfileDef sweptArea;
    protected IfcAxis2Placement3D position;

    protected IfcSweptAreaSolid() { initCollections(); }
    /**
     * Constructs IfcSweptAreaSolid with all required attributes.
     */
    public IfcSweptAreaSolid(IfcProfileDef sweptArea) {

        super();
        this.sweptArea = sweptArea;
    }
    /**
     * Constructs IfcSweptAreaSolid with required and optional attributes.
     */
    public IfcSweptAreaSolid(IfcProfileDef sweptArea,IfcAxis2Placement3D position) {
        super();
        this.sweptArea = sweptArea;
        this.position = position;
    }
    private void initCollections() {
    }
    public IfcProfileDef getSweptArea() { return this.sweptArea; }
    public void setSweptArea(IfcProfileDef value) { this.sweptArea = value; }
    public IfcAxis2Placement3D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement3D value) { this.position = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}