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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstoactor.htm">IfcRelAssignsToActor</a>
 */
public class IfcRelAssignsToActor extends IfcRelAssigns {
    protected IfcActor relatingActor;
    protected IfcActorRole actingRole;

    protected IfcRelAssignsToActor() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToActor with all required attributes.
     */
    public IfcRelAssignsToActor(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcActor relatingActor) {

        super(globalId,relatedObjects);
        this.relatingActor = relatingActor;
    }
    /**
     * Constructs IfcRelAssignsToActor with required and optional attributes.
     */
    public IfcRelAssignsToActor(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcActor relatingActor,IfcActorRole actingRole) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType);
        this.relatingActor = relatingActor;
        this.actingRole = actingRole;
    }
    private void initCollections() {
    }
    public IfcActor getRelatingActor() { return this.relatingActor; }
    public void setRelatingActor(IfcActor value) { this.relatingActor = value; }
    public IfcActorRole getActingRole() { return this.actingRole; }
    public void setActingRole(IfcActorRole value) { this.actingRole = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingActor != null ? StepUtils.toStepValue(relatingActor) : "$");
		parameters.add(actingRole != null ? StepUtils.toStepValue(actingRole) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssignsToActorRelationship(); }
    private void setIfcRelAssignsToActorRelationship() {
		if (this.relatingActor != null) {
		    if (this.relatingActor instanceof IfcActor)
		        ((IfcActor)this.relatingActor).isActingUpon.add(this);
		}
    }
}