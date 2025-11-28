package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPositiveLengthMeasure = IfcLengthMeasure;
 * WHERE
 * WR1 : SELF > 0.;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpositivelengthmeasure.htm">IfcPositiveLengthMeasure</a>
 */
public class IfcPositiveLengthMeasure extends BaseIfc implements IfcMeasureValue, IfcSizeSelect, IfcHatchLineDistanceSelect, SimpleType {
    protected IfcLengthMeasure value;

    public IfcLengthMeasure getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcLengthMeasure) value; }
    public IfcPositiveLengthMeasure(IfcLengthMeasure value){ this.value = value; }
    public IfcPositiveLengthMeasure() { }
    public void setValue(IfcLengthMeasure value){ this.value = value; }

    
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