package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAxis1Placement
 * SUBTYPE OF (IfcPlacement);
 * Axis : OPTIONAL IfcDirection;
 * DERIVE
 * Z : IfcDirection := NVL (IfcNormalise(Axis), IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcDirection([0.0,0.0,1.0]));
 * WHERE
 * AxisIs3D : (NOT (EXISTS (Axis))) OR (Axis.Dim = 3);
 * LocationIs3D : SELF\IfcPlacement.Location.Dim = 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcplacement.htm">IfcPlacement</a>
 */
public abstract class IfcPlacement extends IfcGeometricRepresentationItem {
    protected IfcCartesianPoint location;

    protected IfcPlacement() { initCollections(); }
    /**
     * Constructs IfcPlacement with all required attributes.
     */
    public IfcPlacement(IfcCartesianPoint location) {
        super();
        this.location = location;
    }
    private void initCollections() {
    }
    public IfcCartesianPoint getLocation() { return this.location; }
    public void setLocation(IfcCartesianPoint value) { this.location = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}