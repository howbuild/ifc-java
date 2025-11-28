package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAppliedValue
 * SUPERTYPE OF (ONEOF
 * (IfcCostValue));
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * AppliedValue : OPTIONAL IfcAppliedValueSelect;
 * UnitBasis : OPTIONAL IfcMeasureWithUnit;
 * ApplicableDate : OPTIONAL IfcDate;
 * FixedUntilDate : OPTIONAL IfcDate;
 * Category : OPTIONAL IfcLabel;
 * Condition : OPTIONAL IfcLabel;
 * ArithmeticOperator : OPTIONAL IfcArithmeticOperatorEnum;
 * Components : OPTIONAL LIST [1:?] OF IfcAppliedValue;
 * INVERSE
 * HasExternalReference : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccostvalue.htm">IfcCostValue</a>
 */
public class IfcCostValue extends IfcAppliedValue {


    /**
     * Constructs IfcCostValue with all required attributes.
     */
    public IfcCostValue() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcCostValue with required and optional attributes.
     */
    public IfcCostValue(IfcLabel name,IfcText description,IfcAppliedValueSelect appliedValue,IfcMeasureWithUnit unitBasis,IfcDate applicableDate,IfcDate fixedUntilDate,IfcLabel category,IfcLabel condition,IfcArithmeticOperatorEnum arithmeticOperator,Collection<IfcAppliedValue> components) {
        super(name,description,appliedValue,unitBasis,applicableDate,fixedUntilDate,category,condition,arithmeticOperator,components);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(appliedValue != null ? StepUtils.toStepValue(appliedValue) : "$");
		parameters.add(unitBasis != null ? StepUtils.toStepValue(unitBasis) : "$");
		parameters.add(applicableDate != null ? StepUtils.toStepValue(applicableDate) : "$");
		parameters.add(fixedUntilDate != null ? StepUtils.toStepValue(fixedUntilDate) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
		parameters.add(condition != null ? StepUtils.toStepValue(condition) : "$");
		parameters.add(StepUtils.toStepValue(arithmeticOperator));
		parameters.add(components != null ? StepUtils.toStepValue(components) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}