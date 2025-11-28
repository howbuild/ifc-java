package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcMetricValueSelect = SELECT
 * (IfcAppliedValue
 * ,IfcMeasureWithUnit
 * ,IfcReference
 * ,IfcTable
 * ,IfcTimeSeries
 * ,IfcValue);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmetricvalueselect.htm">IfcMetricValueSelect</a>
 */
public interface IfcMetricValueSelect extends Select, ConvertibleToStep {
}