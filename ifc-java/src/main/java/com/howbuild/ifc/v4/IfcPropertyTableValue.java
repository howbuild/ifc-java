package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyTableValue
 * SUBTYPE OF (IfcSimpleProperty);
 * DefiningValues : OPTIONAL LIST [1:?] OF UNIQUE IfcValue;
 * DefinedValues : OPTIONAL LIST [1:?] OF IfcValue;
 * Expression : OPTIONAL IfcText;
 * DefiningUnit : OPTIONAL IfcUnit;
 * DefinedUnit : OPTIONAL IfcUnit;
 * CurveInterpolation : OPTIONAL IfcCurveInterpolationEnum;
 * WHERE
 * WR21 : (NOT(EXISTS(DefiningValues)) AND NOT(EXISTS(DefinedValues)))
 * OR (SIZEOF(DefiningValues) = SIZEOF(DefinedValues));
 * WR22 : NOT(EXISTS(DefiningValues)) OR
 * (SIZEOF(QUERY(temp <* SELF.DefiningValues | TYPEOF(temp) <> TYPEOF(SELF.DefiningValues[1])
 * )) = 0);
 * WR23 : NOT(EXISTS(DefinedValues)) OR
 * (SIZEOF(QUERY(temp <* SELF.DefinedValues | TYPEOF(temp) <> TYPEOF(SELF.DefinedValues[1])
 * )) = 0);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertytablevalue.htm">IfcPropertyTableValue</a>
 */
public class IfcPropertyTableValue extends IfcSimpleProperty {
    protected Collection<IfcValue> definingValues;
    protected Collection<IfcValue> definedValues;
    protected IfcText expression;
    protected IfcUnit definingUnit;
    protected IfcUnit definedUnit;
    protected IfcCurveInterpolationEnum curveInterpolation;

    protected IfcPropertyTableValue() { initCollections(); }
    /**
     * Constructs IfcPropertyTableValue with all required attributes.
     */
    public IfcPropertyTableValue(IfcIdentifier name) {

        super(name);
        this.definingValues = new ArrayList<>();
        this.definedValues = new ArrayList<>();
    }
    /**
     * Constructs IfcPropertyTableValue with required and optional attributes.
     */
    public IfcPropertyTableValue(IfcIdentifier name,IfcText description,Collection<IfcValue> definingValues,Collection<IfcValue> definedValues,IfcText expression,IfcUnit definingUnit,IfcUnit definedUnit,IfcCurveInterpolationEnum curveInterpolation) {
        super(name,description);
        this.definingValues = definingValues;
        this.definedValues = definedValues;
        this.expression = expression;
        this.definingUnit = definingUnit;
        this.definedUnit = definedUnit;
        this.curveInterpolation = curveInterpolation;
    }
    private void initCollections() {
        this.definingValues = new ArrayList<>();
        this.definedValues = new ArrayList<>();
    }
    public Collection<IfcValue> getDefiningValues() { return this.definingValues; }
    public void setDefiningValues(Collection<IfcValue> value) { this.definingValues = value; } // optional
    public Collection<IfcValue> getDefinedValues() { return this.definedValues; }
    public void setDefinedValues(Collection<IfcValue> value) { this.definedValues = value; } // optional
    public IfcText getExpression() { return this.expression; }
    public void setExpression(IfcText value) { this.expression = value; } // optional
    public IfcUnit getDefiningUnit() { return this.definingUnit; }
    public void setDefiningUnit(IfcUnit value) { this.definingUnit = value; } // optional
    public IfcUnit getDefinedUnit() { return this.definedUnit; }
    public void setDefinedUnit(IfcUnit value) { this.definedUnit = value; } // optional
    public IfcCurveInterpolationEnum getCurveInterpolation() { return this.curveInterpolation; }
    public void setCurveInterpolation(IfcCurveInterpolationEnum value) { this.curveInterpolation = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(definingValues != null ? StepUtils.toStepValue(definingValues) : "$");
		parameters.add(definedValues != null ? StepUtils.toStepValue(definedValues) : "$");
		parameters.add(expression != null ? StepUtils.toStepValue(expression) : "$");
		parameters.add(definingUnit != null ? StepUtils.toStepValue(definingUnit) : "$");
		parameters.add(definedUnit != null ? StepUtils.toStepValue(definedUnit) : "$");
		parameters.add(StepUtils.toStepValue(curveInterpolation));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}