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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantitylength.htm">IfcQuantityLength</a>
 */
public class IfcQuantityLength extends IfcPhysicalSimpleQuantity {
    protected IfcLengthMeasure lengthValue;
    protected IfcLabel formula;

    protected IfcQuantityLength() { initCollections(); }
    /**
     * Constructs IfcQuantityLength with all required attributes.
     */
    public IfcQuantityLength(IfcLabel name,IfcLengthMeasure lengthValue) {

        super(name);
        this.lengthValue = lengthValue;
    }
    /**
     * Constructs IfcQuantityLength with required and optional attributes.
     */
    public IfcQuantityLength(IfcLabel name,IfcText description,IfcNamedUnit unit,IfcLengthMeasure lengthValue,IfcLabel formula) {
        super(name,description,unit);
        this.lengthValue = lengthValue;
        this.formula = formula;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getLengthValue() { return this.lengthValue; }
    public void setLengthValue(IfcLengthMeasure value) { this.lengthValue = value; }
    public IfcLabel getFormula() { return this.formula; }
    public void setFormula(IfcLabel value) { this.formula = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(lengthValue != null ? StepUtils.toStepValue(lengthValue) : "$");
		parameters.add(formula != null ? StepUtils.toStepValue(formula) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}