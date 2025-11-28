package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcMoistureDiffusivityMeasure = REAL;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmoisturediffusivitymeasure.htm">IfcMoistureDiffusivityMeasure</a>
 */
public class IfcMoistureDiffusivityMeasure extends BaseIfc implements IfcDerivedMeasureValue, SimpleType {
    protected Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Double) value; }
    public IfcMoistureDiffusivityMeasure(Double value){ this.value = value; }
    public IfcMoistureDiffusivityMeasure() { }
    public void setValue(Double value){ this.value = value; }

    
    public String toString(){
        if (this.value == null) return "$";
        double d = ((Number) this.value).doubleValue();
        return Double.toString(d);
    }

    public String toStepValue(boolean isSelectOption){
        if(isSelectOption) {
            return getClass().getSimpleName().toUpperCase() + "(" + StepUtils.toStepValue(this.value, isSelectOption) + ")";
        } else {
            return StepUtils.toStepValue(this.value, isSelectOption);
        }
    }
    public void finalizeRelationships() { /* no inverse relations */ }
}