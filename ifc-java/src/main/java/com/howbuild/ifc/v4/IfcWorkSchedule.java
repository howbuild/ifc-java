package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcWorkControl
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcWorkPlan
 * ,IfcWorkSchedule))
 * SUBTYPE OF (IfcControl);
 * CreationDate : IfcDateTime;
 * Creators : OPTIONAL SET [1:?] OF IfcPerson;
 * Purpose : OPTIONAL IfcLabel;
 * Duration : OPTIONAL IfcDuration;
 * TotalFloat : OPTIONAL IfcDuration;
 * StartTime : IfcDateTime;
 * FinishTime : OPTIONAL IfcDateTime;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcworkschedule.htm">IfcWorkSchedule</a>
 */
public class IfcWorkSchedule extends IfcWorkControl {
    protected IfcWorkScheduleTypeEnum predefinedType;

    protected IfcWorkSchedule() { initCollections(); }
    /**
     * Constructs IfcWorkSchedule with all required attributes.
     */
    public IfcWorkSchedule(IfcGloballyUniqueId globalId,IfcDateTime creationDate,IfcDateTime startTime) {

        super(globalId,creationDate,startTime);
    }
    /**
     * Constructs IfcWorkSchedule with required and optional attributes.
     */
    public IfcWorkSchedule(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcDateTime creationDate,Collection<IfcPerson> creators,IfcLabel purpose,IfcDuration duration,IfcDuration totalFloat,IfcDateTime startTime,IfcDateTime finishTime,IfcWorkScheduleTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,identification,creationDate,creators,purpose,duration,totalFloat,startTime,finishTime);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcWorkScheduleTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcWorkScheduleTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(creationDate != null ? StepUtils.toStepValue(creationDate) : "$");
		parameters.add(creators != null ? StepUtils.toStepValue(creators) : "$");
		parameters.add(purpose != null ? StepUtils.toStepValue(purpose) : "$");
		parameters.add(duration != null ? StepUtils.toStepValue(duration) : "$");
		parameters.add(totalFloat != null ? StepUtils.toStepValue(totalFloat) : "$");
		parameters.add(startTime != null ? StepUtils.toStepValue(startTime) : "$");
		parameters.add(finishTime != null ? StepUtils.toStepValue(finishTime) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}