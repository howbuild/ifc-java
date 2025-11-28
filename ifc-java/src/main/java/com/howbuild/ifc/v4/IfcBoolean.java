package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcBoolean = BOOLEAN;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboolean.htm">IfcBoolean</a>
 */
public class IfcBoolean extends BaseIfc implements IfcModulusOfSubgradeReactionSelect, IfcModulusOfRotationalSubgradeReactionSelect, IfcWarpingStiffnessSelect, IfcRotationalStiffnessSelect, IfcModulusOfTranslationalSubgradeReactionSelect, IfcSimpleValue, IfcTranslationalStiffnessSelect, SimpleType {
    protected Boolean value;

    public Boolean getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Boolean) value; }
    public IfcBoolean(Boolean value){ this.value = value; }
    public IfcBoolean() { }
    public void setValue(Boolean value){ this.value = value; }

    
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