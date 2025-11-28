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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcprofileproperties.htm">IfcProfileProperties</a>
 */
public class IfcProfileProperties extends IfcExtendedProperties {
    protected IfcProfileDef profileDefinition;

    protected IfcProfileProperties() { initCollections(); }
    /**
     * Constructs IfcProfileProperties with all required attributes.
     */
    public IfcProfileProperties(Collection<IfcProperty> properties,IfcProfileDef profileDefinition) {

        super(properties);
        this.profileDefinition = profileDefinition;
    }
    /**
     * Constructs IfcProfileProperties with required and optional attributes.
     */
    public IfcProfileProperties(IfcIdentifier name,IfcText description,Collection<IfcProperty> properties,IfcProfileDef profileDefinition) {
        super(name,description,properties);
        this.profileDefinition = profileDefinition;
    }
    private void initCollections() {
    }
    public IfcProfileDef getProfileDefinition() { return this.profileDefinition; }
    public void setProfileDefinition(IfcProfileDef value) { this.profileDefinition = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(properties != null ? StepUtils.toStepValue(properties) : "$");
		parameters.add(profileDefinition != null ? StepUtils.toStepValue(profileDefinition) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcProfilePropertiesRelationship(); }
    private void setIfcProfilePropertiesRelationship() {
		if (this.profileDefinition != null) {
		    if (this.profileDefinition instanceof IfcProfileDef)
		        ((IfcProfileDef)this.profileDefinition).hasProperties.add(this);
		}
    }
}