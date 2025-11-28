package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcClassification
 * SUBTYPE OF (IfcExternalInformation);
 * Source : OPTIONAL IfcLabel;
 * Edition : OPTIONAL IfcLabel;
 * EditionDate : OPTIONAL IfcDate;
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * Location : OPTIONAL IfcURIReference;
 * ReferenceTokens : OPTIONAL LIST [1:?] OF IfcIdentifier;
 * INVERSE
 * ClassificationForObjects : SET [0:?] OF IfcRelAssociatesClassification FOR RelatingClassification;
 * HasReferences : SET [0:?] OF IfcClassificationReference FOR ReferencedSource;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcclassification.htm">IfcClassification</a>
 */
public class IfcClassification extends IfcExternalInformation implements IfcClassificationReferenceSelect, IfcClassificationSelect {
    protected IfcLabel source;
    protected IfcLabel edition;
    protected IfcDate editionDate;
    protected IfcLabel name;
    protected IfcText description;
    protected IfcURIReference location;
    protected Collection<IfcIdentifier> referenceTokens;
    protected Collection<IfcRelAssociatesClassification> classificationForObjects;
    protected Collection<IfcClassificationReference> hasReferences;

    protected IfcClassification() { initCollections(); }
    /**
     * Constructs IfcClassification with all required attributes.
     */
    public IfcClassification(IfcLabel name) {

        super();
        this.referenceTokens = new ArrayList<>();
        this.classificationForObjects = new ArrayList<>();
        this.hasReferences = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcClassification with required and optional attributes.
     */
    public IfcClassification(IfcLabel source,IfcLabel edition,IfcDate editionDate,IfcLabel name,IfcText description,IfcURIReference location,Collection<IfcIdentifier> referenceTokens) {
        super();
        this.classificationForObjects = new ArrayList<>();
        this.hasReferences = new ArrayList<>();
        this.source = source;
        this.edition = edition;
        this.editionDate = editionDate;
        this.name = name;
        this.description = description;
        this.location = location;
        this.referenceTokens = referenceTokens;
    }
    private void initCollections() {
        this.referenceTokens = new ArrayList<>();
        this.classificationForObjects = new ArrayList<>();
        this.hasReferences = new ArrayList<>();
    }
    public IfcLabel getSource() { return this.source; }
    public void setSource(IfcLabel value) { this.source = value; } // optional
    public IfcLabel getEdition() { return this.edition; }
    public void setEdition(IfcLabel value) { this.edition = value; } // optional
    public IfcDate getEditionDate() { return this.editionDate; }
    public void setEditionDate(IfcDate value) { this.editionDate = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcURIReference getLocation() { return this.location; }
    public void setLocation(IfcURIReference value) { this.location = value; } // optional
    public Collection<IfcIdentifier> getReferenceTokens() { return this.referenceTokens; }
    public void setReferenceTokens(Collection<IfcIdentifier> value) { this.referenceTokens = value; } // optional
    public Collection<IfcRelAssociatesClassification> getClassificationForObjects() { return this.classificationForObjects; }
    public void setClassificationForObjects(Collection<IfcRelAssociatesClassification> value) { this.classificationForObjects = value; } // inverse
    public Collection<IfcClassificationReference> getHasReferences() { return this.hasReferences; }
    public void setHasReferences(Collection<IfcClassificationReference> value) { this.hasReferences = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(source != null ? StepUtils.toStepValue(source) : "$");
		parameters.add(edition != null ? StepUtils.toStepValue(edition) : "$");
		parameters.add(editionDate != null ? StepUtils.toStepValue(editionDate) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(referenceTokens != null ? StepUtils.toStepValue(referenceTokens) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}