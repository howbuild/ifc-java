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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialprofileset.htm">IfcMaterialProfileSet</a>
 */
public class IfcMaterialProfileSet extends IfcMaterialDefinition {
    protected IfcLabel name;
    protected IfcText description;
    protected Collection<IfcMaterialProfile> materialProfiles;
    protected IfcCompositeProfileDef compositeProfile;

    protected IfcMaterialProfileSet() { initCollections(); }
    /**
     * Constructs IfcMaterialProfileSet with all required attributes.
     */
    public IfcMaterialProfileSet(Collection<IfcMaterialProfile> materialProfiles) {

        super();
        this.materialProfiles = materialProfiles;
    }
    /**
     * Constructs IfcMaterialProfileSet with required and optional attributes.
     */
    public IfcMaterialProfileSet(IfcLabel name,IfcText description,Collection<IfcMaterialProfile> materialProfiles,IfcCompositeProfileDef compositeProfile) {
        super();
        this.name = name;
        this.description = description;
        this.materialProfiles = materialProfiles;
        this.compositeProfile = compositeProfile;
    }
    private void initCollections() {
        this.materialProfiles = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcMaterialProfile> getMaterialProfiles() { return this.materialProfiles; }
    public void setMaterialProfiles(Collection<IfcMaterialProfile> value) { this.materialProfiles = value; }
    public IfcCompositeProfileDef getCompositeProfile() { return this.compositeProfile; }
    public void setCompositeProfile(IfcCompositeProfileDef value) { this.compositeProfile = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(materialProfiles != null ? StepUtils.toStepValue(materialProfiles) : "$");
		parameters.add(compositeProfile != null ? StepUtils.toStepValue(compositeProfile) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMaterialProfileSetRelationship(); }
    private void setIfcMaterialProfileSetRelationship() {
		if (this.materialProfiles != null) {
		    for (Object x : this.materialProfiles) {
		        if (x instanceof IfcMaterialProfile)
		            ((IfcMaterialProfile)x).toMaterialProfileSet = this;
		    }
		}
    }
}