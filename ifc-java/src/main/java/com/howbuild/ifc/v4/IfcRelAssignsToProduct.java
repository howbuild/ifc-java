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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstoproduct.htm">IfcRelAssignsToProduct</a>
 */
public class IfcRelAssignsToProduct extends IfcRelAssigns {
    protected IfcProductSelect relatingProduct;

    protected IfcRelAssignsToProduct() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToProduct with all required attributes.
     */
    public IfcRelAssignsToProduct(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcProductSelect relatingProduct) {

        super(globalId,relatedObjects);
        this.relatingProduct = relatingProduct;
    }
    /**
     * Constructs IfcRelAssignsToProduct with required and optional attributes.
     */
    public IfcRelAssignsToProduct(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcProductSelect relatingProduct) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType);
        this.relatingProduct = relatingProduct;
    }
    private void initCollections() {
    }
    public IfcProductSelect getRelatingProduct() { return this.relatingProduct; }
    public void setRelatingProduct(IfcProductSelect value) { this.relatingProduct = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingProduct != null ? StepUtils.toStepValue(relatingProduct) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssignsToProductRelationship(); }
    private void setIfcRelAssignsToProductRelationship() {
		if (this.relatingProduct != null) {
		    if (this.relatingProduct instanceof IfcProduct)
		        ((IfcProduct)this.relatingProduct).referencedBy.add(this);
		}
		if (this.relatingProduct != null) {
		    if (this.relatingProduct instanceof IfcTypeProduct)
		        ((IfcTypeProduct)this.relatingProduct).referencedBy.add(this);
		}
    }
}