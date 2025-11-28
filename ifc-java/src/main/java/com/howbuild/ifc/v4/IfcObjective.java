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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcobjective.htm">IfcObjective</a>
 */
public class IfcObjective extends IfcConstraint {
    protected Collection<IfcConstraint> benchmarkValues;
    protected IfcLogicalOperatorEnum logicalAggregator;
    protected IfcObjectiveEnum objectiveQualifier;
    protected IfcLabel userDefinedQualifier;

    protected IfcObjective() { initCollections(); }
    /**
     * Constructs IfcObjective with all required attributes.
     */
    public IfcObjective(IfcLabel name,IfcConstraintEnum constraintGrade,IfcObjectiveEnum objectiveQualifier) {

        super(name,constraintGrade);
        this.benchmarkValues = new ArrayList<>();
        this.objectiveQualifier = objectiveQualifier;
    }
    /**
     * Constructs IfcObjective with required and optional attributes.
     */
    public IfcObjective(IfcLabel name,IfcText description,IfcConstraintEnum constraintGrade,IfcLabel constraintSource,IfcActorSelect creatingActor,IfcDateTime creationTime,IfcLabel userDefinedGrade,Collection<IfcConstraint> benchmarkValues,IfcLogicalOperatorEnum logicalAggregator,IfcObjectiveEnum objectiveQualifier,IfcLabel userDefinedQualifier) {
        super(name,description,constraintGrade,constraintSource,creatingActor,creationTime,userDefinedGrade);
        this.benchmarkValues = benchmarkValues;
        this.logicalAggregator = logicalAggregator;
        this.objectiveQualifier = objectiveQualifier;
        this.userDefinedQualifier = userDefinedQualifier;
    }
    private void initCollections() {
        this.benchmarkValues = new ArrayList<>();
    }
    public Collection<IfcConstraint> getBenchmarkValues() { return this.benchmarkValues; }
    public void setBenchmarkValues(Collection<IfcConstraint> value) { this.benchmarkValues = value; } // optional
    public IfcLogicalOperatorEnum getLogicalAggregator() { return this.logicalAggregator; }
    public void setLogicalAggregator(IfcLogicalOperatorEnum value) { this.logicalAggregator = value; } // optional
    public IfcObjectiveEnum getObjectiveQualifier() { return this.objectiveQualifier; }
    public void setObjectiveQualifier(IfcObjectiveEnum value) { this.objectiveQualifier = value; }
    public IfcLabel getUserDefinedQualifier() { return this.userDefinedQualifier; }
    public void setUserDefinedQualifier(IfcLabel value) { this.userDefinedQualifier = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(StepUtils.toStepValue(constraintGrade));
		parameters.add(constraintSource != null ? StepUtils.toStepValue(constraintSource) : "$");
		parameters.add(creatingActor != null ? StepUtils.toStepValue(creatingActor) : "$");
		parameters.add(creationTime != null ? StepUtils.toStepValue(creationTime) : "$");
		parameters.add(userDefinedGrade != null ? StepUtils.toStepValue(userDefinedGrade) : "$");
		parameters.add(benchmarkValues != null ? StepUtils.toStepValue(benchmarkValues) : "$");
		parameters.add(StepUtils.toStepValue(logicalAggregator));
		parameters.add(StepUtils.toStepValue(objectiveQualifier));
		parameters.add(userDefinedQualifier != null ? StepUtils.toStepValue(userDefinedQualifier) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}