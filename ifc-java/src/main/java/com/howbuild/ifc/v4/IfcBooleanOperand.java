package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcBooleanOperand = SELECT
 * (IfcBooleanResult
 * ,IfcCsgPrimitive3D
 * ,IfcHalfSpaceSolid
 * ,IfcSolidModel
 * ,IfcTessellatedFaceSet);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbooleanoperand.htm">IfcBooleanOperand</a>
 */
public interface IfcBooleanOperand extends Select, ConvertibleToStep {
}