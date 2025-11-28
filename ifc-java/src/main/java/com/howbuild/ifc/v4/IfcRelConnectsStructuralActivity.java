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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectsstructuralactivity.htm">IfcRelConnectsStructuralActivity</a>
 */
public class IfcRelConnectsStructuralActivity extends IfcRelConnects {
    protected IfcStructuralActivityAssignmentSelect relatingElement;
    protected IfcStructuralActivity relatedStructuralActivity;

    protected IfcRelConnectsStructuralActivity() { initCollections(); }
    /**
     * Constructs IfcRelConnectsStructuralActivity with all required attributes.
     */
    public IfcRelConnectsStructuralActivity(IfcGloballyUniqueId globalId,IfcStructuralActivityAssignmentSelect relatingElement,IfcStructuralActivity relatedStructuralActivity) {

        super(globalId);
        this.relatingElement = relatingElement;
        this.relatedStructuralActivity = relatedStructuralActivity;
    }
    /**
     * Constructs IfcRelConnectsStructuralActivity with required and optional attributes.
     */
    public IfcRelConnectsStructuralActivity(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcStructuralActivityAssignmentSelect relatingElement,IfcStructuralActivity relatedStructuralActivity) {
        super(globalId,ownerHistory,name,description);
        this.relatingElement = relatingElement;
        this.relatedStructuralActivity = relatedStructuralActivity;
    }
    private void initCollections() {
    }
    public IfcStructuralActivityAssignmentSelect getRelatingElement() { return this.relatingElement; }
    public void setRelatingElement(IfcStructuralActivityAssignmentSelect value) { this.relatingElement = value; }
    public IfcStructuralActivity getRelatedStructuralActivity() { return this.relatedStructuralActivity; }
    public void setRelatedStructuralActivity(IfcStructuralActivity value) { this.relatedStructuralActivity = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingElement != null ? StepUtils.toStepValue(relatingElement) : "$");
		parameters.add(relatedStructuralActivity != null ? StepUtils.toStepValue(relatedStructuralActivity) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelConnectsStructuralActivityRelationship(); }
    private void setIfcRelConnectsStructuralActivityRelationship() {
		if (this.relatedStructuralActivity != null) {
		    if (this.relatedStructuralActivity instanceof IfcStructuralActivity)
		        ((IfcStructuralActivity)this.relatedStructuralActivity).assignedToStructuralItem.add(this);
		}
		if (this.relatingElement != null) {
		    if (this.relatingElement instanceof IfcStructuralItem)
		        ((IfcStructuralItem)this.relatingElement).assignedStructuralActivity.add(this);
		}
    }
}