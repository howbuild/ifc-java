package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcModulusOfRotationalSubgradeReactionMeasure = REAL;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmodulusofrotationalsubgradereactionmeasure.htm">IfcModulusOfRotationalSubgradeReactionMeasure</a>
 */
public class IfcModulusOfRotationalSubgradeReactionMeasure extends BaseIfc implements IfcModulusOfRotationalSubgradeReactionSelect, IfcDerivedMeasureValue, SimpleType {
    protected Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Double) value; }
    public IfcModulusOfRotationalSubgradeReactionMeasure(Double value){ this.value = value; }
    public IfcModulusOfRotationalSubgradeReactionMeasure() { }
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