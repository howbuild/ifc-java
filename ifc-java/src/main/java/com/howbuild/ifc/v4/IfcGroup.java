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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgroup.htm">IfcGroup</a>
 */
public class IfcGroup extends IfcObject {
    protected Collection<IfcRelAssignsToGroup> isGroupedBy;

    protected IfcGroup() { initCollections(); }
    /**
     * Constructs IfcGroup with all required attributes.
     */
    public IfcGroup(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.isGroupedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcGroup with required and optional attributes.
     */
    public IfcGroup(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType) {
        super(globalId,ownerHistory,name,description,objectType);
        this.isGroupedBy = new ArrayList<>();
    }
    private void initCollections() {
        this.isGroupedBy = new ArrayList<>();
    }
    public Collection<IfcRelAssignsToGroup> getIsGroupedBy() { return this.isGroupedBy; }
    public void setIsGroupedBy(Collection<IfcRelAssignsToGroup> value) { this.isGroupedBy = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}