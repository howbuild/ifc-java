package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcFontWeight = STRING;
 * WHERE
 * WR1 : SELF IN ['normal','small-caps','100','200','300','400','500','600','700','800','900'];
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfontweight.htm">IfcFontWeight</a>
 */
public class IfcFontWeight extends BaseIfc implements SimpleType {
    protected String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (String) value; }
    public IfcFontWeight(String value){ this.value = value; }
    public IfcFontWeight() { }
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