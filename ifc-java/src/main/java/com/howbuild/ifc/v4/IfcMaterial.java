package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterial
 * SUBTYPE OF (IfcMaterialDefinition);
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * Category : OPTIONAL IfcLabel;
 * INVERSE
 * HasRepresentation : SET [0:1] OF IfcMaterialDefinitionRepresentation FOR RepresentedMaterial;
 * IsRelatedWith : SET [0:?] OF IfcMaterialRelationship FOR RelatedMaterials;
 * RelatesTo : SET [0:1] OF IfcMaterialRelationship FOR RelatingMaterial;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterial.htm">IfcMaterial</a>
 */
public class IfcMaterial extends IfcMaterialDefinition {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcLabel category;
    protected Collection<IfcMaterialDefinitionRepresentation> hasRepresentation;
    protected Collection<IfcMaterialRelationship> isRelatedWith;
    protected Collection<IfcMaterialRelationship> relatesTo;

    protected IfcMaterial() { initCollections(); }
    /**
     * Constructs IfcMaterial with all required attributes.
     */
    public IfcMaterial(IfcLabel name) {

        super();
        this.hasRepresentation = new ArrayList<>();
        this.isRelatedWith = new ArrayList<>();
        this.relatesTo = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcMaterial with required and optional attributes.
     */
    public IfcMaterial(IfcLabel name,IfcText description,IfcLabel category) {
        super();
        this.hasRepresentation = new ArrayList<>();
        this.isRelatedWith = new ArrayList<>();
        this.relatesTo = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.category = category;
    }
    private void initCollections() {
        this.hasRepresentation = new ArrayList<>();
        this.isRelatedWith = new ArrayList<>();
        this.relatesTo = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcLabel getCategory() { return this.category; }
    public void setCategory(IfcLabel value) { this.category = value; } // optional
    public Collection<IfcMaterialDefinitionRepresentation> getHasRepresentation() { return this.hasRepresentation; }
    public void setHasRepresentation(Collection<IfcMaterialDefinitionRepresentation> value) { this.hasRepresentation = value; } // inverse
    public Collection<IfcMaterialRelationship> getIsRelatedWith() { return this.isRelatedWith; }
    public void setIsRelatedWith(Collection<IfcMaterialRelationship> value) { this.isRelatedWith = value; } // inverse
    public Collection<IfcMaterialRelationship> getRelatesTo() { return this.relatesTo; }
    public void setRelatesTo(Collection<IfcMaterialRelationship> value) { this.relatesTo = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}