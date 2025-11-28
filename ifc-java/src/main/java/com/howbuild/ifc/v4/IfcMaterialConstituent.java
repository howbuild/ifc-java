package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialConstituent
 * SUBTYPE OF (IfcMaterialDefinition);
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * Material : IfcMaterial;
 * Fraction : OPTIONAL IfcNormalisedRatioMeasure;
 * Category : OPTIONAL IfcLabel;
 * INVERSE
 * ToMaterialConstituentSet : IfcMaterialConstituentSet FOR MaterialConstituents;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialconstituent.htm">IfcMaterialConstituent</a>
 */
public class IfcMaterialConstituent extends IfcMaterialDefinition {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcMaterial material;
    protected IfcNormalisedRatioMeasure fraction;
    protected IfcLabel category;
    protected IfcMaterialConstituentSet toMaterialConstituentSet;

    protected IfcMaterialConstituent() { initCollections(); }
    /**
     * Constructs IfcMaterialConstituent with all required attributes.
     */
    public IfcMaterialConstituent(IfcMaterial material) {

        super();
        this.material = material;
    }
    /**
     * Constructs IfcMaterialConstituent with required and optional attributes.
     */
    public IfcMaterialConstituent(IfcLabel name,IfcText description,IfcMaterial material,IfcNormalisedRatioMeasure fraction,IfcLabel category) {
        super();
        this.name = name;
        this.description = description;
        this.material = material;
        this.fraction = fraction;
        this.category = category;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcMaterial getMaterial() { return this.material; }
    public void setMaterial(IfcMaterial value) { this.material = value; }
    public IfcNormalisedRatioMeasure getFraction() { return this.fraction; }
    public void setFraction(IfcNormalisedRatioMeasure value) { this.fraction = value; } // optional
    public IfcLabel getCategory() { return this.category; }
    public void setCategory(IfcLabel value) { this.category = value; } // optional
    public IfcMaterialConstituentSet getToMaterialConstituentSet() { return this.toMaterialConstituentSet; }
    public void setToMaterialConstituentSet(IfcMaterialConstituentSet value) { this.toMaterialConstituentSet = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(material != null ? StepUtils.toStepValue(material) : "$");
		parameters.add(fraction != null ? StepUtils.toStepValue(fraction) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}