package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcObjectReferenceSelect = SELECT
 * (IfcAddress
 * ,IfcAppliedValue
 * ,IfcExternalReference
 * ,IfcMaterialDefinition
 * ,IfcOrganization
 * ,IfcPerson
 * ,IfcPersonAndOrganization
 * ,IfcTable
 * ,IfcTimeSeries);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcobjectreferenceselect.htm">IfcObjectReferenceSelect</a>
 */
public interface IfcObjectReferenceSelect extends Select, ConvertibleToStep {
}