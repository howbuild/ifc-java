package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActorRole;
 * Role : IfcRoleEnum;
 * UserDefinedRole : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * INVERSE
 * HasExternalReference : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * WHERE
 * WR1 : (Role <> IfcRoleEnum.USERDEFINED) OR
 * ((Role = IfcRoleEnum.USERDEFINED) AND
 * EXISTS(SELF.UserDefinedRole));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcactorrole.htm">IfcActorRole</a>
 */
public class IfcActorRole extends BaseIfc implements IfcResourceObjectSelect {
    protected IfcRoleEnum role;
    protected IfcLabel userDefinedRole;
    protected IfcText description;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReference;

    protected IfcActorRole() { initCollections(); }
    /**
     * Constructs IfcActorRole with all required attributes.
     */
    public IfcActorRole(IfcRoleEnum role) {

        super();
        this.hasExternalReference = new ArrayList<>();
        this.role = role;
    }
    /**
     * Constructs IfcActorRole with required and optional attributes.
     */
    public IfcActorRole(IfcRoleEnum role,IfcLabel userDefinedRole,IfcText description) {
        super();
        this.hasExternalReference = new ArrayList<>();
        this.role = role;
        this.userDefinedRole = userDefinedRole;
        this.description = description;
    }
    private void initCollections() {
        this.hasExternalReference = new ArrayList<>();
    }
    public IfcRoleEnum getRole() { return this.role; }
    public void setRole(IfcRoleEnum value) { this.role = value; }
    public IfcLabel getUserDefinedRole() { return this.userDefinedRole; }
    public void setUserDefinedRole(IfcLabel value) { this.userDefinedRole = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReference() { return this.hasExternalReference; }
    public void setHasExternalReference(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReference = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(role));
		parameters.add(userDefinedRole != null ? StepUtils.toStepValue(userDefinedRole) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}