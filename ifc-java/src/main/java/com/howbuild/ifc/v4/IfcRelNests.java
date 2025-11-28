package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelDecomposes
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAggregates
 * ,IfcRelNests
 * ,IfcRelProjectsElement
 * ,IfcRelVoidsElement))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelnests.htm">IfcRelNests</a>
 */
public class IfcRelNests extends IfcRelDecomposes {
    protected IfcObjectDefinition relatingObject;
    protected Collection<IfcObjectDefinition> relatedObjects;

    protected IfcRelNests() { initCollections(); }
    /**
     * Constructs IfcRelNests with all required attributes.
     */
    public IfcRelNests(IfcGloballyUniqueId globalId,IfcObjectDefinition relatingObject,Collection<IfcObjectDefinition> relatedObjects) {

        super(globalId);
        this.relatingObject = relatingObject;
        this.relatedObjects = relatedObjects;
    }
    /**
     * Constructs IfcRelNests with required and optional attributes.
     */
    public IfcRelNests(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcObjectDefinition relatingObject,Collection<IfcObjectDefinition> relatedObjects) {
        super(globalId,ownerHistory,name,description);
        this.relatingObject = relatingObject;
        this.relatedObjects = relatedObjects;
    }
    private void initCollections() {
        this.relatedObjects = new ArrayList<>();
    }
    public IfcObjectDefinition getRelatingObject() { return this.relatingObject; }
    public void setRelatingObject(IfcObjectDefinition value) { this.relatingObject = value; }
    public Collection<IfcObjectDefinition> getRelatedObjects() { return this.relatedObjects; }
    public void setRelatedObjects(Collection<IfcObjectDefinition> value) { this.relatedObjects = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingObject != null ? StepUtils.toStepValue(relatingObject) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelNestsRelationship(); }
    private void setIfcRelNestsRelationship() {
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObjectDefinition)
		            ((IfcObjectDefinition)x).nests.add(this);
		    }
		}
		if (this.relatingObject != null) {
		    if (this.relatingObject instanceof IfcObjectDefinition)
		        ((IfcObjectDefinition)this.relatingObject).isNestedBy.add(this);
		}
    }
}