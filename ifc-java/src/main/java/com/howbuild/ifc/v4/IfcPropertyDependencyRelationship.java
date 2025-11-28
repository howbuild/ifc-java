package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyDependencyRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * DependingProperty : IfcProperty;
 * DependantProperty : IfcProperty;
 * Expression : OPTIONAL IfcText;
 * WHERE
 * NoSelfReference : DependingProperty :<>: DependantProperty;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertydependencyrelationship.htm">IfcPropertyDependencyRelationship</a>
 */
public class IfcPropertyDependencyRelationship extends IfcResourceLevelRelationship {
    protected IfcProperty dependingProperty;
    protected IfcProperty dependantProperty;
    protected IfcText expression;

    protected IfcPropertyDependencyRelationship() { initCollections(); }
    /**
     * Constructs IfcPropertyDependencyRelationship with all required attributes.
     */
    public IfcPropertyDependencyRelationship(IfcProperty dependingProperty,IfcProperty dependantProperty) {

        super();
        this.dependingProperty = dependingProperty;
        this.dependantProperty = dependantProperty;
    }
    /**
     * Constructs IfcPropertyDependencyRelationship with required and optional attributes.
     */
    public IfcPropertyDependencyRelationship(IfcLabel name,IfcText description,IfcProperty dependingProperty,IfcProperty dependantProperty,IfcText expression) {
        super(name,description);
        this.dependingProperty = dependingProperty;
        this.dependantProperty = dependantProperty;
        this.expression = expression;
    }
    private void initCollections() {
    }
    public IfcProperty getDependingProperty() { return this.dependingProperty; }
    public void setDependingProperty(IfcProperty value) { this.dependingProperty = value; }
    public IfcProperty getDependantProperty() { return this.dependantProperty; }
    public void setDependantProperty(IfcProperty value) { this.dependantProperty = value; }
    public IfcText getExpression() { return this.expression; }
    public void setExpression(IfcText value) { this.expression = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(dependingProperty != null ? StepUtils.toStepValue(dependingProperty) : "$");
		parameters.add(dependantProperty != null ? StepUtils.toStepValue(dependantProperty) : "$");
		parameters.add(expression != null ? StepUtils.toStepValue(expression) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPropertyDependencyRelationshipRelationship(); }
    private void setIfcPropertyDependencyRelationshipRelationship() {
		if (this.dependingProperty != null) {
		    if (this.dependingProperty instanceof IfcProperty)
		        ((IfcProperty)this.dependingProperty).propertyForDependance.add(this);
		}
		if (this.dependantProperty != null) {
		    if (this.dependantProperty instanceof IfcProperty)
		        ((IfcProperty)this.dependantProperty).propertyDependsOn.add(this);
		}
    }
}