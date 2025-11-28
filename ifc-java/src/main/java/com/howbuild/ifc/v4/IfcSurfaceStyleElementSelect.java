package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSurfaceStyleElementSelect = SELECT
 * (IfcExternallyDefinedSurfaceStyle
 * ,IfcSurfaceStyleLighting
 * ,IfcSurfaceStyleRefraction
 * ,IfcSurfaceStyleShading
 * ,IfcSurfaceStyleWithTextures);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestyleelementselect.htm">IfcSurfaceStyleElementSelect</a>
 */
public interface IfcSurfaceStyleElementSelect extends Select, ConvertibleToStep {
}