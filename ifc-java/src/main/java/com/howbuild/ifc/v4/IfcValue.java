package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcValue = SELECT
 * (IfcDerivedMeasureValue
 * ,IfcMeasureValue
 * ,IfcSimpleValue);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvalue.htm">IfcValue</a>
 */
public interface IfcValue extends IfcAppliedValueSelect, IfcMetricValueSelect, Select, ConvertibleToStep {
}