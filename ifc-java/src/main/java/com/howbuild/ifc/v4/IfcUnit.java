package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcUnit = SELECT
 * (IfcDerivedUnit
 * ,IfcMonetaryUnit
 * ,IfcNamedUnit);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcunit.htm">IfcUnit</a>
 */
public interface IfcUnit extends Select, ConvertibleToStep {
}