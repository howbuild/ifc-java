package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertySingleValue
 * SUBTYPE OF (IfcSimpleProperty);
 * NominalValue : OPTIONAL IfcValue;
 * Unit : OPTIONAL IfcUnit;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertysinglevalue.htm">IfcPropertySingleValue</a>
 */
public class IfcPropertySingleValue extends IfcSimpleProperty {
    protected IfcValue nominalValue;
    protected IfcUnit unit;

    protected IfcPropertySingleValue() { initCollections(); }
    /**
     * Constructs IfcPropertySingleValue with all required attributes.
     */
    public IfcPropertySingleValue(IfcIdentifier name) {

        super(name);
    }
    /**
     * Constructs IfcPropertySingleValue with required and optional attributes.
     */
    public IfcPropertySingleValue(IfcIdentifier name,IfcText description,IfcValue nominalValue,IfcUnit unit) {
        super(name,description);
        this.nominalValue = nominalValue;
        this.unit = unit;
    }
    private void initCollections() {
    }
    public IfcValue getNominalValue() { return this.nominalValue; }
    public void setNominalValue(IfcValue value) { this.nominalValue = value; } // optional
    public IfcUnit getUnit() { return this.unit; }
    public void setUnit(IfcUnit value) { this.unit = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(nominalValue != null ? StepUtils.toStepValue(nominalValue) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}