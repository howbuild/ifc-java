package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcFillStyleSelect = SELECT
 * (IfcColour
 * ,IfcExternallyDefinedHatchStyle
 * ,IfcFillAreaStyleHatching
 * ,IfcFillAreaStyleTiles);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfillstyleselect.htm">IfcFillStyleSelect</a>
 */
public interface IfcFillStyleSelect extends Select, ConvertibleToStep {
}