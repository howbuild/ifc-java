package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEventType
 * SUBTYPE OF (IfcTypeProcess);
 * PredefinedType : IfcEventTypeEnum;
 * EventTriggerType : IfcEventTriggerTypeEnum;
 * UserDefinedEventTriggerType : OPTIONAL IfcLabel;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcEventTypeEnum.USERDEFINED) OR ((PredefinedType = IfcEventTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcTypeProcess.ProcessType));
 * CorrectEventTriggerType : (EventTriggerType <> IfcEventTriggerTypeEnum.USERDEFINED) OR ((EventTriggerType = IfcEventTriggerTypeEnum.USERDEFINED) AND EXISTS(UserDefinedEventTriggerType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifceventtype.htm">IfcEventType</a>
 */
public class IfcEventType extends IfcTypeProcess {
    protected IfcEventTypeEnum predefinedType;
    protected IfcEventTriggerTypeEnum eventTriggerType;
    protected IfcLabel userDefinedEventTriggerType;

    protected IfcEventType() { initCollections(); }
    /**
     * Constructs IfcEventType with all required attributes.
     */
    public IfcEventType(IfcGloballyUniqueId globalId,IfcEventTypeEnum predefinedType,IfcEventTriggerTypeEnum eventTriggerType) {

        super(globalId);
        this.predefinedType = predefinedType;
        this.eventTriggerType = eventTriggerType;
    }
    /**
     * Constructs IfcEventType with required and optional attributes.
     */
    public IfcEventType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel processType,IfcEventTypeEnum predefinedType,IfcEventTriggerTypeEnum eventTriggerType,IfcLabel userDefinedEventTriggerType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,identification,longDescription,processType);
        this.predefinedType = predefinedType;
        this.eventTriggerType = eventTriggerType;
        this.userDefinedEventTriggerType = userDefinedEventTriggerType;
    }
    private void initCollections() {
    }
    public IfcEventTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcEventTypeEnum value) { this.predefinedType = value; }
    public IfcEventTriggerTypeEnum getEventTriggerType() { return this.eventTriggerType; }
    public void setEventTriggerType(IfcEventTriggerTypeEnum value) { this.eventTriggerType = value; }
    public IfcLabel getUserDefinedEventTriggerType() { return this.userDefinedEventTriggerType; }
    public void setUserDefinedEventTriggerType(IfcLabel value) { this.userDefinedEventTriggerType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(processType != null ? StepUtils.toStepValue(processType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(StepUtils.toStepValue(eventTriggerType));
		parameters.add(userDefinedEventTriggerType != null ? StepUtils.toStepValue(userDefinedEventTriggerType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}