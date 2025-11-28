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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstoresource.htm">IfcRelAssignsToResource</a>
 */
public class IfcRelAssignsToResource extends IfcRelAssigns {
    protected IfcResourceSelect relatingResource;

    protected IfcRelAssignsToResource() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToResource with all required attributes.
     */
    public IfcRelAssignsToResource(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcResourceSelect relatingResource) {

        super(globalId,relatedObjects);
        this.relatingResource = relatingResource;
    }
    /**
     * Constructs IfcRelAssignsToResource with required and optional attributes.
     */
    public IfcRelAssignsToResource(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcResourceSelect relatingResource) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType);
        this.relatingResource = relatingResource;
    }
    private void initCollections() {
    }
    public IfcResourceSelect getRelatingResource() { return this.relatingResource; }
    public void setRelatingResource(IfcResourceSelect value) { this.relatingResource = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingResource != null ? StepUtils.toStepValue(relatingResource) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssignsToResourceRelationship(); }
    private void setIfcRelAssignsToResourceRelationship() {
		if (this.relatingResource != null) {
		    if (this.relatingResource instanceof IfcResource)
		        ((IfcResource)this.relatingResource).resourceOf.add(this);
		}
		if (this.relatingResource != null) {
		    if (this.relatingResource instanceof IfcTypeResource)
		        ((IfcTypeResource)this.relatingResource).resourceOf.add(this);
		}
    }
}