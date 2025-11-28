package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPerson;
 * Identification : OPTIONAL IfcIdentifier;
 * FamilyName : OPTIONAL IfcLabel;
 * GivenName : OPTIONAL IfcLabel;
 * MiddleNames : OPTIONAL LIST [1:?] OF IfcLabel;
 * PrefixTitles : OPTIONAL LIST [1:?] OF IfcLabel;
 * SuffixTitles : OPTIONAL LIST [1:?] OF IfcLabel;
 * Roles : OPTIONAL LIST [1:?] OF IfcActorRole;
 * Addresses : OPTIONAL LIST [1:?] OF IfcAddress;
 * INVERSE
 * EngagedIn : SET [0:?] OF IfcPersonAndOrganization FOR ThePerson;
 * WHERE
 * IdentifiablePerson : EXISTS(Identification) OR EXISTS(FamilyName) OR EXISTS(GivenName);
 * ValidSetOfNames : NOT EXISTS(MiddleNames) OR EXISTS(FamilyName) OR EXISTS(GivenName);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcperson.htm">IfcPerson</a>
 */
public class IfcPerson extends BaseIfc implements IfcActorSelect, IfcResourceObjectSelect, IfcObjectReferenceSelect {
    protected IfcIdentifier identification;
    protected IfcLabel familyName;
    protected IfcLabel givenName;
    protected Collection<IfcLabel> middleNames;
    protected Collection<IfcLabel> prefixTitles;
    protected Collection<IfcLabel> suffixTitles;
    protected Collection<IfcActorRole> roles;
    protected Collection<IfcAddress> addresses;
    protected Collection<IfcPersonAndOrganization> engagedIn;


    /**
     * Constructs IfcPerson with all required attributes.
     */
    public IfcPerson() {

        super();
        this.middleNames = new ArrayList<>();
        this.prefixTitles = new ArrayList<>();
        this.suffixTitles = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.addresses = new ArrayList<>();
        this.engagedIn = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcPerson with required and optional attributes.
     */
    public IfcPerson(IfcIdentifier identification,IfcLabel familyName,IfcLabel givenName,Collection<IfcLabel> middleNames,Collection<IfcLabel> prefixTitles,Collection<IfcLabel> suffixTitles,Collection<IfcActorRole> roles,Collection<IfcAddress> addresses) {
        super();
        this.engagedIn = new ArrayList<>();
        this.identification = identification;
        this.familyName = familyName;
        this.givenName = givenName;
        this.middleNames = middleNames;
        this.prefixTitles = prefixTitles;
        this.suffixTitles = suffixTitles;
        this.roles = roles;
        this.addresses = addresses;
    }
    private void initCollections() {
        this.middleNames = new ArrayList<>();
        this.prefixTitles = new ArrayList<>();
        this.suffixTitles = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.addresses = new ArrayList<>();
        this.engagedIn = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcLabel getFamilyName() { return this.familyName; }
    public void setFamilyName(IfcLabel value) { this.familyName = value; } // optional
    public IfcLabel getGivenName() { return this.givenName; }
    public void setGivenName(IfcLabel value) { this.givenName = value; } // optional
    public Collection<IfcLabel> getMiddleNames() { return this.middleNames; }
    public void setMiddleNames(Collection<IfcLabel> value) { this.middleNames = value; } // optional
    public Collection<IfcLabel> getPrefixTitles() { return this.prefixTitles; }
    public void setPrefixTitles(Collection<IfcLabel> value) { this.prefixTitles = value; } // optional
    public Collection<IfcLabel> getSuffixTitles() { return this.suffixTitles; }
    public void setSuffixTitles(Collection<IfcLabel> value) { this.suffixTitles = value; } // optional
    public Collection<IfcActorRole> getRoles() { return this.roles; }
    public void setRoles(Collection<IfcActorRole> value) { this.roles = value; } // optional
    public Collection<IfcAddress> getAddresses() { return this.addresses; }
    public void setAddresses(Collection<IfcAddress> value) { this.addresses = value; } // optional
    public Collection<IfcPersonAndOrganization> getEngagedIn() { return this.engagedIn; }
    public void setEngagedIn(Collection<IfcPersonAndOrganization> value) { this.engagedIn = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(familyName != null ? StepUtils.toStepValue(familyName) : "$");
		parameters.add(givenName != null ? StepUtils.toStepValue(givenName) : "$");
		parameters.add(middleNames != null ? StepUtils.toStepValue(middleNames) : "$");
		parameters.add(prefixTitles != null ? StepUtils.toStepValue(prefixTitles) : "$");
		parameters.add(suffixTitles != null ? StepUtils.toStepValue(suffixTitles) : "$");
		parameters.add(roles != null ? StepUtils.toStepValue(roles) : "$");
		parameters.add(addresses != null ? StepUtils.toStepValue(addresses) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPersonRelationship(); }
    private void setIfcPersonRelationship() {
		if (this.addresses != null) {
		    for (Object x : this.addresses) {
		        if (x instanceof IfcAddress)
		            ((IfcAddress)x).ofPerson.add(this);
		    }
		}
    }
}