package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadPlanarForce
 * SUBTYPE OF (IfcStructuralLoadStatic);
 * PlanarForceX : OPTIONAL IfcPlanarForceMeasure;
 * PlanarForceY : OPTIONAL IfcPlanarForceMeasure;
 * PlanarForceZ : OPTIONAL IfcPlanarForceMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadplanarforce.htm">IfcStructuralLoadPlanarForce</a>
 */
public class IfcStructuralLoadPlanarForce extends IfcStructuralLoadStatic {
    protected IfcPlanarForceMeasure planarForceX;
    protected IfcPlanarForceMeasure planarForceY;
    protected IfcPlanarForceMeasure planarForceZ;


    /**
     * Constructs IfcStructuralLoadPlanarForce with all required attributes.
     */
    public IfcStructuralLoadPlanarForce() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadPlanarForce with required and optional attributes.
     */
    public IfcStructuralLoadPlanarForce(IfcLabel name,IfcPlanarForceMeasure planarForceX,IfcPlanarForceMeasure planarForceY,IfcPlanarForceMeasure planarForceZ) {
        super(name);
        this.planarForceX = planarForceX;
        this.planarForceY = planarForceY;
        this.planarForceZ = planarForceZ;
    }
    private void initCollections() {
    }
    public IfcPlanarForceMeasure getPlanarForceX() { return this.planarForceX; }
    public void setPlanarForceX(IfcPlanarForceMeasure value) { this.planarForceX = value; } // optional
    public IfcPlanarForceMeasure getPlanarForceY() { return this.planarForceY; }
    public void setPlanarForceY(IfcPlanarForceMeasure value) { this.planarForceY = value; } // optional
    public IfcPlanarForceMeasure getPlanarForceZ() { return this.planarForceZ; }
    public void setPlanarForceZ(IfcPlanarForceMeasure value) { this.planarForceZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(planarForceX != null ? StepUtils.toStepValue(planarForceX) : "$");
		parameters.add(planarForceY != null ? StepUtils.toStepValue(planarForceY) : "$");
		parameters.add(planarForceZ != null ? StepUtils.toStepValue(planarForceZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}