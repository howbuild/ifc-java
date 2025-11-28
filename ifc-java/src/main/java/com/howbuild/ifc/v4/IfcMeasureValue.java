package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcMeasureValue = SELECT
 * (IfcAmountOfSubstanceMeasure
 * ,IfcAreaMeasure
 * ,IfcComplexNumber
 * ,IfcContextDependentMeasure
 * ,IfcCountMeasure
 * ,IfcDescriptiveMeasure
 * ,IfcElectricCurrentMeasure
 * ,IfcLengthMeasure
 * ,IfcLuminousIntensityMeasure
 * ,IfcMassMeasure
 * ,IfcNonNegativeLengthMeasure
 * ,IfcNormalisedRatioMeasure
 * ,IfcNumericMeasure
 * ,IfcParameterValue
 * ,IfcPlaneAngleMeasure
 * ,IfcPositiveLengthMeasure
 * ,IfcPositivePlaneAngleMeasure
 * ,IfcPositiveRatioMeasure
 * ,IfcRatioMeasure
 * ,IfcSolidAngleMeasure
 * ,IfcThermodynamicTemperatureMeasure
 * ,IfcTimeMeasure
 * ,IfcVolumeMeasure);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmeasurevalue.htm">IfcMeasureValue</a>
 */
public interface IfcMeasureValue extends IfcValue, Select, ConvertibleToStep {
}