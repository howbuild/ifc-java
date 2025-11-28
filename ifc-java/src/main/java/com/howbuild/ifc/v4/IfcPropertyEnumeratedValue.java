package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyEnumeratedValue
 * SUBTYPE OF (IfcSimpleProperty);
 * EnumerationValues : OPTIONAL LIST [1:?] OF IfcValue;
 * EnumerationReference : OPTIONAL IfcPropertyEnumeration;
 * WHERE
 * WR21 : NOT(EXISTS(EnumerationReference))
 * OR  NOT(EXISTS(EnumerationValues))
 * OR  (SIZEOF(QUERY(temp <* EnumerationValues |
 * temp IN EnumerationReference.EnumerationValues))
 * = SIZEOF(EnumerationValues));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertyenumeratedvalue.htm">IfcPropertyEnumeratedValue</a>
 */
public class IfcPropertyEnumeratedValue extends IfcSimpleProperty {
    protected Collection<IfcValue> enumerationValues;
    protected IfcPropertyEnumeration enumerationReference;

    protected IfcPropertyEnumeratedValue() { initCollections(); }
    /**
     * Constructs IfcPropertyEnumeratedValue with all required attributes.
     */
    public IfcPropertyEnumeratedValue(IfcIdentifier name) {

        super(name);
        this.enumerationValues = new ArrayList<>();
    }
    /**
     * Constructs IfcPropertyEnumeratedValue with required and optional attributes.
     */
    public IfcPropertyEnumeratedValue(IfcIdentifier name,IfcText description,Collection<IfcValue> enumerationValues,IfcPropertyEnumeration enumerationReference) {
        super(name,description);
        this.enumerationValues = enumerationValues;
        this.enumerationReference = enumerationReference;
    }
    private void initCollections() {
        this.enumerationValues = new ArrayList<>();
    }
    public Collection<IfcValue> getEnumerationValues() { return this.enumerationValues; }
    public void setEnumerationValues(Collection<IfcValue> value) { this.enumerationValues = value; } // optional
    public IfcPropertyEnumeration getEnumerationReference() { return this.enumerationReference; }
    public void setEnumerationReference(IfcPropertyEnumeration value) { this.enumerationReference = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(enumerationValues != null ? StepUtils.toStepValue(enumerationValues) : "$");
		parameters.add(enumerationReference != null ? StepUtils.toStepValue(enumerationReference) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}