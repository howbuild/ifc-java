package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSizeSelect = SELECT
 * (IfcDescriptiveMeasure
 * ,IfcLengthMeasure
 * ,IfcNormalisedRatioMeasure
 * ,IfcPositiveLengthMeasure
 * ,IfcPositiveRatioMeasure
 * ,IfcRatioMeasure);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsizeselect.htm">IfcSizeSelect</a>
 */
public interface IfcSizeSelect extends Select, ConvertibleToStep {
}