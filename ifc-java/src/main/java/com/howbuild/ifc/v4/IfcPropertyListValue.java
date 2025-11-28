package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyListValue
 * SUBTYPE OF (IfcSimpleProperty);
 * ListValues : OPTIONAL LIST [1:?] OF IfcValue;
 * Unit : OPTIONAL IfcUnit;
 * WHERE
 * WR31 : SIZEOF(QUERY(temp <* SELF.ListValues |
 * NOT(TYPEOF(SELF.ListValues[1]) = TYPEOF(temp))
 * )) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertylistvalue.htm">IfcPropertyListValue</a>
 */
public class IfcPropertyListValue extends IfcSimpleProperty {
    protected Collection<IfcValue> listValues;
    protected IfcUnit unit;

    protected IfcPropertyListValue() { initCollections(); }
    /**
     * Constructs IfcPropertyListValue with all required attributes.
     */
    public IfcPropertyListValue(IfcIdentifier name) {

        super(name);
        this.listValues = new ArrayList<>();
    }
    /**
     * Constructs IfcPropertyListValue with required and optional attributes.
     */
    public IfcPropertyListValue(IfcIdentifier name,IfcText description,Collection<IfcValue> listValues,IfcUnit unit) {
        super(name,description);
        this.listValues = listValues;
        this.unit = unit;
    }
    private void initCollections() {
        this.listValues = new ArrayList<>();
    }
    public Collection<IfcValue> getListValues() { return this.listValues; }
    public void setListValues(Collection<IfcValue> value) { this.listValues = value; } // optional
    public IfcUnit getUnit() { return this.unit; }
    public void setUnit(IfcUnit value) { this.unit = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(listValues != null ? StepUtils.toStepValue(listValues) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}