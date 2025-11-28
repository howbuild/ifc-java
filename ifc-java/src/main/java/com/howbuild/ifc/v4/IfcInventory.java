package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGroup
 * SUPERTYPE OF (ONEOF
 * (IfcAsset
 * ,IfcInventory
 * ,IfcStructuralLoadGroup
 * ,IfcStructuralResultGroup
 * ,IfcSystem))
 * SUBTYPE OF (IfcObject);
 * INVERSE
 * IsGroupedBy : SET [0:?] OF IfcRelAssignsToGroup FOR RelatingGroup;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcinventory.htm">IfcInventory</a>
 */
public class IfcInventory extends IfcGroup {
    protected IfcInventoryTypeEnum predefinedType;
    protected IfcActorSelect jurisdiction;
    protected Collection<IfcPerson> responsiblePersons;
    protected IfcDate lastUpdateDate;
    protected IfcCostValue currentValue;
    protected IfcCostValue originalValue;

    protected IfcInventory() { initCollections(); }
    /**
     * Constructs IfcInventory with all required attributes.
     */
    public IfcInventory(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.responsiblePersons = new ArrayList<>();
    }
    /**
     * Constructs IfcInventory with required and optional attributes.
     */
    public IfcInventory(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcInventoryTypeEnum predefinedType,IfcActorSelect jurisdiction,Collection<IfcPerson> responsiblePersons,IfcDate lastUpdateDate,IfcCostValue currentValue,IfcCostValue originalValue) {
        super(globalId,ownerHistory,name,description,objectType);
        this.predefinedType = predefinedType;
        this.jurisdiction = jurisdiction;
        this.responsiblePersons = responsiblePersons;
        this.lastUpdateDate = lastUpdateDate;
        this.currentValue = currentValue;
        this.originalValue = originalValue;
    }
    private void initCollections() {
        this.responsiblePersons = new ArrayList<>();
    }
    public IfcInventoryTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcInventoryTypeEnum value) { this.predefinedType = value; } // optional
    public IfcActorSelect getJurisdiction() { return this.jurisdiction; }
    public void setJurisdiction(IfcActorSelect value) { this.jurisdiction = value; } // optional
    public Collection<IfcPerson> getResponsiblePersons() { return this.responsiblePersons; }
    public void setResponsiblePersons(Collection<IfcPerson> value) { this.responsiblePersons = value; } // optional
    public IfcDate getLastUpdateDate() { return this.lastUpdateDate; }
    public void setLastUpdateDate(IfcDate value) { this.lastUpdateDate = value; } // optional
    public IfcCostValue getCurrentValue() { return this.currentValue; }
    public void setCurrentValue(IfcCostValue value) { this.currentValue = value; } // optional
    public IfcCostValue getOriginalValue() { return this.originalValue; }
    public void setOriginalValue(IfcCostValue value) { this.originalValue = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(jurisdiction != null ? StepUtils.toStepValue(jurisdiction) : "$");
		parameters.add(responsiblePersons != null ? StepUtils.toStepValue(responsiblePersons) : "$");
		parameters.add(lastUpdateDate != null ? StepUtils.toStepValue(lastUpdateDate) : "$");
		parameters.add(currentValue != null ? StepUtils.toStepValue(currentValue) : "$");
		parameters.add(originalValue != null ? StepUtils.toStepValue(originalValue) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}