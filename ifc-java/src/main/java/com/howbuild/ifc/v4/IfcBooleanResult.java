package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBooleanClippingResult
 * SUBTYPE OF (IfcBooleanResult);
 * WHERE
 * FirstOperandType : ('IFC4.IFCSWEPTAREASOLID' IN TYPEOF(FirstOperand)) OR
 * ('IFC4.IFCSWEPTDISCSOLID' IN TYPEOF(FirstOperand)) OR
 * ('IFC4.IFCBOOLEANCLIPPINGRESULT' IN TYPEOF(FirstOperand));
 * SecondOperandType : ('IFC4.IFCHALFSPACESOLID' IN TYPEOF(SecondOperand));
 * OperatorType : Operator = DIFFERENCE;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbooleanresult.htm">IfcBooleanResult</a>
 */
public class IfcBooleanResult extends IfcGeometricRepresentationItem implements IfcBooleanOperand, IfcCsgSelect {
    protected IfcBooleanOperator operator;
    protected IfcBooleanOperand firstOperand;
    protected IfcBooleanOperand secondOperand;

    protected IfcBooleanResult() { initCollections(); }
    /**
     * Constructs IfcBooleanResult with all required attributes.
     */
    public IfcBooleanResult(IfcBooleanOperator op,IfcBooleanOperand firstOperand,IfcBooleanOperand secondOperand) {
        super();
        this.operator = op;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    private void initCollections() {
    }
    public IfcBooleanOperator getOperator() { return this.operator; }
    public void setOperator(IfcBooleanOperator value) { this.operator = value; }
    public IfcBooleanOperand getFirstOperand() { return this.firstOperand; }
    public void setFirstOperand(IfcBooleanOperand value) { this.firstOperand = value; }
    public IfcBooleanOperand getSecondOperand() { return this.secondOperand; }
    public void setSecondOperand(IfcBooleanOperand value) { this.secondOperand = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(operator != null ? StepUtils.toStepValue(operator) : "$");
		parameters.add(firstOperand != null ? StepUtils.toStepValue(firstOperand) : "$");
		parameters.add(secondOperand != null ? StepUtils.toStepValue(secondOperand) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}