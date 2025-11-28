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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconstraint.htm">IfcConstraint</a>
 */
public abstract class IfcConstraint extends BaseIfc implements IfcResourceObjectSelect {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcConstraintEnum constraintGrade;
    protected IfcLabel constraintSource;
    protected IfcActorSelect creatingActor;
    protected IfcDateTime creationTime;
    protected IfcLabel userDefinedGrade;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReferences;
    protected Collection<IfcResourceConstraintRelationship> propertiesForConstraint;

    protected IfcConstraint() { initCollections(); }
    /**
     * Constructs IfcConstraint with all required attributes.
     */
    public IfcConstraint(IfcLabel name,IfcConstraintEnum constraintGrade) {

        super();
        this.hasExternalReferences = new ArrayList<>();
        this.propertiesForConstraint = new ArrayList<>();
        this.name = name;
        this.constraintGrade = constraintGrade;
    }
    /**
     * Constructs IfcConstraint with required and optional attributes.
     */
    public IfcConstraint(IfcLabel name,IfcText description,IfcConstraintEnum constraintGrade,IfcLabel constraintSource,IfcActorSelect creatingActor,IfcDateTime creationTime,IfcLabel userDefinedGrade) {
        super();
        this.hasExternalReferences = new ArrayList<>();
        this.propertiesForConstraint = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.constraintGrade = constraintGrade;
        this.constraintSource = constraintSource;
        this.creatingActor = creatingActor;
        this.creationTime = creationTime;
        this.userDefinedGrade = userDefinedGrade;
    }
    private void initCollections() {
        this.hasExternalReferences = new ArrayList<>();
        this.propertiesForConstraint = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcConstraintEnum getConstraintGrade() { return this.constraintGrade; }
    public void setConstraintGrade(IfcConstraintEnum value) { this.constraintGrade = value; }
    public IfcLabel getConstraintSource() { return this.constraintSource; }
    public void setConstraintSource(IfcLabel value) { this.constraintSource = value; } // optional
    public IfcActorSelect getCreatingActor() { return this.creatingActor; }
    public void setCreatingActor(IfcActorSelect value) { this.creatingActor = value; } // optional
    public IfcDateTime getCreationTime() { return this.creationTime; }
    public void setCreationTime(IfcDateTime value) { this.creationTime = value; } // optional
    public IfcLabel getUserDefinedGrade() { return this.userDefinedGrade; }
    public void setUserDefinedGrade(IfcLabel value) { this.userDefinedGrade = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReferences() { return this.hasExternalReferences; }
    public void setHasExternalReferences(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReferences = value; } // inverse
    public Collection<IfcResourceConstraintRelationship> getPropertiesForConstraint() { return this.propertiesForConstraint; }
    public void setPropertiesForConstraint(Collection<IfcResourceConstraintRelationship> value) { this.propertiesForConstraint = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}