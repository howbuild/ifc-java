package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcBoxAlignment = IfcLabel;
 * WHERE
 * WR1 : SELF IN ['top-left', 'top-middle', 'top-right', 'middle-left', 'center', 'middle-right', 'bottom-left', 'bottom-middle', 'bottom-right'];
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboxalignment.htm">IfcBoxAlignment</a>
 */
public class IfcBoxAlignment extends BaseIfc implements SimpleType {
    protected IfcLabel value;

    public IfcLabel getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcLabel) value; }
    public IfcBoxAlignment(IfcLabel value){ this.value = value; }
    public IfcBoxAlignment() { }
    public void setValue(IfcLabel value){ this.value = value; }

    
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