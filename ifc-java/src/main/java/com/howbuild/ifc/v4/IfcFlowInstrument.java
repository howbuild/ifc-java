package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDistributionControlElement
 * SUPERTYPE OF (ONEOF
 * (IfcActuator
 * ,IfcAlarm
 * ,IfcController
 * ,IfcFlowInstrument
 * ,IfcProtectiveDeviceTrippingUnit
 * ,IfcSensor
 * ,IfcUnitaryControlElement))
 * SUBTYPE OF (IfcDistributionElement);
 * INVERSE
 * AssignedToFlowElement : SET [0:1] OF IfcRelFlowControlElements FOR RelatedControlElements;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowinstrument.htm">IfcFlowInstrument</a>
 */
public class IfcFlowInstrument extends IfcDistributionControlElement {
    protected IfcFlowInstrumentTypeEnum predefinedType;

    protected IfcFlowInstrument() { initCollections(); }
    /**
     * Constructs IfcFlowInstrument with all required attributes.
     */
    public IfcFlowInstrument(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowInstrument with required and optional attributes.
     */
    public IfcFlowInstrument(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcFlowInstrumentTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcFlowInstrumentTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcFlowInstrumentTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}