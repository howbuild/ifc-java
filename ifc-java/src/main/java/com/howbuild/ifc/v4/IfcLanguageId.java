package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcLanguageId = IfcIdentifier;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclanguageid.htm">IfcLanguageId</a>
 */
public class IfcLanguageId extends BaseIfc implements SimpleType {
    protected IfcIdentifier value;

    public IfcIdentifier getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (IfcIdentifier) value; }
    public IfcLanguageId(IfcIdentifier value){ this.value = value; }
    public IfcLanguageId() { }
    public void setValue(IfcIdentifier value){ this.value = value; }

    
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