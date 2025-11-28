package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPositivePlaneAngleMeasure = IfcPlaneAngleMeasure;
 * WHERE
 * WR1 : SELF > 0.;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpositiveplaneanglemeasure.htm">IfcPositivePlaneAngleMeasure</a>
 */
public class IfcPositivePlaneAngleMeasure extends BaseIfc implements IfcMeasureValue, SimpleType {
    protected IfcPlaneAngleMeasure value;

    public IfcPlaneAngleMeasure getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcPlaneAngleMeasure) value; }
    public IfcPositivePlaneAngleMeasure(IfcPlaneAngleMeasure value){ this.value = value; }
    public IfcPositivePlaneAngleMeasure() { }
    public void setValue(IfcPlaneAngleMeasure value){ this.value = value; }

    
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