package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialDefinition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMaterial
 * ,IfcMaterialConstituent
 * ,IfcMaterialConstituentSet
 * ,IfcMaterialLayer
 * ,IfcMaterialLayerSet
 * ,IfcMaterialProfile
 * ,IfcMaterialProfileSet));
 * INVERSE
 * AssociatedTo : SET [0:?] OF IfcRelAssociatesMaterial FOR RelatingMaterial;
 * HasExternalReferences : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * HasProperties : SET [0:?] OF IfcMaterialProperties FOR Material;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmateriallayer.htm">IfcMaterialLayer</a>
 */
public class IfcMaterialLayer extends IfcMaterialDefinition {
    protected IfcMaterial material;
    protected IfcNonNegativeLengthMeasure layerThickness;
    protected IfcLogical isVentilated;
    protected IfcLabel name;
    protected IfcText description;
    protected IfcLabel category;
    protected IfcInteger priority;
    protected IfcMaterialLayerSet toMaterialLayerSet;

    protected IfcMaterialLayer() { initCollections(); }
    /**
     * Constructs IfcMaterialLayer with all required attributes.
     */
    public IfcMaterialLayer(IfcNonNegativeLengthMeasure layerThickness) {

        super();
        this.layerThickness = layerThickness;
    }
    /**
     * Constructs IfcMaterialLayer with required and optional attributes.
     */
    public IfcMaterialLayer(IfcMaterial material,IfcNonNegativeLengthMeasure layerThickness,IfcLogical isVentilated,IfcLabel name,IfcText description,IfcLabel category,IfcInteger priority) {
        super();
        this.material = material;
        this.layerThickness = layerThickness;
        this.isVentilated = isVentilated;
        this.name = name;
        this.description = description;
        this.category = category;
        this.priority = priority;
    }
    private void initCollections() {
    }
    public IfcMaterial getMaterial() { return this.material; }
    public void setMaterial(IfcMaterial value) { this.material = value; } // optional
    public IfcNonNegativeLengthMeasure getLayerThickness() { return this.layerThickness; }
    public void setLayerThickness(IfcNonNegativeLengthMeasure value) { this.layerThickness = value; }
    public IfcLogical getIsVentilated() { return this.isVentilated; }
    public void setIsVentilated(IfcLogical value) { this.isVentilated = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcLabel getCategory() { return this.category; }
    public void setCategory(IfcLabel value) { this.category = value; } // optional
    public IfcInteger getPriority() { return this.priority; }
    public void setPriority(IfcInteger value) { this.priority = value; } // optional
    public IfcMaterialLayerSet getToMaterialLayerSet() { return this.toMaterialLayerSet; }
    public void setToMaterialLayerSet(IfcMaterialLayerSet value) { this.toMaterialLayerSet = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(material != null ? StepUtils.toStepValue(material) : "$");
		parameters.add(layerThickness != null ? StepUtils.toStepValue(layerThickness) : "$");
		parameters.add(isVentilated != null ? StepUtils.toStepValue(isVentilated) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
		parameters.add(priority != null ? StepUtils.toStepValue(priority) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}