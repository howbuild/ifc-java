package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcOrganization;
 * Identification : OPTIONAL IfcIdentifier;
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * Roles : OPTIONAL LIST [1:?] OF IfcActorRole;
 * Addresses : OPTIONAL LIST [1:?] OF IfcAddress;
 * INVERSE
 * IsRelatedBy : SET [0:?] OF IfcOrganizationRelationship FOR RelatedOrganizations;
 * Relates : SET [0:?] OF IfcOrganizationRelationship FOR RelatingOrganization;
 * Engages : SET [0:?] OF IfcPersonAndOrganization FOR TheOrganization;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcorganization.htm">IfcOrganization</a>
 */
public class IfcOrganization extends BaseIfc implements IfcActorSelect, IfcResourceObjectSelect, IfcObjectReferenceSelect {
    protected IfcIdentifier identification;
    protected IfcLabel name;
    protected IfcText description;
    protected Collection<IfcActorRole> roles;
    protected Collection<IfcAddress> addresses;
    protected Collection<IfcOrganizationRelationship> isRelatedBy;
    protected Collection<IfcOrganizationRelationship> relates;
    protected Collection<IfcPersonAndOrganization> engages;

    protected IfcOrganization() { initCollections(); }
    /**
     * Constructs IfcOrganization with all required attributes.
     */
    public IfcOrganization(IfcLabel name) {

        super();
        this.roles = new ArrayList<>();
        this.addresses = new ArrayList<>();
        this.isRelatedBy = new ArrayList<>();
        this.relates = new ArrayList<>();
        this.engages = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcOrganization with required and optional attributes.
     */
    public IfcOrganization(IfcIdentifier identification,IfcLabel name,IfcText description,Collection<IfcActorRole> roles,Collection<IfcAddress> addresses) {
        super();
        this.isRelatedBy = new ArrayList<>();
        this.relates = new ArrayList<>();
        this.engages = new ArrayList<>();
        this.identification = identification;
        this.name = name;
        this.description = description;
        this.roles = roles;
        this.addresses = addresses;
    }
    private void initCollections() {
        this.roles = new ArrayList<>();
        this.addresses = new ArrayList<>();
        this.isRelatedBy = new ArrayList<>();
        this.relates = new ArrayList<>();
        this.engages = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcActorRole> getRoles() { return this.roles; }
    public void setRoles(Collection<IfcActorRole> value) { this.roles = value; } // optional
    public Collection<IfcAddress> getAddresses() { return this.addresses; }
    public void setAddresses(Collection<IfcAddress> value) { this.addresses = value; } // optional
    public Collection<IfcOrganizationRelationship> getIsRelatedBy() { return this.isRelatedBy; }
    public void setIsRelatedBy(Collection<IfcOrganizationRelationship> value) { this.isRelatedBy = value; } // inverse
    public Collection<IfcOrganizationRelationship> getRelates() { return this.relates; }
    public void setRelates(Collection<IfcOrganizationRelationship> value) { this.relates = value; } // inverse
    public Collection<IfcPersonAndOrganization> getEngages() { return this.engages; }
    public void setEngages(Collection<IfcPersonAndOrganization> value) { this.engages = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(roles != null ? StepUtils.toStepValue(roles) : "$");
		parameters.add(addresses != null ? StepUtils.toStepValue(addresses) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcOrganizationRelationship(); }
    private void setIfcOrganizationRelationship() {
		if (this.addresses != null) {
		    for (Object x : this.addresses) {
		        if (x instanceof IfcAddress)
		            ((IfcAddress)x).ofOrganization.add(this);
		    }
		}
    }
}