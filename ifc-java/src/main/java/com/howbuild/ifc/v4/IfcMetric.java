package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstraint
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMetric
 * ,IfcObjective));
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * ConstraintGrade : IfcConstraintEnum;
 * ConstraintSource : OPTIONAL IfcLabel;
 * CreatingActor : OPTIONAL IfcActorSelect;
 * CreationTime : OPTIONAL IfcDateTime;
 * UserDefinedGrade : OPTIONAL IfcLabel;
 * INVERSE
 * HasExternalReferences : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * PropertiesForConstraint : SET [0:?] OF IfcResourceConstraintRelationship FOR RelatingConstraint;
 * WHERE
 * WR11 : (ConstraintGrade <> IfcConstraintEnum.USERDEFINED) OR
 * ((ConstraintGrade = IfcConstraintEnum.USERDEFINED) AND EXISTS(SELF\IfcConstraint.UserDefinedGrade));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmetric.htm">IfcMetric</a>
 */
public class IfcMetric extends IfcConstraint {
    protected IfcBenchmarkEnum benchmark;
    protected IfcLabel valueSource;
    protected IfcMetricValueSelect dataValue;
    protected IfcReference referencePath;

    protected IfcMetric() { initCollections(); }
    /**
     * Constructs IfcMetric with all required attributes.
     */
    public IfcMetric(IfcLabel name,IfcConstraintEnum constraintGrade,IfcBenchmarkEnum benchmark) {

        super(name,constraintGrade);
        this.benchmark = benchmark;
    }
    /**
     * Constructs IfcMetric with required and optional attributes.
     */
    public IfcMetric(IfcLabel name,IfcText description,IfcConstraintEnum constraintGrade,IfcLabel constraintSource,IfcActorSelect creatingActor,IfcDateTime creationTime,IfcLabel userDefinedGrade,IfcBenchmarkEnum benchmark,IfcLabel valueSource,IfcMetricValueSelect dataValue,IfcReference referencePath) {
        super(name,description,constraintGrade,constraintSource,creatingActor,creationTime,userDefinedGrade);
        this.benchmark = benchmark;
        this.valueSource = valueSource;
        this.dataValue = dataValue;
        this.referencePath = referencePath;
    }
    private void initCollections() {
    }
    public IfcBenchmarkEnum getBenchmark() { return this.benchmark; }
    public void setBenchmark(IfcBenchmarkEnum value) { this.benchmark = value; }
    public IfcLabel getValueSource() { return this.valueSource; }
    public void setValueSource(IfcLabel value) { this.valueSource = value; } // optional
    public IfcMetricValueSelect getDataValue() { return this.dataValue; }
    public void setDataValue(IfcMetricValueSelect value) { this.dataValue = value; } // optional
    public IfcReference getReferencePath() { return this.referencePath; }
    public void setReferencePath(IfcReference value) { this.referencePath = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(StepUtils.toStepValue(constraintGrade));
		parameters.add(constraintSource != null ? StepUtils.toStepValue(constraintSource) : "$");
		parameters.add(creatingActor != null ? StepUtils.toStepValue(creatingActor) : "$");
		parameters.add(creationTime != null ? StepUtils.toStepValue(creationTime) : "$");
		parameters.add(userDefinedGrade != null ? StepUtils.toStepValue(userDefinedGrade) : "$");
		parameters.add(StepUtils.toStepValue(benchmark));
		parameters.add(valueSource != null ? StepUtils.toStepValue(valueSource) : "$");
		parameters.add(dataValue != null ? StepUtils.toStepValue(dataValue) : "$");
		parameters.add(referencePath != null ? StepUtils.toStepValue(referencePath) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}