package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedProperties
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcementBarProperties
 * ,IfcSectionProperties
 * ,IfcSectionReinforcementProperties))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsectionreinforcementproperties.htm">IfcSectionReinforcementProperties</a>
 */
public class IfcSectionReinforcementProperties extends IfcPreDefinedProperties {
    protected IfcLengthMeasure longitudinalStartPosition;
    protected IfcLengthMeasure longitudinalEndPosition;
    protected IfcLengthMeasure transversePosition;
    protected IfcReinforcingBarRoleEnum reinforcementRole;
    protected IfcSectionProperties sectionDefinition;
    protected Collection<IfcReinforcementBarProperties> crossSectionReinforcementDefinitions;

    protected IfcSectionReinforcementProperties() { initCollections(); }
    /**
     * Constructs IfcSectionReinforcementProperties with all required attributes.
     */
    public IfcSectionReinforcementProperties(IfcLengthMeasure longitudinalStartPosition,IfcLengthMeasure longitudinalEndPosition,IfcReinforcingBarRoleEnum reinforcementRole,IfcSectionProperties sectionDefinition,Collection<IfcReinforcementBarProperties> crossSectionReinforcementDefinitions) {

        super();
        this.longitudinalStartPosition = longitudinalStartPosition;
        this.longitudinalEndPosition = longitudinalEndPosition;
        this.reinforcementRole = reinforcementRole;
        this.sectionDefinition = sectionDefinition;
        this.crossSectionReinforcementDefinitions = crossSectionReinforcementDefinitions;
    }
    /**
     * Constructs IfcSectionReinforcementProperties with required and optional attributes.
     */
    public IfcSectionReinforcementProperties(IfcLengthMeasure longitudinalStartPosition,IfcLengthMeasure longitudinalEndPosition,IfcLengthMeasure transversePosition,IfcReinforcingBarRoleEnum reinforcementRole,IfcSectionProperties sectionDefinition,Collection<IfcReinforcementBarProperties> crossSectionReinforcementDefinitions) {
        super();
        this.longitudinalStartPosition = longitudinalStartPosition;
        this.longitudinalEndPosition = longitudinalEndPosition;
        this.transversePosition = transversePosition;
        this.reinforcementRole = reinforcementRole;
        this.sectionDefinition = sectionDefinition;
        this.crossSectionReinforcementDefinitions = crossSectionReinforcementDefinitions;
    }
    private void initCollections() {
        this.crossSectionReinforcementDefinitions = new ArrayList<>();
    }
    public IfcLengthMeasure getLongitudinalStartPosition() { return this.longitudinalStartPosition; }
    public void setLongitudinalStartPosition(IfcLengthMeasure value) { this.longitudinalStartPosition = value; }
    public IfcLengthMeasure getLongitudinalEndPosition() { return this.longitudinalEndPosition; }
    public void setLongitudinalEndPosition(IfcLengthMeasure value) { this.longitudinalEndPosition = value; }
    public IfcLengthMeasure getTransversePosition() { return this.transversePosition; }
    public void setTransversePosition(IfcLengthMeasure value) { this.transversePosition = value; } // optional
    public IfcReinforcingBarRoleEnum getReinforcementRole() { return this.reinforcementRole; }
    public void setReinforcementRole(IfcReinforcingBarRoleEnum value) { this.reinforcementRole = value; }
    public IfcSectionProperties getSectionDefinition() { return this.sectionDefinition; }
    public void setSectionDefinition(IfcSectionProperties value) { this.sectionDefinition = value; }
    public Collection<IfcReinforcementBarProperties> getCrossSectionReinforcementDefinitions() { return this.crossSectionReinforcementDefinitions; }
    public void setCrossSectionReinforcementDefinitions(Collection<IfcReinforcementBarProperties> value) { this.crossSectionReinforcementDefinitions = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(longitudinalStartPosition != null ? StepUtils.toStepValue(longitudinalStartPosition) : "$");
		parameters.add(longitudinalEndPosition != null ? StepUtils.toStepValue(longitudinalEndPosition) : "$");
		parameters.add(transversePosition != null ? StepUtils.toStepValue(transversePosition) : "$");
		parameters.add(StepUtils.toStepValue(reinforcementRole));
		parameters.add(sectionDefinition != null ? StepUtils.toStepValue(sectionDefinition) : "$");
		parameters.add(crossSectionReinforcementDefinitions != null ? StepUtils.toStepValue(crossSectionReinforcementDefinitions) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}