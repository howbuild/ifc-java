package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcLineIndex = LIST [2:?] OF IfcPositiveInteger;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclineindex.htm">IfcLineIndex</a>
 */
public class IfcLineIndex extends BaseIfc implements IfcSegmentIndexSelect, SimpleType {
    protected Collection<IfcPositiveInteger> value;

    public Collection<IfcPositiveInteger> getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Collection<IfcPositiveInteger>) value; }
    public IfcLineIndex(Collection<IfcPositiveInteger> value){ this.value = value; }
    public IfcLineIndex() { }
    public void setValue(Collection<IfcPositiveInteger> value){ this.value = value; }

    
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