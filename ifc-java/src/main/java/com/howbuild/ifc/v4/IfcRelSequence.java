package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelConnects
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelConnectsElements
 * ,IfcRelConnectsPortToElement
 * ,IfcRelConnectsPorts
 * ,IfcRelConnectsStructuralActivity
 * ,IfcRelConnectsStructuralMember
 * ,IfcRelContainedInSpatialStructure
 * ,IfcRelCoversBldgElements
 * ,IfcRelCoversSpaces
 * ,IfcRelFillsElement
 * ,IfcRelFlowControlElements
 * ,IfcRelInterferesElements
 * ,IfcRelReferencedInSpatialStructure
 * ,IfcRelSequence
 * ,IfcRelServicesBuildings
 * ,IfcRelSpaceBoundary))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelsequence.htm">IfcRelSequence</a>
 */
public class IfcRelSequence extends IfcRelConnects {
    protected IfcProcess relatingProcess;
    protected IfcProcess relatedProcess;
    protected IfcLagTime timeLag;
    protected IfcSequenceEnum sequenceType;
    protected IfcLabel userDefinedSequenceType;

    protected IfcRelSequence() { initCollections(); }
    /**
     * Constructs IfcRelSequence with all required attributes.
     */
    public IfcRelSequence(IfcGloballyUniqueId globalId,IfcProcess relatingProcess,IfcProcess relatedProcess) {

        super(globalId);
        this.relatingProcess = relatingProcess;
        this.relatedProcess = relatedProcess;
    }
    /**
     * Constructs IfcRelSequence with required and optional attributes.
     */
    public IfcRelSequence(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcProcess relatingProcess,IfcProcess relatedProcess,IfcLagTime timeLag,IfcSequenceEnum sequenceType,IfcLabel userDefinedSequenceType) {
        super(globalId,ownerHistory,name,description);
        this.relatingProcess = relatingProcess;
        this.relatedProcess = relatedProcess;
        this.timeLag = timeLag;
        this.sequenceType = sequenceType;
        this.userDefinedSequenceType = userDefinedSequenceType;
    }
    private void initCollections() {
    }
    public IfcProcess getRelatingProcess() { return this.relatingProcess; }
    public void setRelatingProcess(IfcProcess value) { this.relatingProcess = value; }
    public IfcProcess getRelatedProcess() { return this.relatedProcess; }
    public void setRelatedProcess(IfcProcess value) { this.relatedProcess = value; }
    public IfcLagTime getTimeLag() { return this.timeLag; }
    public void setTimeLag(IfcLagTime value) { this.timeLag = value; } // optional
    public IfcSequenceEnum getSequenceType() { return this.sequenceType; }
    public void setSequenceType(IfcSequenceEnum value) { this.sequenceType = value; } // optional
    public IfcLabel getUserDefinedSequenceType() { return this.userDefinedSequenceType; }
    public void setUserDefinedSequenceType(IfcLabel value) { this.userDefinedSequenceType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingProcess != null ? StepUtils.toStepValue(relatingProcess) : "$");
		parameters.add(relatedProcess != null ? StepUtils.toStepValue(relatedProcess) : "$");
		parameters.add(timeLag != null ? StepUtils.toStepValue(timeLag) : "$");
		parameters.add(StepUtils.toStepValue(sequenceType));
		parameters.add(userDefinedSequenceType != null ? StepUtils.toStepValue(userDefinedSequenceType) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelSequenceRelationship(); }
    private void setIfcRelSequenceRelationship() {
		if (this.relatingProcess != null) {
		    if (this.relatingProcess instanceof IfcProcess)
		        ((IfcProcess)this.relatingProcess).isPredecessorTo.add(this);
		}
		if (this.relatedProcess != null) {
		    if (this.relatedProcess instanceof IfcProcess)
		        ((IfcProcess)this.relatedProcess).isSuccessorFrom.add(this);
		}
    }
}