package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSimpleValue = SELECT
 * (IfcBinary
 * ,IfcBoolean
 * ,IfcDate
 * ,IfcDateTime
 * ,IfcDuration
 * ,IfcIdentifier
 * ,IfcInteger
 * ,IfcLabel
 * ,IfcLogical
 * ,IfcPositiveInteger
 * ,IfcReal
 * ,IfcText
 * ,IfcTime
 * ,IfcTimeStamp);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsimplevalue.htm">IfcSimpleValue</a>
 */
public interface IfcSimpleValue extends IfcValue, Select, ConvertibleToStep {
}