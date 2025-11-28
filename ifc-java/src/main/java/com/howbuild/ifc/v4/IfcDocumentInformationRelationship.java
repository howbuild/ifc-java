package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDocumentInformationRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingDocument : IfcDocumentInformation;
 * RelatedDocuments : SET [1:?] OF IfcDocumentInformation;
 * RelationshipType : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdocumentinformationrelationship.htm">IfcDocumentInformationRelationship</a>
 */
public class IfcDocumentInformationRelationship extends IfcResourceLevelRelationship {
    protected IfcDocumentInformation relatingDocument;
    protected Collection<IfcDocumentInformation> relatedDocuments;
    protected IfcLabel relationshipType;

    protected IfcDocumentInformationRelationship() { initCollections(); }
    /**
     * Constructs IfcDocumentInformationRelationship with all required attributes.
     */
    public IfcDocumentInformationRelationship(IfcDocumentInformation relatingDocument,Collection<IfcDocumentInformation> relatedDocuments) {

        super();
        this.relatingDocument = relatingDocument;
        this.relatedDocuments = relatedDocuments;
    }
    /**
     * Constructs IfcDocumentInformationRelationship with required and optional attributes.
     */
    public IfcDocumentInformationRelationship(IfcLabel name,IfcText description,IfcDocumentInformation relatingDocument,Collection<IfcDocumentInformation> relatedDocuments,IfcLabel relationshipType) {
        super(name,description);
        this.relatingDocument = relatingDocument;
        this.relatedDocuments = relatedDocuments;
        this.relationshipType = relationshipType;
    }
    private void initCollections() {
        this.relatedDocuments = new ArrayList<>();
    }
    public IfcDocumentInformation getRelatingDocument() { return this.relatingDocument; }
    public void setRelatingDocument(IfcDocumentInformation value) { this.relatingDocument = value; }
    public Collection<IfcDocumentInformation> getRelatedDocuments() { return this.relatedDocuments; }
    public void setRelatedDocuments(Collection<IfcDocumentInformation> value) { this.relatedDocuments = value; }
    public IfcLabel getRelationshipType() { return this.relationshipType; }
    public void setRelationshipType(IfcLabel value) { this.relationshipType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingDocument != null ? StepUtils.toStepValue(relatingDocument) : "$");
		parameters.add(relatedDocuments != null ? StepUtils.toStepValue(relatedDocuments) : "$");
		parameters.add(relationshipType != null ? StepUtils.toStepValue(relationshipType) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcDocumentInformationRelationshipRelationship(); }
    private void setIfcDocumentInformationRelationshipRelationship() {
		if (this.relatedDocuments != null) {
		    for (Object x : this.relatedDocuments) {
		        if (x instanceof IfcDocumentInformation)
		            ((IfcDocumentInformation)x).isPointedTo.add(this);
		    }
		}
		if (this.relatingDocument != null) {
		    if (this.relatingDocument instanceof IfcDocumentInformation)
		        ((IfcDocumentInformation)this.relatingDocument).isPointer.add(this);
		}
    }
}