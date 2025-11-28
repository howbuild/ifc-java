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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcprocess.htm">IfcProcess</a>
 */
public abstract class IfcProcess extends IfcObject implements IfcProcessSelect {
    protected IfcIdentifier identification;
    protected IfcText longDescription;
    protected Collection<IfcRelSequence> isPredecessorTo;
    protected Collection<IfcRelSequence> isSuccessorFrom;
    protected Collection<IfcRelAssignsToProcess> operatesOn;

    protected IfcProcess() { initCollections(); }
    /**
     * Constructs IfcProcess with all required attributes.
     */
    public IfcProcess(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.isPredecessorTo = new ArrayList<>();
        this.isSuccessorFrom = new ArrayList<>();
        this.operatesOn = new ArrayList<>();
    }
    /**
     * Constructs IfcProcess with required and optional attributes.
     */
    public IfcProcess(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription) {
        super(globalId,ownerHistory,name,description,objectType);
        this.isPredecessorTo = new ArrayList<>();
        this.isSuccessorFrom = new ArrayList<>();
        this.operatesOn = new ArrayList<>();
        this.identification = identification;
        this.longDescription = longDescription;
    }
    private void initCollections() {
        this.isPredecessorTo = new ArrayList<>();
        this.isSuccessorFrom = new ArrayList<>();
        this.operatesOn = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcText getLongDescription() { return this.longDescription; }
    public void setLongDescription(IfcText value) { this.longDescription = value; } // optional
    public Collection<IfcRelSequence> getIsPredecessorTo() { return this.isPredecessorTo; }
    public void setIsPredecessorTo(Collection<IfcRelSequence> value) { this.isPredecessorTo = value; } // inverse
    public Collection<IfcRelSequence> getIsSuccessorFrom() { return this.isSuccessorFrom; }
    public void setIsSuccessorFrom(Collection<IfcRelSequence> value) { this.isSuccessorFrom = value; } // inverse
    public Collection<IfcRelAssignsToProcess> getOperatesOn() { return this.operatesOn; }
    public void setOperatesOn(Collection<IfcRelAssignsToProcess> value) { this.operatesOn = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}