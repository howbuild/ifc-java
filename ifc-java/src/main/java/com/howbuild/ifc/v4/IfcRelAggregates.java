package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAggregates
 * SUBTYPE OF (IfcRelDecomposes);
 * RelatingObject : IfcObjectDefinition;
 * RelatedObjects : SET [1:?] OF IfcObjectDefinition;
 * WHERE
 * NoSelfReference : SIZEOF(QUERY(Temp <* RelatedObjects | RelatingObject :=: Temp)) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelaggregates.htm">IfcRelAggregates</a>
 */
public class IfcRelAggregates extends IfcRelDecomposes {
    protected IfcObjectDefinition relatingObject;
    protected Collection<IfcObjectDefinition> relatedObjects;

    protected IfcRelAggregates() { initCollections(); }
    /**
     * Constructs IfcRelAggregates with all required attributes.
     */
    public IfcRelAggregates(IfcGloballyUniqueId globalId,IfcObjectDefinition relatingObject,Collection<IfcObjectDefinition> relatedObjects) {

        super(globalId);
        this.relatingObject = relatingObject;
        this.relatedObjects = relatedObjects;
    }
    /**
     * Constructs IfcRelAggregates with required and optional attributes.
     */
    public IfcRelAggregates(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcObjectDefinition relatingObject,Collection<IfcObjectDefinition> relatedObjects) {
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
    @Override public void finalizeRelationships() { this.setIfcRelAggregatesRelationship(); }
    private void setIfcRelAggregatesRelationship() {
		if (this.relatingObject != null) {
		    if (this.relatingObject instanceof IfcObjectDefinition)
		        ((IfcObjectDefinition)this.relatingObject).isDecomposedBy.add(this);
		}
		if (this.relatedObjects != null) {
		    for (Object x : this.relatedObjects) {
		        if (x instanceof IfcObjectDefinition)
		            ((IfcObjectDefinition)x).decomposes.add(this);
		    }
		}
    }
}