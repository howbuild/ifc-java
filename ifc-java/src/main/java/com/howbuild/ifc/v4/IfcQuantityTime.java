package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPhysicalSimpleQuantity
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcQuantityArea
 * ,IfcQuantityCount
 * ,IfcQuantityLength
 * ,IfcQuantityTime
 * ,IfcQuantityVolume
 * ,IfcQuantityWeight))
 * SUBTYPE OF (IfcPhysicalQuantity);
 * Unit : OPTIONAL IfcNamedUnit;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantitytime.htm">IfcQuantityTime</a>
 */
public class IfcQuantityTime extends IfcPhysicalSimpleQuantity {
    protected IfcTimeMeasure timeValue;
    protected IfcLabel formula;

    protected IfcQuantityTime() { initCollections(); }
    /**
     * Constructs IfcQuantityTime with all required attributes.
     */
    public IfcQuantityTime(IfcLabel name,IfcTimeMeasure timeValue) {

        super(name);
        this.timeValue = timeValue;
    }
    /**
     * Constructs IfcQuantityTime with required and optional attributes.
     */
    public IfcQuantityTime(IfcLabel name,IfcText description,IfcNamedUnit unit,IfcTimeMeasure timeValue,IfcLabel formula) {
        super(name,description,unit);
        this.timeValue = timeValue;
        this.formula = formula;
    }
    private void initCollections() {
    }
    public IfcTimeMeasure getTimeValue() { return this.timeValue; }
    public void setTimeValue(IfcTimeMeasure value) { this.timeValue = value; }
    public IfcLabel getFormula() { return this.formula; }
    public void setFormula(IfcLabel value) { this.formula = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(timeValue != null ? StepUtils.toStepValue(timeValue) : "$");
		parameters.add(formula != null ? StepUtils.toStepValue(formula) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}