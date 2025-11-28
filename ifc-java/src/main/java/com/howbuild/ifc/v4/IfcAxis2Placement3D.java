package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAxis2Placement3D
 * SUBTYPE OF (IfcPlacement);
 * Axis : OPTIONAL IfcDirection;
 * RefDirection : OPTIONAL IfcDirection;
 * DERIVE
 * P : LIST [3:3] OF IfcDirection := IfcBuildAxes(Axis, RefDirection);
 * WHERE
 * LocationIs3D : SELF\IfcPlacement.Location.Dim = 3;
 * AxisIs3D : (NOT (EXISTS (Axis))) OR (Axis.Dim = 3);
 * RefDirIs3D : (NOT (EXISTS (RefDirection))) OR (RefDirection.Dim = 3);
 * AxisToRefDirPosition : (NOT (EXISTS (Axis))) OR (NOT (EXISTS (RefDirection))) OR (IfcCrossProduct(Axis,RefDirection).Magnitude > 0.0);
 * AxisAndRefDirProvision : NOT ((EXISTS (Axis)) XOR (EXISTS (RefDirection)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcaxis2placement3d.htm">IfcAxis2Placement3D</a>
 */
public class IfcAxis2Placement3D extends IfcPlacement implements IfcAxis2Placement {
    protected IfcDirection axis;
    protected IfcDirection refDirection;

    protected IfcAxis2Placement3D() { initCollections(); }
    /**
     * Constructs IfcAxis2Placement3D with all required attributes.
     */
    public IfcAxis2Placement3D(IfcCartesianPoint location) {

        super(location);
    }
    /**
     * Constructs IfcAxis2Placement3D with required and optional attributes.
     */
    public IfcAxis2Placement3D(IfcCartesianPoint location,IfcDirection axis,IfcDirection refDirection) {
        super(location);
        this.axis = axis;
        this.refDirection = refDirection;
    }
    private void initCollections() {
    }
    public IfcDirection getAxis() { return this.axis; }
    public void setAxis(IfcDirection value) { this.axis = value; } // optional
    public IfcDirection getRefDirection() { return this.refDirection; }
    public void setRefDirection(IfcDirection value) { this.refDirection = value; } // optional
    public Collection<IfcDirection> getP() { throw new UnsupportedOperationException("Derived property logic has been implemented for P."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(axis != null ? StepUtils.toStepValue(axis) : "$");
		parameters.add(refDirection != null ? StepUtils.toStepValue(refDirection) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}