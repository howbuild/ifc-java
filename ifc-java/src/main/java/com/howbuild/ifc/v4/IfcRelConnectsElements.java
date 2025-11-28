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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectselements.htm">IfcRelConnectsElements</a>
 */
public class IfcRelConnectsElements extends IfcRelConnects {
    protected IfcConnectionGeometry connectionGeometry;
    protected IfcElement relatingElement;
    protected IfcElement relatedElement;

    protected IfcRelConnectsElements() { initCollections(); }
    /**
     * Constructs IfcRelConnectsElements with all required attributes.
     */
    public IfcRelConnectsElements(IfcGloballyUniqueId globalId,IfcElement relatingElement,IfcElement relatedElement) {

        super(globalId);
        this.relatingElement = relatingElement;
        this.relatedElement = relatedElement;
    }
    /**
     * Constructs IfcRelConnectsElements with required and optional attributes.
     */
    public IfcRelConnectsElements(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcConnectionGeometry connectionGeometry,IfcElement relatingElement,IfcElement relatedElement) {
        super(globalId,ownerHistory,name,description);
        this.connectionGeometry = connectionGeometry;
        this.relatingElement = relatingElement;
        this.relatedElement = relatedElement;
    }
    private void initCollections() {
    }
    public IfcConnectionGeometry getConnectionGeometry() { return this.connectionGeometry; }
    public void setConnectionGeometry(IfcConnectionGeometry value) { this.connectionGeometry = value; } // optional
    public IfcElement getRelatingElement() { return this.relatingElement; }
    public void setRelatingElement(IfcElement value) { this.relatingElement = value; }
    public IfcElement getRelatedElement() { return this.relatedElement; }
    public void setRelatedElement(IfcElement value) { this.relatedElement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(connectionGeometry != null ? StepUtils.toStepValue(connectionGeometry) : "$");
		parameters.add(relatingElement != null ? StepUtils.toStepValue(relatingElement) : "$");
		parameters.add(relatedElement != null ? StepUtils.toStepValue(relatedElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelConnectsElementsRelationship(); }
    private void setIfcRelConnectsElementsRelationship() {
		if (this.relatingElement != null) {
		    if (this.relatingElement instanceof IfcElement)
		        ((IfcElement)this.relatingElement).connectedTo.add(this);
		}
		if (this.relatedElement != null) {
		    if (this.relatedElement instanceof IfcElement)
		        ((IfcElement)this.relatedElement).connectedFrom.add(this);
		}
    }
}