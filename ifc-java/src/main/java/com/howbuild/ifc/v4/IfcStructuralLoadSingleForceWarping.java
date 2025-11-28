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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadsingleforcewarping.htm">IfcStructuralLoadSingleForceWarping</a>
 */
public class IfcStructuralLoadSingleForceWarping extends IfcStructuralLoadSingleForce {
    protected IfcWarpingMomentMeasure warpingMoment;


    /**
     * Constructs IfcStructuralLoadSingleForceWarping with all required attributes.
     */
    public IfcStructuralLoadSingleForceWarping() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadSingleForceWarping with required and optional attributes.
     */
    public IfcStructuralLoadSingleForceWarping(IfcLabel name,IfcForceMeasure forceX,IfcForceMeasure forceY,IfcForceMeasure forceZ,IfcTorqueMeasure momentX,IfcTorqueMeasure momentY,IfcTorqueMeasure momentZ,IfcWarpingMomentMeasure warpingMoment) {
        super(name,forceX,forceY,forceZ,momentX,momentY,momentZ);
        this.warpingMoment = warpingMoment;
    }
    private void initCollections() {
    }
    public IfcWarpingMomentMeasure getWarpingMoment() { return this.warpingMoment; }
    public void setWarpingMoment(IfcWarpingMomentMeasure value) { this.warpingMoment = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(forceX != null ? StepUtils.toStepValue(forceX) : "$");
		parameters.add(forceY != null ? StepUtils.toStepValue(forceY) : "$");
		parameters.add(forceZ != null ? StepUtils.toStepValue(forceZ) : "$");
		parameters.add(momentX != null ? StepUtils.toStepValue(momentX) : "$");
		parameters.add(momentY != null ? StepUtils.toStepValue(momentY) : "$");
		parameters.add(momentZ != null ? StepUtils.toStepValue(momentZ) : "$");
		parameters.add(warpingMoment != null ? StepUtils.toStepValue(warpingMoment) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}