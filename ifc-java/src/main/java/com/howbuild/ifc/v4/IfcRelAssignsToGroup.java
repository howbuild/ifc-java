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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstogroup.htm">IfcRelAssignsToGroup</a>
 */
public class IfcRelAssignsToGroup extends IfcRelAssigns {
    protected IfcGroup relatingGroup;

    protected IfcRelAssignsToGroup() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToGroup with all required attributes.
     */
    public IfcRelAssignsToGroup(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcGroup relatingGroup) {

        super(globalId,relatedObjects);
        this.relatingGroup = relatingGroup;
    }
    /**
     * Constructs IfcRelAssignsToGroup with required and optional attributes.
     */
    public IfcRelAssignsToGroup(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcGroup relatingGroup) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType);
        this.relatingGroup = relatingGroup;
    }
    private void initCollections() {
    }
    public IfcGroup getRelatingGroup() { return this.relatingGroup; }
    public void setRelatingGroup(IfcGroup value) { this.relatingGroup = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingGroup != null ? StepUtils.toStepValue(relatingGroup) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssignsToGroupRelationship(); }
    private void setIfcRelAssignsToGroupRelationship() {
		if (this.relatingGroup != null) {
		    if (this.relatingGroup instanceof IfcGroup)
		        ((IfcGroup)this.relatingGroup).isGroupedBy.add(this);
		}
    }
}