package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExtendedProperties
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMaterialProperties
 * ,IfcProfileProperties))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * Name : OPTIONAL IfcIdentifier;
 * Description : OPTIONAL IfcText;
 * Properties : SET [1:?] OF IfcProperty;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialproperties.htm">IfcMaterialProperties</a>
 */
public class IfcMaterialProperties extends IfcExtendedProperties {
    protected IfcMaterialDefinition material;

    protected IfcMaterialProperties() { initCollections(); }
    /**
     * Constructs IfcMaterialProperties with all required attributes.
     */
    public IfcMaterialProperties(Collection<IfcProperty> properties,IfcMaterialDefinition material) {

        super(properties);
        this.material = material;
    }
    /**
     * Constructs IfcMaterialProperties with required and optional attributes.
     */
    public IfcMaterialProperties(IfcIdentifier name,IfcText description,Collection<IfcProperty> properties,IfcMaterialDefinition material) {
        super(name,description,properties);
        this.material = material;
    }
    private void initCollections() {
    }
    public IfcMaterialDefinition getMaterial() { return this.material; }
    public void setMaterial(IfcMaterialDefinition value) { this.material = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(properties != null ? StepUtils.toStepValue(properties) : "$");
		parameters.add(material != null ? StepUtils.toStepValue(material) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMaterialPropertiesRelationship(); }
    private void setIfcMaterialPropertiesRelationship() {
		if (this.material != null) {
		    if (this.material instanceof IfcMaterialDefinition)
		        ((IfcMaterialDefinition)this.material).hasProperties.add(this);
		}
    }
}