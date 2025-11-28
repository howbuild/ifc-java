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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectsporttoelement.htm">IfcRelConnectsPortToElement</a>
 */
public class IfcRelConnectsPortToElement extends IfcRelConnects {
    protected IfcPort relatingPort;
    protected IfcDistributionElement relatedElement;

    protected IfcRelConnectsPortToElement() { initCollections(); }
    /**
     * Constructs IfcRelConnectsPortToElement with all required attributes.
     */
    public IfcRelConnectsPortToElement(IfcGloballyUniqueId globalId,IfcPort relatingPort,IfcDistributionElement relatedElement) {

        super(globalId);
        this.relatingPort = relatingPort;
        this.relatedElement = relatedElement;
    }
    /**
     * Constructs IfcRelConnectsPortToElement with required and optional attributes.
     */
    public IfcRelConnectsPortToElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPort relatingPort,IfcDistributionElement relatedElement) {
        super(globalId,ownerHistory,name,description);
        this.relatingPort = relatingPort;
        this.relatedElement = relatedElement;
    }
    private void initCollections() {
    }
    public IfcPort getRelatingPort() { return this.relatingPort; }
    public void setRelatingPort(IfcPort value) { this.relatingPort = value; }
    public IfcDistributionElement getRelatedElement() { return this.relatedElement; }
    public void setRelatedElement(IfcDistributionElement value) { this.relatedElement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingPort != null ? StepUtils.toStepValue(relatingPort) : "$");
		parameters.add(relatedElement != null ? StepUtils.toStepValue(relatedElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelConnectsPortToElementRelationship(); }
    private void setIfcRelConnectsPortToElementRelationship() {
		if (this.relatedElement != null) {
		    if (this.relatedElement instanceof IfcDistributionElement)
		        ((IfcDistributionElement)this.relatedElement).hasPorts.add(this);
		}
		if (this.relatingPort != null) {
		    if (this.relatingPort instanceof IfcPort)
		        ((IfcPort)this.relatingPort).containedIn.add(this);
		}
    }
}