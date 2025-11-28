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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantityweight.htm">IfcQuantityWeight</a>
 */
public class IfcQuantityWeight extends IfcPhysicalSimpleQuantity {
    protected IfcMassMeasure weightValue;
    protected IfcLabel formula;

    protected IfcQuantityWeight() { initCollections(); }
    /**
     * Constructs IfcQuantityWeight with all required attributes.
     */
    public IfcQuantityWeight(IfcLabel name,IfcMassMeasure weightValue) {

        super(name);
        this.weightValue = weightValue;
    }
    /**
     * Constructs IfcQuantityWeight with required and optional attributes.
     */
    public IfcQuantityWeight(IfcLabel name,IfcText description,IfcNamedUnit unit,IfcMassMeasure weightValue,IfcLabel formula) {
        super(name,description,unit);
        this.weightValue = weightValue;
        this.formula = formula;
    }
    private void initCollections() {
    }
    public IfcMassMeasure getWeightValue() { return this.weightValue; }
    public void setWeightValue(IfcMassMeasure value) { this.weightValue = value; }
    public IfcLabel getFormula() { return this.formula; }
    public void setFormula(IfcLabel value) { this.formula = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(weightValue != null ? StepUtils.toStepValue(weightValue) : "$");
		parameters.add(formula != null ? StepUtils.toStepValue(formula) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}