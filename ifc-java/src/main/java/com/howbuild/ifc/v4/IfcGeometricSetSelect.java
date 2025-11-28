package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcGeometricSetSelect = SELECT
 * (IfcCurve
 * ,IfcPoint
 * ,IfcSurface);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgeometricsetselect.htm">IfcGeometricSetSelect</a>
 */
public interface IfcGeometricSetSelect extends Select, ConvertibleToStep {
}