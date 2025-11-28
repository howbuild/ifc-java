package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcClassificationReference
 * SUBTYPE OF (IfcExternalReference);
 * ReferencedSource : OPTIONAL IfcClassificationReferenceSelect;
 * Description : OPTIONAL IfcText;
 * Sort : OPTIONAL IfcIdentifier;
 * INVERSE
 * ClassificationRefForObjects : SET [0:?] OF IfcRelAssociatesClassification FOR RelatingClassification;
 * HasReferences : SET [0:?] OF IfcClassificationReference FOR ReferencedSource;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcclassificationreference.htm">IfcClassificationReference</a>
 */
public class IfcClassificationReference extends IfcExternalReference implements IfcClassificationReferenceSelect, IfcClassificationSelect {
    protected IfcClassificationReferenceSelect referencedSource;
    protected IfcText description;
    protected IfcIdentifier sort;
    protected Collection<IfcRelAssociatesClassification> classificationRefForObjects;
    protected Collection<IfcClassificationReference> hasReferences;


    /**
     * Constructs IfcClassificationReference with all required attributes.
     */
    public IfcClassificationReference() {

        super();
        this.classificationRefForObjects = new ArrayList<>();
        this.hasReferences = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcClassificationReference with required and optional attributes.
     */
    public IfcClassificationReference(IfcURIReference location,IfcIdentifier identification,IfcLabel name,IfcClassificationReferenceSelect referencedSource,IfcText description,IfcIdentifier sort) {
        super(location,identification,name);
        this.classificationRefForObjects = new ArrayList<>();
        this.hasReferences = new ArrayList<>();
        this.referencedSource = referencedSource;
        this.description = description;
        this.sort = sort;
    }
    private void initCollections() {
        this.classificationRefForObjects = new ArrayList<>();
        this.hasReferences = new ArrayList<>();
    }
    public IfcClassificationReferenceSelect getReferencedSource() { return this.referencedSource; }
    public void setReferencedSource(IfcClassificationReferenceSelect value) { this.referencedSource = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcIdentifier getSort() { return this.sort; }
    public void setSort(IfcIdentifier value) { this.sort = value; } // optional
    public Collection<IfcRelAssociatesClassification> getClassificationRefForObjects() { return this.classificationRefForObjects; }
    public void setClassificationRefForObjects(Collection<IfcRelAssociatesClassification> value) { this.classificationRefForObjects = value; } // inverse
    public Collection<IfcClassificationReference> getHasReferences() { return this.hasReferences; }
    public void setHasReferences(Collection<IfcClassificationReference> value) { this.hasReferences = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(referencedSource != null ? StepUtils.toStepValue(referencedSource) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(sort != null ? StepUtils.toStepValue(sort) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcClassificationReferenceRelationship(); }
    private void setIfcClassificationReferenceRelationship() {
		if (this.referencedSource != null) {
		    if (this.referencedSource instanceof IfcClassification)
		        ((IfcClassification)this.referencedSource).hasReferences.add(this);
		}
		if (this.referencedSource != null) {
		    if (this.referencedSource instanceof IfcClassificationReference)
		        ((IfcClassificationReference)this.referencedSource).hasReferences.add(this);
		}
    }
}