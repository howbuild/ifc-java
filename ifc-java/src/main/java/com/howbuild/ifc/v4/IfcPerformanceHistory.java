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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcperformancehistory.htm">IfcPerformanceHistory</a>
 */
public class IfcPerformanceHistory extends IfcControl {
    protected IfcLabel lifeCyclePhase;
    protected IfcPerformanceHistoryTypeEnum predefinedType;

    protected IfcPerformanceHistory() { initCollections(); }
    /**
     * Constructs IfcPerformanceHistory with all required attributes.
     */
    public IfcPerformanceHistory(IfcGloballyUniqueId globalId,IfcLabel lifeCyclePhase) {

        super(globalId);
        this.lifeCyclePhase = lifeCyclePhase;
    }
    /**
     * Constructs IfcPerformanceHistory with required and optional attributes.
     */
    public IfcPerformanceHistory(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcLabel lifeCyclePhase,IfcPerformanceHistoryTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.lifeCyclePhase = lifeCyclePhase;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcLabel getLifeCyclePhase() { return this.lifeCyclePhase; }
    public void setLifeCyclePhase(IfcLabel value) { this.lifeCyclePhase = value; }
    public IfcPerformanceHistoryTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcPerformanceHistoryTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(lifeCyclePhase != null ? StepUtils.toStepValue(lifeCyclePhase) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}