package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAssociates
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAssociatesApproval
 * ,IfcRelAssociatesClassification
 * ,IfcRelAssociatesConstraint
 * ,IfcRelAssociatesDocument
 * ,IfcRelAssociatesLibrary
 * ,IfcRelAssociatesMaterial))
 * SUBTYPE OF (IfcRelationship);
 * RelatedObjects : SET [1:?] OF IfcDefinitionSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociatesmaterial.htm">IfcRelAssociatesMaterial</a>
 */
public class IfcRelAssociatesMaterial extends IfcRelAssociates {
    protected IfcMaterialSelect relatingMaterial;

    protected IfcRelAssociatesMaterial() { initCollections(); }
    /**
     * Constructs IfcRelAssociatesMaterial with all required attributes.
     */
    public IfcRelAssociatesMaterial(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects,IfcMaterialSelect relatingMaterial) {

        super(globalId,relatedObjects);
        this.relatingMaterial = relatingMaterial;
    }
    /**
     * Constructs IfcRelAssociatesMaterial with required and optional attributes.
     */
    public IfcRelAssociatesMaterial(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects,IfcMaterialSelect relatingMaterial) {
        super(globalId,ownerHistory,name,description,relatedObjects);
        this.relatingMaterial = relatingMaterial;
    }
    private void initCollections() {
    }
    public IfcMaterialSelect getRelatingMaterial() { return this.relatingMaterial; }
    public void setRelatingMaterial(IfcMaterialSelect value) { this.relatingMaterial = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingMaterial != null ? StepUtils.toStepValue(relatingMaterial) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssociatesMaterialRelationship(); }
    private void setIfcRelAssociatesMaterialRelationship() {
		if (this.relatingMaterial != null) {
		    if (this.relatingMaterial instanceof IfcMaterialDefinition)
		        ((IfcMaterialDefinition)this.relatingMaterial).associatedTo.add(this);
		}
		if (this.relatingMaterial != null) {
		    if (this.relatingMaterial instanceof IfcMaterialUsageDefinition)
		        ((IfcMaterialUsageDefinition)this.relatingMaterial).associatedTo.add(this);
		}
    }
}