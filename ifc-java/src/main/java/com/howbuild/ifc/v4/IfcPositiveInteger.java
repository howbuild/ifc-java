package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPositiveInteger = IfcInteger;
 * WHERE
 * WR1 : SELF > 0;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpositiveinteger.htm">IfcPositiveInteger</a>
 */
public class IfcPositiveInteger extends BaseIfc implements IfcSimpleValue, SimpleType {
    protected IfcInteger value;

    public IfcInteger getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcInteger) value; }
    public IfcPositiveInteger(IfcInteger value){ this.value = value; }
    public IfcPositiveInteger() { }
    public void setValue(IfcInteger value){ this.value = value; }

    
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