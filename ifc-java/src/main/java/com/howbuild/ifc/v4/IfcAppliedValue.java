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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcappliedvalue.htm">IfcAppliedValue</a>
 */
public class IfcAppliedValue extends BaseIfc implements IfcResourceObjectSelect, IfcMetricValueSelect, IfcObjectReferenceSelect {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcAppliedValueSelect appliedValue;
    protected IfcMeasureWithUnit unitBasis;
    protected IfcDate applicableDate;
    protected IfcDate fixedUntilDate;
    protected IfcLabel category;
    protected IfcLabel condition;
    protected IfcArithmeticOperatorEnum arithmeticOperator;
    protected Collection<IfcAppliedValue> components;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReference;


    /**
     * Constructs IfcAppliedValue with all required attributes.
     */
    public IfcAppliedValue() {

        super();
        this.components = new ArrayList<>();
        this.hasExternalReference = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcAppliedValue with required and optional attributes.
     */
    public IfcAppliedValue(IfcLabel name,IfcText description,IfcAppliedValueSelect appliedValue,IfcMeasureWithUnit unitBasis,IfcDate applicableDate,IfcDate fixedUntilDate,IfcLabel category,IfcLabel condition,IfcArithmeticOperatorEnum arithmeticOperator,Collection<IfcAppliedValue> components) {
        super();
        this.hasExternalReference = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.appliedValue = appliedValue;
        this.unitBasis = unitBasis;
        this.applicableDate = applicableDate;
        this.fixedUntilDate = fixedUntilDate;
        this.category = category;
        this.condition = condition;
        this.arithmeticOperator = arithmeticOperator;
        this.components = components;
    }
    private void initCollections() {
        this.components = new ArrayList<>();
        this.hasExternalReference = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcAppliedValueSelect getAppliedValue() { return this.appliedValue; }
    public void setAppliedValue(IfcAppliedValueSelect value) { this.appliedValue = value; } // optional
    public IfcMeasureWithUnit getUnitBasis() { return this.unitBasis; }
    public void setUnitBasis(IfcMeasureWithUnit value) { this.unitBasis = value; } // optional
    public IfcDate getApplicableDate() { return this.applicableDate; }
    public void setApplicableDate(IfcDate value) { this.applicableDate = value; } // optional
    public IfcDate getFixedUntilDate() { return this.fixedUntilDate; }
    public void setFixedUntilDate(IfcDate value) { this.fixedUntilDate = value; } // optional
    public IfcLabel getCategory() { return this.category; }
    public void setCategory(IfcLabel value) { this.category = value; } // optional
    public IfcLabel getCondition() { return this.condition; }
    public void setCondition(IfcLabel value) { this.condition = value; } // optional
    public IfcArithmeticOperatorEnum getArithmeticOperator() { return this.arithmeticOperator; }
    public void setArithmeticOperator(IfcArithmeticOperatorEnum value) { this.arithmeticOperator = value; } // optional
    public Collection<IfcAppliedValue> getComponents() { return this.components; }
    public void setComponents(Collection<IfcAppliedValue> value) { this.components = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReference() { return this.hasExternalReference; }
    public void setHasExternalReference(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReference = value; } // inverse

    
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