package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPointOrVertexPoint = SELECT
 * (IfcPoint
 * ,IfcVertexPoint);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpointorvertexpoint.htm">IfcPointOrVertexPoint</a>
 */
public interface IfcPointOrVertexPoint extends Select, ConvertibleToStep {
}