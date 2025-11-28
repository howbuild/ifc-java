package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSpaceBoundarySelect = SELECT
 * (IfcExternalSpatialElement
 * ,IfcSpace);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspaceboundaryselect.htm">IfcSpaceBoundarySelect</a>
 */
public interface IfcSpaceBoundarySelect extends Select, ConvertibleToStep {
}