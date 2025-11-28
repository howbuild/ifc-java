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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstoprocess.htm">IfcRelAssignsToProcess</a>
 */
public class IfcRelAssignsToProcess extends IfcRelAssigns {
    protected IfcProcessSelect relatingProcess;
    protected IfcMeasureWithUnit quantityInProcess;

    protected IfcRelAssignsToProcess() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToProcess with all required attributes.
     */
    public IfcRelAssignsToProcess(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcProcessSelect relatingProcess) {

        super(globalId,relatedObjects);
        this.relatingProcess = relatingProcess;
    }
    /**
     * Constructs IfcRelAssignsToProcess with required and optional attributes.
     */
    public IfcRelAssignsToProcess(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcProcessSelect relatingProcess,IfcMeasureWithUnit quantityInProcess) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType);
        this.relatingProcess = relatingProcess;
        this.quantityInProcess = quantityInProcess;
    }
    private void initCollections() {
    }
    public IfcProcessSelect getRelatingProcess() { return this.relatingProcess; }
    public void setRelatingProcess(IfcProcessSelect value) { this.relatingProcess = value; }
    public IfcMeasureWithUnit getQuantityInProcess() { return this.quantityInProcess; }
    public void setQuantityInProcess(IfcMeasureWithUnit value) { this.quantityInProcess = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingProcess != null ? StepUtils.toStepValue(relatingProcess) : "$");
		parameters.add(quantityInProcess != null ? StepUtils.toStepValue(quantityInProcess) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssignsToProcessRelationship(); }
    private void setIfcRelAssignsToProcessRelationship() {
		if (this.relatingProcess != null) {
		    if (this.relatingProcess instanceof IfcProcess)
		        ((IfcProcess)this.relatingProcess).operatesOn.add(this);
		}
		if (this.relatingProcess != null) {
		    if (this.relatingProcess instanceof IfcTypeProcess)
		        ((IfcTypeProcess)this.relatingProcess).operatesOn.add(this);
		}
    }
}