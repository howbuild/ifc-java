package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSurface
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBoundedSurface
 * ,IfcElementarySurface
 * ,IfcSweptSurface))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsweptsurface.htm">IfcSweptSurface</a>
 */
public abstract class IfcSweptSurface extends IfcSurface {
    protected IfcProfileDef sweptCurve;
    protected IfcAxis2Placement3D position;

    protected IfcSweptSurface() { initCollections(); }
    /**
     * Constructs IfcSweptSurface with all required attributes.
     */
    public IfcSweptSurface(IfcProfileDef sweptCurve) {

        super();
        this.sweptCurve = sweptCurve;
    }
    /**
     * Constructs IfcSweptSurface with required and optional attributes.
     */
    public IfcSweptSurface(IfcProfileDef sweptCurve,IfcAxis2Placement3D position) {
        super();
        this.sweptCurve = sweptCurve;
        this.position = position;
    }
    private void initCollections() {
    }
    public IfcProfileDef getSweptCurve() { return this.sweptCurve; }
    public void setSweptCurve(IfcProfileDef value) { this.sweptCurve = value; }
    public IfcAxis2Placement3D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement3D value) { this.position = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}