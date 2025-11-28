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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcprotectivedevicetrippingunit.htm">IfcProtectiveDeviceTrippingUnit</a>
 */
public class IfcProtectiveDeviceTrippingUnit extends IfcDistributionControlElement {
    protected IfcProtectiveDeviceTrippingUnitTypeEnum predefinedType;

    protected IfcProtectiveDeviceTrippingUnit() { initCollections(); }
    /**
     * Constructs IfcProtectiveDeviceTrippingUnit with all required attributes.
     */
    public IfcProtectiveDeviceTrippingUnit(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcProtectiveDeviceTrippingUnit with required and optional attributes.
     */
    public IfcProtectiveDeviceTrippingUnit(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcProtectiveDeviceTrippingUnitTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcProtectiveDeviceTrippingUnitTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcProtectiveDeviceTrippingUnitTypeEnum value) { this.predefinedType = value; } // optional

    
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