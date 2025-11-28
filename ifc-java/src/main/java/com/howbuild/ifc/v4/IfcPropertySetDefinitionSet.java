package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcPropertySetDefinitionSet = SET [1:?] OF IfcPropertySetDefinition;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertysetdefinitionset.htm">IfcPropertySetDefinitionSet</a>
 */
public class IfcPropertySetDefinitionSet extends BaseIfc implements IfcPropertySetDefinitionSelect, SimpleType {
    protected Collection<IfcPropertySetDefinition> value;

    public Collection<IfcPropertySetDefinition> getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Collection<IfcPropertySetDefinition>) value; }
    public IfcPropertySetDefinitionSet(Collection<IfcPropertySetDefinition> value){ this.value = value; }
    public IfcPropertySetDefinitionSet() { }
    public void setValue(Collection<IfcPropertySetDefinition> value){ this.value = value; }

    
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