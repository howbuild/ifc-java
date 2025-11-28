package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialConstituentSet
 * SUBTYPE OF (IfcMaterialDefinition);
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * MaterialConstituents : OPTIONAL SET [1:?] OF IfcMaterialConstituent;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialconstituentset.htm">IfcMaterialConstituentSet</a>
 */
public class IfcMaterialConstituentSet extends IfcMaterialDefinition {
    protected IfcLabel name;
    protected IfcText description;
    protected Collection<IfcMaterialConstituent> materialConstituents;


    /**
     * Constructs IfcMaterialConstituentSet with all required attributes.
     */
    public IfcMaterialConstituentSet() {

        super();
        this.materialConstituents = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcMaterialConstituentSet with required and optional attributes.
     */
    public IfcMaterialConstituentSet(IfcLabel name,IfcText description,Collection<IfcMaterialConstituent> materialConstituents) {
        super();
        this.name = name;
        this.description = description;
        this.materialConstituents = materialConstituents;
    }
    private void initCollections() {
        this.materialConstituents = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcMaterialConstituent> getMaterialConstituents() { return this.materialConstituents; }
    public void setMaterialConstituents(Collection<IfcMaterialConstituent> value) { this.materialConstituents = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(materialConstituents != null ? StepUtils.toStepValue(materialConstituents) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMaterialConstituentSetRelationship(); }
    private void setIfcMaterialConstituentSetRelationship() {
		if (this.materialConstituents != null) {
		    for (Object x : this.materialConstituents) {
		        if (x instanceof IfcMaterialConstituent)
		            ((IfcMaterialConstituent)x).toMaterialConstituentSet = this;
		    }
		}
    }
}