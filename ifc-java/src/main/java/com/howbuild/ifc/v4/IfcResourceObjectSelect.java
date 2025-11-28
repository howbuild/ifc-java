package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcResourceObjectSelect = SELECT
 * (IfcActorRole
 * ,IfcAppliedValue
 * ,IfcApproval
 * ,IfcConstraint
 * ,IfcContextDependentUnit
 * ,IfcConversionBasedUnit
 * ,IfcExternalInformation
 * ,IfcExternalReference
 * ,IfcMaterialDefinition
 * ,IfcOrganization
 * ,IfcPerson
 * ,IfcPersonAndOrganization
 * ,IfcPhysicalQuantity
 * ,IfcProfileDef
 * ,IfcPropertyAbstraction
 * ,IfcTimeSeries);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcresourceobjectselect.htm">IfcResourceObjectSelect</a>
 */
public interface IfcResourceObjectSelect extends Select, ConvertibleToStep {
}