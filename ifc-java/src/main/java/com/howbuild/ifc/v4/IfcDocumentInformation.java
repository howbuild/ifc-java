package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDocumentInformation
 * SUBTYPE OF (IfcExternalInformation);
 * Identification : IfcIdentifier;
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * Location : OPTIONAL IfcURIReference;
 * Purpose : OPTIONAL IfcText;
 * IntendedUse : OPTIONAL IfcText;
 * Scope : OPTIONAL IfcText;
 * Revision : OPTIONAL IfcLabel;
 * DocumentOwner : OPTIONAL IfcActorSelect;
 * Editors : OPTIONAL SET [1:?] OF IfcActorSelect;
 * CreationTime : OPTIONAL IfcDateTime;
 * LastRevisionTime : OPTIONAL IfcDateTime;
 * ElectronicFormat : OPTIONAL IfcIdentifier;
 * ValidFrom : OPTIONAL IfcDate;
 * ValidUntil : OPTIONAL IfcDate;
 * Confidentiality : OPTIONAL IfcDocumentConfidentialityEnum;
 * Status : OPTIONAL IfcDocumentStatusEnum;
 * INVERSE
 * DocumentInfoForObjects : SET [0:?] OF IfcRelAssociatesDocument FOR RelatingDocument;
 * HasDocumentReferences : SET [0:?] OF IfcDocumentReference FOR ReferencedDocument;
 * IsPointedTo : SET [0:?] OF IfcDocumentInformationRelationship FOR RelatedDocuments;
 * IsPointer : SET [0:1] OF IfcDocumentInformationRelationship FOR RelatingDocument;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdocumentinformation.htm">IfcDocumentInformation</a>
 */
public class IfcDocumentInformation extends IfcExternalInformation implements IfcDocumentSelect {
    protected IfcIdentifier identification;
    protected IfcLabel name;
    protected IfcText description;
    protected IfcURIReference location;
    protected IfcText purpose;
    protected IfcText intendedUse;
    protected IfcText scope;
    protected IfcLabel revision;
    protected IfcActorSelect documentOwner;
    protected Collection<IfcActorSelect> editors;
    protected IfcDateTime creationTime;
    protected IfcDateTime lastRevisionTime;
    protected IfcIdentifier electronicFormat;
    protected IfcDate validFrom;
    protected IfcDate validUntil;
    protected IfcDocumentConfidentialityEnum confidentiality;
    protected IfcDocumentStatusEnum status;
    protected Collection<IfcRelAssociatesDocument> documentInfoForObjects;
    protected Collection<IfcDocumentReference> hasDocumentReferences;
    protected Collection<IfcDocumentInformationRelationship> isPointedTo;
    protected Collection<IfcDocumentInformationRelationship> isPointer;

    protected IfcDocumentInformation() { initCollections(); }
    /**
     * Constructs IfcDocumentInformation with all required attributes.
     */
    public IfcDocumentInformation(IfcIdentifier identification,IfcLabel name) {

        super();
        this.editors = new ArrayList<>();
        this.documentInfoForObjects = new ArrayList<>();
        this.hasDocumentReferences = new ArrayList<>();
        this.isPointedTo = new ArrayList<>();
        this.isPointer = new ArrayList<>();
        this.identification = identification;
        this.name = name;
    }
    /**
     * Constructs IfcDocumentInformation with required and optional attributes.
     */
    public IfcDocumentInformation(IfcIdentifier identification,IfcLabel name,IfcText description,IfcURIReference location,IfcText purpose,IfcText intendedUse,IfcText scope,IfcLabel revision,IfcActorSelect documentOwner,Collection<IfcActorSelect> editors,IfcDateTime creationTime,IfcDateTime lastRevisionTime,IfcIdentifier electronicFormat,IfcDate validFrom,IfcDate validUntil,IfcDocumentConfidentialityEnum confidentiality,IfcDocumentStatusEnum status) {
        super();
        this.documentInfoForObjects = new ArrayList<>();
        this.hasDocumentReferences = new ArrayList<>();
        this.isPointedTo = new ArrayList<>();
        this.isPointer = new ArrayList<>();
        this.identification = identification;
        this.name = name;
        this.description = description;
        this.location = location;
        this.purpose = purpose;
        this.intendedUse = intendedUse;
        this.scope = scope;
        this.revision = revision;
        this.documentOwner = documentOwner;
        this.editors = editors;
        this.creationTime = creationTime;
        this.lastRevisionTime = lastRevisionTime;
        this.electronicFormat = electronicFormat;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.confidentiality = confidentiality;
        this.status = status;
    }
    private void initCollections() {
        this.editors = new ArrayList<>();
        this.documentInfoForObjects = new ArrayList<>();
        this.hasDocumentReferences = new ArrayList<>();
        this.isPointedTo = new ArrayList<>();
        this.isPointer = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcURIReference getLocation() { return this.location; }
    public void setLocation(IfcURIReference value) { this.location = value; } // optional
    public IfcText getPurpose() { return this.purpose; }
    public void setPurpose(IfcText value) { this.purpose = value; } // optional
    public IfcText getIntendedUse() { return this.intendedUse; }
    public void setIntendedUse(IfcText value) { this.intendedUse = value; } // optional
    public IfcText getScope() { return this.scope; }
    public void setScope(IfcText value) { this.scope = value; } // optional
    public IfcLabel getRevision() { return this.revision; }
    public void setRevision(IfcLabel value) { this.revision = value; } // optional
    public IfcActorSelect getDocumentOwner() { return this.documentOwner; }
    public void setDocumentOwner(IfcActorSelect value) { this.documentOwner = value; } // optional
    public Collection<IfcActorSelect> getEditors() { return this.editors; }
    public void setEditors(Collection<IfcActorSelect> value) { this.editors = value; } // optional
    public IfcDateTime getCreationTime() { return this.creationTime; }
    public void setCreationTime(IfcDateTime value) { this.creationTime = value; } // optional
    public IfcDateTime getLastRevisionTime() { return this.lastRevisionTime; }
    public void setLastRevisionTime(IfcDateTime value) { this.lastRevisionTime = value; } // optional
    public IfcIdentifier getElectronicFormat() { return this.electronicFormat; }
    public void setElectronicFormat(IfcIdentifier value) { this.electronicFormat = value; } // optional
    public IfcDate getValidFrom() { return this.validFrom; }
    public void setValidFrom(IfcDate value) { this.validFrom = value; } // optional
    public IfcDate getValidUntil() { return this.validUntil; }
    public void setValidUntil(IfcDate value) { this.validUntil = value; } // optional
    public IfcDocumentConfidentialityEnum getConfidentiality() { return this.confidentiality; }
    public void setConfidentiality(IfcDocumentConfidentialityEnum value) { this.confidentiality = value; } // optional
    public IfcDocumentStatusEnum getStatus() { return this.status; }
    public void setStatus(IfcDocumentStatusEnum value) { this.status = value; } // optional
    public Collection<IfcRelAssociatesDocument> getDocumentInfoForObjects() { return this.documentInfoForObjects; }
    public void setDocumentInfoForObjects(Collection<IfcRelAssociatesDocument> value) { this.documentInfoForObjects = value; } // inverse
    public Collection<IfcDocumentReference> getHasDocumentReferences() { return this.hasDocumentReferences; }
    public void setHasDocumentReferences(Collection<IfcDocumentReference> value) { this.hasDocumentReferences = value; } // inverse
    public Collection<IfcDocumentInformationRelationship> getIsPointedTo() { return this.isPointedTo; }
    public void setIsPointedTo(Collection<IfcDocumentInformationRelationship> value) { this.isPointedTo = value; } // inverse
    public Collection<IfcDocumentInformationRelationship> getIsPointer() { return this.isPointer; }
    public void setIsPointer(Collection<IfcDocumentInformationRelationship> value) { this.isPointer = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(purpose != null ? StepUtils.toStepValue(purpose) : "$");
		parameters.add(intendedUse != null ? StepUtils.toStepValue(intendedUse) : "$");
		parameters.add(scope != null ? StepUtils.toStepValue(scope) : "$");
		parameters.add(revision != null ? StepUtils.toStepValue(revision) : "$");
		parameters.add(documentOwner != null ? StepUtils.toStepValue(documentOwner) : "$");
		parameters.add(editors != null ? StepUtils.toStepValue(editors) : "$");
		parameters.add(creationTime != null ? StepUtils.toStepValue(creationTime) : "$");
		parameters.add(lastRevisionTime != null ? StepUtils.toStepValue(lastRevisionTime) : "$");
		parameters.add(electronicFormat != null ? StepUtils.toStepValue(electronicFormat) : "$");
		parameters.add(validFrom != null ? StepUtils.toStepValue(validFrom) : "$");
		parameters.add(validUntil != null ? StepUtils.toStepValue(validUntil) : "$");
		parameters.add(StepUtils.toStepValue(confidentiality));
		parameters.add(StepUtils.toStepValue(status));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}