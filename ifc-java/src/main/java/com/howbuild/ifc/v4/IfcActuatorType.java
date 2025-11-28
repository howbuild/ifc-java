package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActuatorType
 * SUBTYPE OF (IfcDistributionControlElementType);
 * PredefinedType : IfcActuatorTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcActuatorTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcActuatorTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcactuatortype.htm">IfcActuatorType</a>
 */
public class IfcActuatorType extends IfcDistributionControlElementType {
    protected IfcActuatorTypeEnum predefinedType;

    protected IfcActuatorType() { initCollections(); }
    /**
     * Constructs IfcActuatorType with all required attributes.
     */
    public IfcActuatorType(IfcGloballyUniqueId globalId,IfcActuatorTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcActuatorType with required and optional attributes.
     */
    public IfcActuatorType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcActuatorTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcActuatorTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcActuatorTypeEnum value) { this.predefinedType = value; }

    
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