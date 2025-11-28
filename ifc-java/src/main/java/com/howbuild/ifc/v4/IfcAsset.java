package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAsset
 * SUBTYPE OF (IfcGroup);
 * Identification : OPTIONAL IfcIdentifier;
 * OriginalValue : OPTIONAL IfcCostValue;
 * CurrentValue : OPTIONAL IfcCostValue;
 * TotalReplacementCost : OPTIONAL IfcCostValue;
 * Owner : OPTIONAL IfcActorSelect;
 * User : OPTIONAL IfcActorSelect;
 * ResponsiblePerson : OPTIONAL IfcPerson;
 * IncorporationDate : OPTIONAL IfcDate;
 * DepreciatedValue : OPTIONAL IfcCostValue;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcasset.htm">IfcAsset</a>
 */
public class IfcAsset extends IfcGroup {
    protected IfcIdentifier identification;
    protected IfcCostValue originalValue;
    protected IfcCostValue currentValue;
    protected IfcCostValue totalReplacementCost;
    protected IfcActorSelect owner;
    protected IfcActorSelect user;
    protected IfcPerson responsiblePerson;
    protected IfcDate incorporationDate;
    protected IfcCostValue depreciatedValue;

    protected IfcAsset() { initCollections(); }
    /**
     * Constructs IfcAsset with all required attributes.
     */
    public IfcAsset(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcAsset with required and optional attributes.
     */
    public IfcAsset(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcCostValue originalValue,IfcCostValue currentValue,IfcCostValue totalReplacementCost,IfcActorSelect owner,IfcActorSelect user,IfcPerson responsiblePerson,IfcDate incorporationDate,IfcCostValue depreciatedValue) {
        super(globalId,ownerHistory,name,description,objectType);
        this.identification = identification;
        this.originalValue = originalValue;
        this.currentValue = currentValue;
        this.totalReplacementCost = totalReplacementCost;
        this.owner = owner;
        this.user = user;
        this.responsiblePerson = responsiblePerson;
        this.incorporationDate = incorporationDate;
        this.depreciatedValue = depreciatedValue;
    }
    private void initCollections() {
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcCostValue getOriginalValue() { return this.originalValue; }
    public void setOriginalValue(IfcCostValue value) { this.originalValue = value; } // optional
    public IfcCostValue getCurrentValue() { return this.currentValue; }
    public void setCurrentValue(IfcCostValue value) { this.currentValue = value; } // optional
    public IfcCostValue getTotalReplacementCost() { return this.totalReplacementCost; }
    public void setTotalReplacementCost(IfcCostValue value) { this.totalReplacementCost = value; } // optional
    public IfcActorSelect getOwner() { return this.owner; }
    public void setOwner(IfcActorSelect value) { this.owner = value; } // optional
    public IfcActorSelect getUser() { return this.user; }
    public void setUser(IfcActorSelect value) { this.user = value; } // optional
    public IfcPerson getResponsiblePerson() { return this.responsiblePerson; }
    public void setResponsiblePerson(IfcPerson value) { this.responsiblePerson = value; } // optional
    public IfcDate getIncorporationDate() { return this.incorporationDate; }
    public void setIncorporationDate(IfcDate value) { this.incorporationDate = value; } // optional
    public IfcCostValue getDepreciatedValue() { return this.depreciatedValue; }
    public void setDepreciatedValue(IfcCostValue value) { this.depreciatedValue = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(originalValue != null ? StepUtils.toStepValue(originalValue) : "$");
		parameters.add(currentValue != null ? StepUtils.toStepValue(currentValue) : "$");
		parameters.add(totalReplacementCost != null ? StepUtils.toStepValue(totalReplacementCost) : "$");
		parameters.add(owner != null ? StepUtils.toStepValue(owner) : "$");
		parameters.add(user != null ? StepUtils.toStepValue(user) : "$");
		parameters.add(responsiblePerson != null ? StepUtils.toStepValue(responsiblePerson) : "$");
		parameters.add(incorporationDate != null ? StepUtils.toStepValue(incorporationDate) : "$");
		parameters.add(depreciatedValue != null ? StepUtils.toStepValue(depreciatedValue) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}