package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPresentationStyleSelect = SELECT
 * (IfcCurveStyle
 * ,IfcFillAreaStyle
 * ,IfcNullStyle
 * ,IfcSurfaceStyle
 * ,IfcTextStyle);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpresentationstyleselect.htm">IfcPresentationStyleSelect</a>
 */
public interface IfcPresentationStyleSelect extends Select, ConvertibleToStep {
}