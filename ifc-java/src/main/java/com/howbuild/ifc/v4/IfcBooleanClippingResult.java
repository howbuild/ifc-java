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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbooleanclippingresult.htm">IfcBooleanClippingResult</a>
 */
public class IfcBooleanClippingResult extends IfcBooleanResult {

    protected IfcBooleanClippingResult() { initCollections(); }
    /**
     * Constructs IfcBooleanClippingResult with all required attributes.
     */
    public IfcBooleanClippingResult(IfcBooleanOperator op,IfcBooleanOperand firstOperand,IfcBooleanOperand secondOperand) {
        super(op,firstOperand,secondOperand);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(operator != null ? StepUtils.toStepValue(operator) : "$");
		parameters.add(firstOperand != null ? StepUtils.toStepValue(firstOperand) : "$");
		parameters.add(secondOperand != null ? StepUtils.toStepValue(secondOperand) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}