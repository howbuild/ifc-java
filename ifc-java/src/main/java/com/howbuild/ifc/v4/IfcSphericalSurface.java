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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsphericalsurface.htm">IfcSphericalSurface</a>
 */
public class IfcSphericalSurface extends IfcElementarySurface {
    protected IfcPositiveLengthMeasure radius;

    protected IfcSphericalSurface() { initCollections(); }
    /**
     * Constructs IfcSphericalSurface with all required attributes.
     */
    public IfcSphericalSurface(IfcAxis2Placement3D position,IfcPositiveLengthMeasure radius) {
        super(position);
        this.radius = radius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getRadius() { return this.radius; }
    public void setRadius(IfcPositiveLengthMeasure value) { this.radius = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}