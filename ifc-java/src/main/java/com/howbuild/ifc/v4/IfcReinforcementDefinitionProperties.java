package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedPropertySet
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcDoorLiningProperties
 * ,IfcDoorPanelProperties
 * ,IfcPermeableCoveringProperties
 * ,IfcReinforcementDefinitionProperties
 * ,IfcWindowLiningProperties
 * ,IfcWindowPanelProperties))
 * SUBTYPE OF (IfcPropertySetDefinition);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcementdefinitionproperties.htm">IfcReinforcementDefinitionProperties</a>
 */
public class IfcReinforcementDefinitionProperties extends IfcPreDefinedPropertySet {
    protected IfcLabel definitionType;
    protected Collection<IfcSectionReinforcementProperties> reinforcementSectionDefinitions;

    protected IfcReinforcementDefinitionProperties() { initCollections(); }
    /**
     * Constructs IfcReinforcementDefinitionProperties with all required attributes.
     */
    public IfcReinforcementDefinitionProperties(IfcGloballyUniqueId globalId,Collection<IfcSectionReinforcementProperties> reinforcementSectionDefinitions) {

        super(globalId);
        this.reinforcementSectionDefinitions = reinforcementSectionDefinitions;
    }
    /**
     * Constructs IfcReinforcementDefinitionProperties with required and optional attributes.
     */
    public IfcReinforcementDefinitionProperties(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel definitionType,Collection<IfcSectionReinforcementProperties> reinforcementSectionDefinitions) {
        super(globalId,ownerHistory,name,description);
        this.definitionType = definitionType;
        this.reinforcementSectionDefinitions = reinforcementSectionDefinitions;
    }
    private void initCollections() {
        this.reinforcementSectionDefinitions = new ArrayList<>();
    }
    public IfcLabel getDefinitionType() { return this.definitionType; }
    public void setDefinitionType(IfcLabel value) { this.definitionType = value; } // optional
    public Collection<IfcSectionReinforcementProperties> getReinforcementSectionDefinitions() { return this.reinforcementSectionDefinitions; }
    public void setReinforcementSectionDefinitions(Collection<IfcSectionReinforcementProperties> value) { this.reinforcementSectionDefinitions = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(definitionType != null ? StepUtils.toStepValue(definitionType) : "$");
		parameters.add(reinforcementSectionDefinitions != null ? StepUtils.toStepValue(reinforcementSectionDefinitions) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}