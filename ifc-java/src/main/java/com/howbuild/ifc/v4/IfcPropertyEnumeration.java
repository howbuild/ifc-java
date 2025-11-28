package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyAbstraction
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcExtendedProperties
 * ,IfcPreDefinedProperties
 * ,IfcProperty
 * ,IfcPropertyEnumeration));
 * INVERSE
 * HasExternalReferences : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertyenumeration.htm">IfcPropertyEnumeration</a>
 */
public class IfcPropertyEnumeration extends IfcPropertyAbstraction {
    protected IfcLabel name;
    protected Collection<IfcValue> enumerationValues;
    protected IfcUnit unit;

    protected IfcPropertyEnumeration() { initCollections(); }
    /**
     * Constructs IfcPropertyEnumeration with all required attributes.
     */
    public IfcPropertyEnumeration(IfcLabel name,Collection<IfcValue> enumerationValues) {

        super();
        this.name = name;
        this.enumerationValues = enumerationValues;
    }
    /**
     * Constructs IfcPropertyEnumeration with required and optional attributes.
     */
    public IfcPropertyEnumeration(IfcLabel name,Collection<IfcValue> enumerationValues,IfcUnit unit) {
        super();
        this.name = name;
        this.enumerationValues = enumerationValues;
        this.unit = unit;
    }
    private void initCollections() {
        this.enumerationValues = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public Collection<IfcValue> getEnumerationValues() { return this.enumerationValues; }
    public void setEnumerationValues(Collection<IfcValue> value) { this.enumerationValues = value; }
    public IfcUnit getUnit() { return this.unit; }
    public void setUnit(IfcUnit value) { this.unit = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(enumerationValues != null ? StepUtils.toStepValue(enumerationValues) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}