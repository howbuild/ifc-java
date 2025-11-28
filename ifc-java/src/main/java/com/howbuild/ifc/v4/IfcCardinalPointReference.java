package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcCardinalPointReference = INTEGER;
 * WHERE
 * GreaterThanZero : SELF > 0;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccardinalpointreference.htm">IfcCardinalPointReference</a>
 */
public class IfcCardinalPointReference extends BaseIfc implements SimpleType {
    protected Long value;

    public Long getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Long) value; }
    public IfcCardinalPointReference(Long value){ this.value = value; }
    public IfcCardinalPointReference() { }
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