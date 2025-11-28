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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialprofile.htm">IfcMaterialProfile</a>
 */
public class IfcMaterialProfile extends IfcMaterialDefinition {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcMaterial material;
    protected IfcProfileDef profile;
    protected IfcInteger priority;
    protected IfcLabel category;
    protected IfcMaterialProfileSet toMaterialProfileSet;

    protected IfcMaterialProfile() { initCollections(); }
    /**
     * Constructs IfcMaterialProfile with all required attributes.
     */
    public IfcMaterialProfile(IfcProfileDef profile) {

        super();
        this.profile = profile;
    }
    /**
     * Constructs IfcMaterialProfile with required and optional attributes.
     */
    public IfcMaterialProfile(IfcLabel name,IfcText description,IfcMaterial material,IfcProfileDef profile,IfcInteger priority,IfcLabel category) {
        super();
        this.name = name;
        this.description = description;
        this.material = material;
        this.profile = profile;
        this.priority = priority;
        this.category = category;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcMaterial getMaterial() { return this.material; }
    public void setMaterial(IfcMaterial value) { this.material = value; } // optional
    public IfcProfileDef getProfile() { return this.profile; }
    public void setProfile(IfcProfileDef value) { this.profile = value; }
    public IfcInteger getPriority() { return this.priority; }
    public void setPriority(IfcInteger value) { this.priority = value; } // optional
    public IfcLabel getCategory() { return this.category; }
    public void setCategory(IfcLabel value) { this.category = value; } // optional
    public IfcMaterialProfileSet getToMaterialProfileSet() { return this.toMaterialProfileSet; }
    public void setToMaterialProfileSet(IfcMaterialProfileSet value) { this.toMaterialProfileSet = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(material != null ? StepUtils.toStepValue(material) : "$");
		parameters.add(profile != null ? StepUtils.toStepValue(profile) : "$");
		parameters.add(priority != null ? StepUtils.toStepValue(priority) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}