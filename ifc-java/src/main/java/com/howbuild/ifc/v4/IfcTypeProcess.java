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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctypeprocess.htm">IfcTypeProcess</a>
 */
public abstract class IfcTypeProcess extends IfcTypeObject implements IfcProcessSelect {
    protected IfcIdentifier identification;
    protected IfcText longDescription;
    protected IfcLabel processType;
    protected Collection<IfcRelAssignsToProcess> operatesOn;

    protected IfcTypeProcess() { initCollections(); }
    /**
     * Constructs IfcTypeProcess with all required attributes.
     */
    public IfcTypeProcess(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.operatesOn = new ArrayList<>();
    }
    /**
     * Constructs IfcTypeProcess with required and optional attributes.
     */
    public IfcTypeProcess(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel processType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets);
        this.operatesOn = new ArrayList<>();
        this.identification = identification;
        this.longDescription = longDescription;
        this.processType = processType;
    }
    private void initCollections() {
        this.operatesOn = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcText getLongDescription() { return this.longDescription; }
    public void setLongDescription(IfcText value) { this.longDescription = value; } // optional
    public IfcLabel getProcessType() { return this.processType; }
    public void setProcessType(IfcLabel value) { this.processType = value; } // optional
    public Collection<IfcRelAssignsToProcess> getOperatesOn() { return this.operatesOn; }
    public void setOperatesOn(Collection<IfcRelAssignsToProcess> value) { this.operatesOn = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}