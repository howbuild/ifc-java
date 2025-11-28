package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDocumentReference
 * SUBTYPE OF (IfcExternalReference);
 * Description : OPTIONAL IfcText;
 * ReferencedDocument : OPTIONAL IfcDocumentInformation;
 * INVERSE
 * DocumentRefForObjects : SET [0:?] OF IfcRelAssociatesDocument FOR RelatingDocument;
 * WHERE
 * WR1 : EXISTS(Name) XOR EXISTS(ReferencedDocument);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdocumentreference.htm">IfcDocumentReference</a>
 */
public class IfcDocumentReference extends IfcExternalReference implements IfcDocumentSelect {
    protected IfcText description;
    protected IfcDocumentInformation referencedDocument;
    protected Collection<IfcRelAssociatesDocument> documentRefForObjects;


    /**
     * Constructs IfcDocumentReference with all required attributes.
     */
    public IfcDocumentReference() {

        super();
        this.documentRefForObjects = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcDocumentReference with required and optional attributes.
     */
    public IfcDocumentReference(IfcURIReference location,IfcIdentifier identification,IfcLabel name,IfcText description,IfcDocumentInformation referencedDocument) {
        super(location,identification,name);
        this.documentRefForObjects = new ArrayList<>();
        this.description = description;
        this.referencedDocument = referencedDocument;
    }
    private void initCollections() {
        this.documentRefForObjects = new ArrayList<>();
    }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcDocumentInformation getReferencedDocument() { return this.referencedDocument; }
    public void setReferencedDocument(IfcDocumentInformation value) { this.referencedDocument = value; } // optional
    public Collection<IfcRelAssociatesDocument> getDocumentRefForObjects() { return this.documentRefForObjects; }
    public void setDocumentRefForObjects(Collection<IfcRelAssociatesDocument> value) { this.documentRefForObjects = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(referencedDocument != null ? StepUtils.toStepValue(referencedDocument) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcDocumentReferenceRelationship(); }
    private void setIfcDocumentReferenceRelationship() {
		if (this.referencedDocument != null) {
		    if (this.referencedDocument instanceof IfcDocumentInformation)
		        ((IfcDocumentInformation)this.referencedDocument).hasDocumentReferences.add(this);
		}
    }
}