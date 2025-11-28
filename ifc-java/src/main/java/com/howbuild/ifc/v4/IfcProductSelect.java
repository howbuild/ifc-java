package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcProductSelect = SELECT
 * (IfcProduct
 * ,IfcTypeProduct);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproductselect.htm">IfcProductSelect</a>
 */
public interface IfcProductSelect extends Select, ConvertibleToStep {
}