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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdoortype.htm">IfcDoorType</a>
 */
public class IfcDoorType extends IfcBuildingElementType {
    protected IfcDoorTypeEnum predefinedType;
    protected IfcDoorTypeOperationEnum operationType;
    protected IfcBoolean parameterTakesPrecedence;
    protected IfcLabel userDefinedOperationType;

    protected IfcDoorType() { initCollections(); }
    /**
     * Constructs IfcDoorType with all required attributes.
     */
    public IfcDoorType(IfcGloballyUniqueId globalId,IfcDoorTypeEnum predefinedType,IfcDoorTypeOperationEnum operationType) {

        super(globalId);
        this.predefinedType = predefinedType;
        this.operationType = operationType;
    }
    /**
     * Constructs IfcDoorType with required and optional attributes.
     */
    public IfcDoorType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcDoorTypeEnum predefinedType,IfcDoorTypeOperationEnum operationType,IfcBoolean parameterTakesPrecedence,IfcLabel userDefinedOperationType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.operationType = operationType;
        this.parameterTakesPrecedence = parameterTakesPrecedence;
        this.userDefinedOperationType = userDefinedOperationType;
    }
    private void initCollections() {
    }
    public IfcDoorTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcDoorTypeEnum value) { this.predefinedType = value; }
    public IfcDoorTypeOperationEnum getOperationType() { return this.operationType; }
    public void setOperationType(IfcDoorTypeOperationEnum value) { this.operationType = value; }
    public IfcBoolean getParameterTakesPrecedence() { return this.parameterTakesPrecedence; }
    public void setParameterTakesPrecedence(IfcBoolean value) { this.parameterTakesPrecedence = value; } // optional
    public IfcLabel getUserDefinedOperationType() { return this.userDefinedOperationType; }
    public void setUserDefinedOperationType(IfcLabel value) { this.userDefinedOperationType = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(operationType));
		parameters.add(parameterTakesPrecedence != null ? StepUtils.toStepValue(parameterTakesPrecedence) : "$");
		parameters.add(userDefinedOperationType != null ? StepUtils.toStepValue(userDefinedOperationType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}