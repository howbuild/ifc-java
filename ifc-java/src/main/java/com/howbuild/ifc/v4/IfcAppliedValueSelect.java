package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcAppliedValueSelect = SELECT
 * (IfcMeasureWithUnit
 * ,IfcReference
 * ,IfcValue);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcappliedvalueselect.htm">IfcAppliedValueSelect</a>
 */
public interface IfcAppliedValueSelect extends Select, ConvertibleToStep {
}