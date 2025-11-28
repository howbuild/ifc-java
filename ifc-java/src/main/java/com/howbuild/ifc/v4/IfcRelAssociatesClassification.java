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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociatesclassification.htm">IfcRelAssociatesClassification</a>
 */
public class IfcRelAssociatesClassification extends IfcRelAssociates {
    protected IfcClassificationSelect relatingClassification;

    protected IfcRelAssociatesClassification() { initCollections(); }
    /**
     * Constructs IfcRelAssociatesClassification with all required attributes.
     */
    public IfcRelAssociatesClassification(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects,IfcClassificationSelect relatingClassification) {

        super(globalId,relatedObjects);
        this.relatingClassification = relatingClassification;
    }
    /**
     * Constructs IfcRelAssociatesClassification with required and optional attributes.
     */
    public IfcRelAssociatesClassification(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects,IfcClassificationSelect relatingClassification) {
        super(globalId,ownerHistory,name,description,relatedObjects);
        this.relatingClassification = relatingClassification;
    }
    private void initCollections() {
    }
    public IfcClassificationSelect getRelatingClassification() { return this.relatingClassification; }
    public void setRelatingClassification(IfcClassificationSelect value) { this.relatingClassification = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingClassification != null ? StepUtils.toStepValue(relatingClassification) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssociatesClassificationRelationship(); }
    private void setIfcRelAssociatesClassificationRelationship() {
		if (this.relatingClassification != null) {
		    if (this.relatingClassification instanceof IfcClassification)
		        ((IfcClassification)this.relatingClassification).classificationForObjects.add(this);
		}
		if (this.relatingClassification != null) {
		    if (this.relatingClassification instanceof IfcClassificationReference)
		        ((IfcClassificationReference)this.relatingClassification).classificationRefForObjects.add(this);
		}
    }
}