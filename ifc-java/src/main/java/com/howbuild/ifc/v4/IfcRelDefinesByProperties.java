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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldefinesbyproperties.htm">IfcRelDefinesByProperties</a>
 */
public class IfcRelDefinesByProperties extends IfcRelDefines {
    protected Collection<IfcObjectDefinition> relatedObjects;
    protected IfcPropertySetDefinitionSelect relatingPropertyDefinition;

    protected IfcRelDefinesByProperties() { initCollections(); }
    /**
     * Constructs IfcRelDefinesByProperties with all required attributes.
     */
    public IfcRelDefinesByProperties(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcPropertySetDefinitionSelect relatingPropertyDefinition) {

        super(globalId);
        this.relatedObjects = relatedObjects;
        this.relatingPropertyDefinition = relatingPropertyDefinition;
    }
    /**
     * Constructs IfcRelDefinesByProperties with required and optional attributes.
     */
    public IfcRelDefinesByProperties(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcPropertySetDefinitionSelect relatingPropertyDefinition) {
        super(globalId,ownerHistory,name,description);
        this.relatedObjects = relatedObjects;
        this.relatingPropertyDefinition = relatingPropertyDefinition;
    }
    private void initCollections() {
        this.relatedObjects = new ArrayList<>();
    }
    public Collection<IfcObjectDefinition> getRelatedObjects() { return this.relatedObjects; }
    public void setRelatedObjects(Collection<IfcObjectDefinition> value) { this.relatedObjects = value; }
    public IfcPropertySetDefinitionSelect getRelatingPropertyDefinition() { return this.relatingPropertyDefinition; }
    public void setRelatingPropertyDefinition(IfcPropertySetDefinitionSelect value) { this.relatingPropertyDefinition = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingPropertyDefinition != null ? StepUtils.toStepValue(relatingPropertyDefinition) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelDefinesByPropertiesRelationship(); }
    private void setIfcRelDefinesByPropertiesRelationship() {
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcContext)
		            ((IfcContext)x).isDefinedBy.add(this);
		    }
		}
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObject)
		            ((IfcObject)x).isDefinedBy.add(this);
		    }
		}
		if (this.relatingPropertyDefinition != null) {
		    if (this.relatingPropertyDefinition instanceof IfcPropertySetDefinition)
		        ((IfcPropertySetDefinition)this.relatingPropertyDefinition).definesOccurrence.add(this);
		}
    }
}