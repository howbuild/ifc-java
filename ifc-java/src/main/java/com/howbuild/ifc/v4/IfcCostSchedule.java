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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccostschedule.htm">IfcCostSchedule</a>
 */
public class IfcCostSchedule extends IfcControl {
    protected IfcCostScheduleTypeEnum predefinedType;
    protected IfcLabel status;
    protected IfcDateTime submittedOn;
    protected IfcDateTime updateDate;

    protected IfcCostSchedule() { initCollections(); }
    /**
     * Constructs IfcCostSchedule with all required attributes.
     */
    public IfcCostSchedule(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcCostSchedule with required and optional attributes.
     */
    public IfcCostSchedule(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcCostScheduleTypeEnum predefinedType,IfcLabel status,IfcDateTime submittedOn,IfcDateTime updateDate) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.predefinedType = predefinedType;
        this.status = status;
        this.submittedOn = submittedOn;
        this.updateDate = updateDate;
    }
    private void initCollections() {
    }
    public IfcCostScheduleTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcCostScheduleTypeEnum value) { this.predefinedType = value; } // optional
    public IfcLabel getStatus() { return this.status; }
    public void setStatus(IfcLabel value) { this.status = value; } // optional
    public IfcDateTime getSubmittedOn() { return this.submittedOn; }
    public void setSubmittedOn(IfcDateTime value) { this.submittedOn = value; } // optional
    public IfcDateTime getUpdateDate() { return this.updateDate; }
    public void setUpdateDate(IfcDateTime value) { this.updateDate = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(status != null ? StepUtils.toStepValue(status) : "$");
		parameters.add(submittedOn != null ? StepUtils.toStepValue(submittedOn) : "$");
		parameters.add(updateDate != null ? StepUtils.toStepValue(updateDate) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}