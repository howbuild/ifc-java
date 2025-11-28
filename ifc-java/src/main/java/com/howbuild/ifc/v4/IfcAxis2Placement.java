package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcAxis2Placement = SELECT
 * (IfcAxis2Placement2D
 * ,IfcAxis2Placement3D);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcaxis2placement.htm">IfcAxis2Placement</a>
 */
public interface IfcAxis2Placement extends Select, ConvertibleToStep {
}