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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcaxis1placement.htm">IfcAxis1Placement</a>
 */
public class IfcAxis1Placement extends IfcPlacement {
    protected IfcDirection axis;

    protected IfcAxis1Placement() { initCollections(); }
    /**
     * Constructs IfcAxis1Placement with all required attributes.
     */
    public IfcAxis1Placement(IfcCartesianPoint location) {

        super(location);
    }
    /**
     * Constructs IfcAxis1Placement with required and optional attributes.
     */
    public IfcAxis1Placement(IfcCartesianPoint location,IfcDirection axis) {
        super(location);
        this.axis = axis;
    }
    private void initCollections() {
    }
    public IfcDirection getAxis() { return this.axis; }
    public void setAxis(IfcDirection value) { this.axis = value; } // optional
    public IfcDirection getZ() { throw new UnsupportedOperationException("Derived property logic has been implemented for Z."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(axis != null ? StepUtils.toStepValue(axis) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}