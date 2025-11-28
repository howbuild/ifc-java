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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantitycount.htm">IfcQuantityCount</a>
 */
public class IfcQuantityCount extends IfcPhysicalSimpleQuantity {
    protected IfcCountMeasure countValue;
    protected IfcLabel formula;

    protected IfcQuantityCount() { initCollections(); }
    /**
     * Constructs IfcQuantityCount with all required attributes.
     */
    public IfcQuantityCount(IfcLabel name,IfcCountMeasure countValue) {

        super(name);
        this.countValue = countValue;
    }
    /**
     * Constructs IfcQuantityCount with required and optional attributes.
     */
    public IfcQuantityCount(IfcLabel name,IfcText description,IfcNamedUnit unit,IfcCountMeasure countValue,IfcLabel formula) {
        super(name,description,unit);
        this.countValue = countValue;
        this.formula = formula;
    }
    private void initCollections() {
    }
    public IfcCountMeasure getCountValue() { return this.countValue; }
    public void setCountValue(IfcCountMeasure value) { this.countValue = value; }
    public IfcLabel getFormula() { return this.formula; }
    public void setFormula(IfcLabel value) { this.formula = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(countValue != null ? StepUtils.toStepValue(countValue) : "$");
		parameters.add(formula != null ? StepUtils.toStepValue(formula) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}