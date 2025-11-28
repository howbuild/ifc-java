package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBlock
 * SUBTYPE OF (IfcCsgPrimitive3D);
 * XLength : IfcPositiveLengthMeasure;
 * YLength : IfcPositiveLengthMeasure;
 * ZLength : IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccsgprimitive3d.htm">IfcCsgPrimitive3D</a>
 */
public abstract class IfcCsgPrimitive3D extends IfcGeometricRepresentationItem implements IfcBooleanOperand, IfcCsgSelect {
    protected IfcAxis2Placement3D position;

    protected IfcCsgPrimitive3D() { initCollections(); }
    /**
     * Constructs IfcCsgPrimitive3D with all required attributes.
     */
    public IfcCsgPrimitive3D(IfcAxis2Placement3D position) {
        super();
        this.position = position;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement3D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement3D value) { this.position = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}