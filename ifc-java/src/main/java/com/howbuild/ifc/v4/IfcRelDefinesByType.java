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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldefinesbytype.htm">IfcRelDefinesByType</a>
 */
public class IfcRelDefinesByType extends IfcRelDefines {
    protected Collection<IfcObject> relatedObjects;
    protected IfcTypeObject relatingType;

    protected IfcRelDefinesByType() { initCollections(); }
    /**
     * Constructs IfcRelDefinesByType with all required attributes.
     */
    public IfcRelDefinesByType(IfcGloballyUniqueId globalId,Collection<IfcObject> relatedObjects,IfcTypeObject relatingType) {

        super(globalId);
        this.relatedObjects = relatedObjects;
        this.relatingType = relatingType;
    }
    /**
     * Constructs IfcRelDefinesByType with required and optional attributes.
     */
    public IfcRelDefinesByType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObject> relatedObjects,IfcTypeObject relatingType) {
        super(globalId,ownerHistory,name,description);
        this.relatedObjects = relatedObjects;
        this.relatingType = relatingType;
    }
    private void initCollections() {
        this.relatedObjects = new ArrayList<>();
    }
    public Collection<IfcObject> getRelatedObjects() { return this.relatedObjects; }
    public void setRelatedObjects(Collection<IfcObject> value) { this.relatedObjects = value; }
    public IfcTypeObject getRelatingType() { return this.relatingType; }
    public void setRelatingType(IfcTypeObject value) { this.relatingType = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingType != null ? StepUtils.toStepValue(relatingType) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelDefinesByTypeRelationship(); }
    private void setIfcRelDefinesByTypeRelationship() {
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObject)
		            ((IfcObject)x).isTypedBy.add(this);
		    }
		}
		if (this.relatingType != null) {
		    if (this.relatingType instanceof IfcTypeObject)
		        ((IfcTypeObject)this.relatingType).types.add(this);
		}
    }
}