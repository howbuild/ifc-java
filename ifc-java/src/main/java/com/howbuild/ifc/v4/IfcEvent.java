package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEvent
 * SUBTYPE OF (IfcProcess);
 * PredefinedType : OPTIONAL IfcEventTypeEnum;
 * EventTriggerType : OPTIONAL IfcEventTriggerTypeEnum;
 * UserDefinedEventTriggerType : OPTIONAL IfcLabel;
 * EventOccurenceTime : OPTIONAL IfcEventTime;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR (PredefinedType <> IfcEventTypeEnum.USERDEFINED) OR ((PredefinedType = IfcEventTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : NOT(EXISTS(EventTriggerType)) OR (EventTriggerType <> IfcEventTriggerTypeEnum.USERDEFINED) OR ((EventTriggerType = IfcEventTriggerTypeEnum.USERDEFINED) AND EXISTS(UserDefinedEventTriggerType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcevent.htm">IfcEvent</a>
 */
public class IfcEvent extends IfcProcess {
    protected IfcEventTypeEnum predefinedType;
    protected IfcEventTriggerTypeEnum eventTriggerType;
    protected IfcLabel userDefinedEventTriggerType;
    protected IfcEventTime eventOccurenceTime;

    protected IfcEvent() { initCollections(); }
    /**
     * Constructs IfcEvent with all required attributes.
     */
    public IfcEvent(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcEvent with required and optional attributes.
     */
    public IfcEvent(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription,IfcEventTypeEnum predefinedType,IfcEventTriggerTypeEnum eventTriggerType,IfcLabel userDefinedEventTriggerType,IfcEventTime eventOccurenceTime) {
        super(globalId,ownerHistory,name,description,objectType,identification,longDescription);
        this.predefinedType = predefinedType;
        this.eventTriggerType = eventTriggerType;
        this.userDefinedEventTriggerType = userDefinedEventTriggerType;
        this.eventOccurenceTime = eventOccurenceTime;
    }
    private void initCollections() {
    }
    public IfcEventTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcEventTypeEnum value) { this.predefinedType = value; } // optional
    public IfcEventTriggerTypeEnum getEventTriggerType() { return this.eventTriggerType; }
    public void setEventTriggerType(IfcEventTriggerTypeEnum value) { this.eventTriggerType = value; } // optional
    public IfcLabel getUserDefinedEventTriggerType() { return this.userDefinedEventTriggerType; }
    public void setUserDefinedEventTriggerType(IfcLabel value) { this.userDefinedEventTriggerType = value; } // optional
    public IfcEventTime getEventOccurenceTime() { return this.eventOccurenceTime; }
    public void setEventOccurenceTime(IfcEventTime value) { this.eventOccurenceTime = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(StepUtils.toStepValue(eventTriggerType));
		parameters.add(userDefinedEventTriggerType != null ? StepUtils.toStepValue(userDefinedEventTriggerType) : "$");
		parameters.add(eventOccurenceTime != null ? StepUtils.toStepValue(eventOccurenceTime) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}