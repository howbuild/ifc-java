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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociatesdocument.htm">IfcRelAssociatesDocument</a>
 */
public class IfcRelAssociatesDocument extends IfcRelAssociates {
    protected IfcDocumentSelect relatingDocument;

    protected IfcRelAssociatesDocument() { initCollections(); }
    /**
     * Constructs IfcRelAssociatesDocument with all required attributes.
     */
    public IfcRelAssociatesDocument(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects,IfcDocumentSelect relatingDocument) {

        super(globalId,relatedObjects);
        this.relatingDocument = relatingDocument;
    }
    /**
     * Constructs IfcRelAssociatesDocument with required and optional attributes.
     */
    public IfcRelAssociatesDocument(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects,IfcDocumentSelect relatingDocument) {
        super(globalId,ownerHistory,name,description,relatedObjects);
        this.relatingDocument = relatingDocument;
    }
    private void initCollections() {
    }
    public IfcDocumentSelect getRelatingDocument() { return this.relatingDocument; }
    public void setRelatingDocument(IfcDocumentSelect value) { this.relatingDocument = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingDocument != null ? StepUtils.toStepValue(relatingDocument) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssociatesDocumentRelationship(); }
    private void setIfcRelAssociatesDocumentRelationship() {
		if (this.relatingDocument != null) {
		    if (this.relatingDocument instanceof IfcDocumentInformation)
		        ((IfcDocumentInformation)this.relatingDocument).documentInfoForObjects.add(this);
		}
		if (this.relatingDocument != null) {
		    if (this.relatingDocument instanceof IfcDocumentReference)
		        ((IfcDocumentReference)this.relatingDocument).documentRefForObjects.add(this);
		}
    }
}