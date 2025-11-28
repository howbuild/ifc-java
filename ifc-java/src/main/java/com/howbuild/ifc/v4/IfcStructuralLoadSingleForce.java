package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadSingleForce
 * SUPERTYPE OF (ONEOF
 * (IfcStructuralLoadSingleForceWarping))
 * SUBTYPE OF (IfcStructuralLoadStatic);
 * ForceX : OPTIONAL IfcForceMeasure;
 * ForceY : OPTIONAL IfcForceMeasure;
 * ForceZ : OPTIONAL IfcForceMeasure;
 * MomentX : OPTIONAL IfcTorqueMeasure;
 * MomentY : OPTIONAL IfcTorqueMeasure;
 * MomentZ : OPTIONAL IfcTorqueMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadsingleforce.htm">IfcStructuralLoadSingleForce</a>
 */
public class IfcStructuralLoadSingleForce extends IfcStructuralLoadStatic {
    protected IfcForceMeasure forceX;
    protected IfcForceMeasure forceY;
    protected IfcForceMeasure forceZ;
    protected IfcTorqueMeasure momentX;
    protected IfcTorqueMeasure momentY;
    protected IfcTorqueMeasure momentZ;


    /**
     * Constructs IfcStructuralLoadSingleForce with all required attributes.
     */
    public IfcStructuralLoadSingleForce() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadSingleForce with required and optional attributes.
     */
    public IfcStructuralLoadSingleForce(IfcLabel name,IfcForceMeasure forceX,IfcForceMeasure forceY,IfcForceMeasure forceZ,IfcTorqueMeasure momentX,IfcTorqueMeasure momentY,IfcTorqueMeasure momentZ) {
        super(name);
        this.forceX = forceX;
        this.forceY = forceY;
        this.forceZ = forceZ;
        this.momentX = momentX;
        this.momentY = momentY;
        this.momentZ = momentZ;
    }
    private void initCollections() {
    }
    public IfcForceMeasure getForceX() { return this.forceX; }
    public void setForceX(IfcForceMeasure value) { this.forceX = value; } // optional
    public IfcForceMeasure getForceY() { return this.forceY; }
    public void setForceY(IfcForceMeasure value) { this.forceY = value; } // optional
    public IfcForceMeasure getForceZ() { return this.forceZ; }
    public void setForceZ(IfcForceMeasure value) { this.forceZ = value; } // optional
    public IfcTorqueMeasure getMomentX() { return this.momentX; }
    public void setMomentX(IfcTorqueMeasure value) { this.momentX = value; } // optional
    public IfcTorqueMeasure getMomentY() { return this.momentY; }
    public void setMomentY(IfcTorqueMeasure value) { this.momentY = value; } // optional
    public IfcTorqueMeasure getMomentZ() { return this.momentZ; }
    public void setMomentZ(IfcTorqueMeasure value) { this.momentZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(forceX != null ? StepUtils.toStepValue(forceX) : "$");
		parameters.add(forceY != null ? StepUtils.toStepValue(forceY) : "$");
		parameters.add(forceZ != null ? StepUtils.toStepValue(forceZ) : "$");
		parameters.add(momentX != null ? StepUtils.toStepValue(momentX) : "$");
		parameters.add(momentY != null ? StepUtils.toStepValue(momentY) : "$");
		parameters.add(momentZ != null ? StepUtils.toStepValue(momentZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}