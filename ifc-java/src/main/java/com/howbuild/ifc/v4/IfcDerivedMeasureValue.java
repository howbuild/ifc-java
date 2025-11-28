package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcDerivedMeasureValue = SELECT
 * (IfcAbsorbedDoseMeasure
 * ,IfcAccelerationMeasure
 * ,IfcAngularVelocityMeasure
 * ,IfcAreaDensityMeasure
 * ,IfcCompoundPlaneAngleMeasure
 * ,IfcCurvatureMeasure
 * ,IfcDoseEquivalentMeasure
 * ,IfcDynamicViscosityMeasure
 * ,IfcElectricCapacitanceMeasure
 * ,IfcElectricChargeMeasure
 * ,IfcElectricConductanceMeasure
 * ,IfcElectricResistanceMeasure
 * ,IfcElectricVoltageMeasure
 * ,IfcEnergyMeasure
 * ,IfcForceMeasure
 * ,IfcFrequencyMeasure
 * ,IfcHeatFluxDensityMeasure
 * ,IfcHeatingValueMeasure
 * ,IfcIlluminanceMeasure
 * ,IfcInductanceMeasure
 * ,IfcIntegerCountRateMeasure
 * ,IfcIonConcentrationMeasure
 * ,IfcIsothermalMoistureCapacityMeasure
 * ,IfcKinematicViscosityMeasure
 * ,IfcLinearForceMeasure
 * ,IfcLinearMomentMeasure
 * ,IfcLinearStiffnessMeasure
 * ,IfcLinearVelocityMeasure
 * ,IfcLuminousFluxMeasure
 * ,IfcLuminousIntensityDistributionMeasure
 * ,IfcMagneticFluxDensityMeasure
 * ,IfcMagneticFluxMeasure
 * ,IfcMassDensityMeasure
 * ,IfcMassFlowRateMeasure
 * ,IfcMassPerLengthMeasure
 * ,IfcModulusOfElasticityMeasure
 * ,IfcModulusOfLinearSubgradeReactionMeasure
 * ,IfcModulusOfRotationalSubgradeReactionMeasure
 * ,IfcModulusOfSubgradeReactionMeasure
 * ,IfcMoistureDiffusivityMeasure
 * ,IfcMolecularWeightMeasure
 * ,IfcMomentOfInertiaMeasure
 * ,IfcMonetaryMeasure
 * ,IfcPHMeasure
 * ,IfcPlanarForceMeasure
 * ,IfcPowerMeasure
 * ,IfcPressureMeasure
 * ,IfcRadioActivityMeasure
 * ,IfcRotationalFrequencyMeasure
 * ,IfcRotationalMassMeasure
 * ,IfcRotationalStiffnessMeasure
 * ,IfcSectionModulusMeasure
 * ,IfcSectionalAreaIntegralMeasure
 * ,IfcShearModulusMeasure
 * ,IfcSoundPowerLevelMeasure
 * ,IfcSoundPowerMeasure
 * ,IfcSoundPressureLevelMeasure
 * ,IfcSoundPressureMeasure
 * ,IfcSpecificHeatCapacityMeasure
 * ,IfcTemperatureGradientMeasure
 * ,IfcTemperatureRateOfChangeMeasure
 * ,IfcThermalAdmittanceMeasure
 * ,IfcThermalConductivityMeasure
 * ,IfcThermalExpansionCoefficientMeasure
 * ,IfcThermalResistanceMeasure
 * ,IfcThermalTransmittanceMeasure
 * ,IfcTorqueMeasure
 * ,IfcVaporPermeabilityMeasure
 * ,IfcVolumetricFlowRateMeasure
 * ,IfcWarpingConstantMeasure
 * ,IfcWarpingMomentMeasure);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcderivedmeasurevalue.htm">IfcDerivedMeasureValue</a>
 */
public interface IfcDerivedMeasureValue extends IfcValue, Select, ConvertibleToStep {
}