package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAxis2Placement2D
 * SUBTYPE OF (IfcPlacement);
 * RefDirection : OPTIONAL IfcDirection;
 * DERIVE
 * P : LIST [2:2] OF IfcDirection := IfcBuild2Axes(RefDirection);
 * WHERE
 * RefDirIs2D : (NOT (EXISTS (RefDirection))) OR (RefDirection.Dim = 2);
 * LocationIs2D : SELF\IfcPlacement.Location.Dim = 2;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcaxis2placement2d.htm">IfcAxis2Placement2D</a>
 */
public class IfcAxis2Placement2D extends IfcPlacement implements IfcAxis2Placement {
    protected IfcDirection refDirection;

    protected IfcAxis2Placement2D() { initCollections(); }
    /**
     * Constructs IfcAxis2Placement2D with all required attributes.
     */
    public IfcAxis2Placement2D(IfcCartesianPoint location) {

        super(location);
    }
    /**
     * Constructs IfcAxis2Placement2D with required and optional attributes.
     */
    public IfcAxis2Placement2D(IfcCartesianPoint location,IfcDirection refDirection) {
        super(location);
        this.refDirection = refDirection;
    }
    private void initCollections() {
    }
    public IfcDirection getRefDirection() { return this.refDirection; }
    public void setRefDirection(IfcDirection value) { this.refDirection = value; } // optional
    public Collection<IfcDirection> getP() { throw new UnsupportedOperationException("Derived property logic has been implemented for P."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(refDirection != null ? StepUtils.toStepValue(refDirection) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}