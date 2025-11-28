package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcCoordinateReferenceSystemSelect = SELECT
 * (IfcCoordinateReferenceSystem
 * ,IfcGeometricRepresentationContext);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccoordinatereferencesystemselect.htm">IfcCoordinateReferenceSystemSelect</a>
 */
public interface IfcCoordinateReferenceSystemSelect extends Select, ConvertibleToStep {
}