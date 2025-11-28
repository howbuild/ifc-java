package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcBinary = BINARY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbinary.htm">IfcBinary</a>
 */
public class IfcBinary extends BaseIfc implements IfcSimpleValue, SimpleType {
    protected byte[] value;

    public byte[] getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (byte[]) value; }
    public IfcBinary(byte[] value){ this.value = value; }
    public IfcBinary() { }
    public void setValue(byte[] value){ this.value = value; }

    
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