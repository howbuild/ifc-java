package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcControl
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcActionRequest
 * ,IfcCostItem
 * ,IfcCostSchedule
 * ,IfcPerformanceHistory
 * ,IfcPermit
 * ,IfcProjectOrder
 * ,IfcWorkCalendar
 * ,IfcWorkControl))
 * SUBTYPE OF (IfcObject);
 * Identification : OPTIONAL IfcIdentifier;
 * INVERSE
 * Controls : SET [0:?] OF IfcRelAssignsToControl FOR RelatingControl;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccostitem.htm">IfcCostItem</a>
 */
public class IfcCostItem extends IfcControl {
    protected IfcCostItemTypeEnum predefinedType;
    protected Collection<IfcCostValue> costValues;
    protected Collection<IfcPhysicalQuantity> costQuantities;

    protected IfcCostItem() { initCollections(); }
    /**
     * Constructs IfcCostItem with all required attributes.
     */
    public IfcCostItem(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.costValues = new ArrayList<>();
        this.costQuantities = new ArrayList<>();
    }
    /**
     * Constructs IfcCostItem with required and optional attributes.
     */
    public IfcCostItem(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcCostItemTypeEnum predefinedType,Collection<IfcCostValue> costValues,Collection<IfcPhysicalQuantity> costQuantities) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.predefinedType = predefinedType;
        this.costValues = costValues;
        this.costQuantities = costQuantities;
    }
    private void initCollections() {
        this.costValues = new ArrayList<>();
        this.costQuantities = new ArrayList<>();
    }
    public IfcCostItemTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcCostItemTypeEnum value) { this.predefinedType = value; } // optional
    public Collection<IfcCostValue> getCostValues() { return this.costValues; }
    public void setCostValues(Collection<IfcCostValue> value) { this.costValues = value; } // optional
    public Collection<IfcPhysicalQuantity> getCostQuantities() { return this.costQuantities; }
    public void setCostQuantities(Collection<IfcPhysicalQuantity> value) { this.costQuantities = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(costValues != null ? StepUtils.toStepValue(costValues) : "$");
		parameters.add(costQuantities != null ? StepUtils.toStepValue(costQuantities) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}