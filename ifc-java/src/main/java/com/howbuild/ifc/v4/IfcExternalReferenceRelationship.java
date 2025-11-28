package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExternalReferenceRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingReference : IfcExternalReference;
 * RelatedResourceObjects : SET [1:?] OF IfcResourceObjectSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcexternalreferencerelationship.htm">IfcExternalReferenceRelationship</a>
 */
public class IfcExternalReferenceRelationship extends IfcResourceLevelRelationship {
    protected IfcExternalReference relatingReference;
    protected Collection<IfcResourceObjectSelect> relatedResourceObjects;

    protected IfcExternalReferenceRelationship() { initCollections(); }
    /**
     * Constructs IfcExternalReferenceRelationship with all required attributes.
     */
    public IfcExternalReferenceRelationship(IfcExternalReference relatingReference,Collection<IfcResourceObjectSelect> relatedResourceObjects) {

        super();
        this.relatingReference = relatingReference;
        this.relatedResourceObjects = relatedResourceObjects;
    }
    /**
     * Constructs IfcExternalReferenceRelationship with required and optional attributes.
     */
    public IfcExternalReferenceRelationship(IfcLabel name,IfcText description,IfcExternalReference relatingReference,Collection<IfcResourceObjectSelect> relatedResourceObjects) {
        super(name,description);
        this.relatingReference = relatingReference;
        this.relatedResourceObjects = relatedResourceObjects;
    }
    private void initCollections() {
        this.relatedResourceObjects = new ArrayList<>();
    }
    public IfcExternalReference getRelatingReference() { return this.relatingReference; }
    public void setRelatingReference(IfcExternalReference value) { this.relatingReference = value; }
    public Collection<IfcResourceObjectSelect> getRelatedResourceObjects() { return this.relatedResourceObjects; }
    public void setRelatedResourceObjects(Collection<IfcResourceObjectSelect> value) { this.relatedResourceObjects = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingReference != null ? StepUtils.toStepValue(relatingReference) : "$");
		parameters.add(relatedResourceObjects != null ? StepUtils.toStepValue(relatedResourceObjects) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcExternalReferenceRelationshipRelationship(); }
    private void setIfcExternalReferenceRelationshipRelationship() {
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcActorRole)
		            ((IfcActorRole)x).hasExternalReference.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcAppliedValue)
		            ((IfcAppliedValue)x).hasExternalReference.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcApproval)
		            ((IfcApproval)x).hasExternalReferences.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcConstraint)
		            ((IfcConstraint)x).hasExternalReferences.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcContextDependentUnit)
		            ((IfcContextDependentUnit)x).hasExternalReference.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcConversionBasedUnit)
		            ((IfcConversionBasedUnit)x).hasExternalReference.add(this);
		    }
		}
		if (this.relatingReference != null) {
		    if (this.relatingReference instanceof IfcExternalReference)
		        ((IfcExternalReference)this.relatingReference).externalReferenceForResources.add(this);
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcMaterialDefinition)
		            ((IfcMaterialDefinition)x).hasExternalReferences.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcPhysicalQuantity)
		            ((IfcPhysicalQuantity)x).hasExternalReferences.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcProfileDef)
		            ((IfcProfileDef)x).hasExternalReference.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcPropertyAbstraction)
		            ((IfcPropertyAbstraction)x).hasExternalReferences.add(this);
		    }
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcTimeSeries)
		            ((IfcTimeSeries)x).hasExternalReference.add(this);
		    }
		}
    }
}