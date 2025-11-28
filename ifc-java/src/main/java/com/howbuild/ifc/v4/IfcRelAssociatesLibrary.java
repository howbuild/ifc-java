package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAssociates
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAssociatesApproval
 * ,IfcRelAssociatesClassification
 * ,IfcRelAssociatesConstraint
 * ,IfcRelAssociatesDocument
 * ,IfcRelAssociatesLibrary
 * ,IfcRelAssociatesMaterial))
 * SUBTYPE OF (IfcRelationship);
 * RelatedObjects : SET [1:?] OF IfcDefinitionSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociateslibrary.htm">IfcRelAssociatesLibrary</a>
 */
public class IfcRelAssociatesLibrary extends IfcRelAssociates {
    protected IfcLibrarySelect relatingLibrary;

    protected IfcRelAssociatesLibrary() { initCollections(); }
    /**
     * Constructs IfcRelAssociatesLibrary with all required attributes.
     */
    public IfcRelAssociatesLibrary(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects,IfcLibrarySelect relatingLibrary) {

        super(globalId,relatedObjects);
        this.relatingLibrary = relatingLibrary;
    }
    /**
     * Constructs IfcRelAssociatesLibrary with required and optional attributes.
     */
    public IfcRelAssociatesLibrary(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects,IfcLibrarySelect relatingLibrary) {
        super(globalId,ownerHistory,name,description,relatedObjects);
        this.relatingLibrary = relatingLibrary;
    }
    private void initCollections() {
    }
    public IfcLibrarySelect getRelatingLibrary() { return this.relatingLibrary; }
    public void setRelatingLibrary(IfcLibrarySelect value) { this.relatingLibrary = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingLibrary != null ? StepUtils.toStepValue(relatingLibrary) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssociatesLibraryRelationship(); }
    private void setIfcRelAssociatesLibraryRelationship() {
		if (this.relatingLibrary != null) {
		    if (this.relatingLibrary instanceof IfcLibraryInformation)
		        ((IfcLibraryInformation)this.relatingLibrary).libraryInfoForObjects.add(this);
		}
		if (this.relatingLibrary != null) {
		    if (this.relatingLibrary instanceof IfcLibraryReference)
		        ((IfcLibraryReference)this.relatingLibrary).libraryRefForObjects.add(this);
		}
    }
}