package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementComponent
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBuildingElementPart
 * ,IfcDiscreteAccessory
 * ,IfcFastener
 * ,IfcMechanicalFastener
 * ,IfcReinforcingElement
 * ,IfcVibrationIsolator))
 * SUBTYPE OF (IfcElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmechanicalfastener.htm">IfcMechanicalFastener</a>
 */
public class IfcMechanicalFastener extends IfcElementComponent {
    protected IfcPositiveLengthMeasure nominalDiameter;
    protected IfcPositiveLengthMeasure nominalLength;
    protected IfcMechanicalFastenerTypeEnum predefinedType;

    protected IfcMechanicalFastener() { initCollections(); }
    /**
     * Constructs IfcMechanicalFastener with all required attributes.
     */
    public IfcMechanicalFastener(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcMechanicalFastener with required and optional attributes.
     */
    public IfcMechanicalFastener(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcPositiveLengthMeasure nominalDiameter,IfcPositiveLengthMeasure nominalLength,IfcMechanicalFastenerTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.nominalDiameter = nominalDiameter;
        this.nominalLength = nominalLength;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getNominalDiameter() { return this.nominalDiameter; }
    public void setNominalDiameter(IfcPositiveLengthMeasure value) { this.nominalDiameter = value; } // optional
    public IfcPositiveLengthMeasure getNominalLength() { return this.nominalLength; }
    public void setNominalLength(IfcPositiveLengthMeasure value) { this.nominalLength = value; } // optional
    public IfcMechanicalFastenerTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcMechanicalFastenerTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(nominalDiameter != null ? StepUtils.toStepValue(nominalDiameter) : "$");
		parameters.add(nominalLength != null ? StepUtils.toStepValue(nominalLength) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}