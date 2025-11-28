package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcClassificationSelect = SELECT
 * (IfcClassification
 * ,IfcClassificationReference);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcclassificationselect.htm">IfcClassificationSelect</a>
 */
public interface IfcClassificationSelect extends Select, ConvertibleToStep {
}