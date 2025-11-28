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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelcoversspaces.htm">IfcRelCoversSpaces</a>
 */
public class IfcRelCoversSpaces extends IfcRelConnects {
    protected IfcSpace relatingSpace;
    protected Collection<IfcCovering> relatedCoverings;

    protected IfcRelCoversSpaces() { initCollections(); }
    /**
     * Constructs IfcRelCoversSpaces with all required attributes.
     */
    public IfcRelCoversSpaces(IfcGloballyUniqueId globalId,IfcSpace relatingSpace,Collection<IfcCovering> relatedCoverings) {

        super(globalId);
        this.relatingSpace = relatingSpace;
        this.relatedCoverings = relatedCoverings;
    }
    /**
     * Constructs IfcRelCoversSpaces with required and optional attributes.
     */
    public IfcRelCoversSpaces(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcSpace relatingSpace,Collection<IfcCovering> relatedCoverings) {
        super(globalId,ownerHistory,name,description);
        this.relatingSpace = relatingSpace;
        this.relatedCoverings = relatedCoverings;
    }
    private void initCollections() {
        this.relatedCoverings = new ArrayList<>();
    }
    public IfcSpace getRelatingSpace() { return this.relatingSpace; }
    public void setRelatingSpace(IfcSpace value) { this.relatingSpace = value; }
    public Collection<IfcCovering> getRelatedCoverings() { return this.relatedCoverings; }
    public void setRelatedCoverings(Collection<IfcCovering> value) { this.relatedCoverings = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingSpace != null ? StepUtils.toStepValue(relatingSpace) : "$");
		parameters.add(relatedCoverings != null ? StepUtils.toStepValue(relatedCoverings) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelCoversSpacesRelationship(); }
    private void setIfcRelCoversSpacesRelationship() {
		if (this.relatedCoverings != null) {
		    for (Object x : this.relatedCoverings) {
		        if (x instanceof IfcCovering)
		            ((IfcCovering)x).coversSpaces.add(this);
		    }
		}
		if (this.relatingSpace != null) {
		    if (this.relatingSpace instanceof IfcSpace)
		        ((IfcSpace)this.relatingSpace).hasCoverings.add(this);
		}
    }
}