package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcInteger = INTEGER;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcinteger.htm">IfcInteger</a>
 */
public class IfcInteger extends BaseIfc implements IfcSimpleValue, SimpleType {
    protected Long value;

    public Long getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Long) value; }
    public IfcInteger(Long value){ this.value = value; }
    public IfcInteger() { }
    public void setValue(Long value){ this.value = value; }

    
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