package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEnergyConversionDevice
 * SUPERTYPE OF (ONEOF
 * (IfcAirToAirHeatRecovery
 * ,IfcBoiler
 * ,IfcBurner
 * ,IfcChiller
 * ,IfcCoil
 * ,IfcCondenser
 * ,IfcCooledBeam
 * ,IfcCoolingTower
 * ,IfcElectricGenerator
 * ,IfcElectricMotor
 * ,IfcEngine
 * ,IfcEvaporativeCooler
 * ,IfcEvaporator
 * ,IfcHeatExchanger
 * ,IfcHumidifier
 * ,IfcMotorConnection
 * ,IfcSolarDevice
 * ,IfcTransformer
 * ,IfcTubeBundle
 * ,IfcUnitaryEquipment))
 * SUBTYPE OF (IfcDistributionFlowElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcengine.htm">IfcEngine</a>
 */
public class IfcEngine extends IfcEnergyConversionDevice {
    protected IfcEngineTypeEnum predefinedType;

    protected IfcEngine() { initCollections(); }
    /**
     * Constructs IfcEngine with all required attributes.
     */
    public IfcEngine(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcEngine with required and optional attributes.
     */
    public IfcEngine(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcEngineTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcEngineTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcEngineTypeEnum value) { this.predefinedType = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}