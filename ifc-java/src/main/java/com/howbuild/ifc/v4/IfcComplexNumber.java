package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcComplexNumber = ARRAY [1:2] OF REAL;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccomplexnumber.htm">IfcComplexNumber</a>
 */
public class IfcComplexNumber extends BaseIfc implements IfcMeasureValue, SimpleType {
    protected Collection<Double> value;

    public Collection<Double> getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Collection<Double>) value; }
    public IfcComplexNumber(Collection<Double> value){ this.value = value; }
    public IfcComplexNumber() { }
    public void setValue(Collection<Double> value){ this.value = value; }

    
    public String toString(){
        return String.valueOf(this.value);
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