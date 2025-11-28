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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdistributionelement.htm">IfcDistributionElement</a>
 */
public class IfcDistributionElement extends IfcElement {
    protected Collection<IfcRelConnectsPortToElement> hasPorts;

    protected IfcDistributionElement() { initCollections(); }
    /**
     * Constructs IfcDistributionElement with all required attributes.
     */
    public IfcDistributionElement(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasPorts = new ArrayList<>();
    }
    /**
     * Constructs IfcDistributionElement with required and optional attributes.
     */
    public IfcDistributionElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.hasPorts = new ArrayList<>();
    }
    private void initCollections() {
        this.hasPorts = new ArrayList<>();
    }
    public Collection<IfcRelConnectsPortToElement> getHasPorts() { return this.hasPorts; }
    public void setHasPorts(Collection<IfcRelConnectsPortToElement> value) { this.hasPorts = value; } // inverse

    
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
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}