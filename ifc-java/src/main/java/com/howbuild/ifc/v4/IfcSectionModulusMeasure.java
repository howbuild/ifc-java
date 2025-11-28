package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSectionModulusMeasure = REAL;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsectionmodulusmeasure.htm">IfcSectionModulusMeasure</a>
 */
public class IfcSectionModulusMeasure extends BaseIfc implements IfcDerivedMeasureValue, SimpleType {
    protected Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Double) value; }
    public IfcSectionModulusMeasure(Double value){ this.value = value; }
    public IfcSectionModulusMeasure() { }
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