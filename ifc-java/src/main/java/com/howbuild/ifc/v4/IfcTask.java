package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcProcess
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcEvent
 * ,IfcProcedure
 * ,IfcTask))
 * SUBTYPE OF (IfcObject);
 * Identification : OPTIONAL IfcIdentifier;
 * LongDescription : OPTIONAL IfcText;
 * INVERSE
 * IsPredecessorTo : SET [0:?] OF IfcRelSequence FOR RelatingProcess;
 * IsSuccessorFrom : SET [0:?] OF IfcRelSequence FOR RelatedProcess;
 * OperatesOn : SET [0:?] OF IfcRelAssignsToProcess FOR RelatingProcess;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctask.htm">IfcTask</a>
 */
public class IfcTask extends IfcProcess {
    protected IfcLabel status;
    protected IfcLabel workMethod;
    protected IfcBoolean isMilestone;
    protected IfcInteger priority;
    protected IfcTaskTime taskTime;
    protected IfcTaskTypeEnum predefinedType;

    protected IfcTask() { initCollections(); }
    /**
     * Constructs IfcTask with all required attributes.
     */
    public IfcTask(IfcGloballyUniqueId globalId,IfcBoolean isMilestone) {

        super(globalId);
        this.isMilestone = isMilestone;
    }
    /**
     * Constructs IfcTask with required and optional attributes.
     */
    public IfcTask(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription,IfcLabel status,IfcLabel workMethod,IfcBoolean isMilestone,IfcInteger priority,IfcTaskTime taskTime,IfcTaskTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,identification,longDescription);
        this.status = status;
        this.workMethod = workMethod;
        this.isMilestone = isMilestone;
        this.priority = priority;
        this.taskTime = taskTime;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcLabel getStatus() { return this.status; }
    public void setStatus(IfcLabel value) { this.status = value; } // optional
    public IfcLabel getWorkMethod() { return this.workMethod; }
    public void setWorkMethod(IfcLabel value) { this.workMethod = value; } // optional
    public IfcBoolean getIsMilestone() { return this.isMilestone; }
    public void setIsMilestone(IfcBoolean value) { this.isMilestone = value; }
    public IfcInteger getPriority() { return this.priority; }
    public void setPriority(IfcInteger value) { this.priority = value; } // optional
    public IfcTaskTime getTaskTime() { return this.taskTime; }
    public void setTaskTime(IfcTaskTime value) { this.taskTime = value; } // optional
    public IfcTaskTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcTaskTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(status != null ? StepUtils.toStepValue(status) : "$");
		parameters.add(workMethod != null ? StepUtils.toStepValue(workMethod) : "$");
		parameters.add(isMilestone != null ? StepUtils.toStepValue(isMilestone) : "$");
		parameters.add(priority != null ? StepUtils.toStepValue(priority) : "$");
		parameters.add(taskTime != null ? StepUtils.toStepValue(taskTime) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}