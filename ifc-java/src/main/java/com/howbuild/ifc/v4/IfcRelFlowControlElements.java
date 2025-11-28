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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelflowcontrolelements.htm">IfcRelFlowControlElements</a>
 */
public class IfcRelFlowControlElements extends IfcRelConnects {
    protected Collection<IfcDistributionControlElement> relatedControlElements;
    protected IfcDistributionFlowElement relatingFlowElement;

    protected IfcRelFlowControlElements() { initCollections(); }
    /**
     * Constructs IfcRelFlowControlElements with all required attributes.
     */
    public IfcRelFlowControlElements(IfcGloballyUniqueId globalId,Collection<IfcDistributionControlElement> relatedControlElements,IfcDistributionFlowElement relatingFlowElement) {

        super(globalId);
        this.relatedControlElements = relatedControlElements;
        this.relatingFlowElement = relatingFlowElement;
    }
    /**
     * Constructs IfcRelFlowControlElements with required and optional attributes.
     */
    public IfcRelFlowControlElements(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDistributionControlElement> relatedControlElements,IfcDistributionFlowElement relatingFlowElement) {
        super(globalId,ownerHistory,name,description);
        this.relatedControlElements = relatedControlElements;
        this.relatingFlowElement = relatingFlowElement;
    }
    private void initCollections() {
        this.relatedControlElements = new ArrayList<>();
    }
    public Collection<IfcDistributionControlElement> getRelatedControlElements() { return this.relatedControlElements; }
    public void setRelatedControlElements(Collection<IfcDistributionControlElement> value) { this.relatedControlElements = value; }
    public IfcDistributionFlowElement getRelatingFlowElement() { return this.relatingFlowElement; }
    public void setRelatingFlowElement(IfcDistributionFlowElement value) { this.relatingFlowElement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedControlElements != null ? StepUtils.toStepValue(relatedControlElements) : "$");
		parameters.add(relatingFlowElement != null ? StepUtils.toStepValue(relatingFlowElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelFlowControlElementsRelationship(); }
    private void setIfcRelFlowControlElementsRelationship() {
		if (this.relatedControlElements != null) {
		    for (Object x : this.relatedControlElements) {
		        if (x instanceof IfcDistributionControlElement)
		            ((IfcDistributionControlElement)x).assignedToFlowElement.add(this);
		    }
		}
		if (this.relatingFlowElement != null) {
		    if (this.relatingFlowElement instanceof IfcDistributionFlowElement)
		        ((IfcDistributionFlowElement)this.relatingFlowElement).hasControlElements.add(this);
		}
    }
}