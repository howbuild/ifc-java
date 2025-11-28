package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcVolumeMeasure = REAL;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvolumemeasure.htm">IfcVolumeMeasure</a>
 */
public class IfcVolumeMeasure extends BaseIfc implements IfcMeasureValue, SimpleType {
    protected Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Double) value; }
    public IfcVolumeMeasure(Double value){ this.value = value; }
    public IfcVolumeMeasure() { }
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