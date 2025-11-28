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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantityarea.htm">IfcQuantityArea</a>
 */
public class IfcQuantityArea extends IfcPhysicalSimpleQuantity {
    protected IfcAreaMeasure areaValue;
    protected IfcLabel formula;

    protected IfcQuantityArea() { initCollections(); }
    /**
     * Constructs IfcQuantityArea with all required attributes.
     */
    public IfcQuantityArea(IfcLabel name,IfcAreaMeasure areaValue) {

        super(name);
        this.areaValue = areaValue;
    }
    /**
     * Constructs IfcQuantityArea with required and optional attributes.
     */
    public IfcQuantityArea(IfcLabel name,IfcText description,IfcNamedUnit unit,IfcAreaMeasure areaValue,IfcLabel formula) {
        super(name,description,unit);
        this.areaValue = areaValue;
        this.formula = formula;
    }
    private void initCollections() {
    }
    public IfcAreaMeasure getAreaValue() { return this.areaValue; }
    public void setAreaValue(IfcAreaMeasure value) { this.areaValue = value; }
    public IfcLabel getFormula() { return this.formula; }
    public void setFormula(IfcLabel value) { this.formula = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(areaValue != null ? StepUtils.toStepValue(areaValue) : "$");
		parameters.add(formula != null ? StepUtils.toStepValue(formula) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}