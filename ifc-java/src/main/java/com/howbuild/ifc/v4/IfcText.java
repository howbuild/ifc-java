package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcText = STRING;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctext.htm">IfcText</a>
 */
public class IfcText extends BaseIfc implements IfcSimpleValue, SimpleType {
    protected String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (String) value; }
    public IfcText(String value){ this.value = value; }
    public IfcText() { }
    public void setValue(String value){ this.value = value; }

    
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