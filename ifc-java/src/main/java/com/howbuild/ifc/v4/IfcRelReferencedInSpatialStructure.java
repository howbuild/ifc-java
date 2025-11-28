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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelreferencedinspatialstructure.htm">IfcRelReferencedInSpatialStructure</a>
 */
public class IfcRelReferencedInSpatialStructure extends IfcRelConnects {
    protected Collection<IfcProduct> relatedElements;
    protected IfcSpatialElement relatingStructure;

    protected IfcRelReferencedInSpatialStructure() { initCollections(); }
    /**
     * Constructs IfcRelReferencedInSpatialStructure with all required attributes.
     */
    public IfcRelReferencedInSpatialStructure(IfcGloballyUniqueId globalId,Collection<IfcProduct> relatedElements,IfcSpatialElement relatingStructure) {

        super(globalId);
        this.relatedElements = relatedElements;
        this.relatingStructure = relatingStructure;
    }
    /**
     * Constructs IfcRelReferencedInSpatialStructure with required and optional attributes.
     */
    public IfcRelReferencedInSpatialStructure(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcProduct> relatedElements,IfcSpatialElement relatingStructure) {
        super(globalId,ownerHistory,name,description);
        this.relatedElements = relatedElements;
        this.relatingStructure = relatingStructure;
    }
    private void initCollections() {
        this.relatedElements = new ArrayList<>();
    }
    public Collection<IfcProduct> getRelatedElements() { return this.relatedElements; }
    public void setRelatedElements(Collection<IfcProduct> value) { this.relatedElements = value; }
    public IfcSpatialElement getRelatingStructure() { return this.relatingStructure; }
    public void setRelatingStructure(IfcSpatialElement value) { this.relatingStructure = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedElements != null ? StepUtils.toStepValue(relatedElements) : "$");
		parameters.add(relatingStructure != null ? StepUtils.toStepValue(relatingStructure) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelReferencedInSpatialStructureRelationship(); }
    private void setIfcRelReferencedInSpatialStructureRelationship() {
		if (this.relatedElements != null) {
		    for (Object x : this.relatedElements) {
		        if (x instanceof IfcElement)
		            ((IfcElement)x).referencedInStructures.add(this);
		    }
		}
		if (this.relatingStructure != null) {
		    if (this.relatingStructure instanceof IfcSpatialElement)
		        ((IfcSpatialElement)this.relatingStructure).referencesElements.add(this);
		}
    }
}