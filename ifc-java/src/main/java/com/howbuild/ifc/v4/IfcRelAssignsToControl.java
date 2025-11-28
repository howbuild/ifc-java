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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstocontrol.htm">IfcRelAssignsToControl</a>
 */
public class IfcRelAssignsToControl extends IfcRelAssigns {
    protected IfcControl relatingControl;

    protected IfcRelAssignsToControl() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToControl with all required attributes.
     */
    public IfcRelAssignsToControl(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcControl relatingControl) {

        super(globalId,relatedObjects);
        this.relatingControl = relatingControl;
    }
    /**
     * Constructs IfcRelAssignsToControl with required and optional attributes.
     */
    public IfcRelAssignsToControl(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcControl relatingControl) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType);
        this.relatingControl = relatingControl;
    }
    private void initCollections() {
    }
    public IfcControl getRelatingControl() { return this.relatingControl; }
    public void setRelatingControl(IfcControl value) { this.relatingControl = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingControl != null ? StepUtils.toStepValue(relatingControl) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssignsToControlRelationship(); }
    private void setIfcRelAssignsToControlRelationship() {
		if (this.relatingControl != null) {
		    if (this.relatingControl instanceof IfcControl)
		        ((IfcControl)this.relatingControl).controls.add(this);
		}
    }
}