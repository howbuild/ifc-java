package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelDefines
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelDefinesByObject
 * ,IfcRelDefinesByProperties
 * ,IfcRelDefinesByTemplate
 * ,IfcRelDefinesByType))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldefinesbyobject.htm">IfcRelDefinesByObject</a>
 */
public class IfcRelDefinesByObject extends IfcRelDefines {
    protected Collection<IfcObject> relatedObjects;
    protected IfcObject relatingObject;

    protected IfcRelDefinesByObject() { initCollections(); }
    /**
     * Constructs IfcRelDefinesByObject with all required attributes.
     */
    public IfcRelDefinesByObject(IfcGloballyUniqueId globalId,Collection<IfcObject> relatedObjects,IfcObject relatingObject) {

        super(globalId);
        this.relatedObjects = relatedObjects;
        this.relatingObject = relatingObject;
    }
    /**
     * Constructs IfcRelDefinesByObject with required and optional attributes.
     */
    public IfcRelDefinesByObject(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObject> relatedObjects,IfcObject relatingObject) {
        super(globalId,ownerHistory,name,description);
        this.relatedObjects = relatedObjects;
        this.relatingObject = relatingObject;
    }
    private void initCollections() {
        this.relatedObjects = new ArrayList<>();
    }
    public Collection<IfcObject> getRelatedObjects() { return this.relatedObjects; }
    public void setRelatedObjects(Collection<IfcObject> value) { this.relatedObjects = value; }
    public IfcObject getRelatingObject() { return this.relatingObject; }
    public void setRelatingObject(IfcObject value) { this.relatingObject = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingObject != null ? StepUtils.toStepValue(relatingObject) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelDefinesByObjectRelationship(); }
    private void setIfcRelDefinesByObjectRelationship() {
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObject)
		            ((IfcObject)x).isDeclaredBy.add(this);
		    }
		}
		if (this.relatingObject != null) {
		    if (this.relatingObject instanceof IfcObject)
		        ((IfcObject)this.relatingObject).declares.add(this);
		}
    }
}