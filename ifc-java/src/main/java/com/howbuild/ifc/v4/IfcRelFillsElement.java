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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelfillselement.htm">IfcRelFillsElement</a>
 */
public class IfcRelFillsElement extends IfcRelConnects {
    protected IfcOpeningElement relatingOpeningElement;
    protected IfcElement relatedBuildingElement;

    protected IfcRelFillsElement() { initCollections(); }
    /**
     * Constructs IfcRelFillsElement with all required attributes.
     */
    public IfcRelFillsElement(IfcGloballyUniqueId globalId,IfcOpeningElement relatingOpeningElement,IfcElement relatedBuildingElement) {

        super(globalId);
        this.relatingOpeningElement = relatingOpeningElement;
        this.relatedBuildingElement = relatedBuildingElement;
    }
    /**
     * Constructs IfcRelFillsElement with required and optional attributes.
     */
    public IfcRelFillsElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcOpeningElement relatingOpeningElement,IfcElement relatedBuildingElement) {
        super(globalId,ownerHistory,name,description);
        this.relatingOpeningElement = relatingOpeningElement;
        this.relatedBuildingElement = relatedBuildingElement;
    }
    private void initCollections() {
    }
    public IfcOpeningElement getRelatingOpeningElement() { return this.relatingOpeningElement; }
    public void setRelatingOpeningElement(IfcOpeningElement value) { this.relatingOpeningElement = value; }
    public IfcElement getRelatedBuildingElement() { return this.relatedBuildingElement; }
    public void setRelatedBuildingElement(IfcElement value) { this.relatedBuildingElement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingOpeningElement != null ? StepUtils.toStepValue(relatingOpeningElement) : "$");
		parameters.add(relatedBuildingElement != null ? StepUtils.toStepValue(relatedBuildingElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelFillsElementRelationship(); }
    private void setIfcRelFillsElementRelationship() {
		if (this.relatedBuildingElement != null) {
		    if (this.relatedBuildingElement instanceof IfcElement)
		        ((IfcElement)this.relatedBuildingElement).fillsVoids.add(this);
		}
		if (this.relatingOpeningElement != null) {
		    if (this.relatingOpeningElement instanceof IfcOpeningElement)
		        ((IfcOpeningElement)this.relatingOpeningElement).hasFillings.add(this);
		}
    }
}