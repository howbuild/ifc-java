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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociates.htm">IfcRelAssociates</a>
 */
public abstract class IfcRelAssociates extends IfcRelationship {
    protected Collection<IfcDefinitionSelect> relatedObjects;

    protected IfcRelAssociates() { initCollections(); }
    /**
     * Constructs IfcRelAssociates with all required attributes.
     */
    public IfcRelAssociates(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects) {

        super(globalId);
        this.relatedObjects = relatedObjects;
    }
    /**
     * Constructs IfcRelAssociates with required and optional attributes.
     */
    public IfcRelAssociates(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects) {
        super(globalId,ownerHistory,name,description);
        this.relatedObjects = relatedObjects;
    }
    private void initCollections() {
        this.relatedObjects = new ArrayList<>();
    }
    public Collection<IfcDefinitionSelect> getRelatedObjects() { return this.relatedObjects; }
    public void setRelatedObjects(Collection<IfcDefinitionSelect> value) { this.relatedObjects = value; }


    @Override public void finalizeRelationships() { this.setIfcRelAssociatesRelationship(); }
    private void setIfcRelAssociatesRelationship() {
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObjectDefinition)
		            ((IfcObjectDefinition)x).hasAssociations.add(this);
		    }
		}
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcPropertyDefinition)
		            ((IfcPropertyDefinition)x).hasAssociations.add(this);
		    }
		}
    }
}