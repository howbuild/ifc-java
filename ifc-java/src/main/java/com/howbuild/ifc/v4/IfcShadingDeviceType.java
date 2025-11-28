package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBeamType
 * ,IfcBuildingElementProxyType
 * ,IfcChimneyType
 * ,IfcColumnType
 * ,IfcCoveringType
 * ,IfcCurtainWallType
 * ,IfcDoorType
 * ,IfcFootingType
 * ,IfcMemberType
 * ,IfcPileType
 * ,IfcPlateType
 * ,IfcRailingType
 * ,IfcRampFlightType
 * ,IfcRampType
 * ,IfcRoofType
 * ,IfcShadingDeviceType
 * ,IfcSlabType
 * ,IfcStairFlightType
 * ,IfcStairType
 * ,IfcWallType
 * ,IfcWindowType))
 * SUBTYPE OF (IfcElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcshadingdevicetype.htm">IfcShadingDeviceType</a>
 */
public class IfcShadingDeviceType extends IfcBuildingElementType {
    protected IfcShadingDeviceTypeEnum predefinedType;

    protected IfcShadingDeviceType() { initCollections(); }
    /**
     * Constructs IfcShadingDeviceType with all required attributes.
     */
    public IfcShadingDeviceType(IfcGloballyUniqueId globalId,IfcShadingDeviceTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcShadingDeviceType with required and optional attributes.
     */
    public IfcShadingDeviceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcShadingDeviceTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcShadingDeviceTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcShadingDeviceTypeEnum value) { this.predefinedType = value; }

    
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