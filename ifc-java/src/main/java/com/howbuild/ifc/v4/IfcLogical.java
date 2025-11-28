package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcLogical = LOGICAL;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclogical.htm">IfcLogical</a>
 */
public class IfcLogical extends BaseIfc implements IfcSimpleValue, SimpleType {
    protected IfcLogicalValue value;

    public IfcLogicalValue getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcLogicalValue) value; }
    public IfcLogical(IfcLogicalValue value){ this.value = value; }
    public IfcLogical() { }
    public void setValue(IfcLogicalValue value){ this.value = value; }

    
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