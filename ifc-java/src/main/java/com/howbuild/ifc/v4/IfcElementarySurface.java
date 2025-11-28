package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCylindricalSurface
 * SUBTYPE OF (IfcElementarySurface);
 * Radius : IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelementarysurface.htm">IfcElementarySurface</a>
 */
public abstract class IfcElementarySurface extends IfcSurface {
    protected IfcAxis2Placement3D position;

    protected IfcElementarySurface() { initCollections(); }
    /**
     * Constructs IfcElementarySurface with all required attributes.
     */
    public IfcElementarySurface(IfcAxis2Placement3D position) {
        super();
        this.position = position;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement3D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement3D value) { this.position = value; }


    // inherits no-op finalizeRelationships from BaseIfc

}