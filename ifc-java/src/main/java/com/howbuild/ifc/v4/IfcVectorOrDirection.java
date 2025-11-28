package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcVectorOrDirection = SELECT
 * (IfcDirection
 * ,IfcVector);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvectorordirection.htm">IfcVectorOrDirection</a>
 */
public interface IfcVectorOrDirection extends Select, ConvertibleToStep {
}