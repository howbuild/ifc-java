package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementarySurface
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCylindricalSurface
 * ,IfcPlane
 * ,IfcSphericalSurface
 * ,IfcToroidalSurface))
 * SUBTYPE OF (IfcSurface);
 * Position : IfcAxis2Placement3D;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcplane.htm">IfcPlane</a>
 */
public class IfcPlane extends IfcElementarySurface {

    protected IfcPlane() { initCollections(); }
    /**
     * Constructs IfcPlane with all required attributes.
     */
    public IfcPlane(IfcAxis2Placement3D position) {
        super(position);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}