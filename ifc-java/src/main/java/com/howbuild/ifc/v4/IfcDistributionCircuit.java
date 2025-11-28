package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDistributionCircuit
 * SUBTYPE OF (IfcDistributionSystem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdistributioncircuit.htm">IfcDistributionCircuit</a>
 */
public class IfcDistributionCircuit extends IfcDistributionSystem {

    protected IfcDistributionCircuit() { initCollections(); }
    /**
     * Constructs IfcDistributionCircuit with all required attributes.
     */
    public IfcDistributionCircuit(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcDistributionCircuit with required and optional attributes.
     */
    public IfcDistributionCircuit(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcLabel longName,IfcDistributionSystemEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,longName,predefinedType);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}