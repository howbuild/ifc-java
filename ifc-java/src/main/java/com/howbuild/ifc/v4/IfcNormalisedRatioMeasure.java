package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcNormalisedRatioMeasure = IfcRatioMeasure;
 * WHERE
 * WR1 : {0.0 <= SELF <= 1.0};
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcnormalisedratiomeasure.htm">IfcNormalisedRatioMeasure</a>
 */
public class IfcNormalisedRatioMeasure extends BaseIfc implements IfcColourOrFactor, IfcMeasureValue, IfcSizeSelect, SimpleType {
    protected IfcRatioMeasure value;

    public IfcRatioMeasure getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcRatioMeasure) value; }
    public IfcNormalisedRatioMeasure(IfcRatioMeasure value){ this.value = value; }
    public IfcNormalisedRatioMeasure() { }
    public void setValue(IfcRatioMeasure value){ this.value = value; }

    
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