package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcColour = SELECT
 * (IfcColourSpecification
 * ,IfcPreDefinedColour);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccolour.htm">IfcColour</a>
 */
public interface IfcColour extends IfcFillStyleSelect, Select, ConvertibleToStep {
}