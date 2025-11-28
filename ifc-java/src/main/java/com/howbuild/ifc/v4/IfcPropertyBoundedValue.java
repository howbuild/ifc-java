package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyBoundedValue
 * SUBTYPE OF (IfcSimpleProperty);
 * UpperBoundValue : OPTIONAL IfcValue;
 * LowerBoundValue : OPTIONAL IfcValue;
 * Unit : OPTIONAL IfcUnit;
 * SetPointValue : OPTIONAL IfcValue;
 * WHERE
 * SameUnitUpperLower : NOT(EXISTS(UpperBoundValue)) OR NOT(EXISTS(LowerBoundValue)) OR
 * (TYPEOF(UpperBoundValue) = TYPEOF(LowerBoundValue));
 * SameUnitUpperSet : NOT(EXISTS(UpperBoundValue)) OR NOT(EXISTS(SetPointValue)) OR
 * (TYPEOF(UpperBoundValue) = TYPEOF(SetPointValue));
 * SameUnitLowerSet : NOT(EXISTS(LowerBoundValue)) OR NOT(EXISTS(SetPointValue)) OR
 * (TYPEOF(LowerBoundValue) = TYPEOF(SetPointValue));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertyboundedvalue.htm">IfcPropertyBoundedValue</a>
 */
public class IfcPropertyBoundedValue extends IfcSimpleProperty {
    protected IfcValue upperBoundValue;
    protected IfcValue lowerBoundValue;
    protected IfcUnit unit;
    protected IfcValue setPointValue;

    protected IfcPropertyBoundedValue() { initCollections(); }
    /**
     * Constructs IfcPropertyBoundedValue with all required attributes.
     */
    public IfcPropertyBoundedValue(IfcIdentifier name) {

        super(name);
    }
    /**
     * Constructs IfcPropertyBoundedValue with required and optional attributes.
     */
    public IfcPropertyBoundedValue(IfcIdentifier name,IfcText description,IfcValue upperBoundValue,IfcValue lowerBoundValue,IfcUnit unit,IfcValue setPointValue) {
        super(name,description);
        this.upperBoundValue = upperBoundValue;
        this.lowerBoundValue = lowerBoundValue;
        this.unit = unit;
        this.setPointValue = setPointValue;
    }
    private void initCollections() {
    }
    public IfcValue getUpperBoundValue() { return this.upperBoundValue; }
    public void setUpperBoundValue(IfcValue value) { this.upperBoundValue = value; } // optional
    public IfcValue getLowerBoundValue() { return this.lowerBoundValue; }
    public void setLowerBoundValue(IfcValue value) { this.lowerBoundValue = value; } // optional
    public IfcUnit getUnit() { return this.unit; }
    public void setUnit(IfcUnit value) { this.unit = value; } // optional
    public IfcValue getSetPointValue() { return this.setPointValue; }
    public void setSetPointValue(IfcValue value) { this.setPointValue = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(upperBoundValue != null ? StepUtils.toStepValue(upperBoundValue) : "$");
		parameters.add(lowerBoundValue != null ? StepUtils.toStepValue(lowerBoundValue) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(setPointValue != null ? StepUtils.toStepValue(setPointValue) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}