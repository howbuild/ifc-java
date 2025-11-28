package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFlowTerminalType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcAirTerminalType
 * ,IfcAudioVisualApplianceType
 * ,IfcCommunicationsApplianceType
 * ,IfcElectricApplianceType
 * ,IfcFireSuppressionTerminalType
 * ,IfcLampType
 * ,IfcLightFixtureType
 * ,IfcMedicalDeviceType
 * ,IfcOutletType
 * ,IfcSanitaryTerminalType
 * ,IfcSpaceHeaterType
 * ,IfcStackTerminalType
 * ,IfcWasteTerminalType))
 * SUBTYPE OF (IfcDistributionFlowElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcwasteterminaltype.htm">IfcWasteTerminalType</a>
 */
public class IfcWasteTerminalType extends IfcFlowTerminalType {
    protected IfcWasteTerminalTypeEnum predefinedType;

    protected IfcWasteTerminalType() { initCollections(); }
    /**
     * Constructs IfcWasteTerminalType with all required attributes.
     */
    public IfcWasteTerminalType(IfcGloballyUniqueId globalId,IfcWasteTerminalTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcWasteTerminalType with required and optional attributes.
     */
    public IfcWasteTerminalType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcWasteTerminalTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcWasteTerminalTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcWasteTerminalTypeEnum value) { this.predefinedType = value; }

    
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
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}