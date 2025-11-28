package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcBendingParameterSelect = SELECT
 * (IfcLengthMeasure
 * ,IfcPlaneAngleMeasure);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbendingparameterselect.htm">IfcBendingParameterSelect</a>
 */
public interface IfcBendingParameterSelect extends Select, ConvertibleToStep {
}