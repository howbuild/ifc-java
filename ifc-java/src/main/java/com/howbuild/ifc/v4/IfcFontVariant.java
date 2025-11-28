package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcFontVariant = STRING;
 * WHERE
 * WR1 : SELF IN ['normal','small-caps'];
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfontvariant.htm">IfcFontVariant</a>
 */
public class IfcFontVariant extends BaseIfc implements SimpleType {
    protected String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (String) value; }
    public IfcFontVariant(String value){ this.value = value; }
    public IfcFontVariant() { }
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