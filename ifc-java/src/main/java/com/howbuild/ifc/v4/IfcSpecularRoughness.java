package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSpecularRoughness = REAL;
 * WHERE
 * WR1 : {0.0 <= SELF <= 1.0};
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspecularroughness.htm">IfcSpecularRoughness</a>
 */
public class IfcSpecularRoughness extends BaseIfc implements IfcSpecularHighlightSelect, SimpleType {
    protected Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Double) value; }
    public IfcSpecularRoughness(Double value){ this.value = value; }
    public IfcSpecularRoughness() { }
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