package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcCompoundPlaneAngleMeasure = LIST [3:4] OF INTEGER;
 * WHERE
 * MinutesInRange : ABS(SELF[2]) < 60;
 * SecondsInRange : ABS(SELF[3]) < 60;
 * MicrosecondsInRange : (SIZEOF(SELF) = 3) OR (ABS(SELF[4]) < 1000000);
 * ConsistentSign : ((SELF[1] >= 0) AND (SELF[2] >= 0) AND (SELF[3] >= 0) AND ((SIZEOF(SELF) = 3) OR (SELF[4] >= 0)))
 * OR
 * ((SELF[1] <= 0) AND (SELF[2] <= 0) AND (SELF[3] <= 0) AND ((SIZEOF(SELF) = 3) OR (SELF[4] <= 0)));
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccompoundplaneanglemeasure.htm">IfcCompoundPlaneAngleMeasure</a>
 */
public class IfcCompoundPlaneAngleMeasure extends BaseIfc implements IfcDerivedMeasureValue, SimpleType {
    protected Collection<Long> value;

    public Collection<Long> getValue() {
        return this.value;
    }

    public void setValue(Object value){ this.value = (Collection<Long>) value; }
    public IfcCompoundPlaneAngleMeasure(Collection<Long> value){ this.value = value; }
    public IfcCompoundPlaneAngleMeasure() { }
    public void setValue(Collection<Long> value){ this.value = value; }

    
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