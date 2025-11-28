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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelcoversbldgelements.htm">IfcRelCoversBldgElements</a>
 */
public class IfcRelCoversBldgElements extends IfcRelConnects {
    protected IfcElement relatingBuildingElement;
    protected Collection<IfcCovering> relatedCoverings;

    protected IfcRelCoversBldgElements() { initCollections(); }
    /**
     * Constructs IfcRelCoversBldgElements with all required attributes.
     */
    public IfcRelCoversBldgElements(IfcGloballyUniqueId globalId,IfcElement relatingBuildingElement,Collection<IfcCovering> relatedCoverings) {

        super(globalId);
        this.relatingBuildingElement = relatingBuildingElement;
        this.relatedCoverings = relatedCoverings;
    }
    /**
     * Constructs IfcRelCoversBldgElements with required and optional attributes.
     */
    public IfcRelCoversBldgElements(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcElement relatingBuildingElement,Collection<IfcCovering> relatedCoverings) {
        super(globalId,ownerHistory,name,description);
        this.relatingBuildingElement = relatingBuildingElement;
        this.relatedCoverings = relatedCoverings;
    }
    private void initCollections() {
        this.relatedCoverings = new ArrayList<>();
    }
    public IfcElement getRelatingBuildingElement() { return this.relatingBuildingElement; }
    public void setRelatingBuildingElement(IfcElement value) { this.relatingBuildingElement = value; }
    public Collection<IfcCovering> getRelatedCoverings() { return this.relatedCoverings; }
    public void setRelatedCoverings(Collection<IfcCovering> value) { this.relatedCoverings = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingBuildingElement != null ? StepUtils.toStepValue(relatingBuildingElement) : "$");
		parameters.add(relatedCoverings != null ? StepUtils.toStepValue(relatedCoverings) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelCoversBldgElementsRelationship(); }
    private void setIfcRelCoversBldgElementsRelationship() {
		if (this.relatedCoverings != null) {
		    for (Object x : this.relatedCoverings) {
		        if (x instanceof IfcCovering)
		            ((IfcCovering)x).coversElements.add(this);
		    }
		}
		if (this.relatingBuildingElement != null) {
		    if (this.relatingBuildingElement instanceof IfcElement)
		        ((IfcElement)this.relatingBuildingElement).hasCoverings.add(this);
		}
    }
}