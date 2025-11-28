package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementComponentType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBuildingElementPartType
 * ,IfcDiscreteAccessoryType
 * ,IfcFastenerType
 * ,IfcMechanicalFastenerType
 * ,IfcReinforcingElementType
 * ,IfcVibrationIsolatorType))
 * SUBTYPE OF (IfcElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmechanicalfastenertype.htm">IfcMechanicalFastenerType</a>
 */
public class IfcMechanicalFastenerType extends IfcElementComponentType {
    protected IfcMechanicalFastenerTypeEnum predefinedType;
    protected IfcPositiveLengthMeasure nominalDiameter;
    protected IfcPositiveLengthMeasure nominalLength;

    protected IfcMechanicalFastenerType() { initCollections(); }
    /**
     * Constructs IfcMechanicalFastenerType with all required attributes.
     */
    public IfcMechanicalFastenerType(IfcGloballyUniqueId globalId,IfcMechanicalFastenerTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcMechanicalFastenerType with required and optional attributes.
     */
    public IfcMechanicalFastenerType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcMechanicalFastenerTypeEnum predefinedType,IfcPositiveLengthMeasure nominalDiameter,IfcPositiveLengthMeasure nominalLength) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.nominalDiameter = nominalDiameter;
        this.nominalLength = nominalLength;
    }
    private void initCollections() {
    }
    public IfcMechanicalFastenerTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcMechanicalFastenerTypeEnum value) { this.predefinedType = value; }
    public IfcPositiveLengthMeasure getNominalDiameter() { return this.nominalDiameter; }
    public void setNominalDiameter(IfcPositiveLengthMeasure value) { this.nominalDiameter = value; } // optional
    public IfcPositiveLengthMeasure getNominalLength() { return this.nominalLength; }
    public void setNominalLength(IfcPositiveLengthMeasure value) { this.nominalLength = value; } // optional

    
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
		parameters.add(nominalLength != null ? StepUtils.toStepValue(nominalLength) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}