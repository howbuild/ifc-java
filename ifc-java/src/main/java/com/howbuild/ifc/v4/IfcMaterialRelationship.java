package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingMaterial : IfcMaterial;
 * RelatedMaterials : SET [1:?] OF IfcMaterial;
 * Expression : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialrelationship.htm">IfcMaterialRelationship</a>
 */
public class IfcMaterialRelationship extends IfcResourceLevelRelationship {
    protected IfcMaterial relatingMaterial;
    protected Collection<IfcMaterial> relatedMaterials;
    protected IfcLabel expression;

    protected IfcMaterialRelationship() { initCollections(); }
    /**
     * Constructs IfcMaterialRelationship with all required attributes.
     */
    public IfcMaterialRelationship(IfcMaterial relatingMaterial,Collection<IfcMaterial> relatedMaterials) {

        super();
        this.relatingMaterial = relatingMaterial;
        this.relatedMaterials = relatedMaterials;
    }
    /**
     * Constructs IfcMaterialRelationship with required and optional attributes.
     */
    public IfcMaterialRelationship(IfcLabel name,IfcText description,IfcMaterial relatingMaterial,Collection<IfcMaterial> relatedMaterials,IfcLabel expression) {
        super(name,description);
        this.relatingMaterial = relatingMaterial;
        this.relatedMaterials = relatedMaterials;
        this.expression = expression;
    }
    private void initCollections() {
        this.relatedMaterials = new ArrayList<>();
    }
    public IfcMaterial getRelatingMaterial() { return this.relatingMaterial; }
    public void setRelatingMaterial(IfcMaterial value) { this.relatingMaterial = value; }
    public Collection<IfcMaterial> getRelatedMaterials() { return this.relatedMaterials; }
    public void setRelatedMaterials(Collection<IfcMaterial> value) { this.relatedMaterials = value; }
    public IfcLabel getExpression() { return this.expression; }
    public void setExpression(IfcLabel value) { this.expression = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingMaterial != null ? StepUtils.toStepValue(relatingMaterial) : "$");
		parameters.add(relatedMaterials != null ? StepUtils.toStepValue(relatedMaterials) : "$");
		parameters.add(expression != null ? StepUtils.toStepValue(expression) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMaterialRelationshipRelationship(); }
    private void setIfcMaterialRelationshipRelationship() {
		if (this.relatedMaterials != null) {
		    for (Object x : this.relatedMaterials) {
		        if (x instanceof IfcMaterial)
		            ((IfcMaterial)x).isRelatedWith.add(this);
		    }
		}
		if (this.relatingMaterial != null) {
		    if (this.relatingMaterial instanceof IfcMaterial)
		        ((IfcMaterial)this.relatingMaterial).relatesTo.add(this);
		}
    }
}