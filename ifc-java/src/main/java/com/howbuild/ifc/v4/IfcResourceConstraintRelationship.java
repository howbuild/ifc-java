package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcResourceConstraintRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingConstraint : IfcConstraint;
 * RelatedResourceObjects : SET [1:?] OF IfcResourceObjectSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcresourceconstraintrelationship.htm">IfcResourceConstraintRelationship</a>
 */
public class IfcResourceConstraintRelationship extends IfcResourceLevelRelationship {
    protected IfcConstraint relatingConstraint;
    protected Collection<IfcResourceObjectSelect> relatedResourceObjects;

    protected IfcResourceConstraintRelationship() { initCollections(); }
    /**
     * Constructs IfcResourceConstraintRelationship with all required attributes.
     */
    public IfcResourceConstraintRelationship(IfcConstraint relatingConstraint,Collection<IfcResourceObjectSelect> relatedResourceObjects) {

        super();
        this.relatingConstraint = relatingConstraint;
        this.relatedResourceObjects = relatedResourceObjects;
    }
    /**
     * Constructs IfcResourceConstraintRelationship with required and optional attributes.
     */
    public IfcResourceConstraintRelationship(IfcLabel name,IfcText description,IfcConstraint relatingConstraint,Collection<IfcResourceObjectSelect> relatedResourceObjects) {
        super(name,description);
        this.relatingConstraint = relatingConstraint;
        this.relatedResourceObjects = relatedResourceObjects;
    }
    private void initCollections() {
        this.relatedResourceObjects = new ArrayList<>();
    }
    public IfcConstraint getRelatingConstraint() { return this.relatingConstraint; }
    public void setRelatingConstraint(IfcConstraint value) { this.relatingConstraint = value; }
    public Collection<IfcResourceObjectSelect> getRelatedResourceObjects() { return this.relatedResourceObjects; }
    public void setRelatedResourceObjects(Collection<IfcResourceObjectSelect> value) { this.relatedResourceObjects = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingConstraint != null ? StepUtils.toStepValue(relatingConstraint) : "$");
		parameters.add(relatedResourceObjects != null ? StepUtils.toStepValue(relatedResourceObjects) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcResourceConstraintRelationshipRelationship(); }
    private void setIfcResourceConstraintRelationshipRelationship() {
		if (this.relatingConstraint != null) {
		    if (this.relatingConstraint instanceof IfcConstraint)
		        ((IfcConstraint)this.relatingConstraint).propertiesForConstraint.add(this);
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcProperty)
		            ((IfcProperty)x).hasConstraints.add(this);
		    }
		}
    }
}