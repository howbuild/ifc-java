package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPositiveRatioMeasure = IfcRatioMeasure;
 * WHERE
 * WR1 : SELF > 0.;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpositiveratiomeasure.htm">IfcPositiveRatioMeasure</a>
 */
public class IfcPositiveRatioMeasure extends BaseIfc implements IfcMeasureValue, IfcSizeSelect, SimpleType {
    protected IfcRatioMeasure value;

    public IfcRatioMeasure getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcRatioMeasure) value; }
    public IfcPositiveRatioMeasure(IfcRatioMeasure value){ this.value = value; }
    public IfcPositiveRatioMeasure() { }
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