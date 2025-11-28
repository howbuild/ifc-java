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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctoroidalsurface.htm">IfcToroidalSurface</a>
 */
public class IfcToroidalSurface extends IfcElementarySurface {
    protected IfcPositiveLengthMeasure majorRadius;
    protected IfcPositiveLengthMeasure minorRadius;

    protected IfcToroidalSurface() { initCollections(); }
    /**
     * Constructs IfcToroidalSurface with all required attributes.
     */
    public IfcToroidalSurface(IfcAxis2Placement3D position,IfcPositiveLengthMeasure majorRadius,IfcPositiveLengthMeasure minorRadius) {
        super(position);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getMajorRadius() { return this.majorRadius; }
    public void setMajorRadius(IfcPositiveLengthMeasure value) { this.majorRadius = value; }
    public IfcPositiveLengthMeasure getMinorRadius() { return this.minorRadius; }
    public void setMinorRadius(IfcPositiveLengthMeasure value) { this.minorRadius = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(majorRadius != null ? StepUtils.toStepValue(majorRadius) : "$");
		parameters.add(minorRadius != null ? StepUtils.toStepValue(minorRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}