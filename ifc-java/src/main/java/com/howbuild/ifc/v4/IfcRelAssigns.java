package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAssigns
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAssignsToActor
 * ,IfcRelAssignsToControl
 * ,IfcRelAssignsToGroup
 * ,IfcRelAssignsToProcess
 * ,IfcRelAssignsToProduct
 * ,IfcRelAssignsToResource))
 * SUBTYPE OF (IfcRelationship);
 * RelatedObjects : SET [1:?] OF IfcObjectDefinition;
 * RelatedObjectsType : OPTIONAL IfcObjectTypeEnum;
 * WHERE
 * WR1 : IfcCorrectObjectAssignment(RelatedObjectsType, RelatedObjects);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassigns.htm">IfcRelAssigns</a>
 */
public abstract class IfcRelAssigns extends IfcRelationship {
    protected Collection<IfcObjectDefinition> relatedObjects;
    protected IfcObjectTypeEnum relatedObjectsType;

    protected IfcRelAssigns() { initCollections(); }
    /**
     * Constructs IfcRelAssigns with all required attributes.
     */
    public IfcRelAssigns(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects) {

        super(globalId);
        this.relatedObjects = relatedObjects;
    }
    /**
     * Constructs IfcRelAssigns with required and optional attributes.
     */
    public IfcRelAssigns(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType) {
        super(globalId,ownerHistory,name,description);
        this.relatedObjects = relatedObjects;
        this.relatedObjectsType = relatedObjectsType;
    }
    private void initCollections() {
        this.relatedObjects = new ArrayList<>();
    }
    public Collection<IfcObjectDefinition> getRelatedObjects() { return this.relatedObjects; }
    public void setRelatedObjects(Collection<IfcObjectDefinition> value) { this.relatedObjects = value; }
    public IfcObjectTypeEnum getRelatedObjectsType() { return this.relatedObjectsType; }
    public void setRelatedObjectsType(IfcObjectTypeEnum value) { this.relatedObjectsType = value; } // optional


    @Override public void finalizeRelationships() { this.setIfcRelAssignsRelationship(); }
    private void setIfcRelAssignsRelationship() {
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObjectDefinition)
		            ((IfcObjectDefinition)x).hasAssignments.add(this);
		    }
		}
    }
}