package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcReinforcingElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcingBarType
 * ,IfcReinforcingMeshType
 * ,IfcTendonAnchorType
 * ,IfcTendonType))
 * SUBTYPE OF (IfcElementComponentType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctendontype.htm">IfcTendonType</a>
 */
public class IfcTendonType extends IfcReinforcingElementType {
    protected IfcTendonTypeEnum predefinedType;
    protected IfcPositiveLengthMeasure nominalDiameter;
    protected IfcAreaMeasure crossSectionArea;
    protected IfcPositiveLengthMeasure sheathDiameter;

    protected IfcTendonType() { initCollections(); }
    /**
     * Constructs IfcTendonType with all required attributes.
     */
    public IfcTendonType(IfcGloballyUniqueId globalId,IfcTendonTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcTendonType with required and optional attributes.
     */
    public IfcTendonType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcTendonTypeEnum predefinedType,IfcPositiveLengthMeasure nominalDiameter,IfcAreaMeasure crossSectionArea,IfcPositiveLengthMeasure sheathDiameter) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.nominalDiameter = nominalDiameter;
        this.crossSectionArea = crossSectionArea;
        this.sheathDiameter = sheathDiameter;
    }
    private void initCollections() {
    }
    public IfcTendonTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcTendonTypeEnum value) { this.predefinedType = value; }
    public IfcPositiveLengthMeasure getNominalDiameter() { return this.nominalDiameter; }
    public void setNominalDiameter(IfcPositiveLengthMeasure value) { this.nominalDiameter = value; } // optional
    public IfcAreaMeasure getCrossSectionArea() { return this.crossSectionArea; }
    public void setCrossSectionArea(IfcAreaMeasure value) { this.crossSectionArea = value; } // optional
    public IfcPositiveLengthMeasure getSheathDiameter() { return this.sheathDiameter; }
    public void setSheathDiameter(IfcPositiveLengthMeasure value) { this.sheathDiameter = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(representationMaps != null ? StepUtils.toStepValue(representationMaps) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(elementType != null ? StepUtils.toStepValue(elementType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(nominalDiameter != null ? StepUtils.toStepValue(nominalDiameter) : "$");
		parameters.add(crossSectionArea != null ? StepUtils.toStepValue(crossSectionArea) : "$");
		parameters.add(sheathDiameter != null ? StepUtils.toStepValue(sheathDiameter) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}