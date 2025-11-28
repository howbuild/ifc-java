package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPersonAndOrganization;
 * ThePerson : IfcPerson;
 * TheOrganization : IfcOrganization;
 * Roles : OPTIONAL LIST [1:?] OF IfcActorRole;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpersonandorganization.htm">IfcPersonAndOrganization</a>
 */
public class IfcPersonAndOrganization extends BaseIfc implements IfcActorSelect, IfcResourceObjectSelect, IfcObjectReferenceSelect {
    protected IfcPerson thePerson;
    protected IfcOrganization theOrganization;
    protected Collection<IfcActorRole> roles;

    protected IfcPersonAndOrganization() { initCollections(); }
    /**
     * Constructs IfcPersonAndOrganization with all required attributes.
     */
    public IfcPersonAndOrganization(IfcPerson thePerson,IfcOrganization theOrganization) {

        super();
        this.roles = new ArrayList<>();
        this.thePerson = thePerson;
        this.theOrganization = theOrganization;
    }
    /**
     * Constructs IfcPersonAndOrganization with required and optional attributes.
     */
    public IfcPersonAndOrganization(IfcPerson thePerson,IfcOrganization theOrganization,Collection<IfcActorRole> roles) {
        super();
        this.thePerson = thePerson;
        this.theOrganization = theOrganization;
        this.roles = roles;
    }
    private void initCollections() {
        this.roles = new ArrayList<>();
    }
    public IfcPerson getThePerson() { return this.thePerson; }
    public void setThePerson(IfcPerson value) { this.thePerson = value; }
    public IfcOrganization getTheOrganization() { return this.theOrganization; }
    public void setTheOrganization(IfcOrganization value) { this.theOrganization = value; }
    public Collection<IfcActorRole> getRoles() { return this.roles; }
    public void setRoles(Collection<IfcActorRole> value) { this.roles = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(thePerson != null ? StepUtils.toStepValue(thePerson) : "$");
		parameters.add(theOrganization != null ? StepUtils.toStepValue(theOrganization) : "$");
		parameters.add(roles != null ? StepUtils.toStepValue(roles) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPersonAndOrganizationRelationship(); }
    private void setIfcPersonAndOrganizationRelationship() {
		if (this.theOrganization != null) {
		    if (this.theOrganization instanceof IfcOrganization)
		        ((IfcOrganization)this.theOrganization).engages.add(this);
		}
		if (this.thePerson != null) {
		    if (this.thePerson instanceof IfcPerson)
		        ((IfcPerson)this.thePerson).engagedIn.add(this);
		}
    }
}