package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundaryNodeCondition
 * SUPERTYPE OF (ONEOF
 * (IfcBoundaryNodeConditionWarping))
 * SUBTYPE OF (IfcBoundaryCondition);
 * TranslationalStiffnessX : OPTIONAL IfcTranslationalStiffnessSelect;
 * TranslationalStiffnessY : OPTIONAL IfcTranslationalStiffnessSelect;
 * TranslationalStiffnessZ : OPTIONAL IfcTranslationalStiffnessSelect;
 * RotationalStiffnessX : OPTIONAL IfcRotationalStiffnessSelect;
 * RotationalStiffnessY : OPTIONAL IfcRotationalStiffnessSelect;
 * RotationalStiffnessZ : OPTIONAL IfcRotationalStiffnessSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundarynodeconditionwarping.htm">IfcBoundaryNodeConditionWarping</a>
 */
public class IfcBoundaryNodeConditionWarping extends IfcBoundaryNodeCondition {
    protected IfcWarpingStiffnessSelect warpingStiffness;


    /**
     * Constructs IfcBoundaryNodeConditionWarping with all required attributes.
     */
    public IfcBoundaryNodeConditionWarping() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcBoundaryNodeConditionWarping with required and optional attributes.
     */
    public IfcBoundaryNodeConditionWarping(IfcLabel name,IfcTranslationalStiffnessSelect translationalStiffnessX,IfcTranslationalStiffnessSelect translationalStiffnessY,IfcTranslationalStiffnessSelect translationalStiffnessZ,IfcRotationalStiffnessSelect rotationalStiffnessX,IfcRotationalStiffnessSelect rotationalStiffnessY,IfcRotationalStiffnessSelect rotationalStiffnessZ,IfcWarpingStiffnessSelect warpingStiffness) {
        super(name,translationalStiffnessX,translationalStiffnessY,translationalStiffnessZ,rotationalStiffnessX,rotationalStiffnessY,rotationalStiffnessZ);
        this.warpingStiffness = warpingStiffness;
    }
    private void initCollections() {
    }
    public IfcWarpingStiffnessSelect getWarpingStiffness() { return this.warpingStiffness; }
    public void setWarpingStiffness(IfcWarpingStiffnessSelect value) { this.warpingStiffness = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(translationalStiffnessX != null ? StepUtils.toStepValue(translationalStiffnessX) : "$");
		parameters.add(translationalStiffnessY != null ? StepUtils.toStepValue(translationalStiffnessY) : "$");
		parameters.add(translationalStiffnessZ != null ? StepUtils.toStepValue(translationalStiffnessZ) : "$");
		parameters.add(rotationalStiffnessX != null ? StepUtils.toStepValue(rotationalStiffnessX) : "$");
		parameters.add(rotationalStiffnessY != null ? StepUtils.toStepValue(rotationalStiffnessY) : "$");
		parameters.add(rotationalStiffnessZ != null ? StepUtils.toStepValue(rotationalStiffnessZ) : "$");
		parameters.add(warpingStiffness != null ? StepUtils.toStepValue(warpingStiffness) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}