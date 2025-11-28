package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAddress
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcPostalAddress
 * ,IfcTelecomAddress));
 * Purpose : OPTIONAL IfcAddressTypeEnum;
 * Description : OPTIONAL IfcText;
 * UserDefinedPurpose : OPTIONAL IfcLabel;
 * INVERSE
 * OfPerson : SET [0:?] OF IfcPerson FOR Addresses;
 * OfOrganization : SET [0:?] OF IfcOrganization FOR Addresses;
 * WHERE
 * WR1 : (NOT(EXISTS(Purpose))) OR
 * ((Purpose <> IfcAddressTypeEnum.USERDEFINED) OR
 * ((Purpose = IfcAddressTypeEnum.USERDEFINED) AND
 * EXISTS(SELF.UserDefinedPurpose)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcaddress.htm">IfcAddress</a>
 */
public abstract class IfcAddress extends BaseIfc implements IfcObjectReferenceSelect {
    protected IfcAddressTypeEnum purpose;
    protected IfcText description;
    protected IfcLabel userDefinedPurpose;
    protected Collection<IfcPerson> ofPerson;
    protected Collection<IfcOrganization> ofOrganization;


    /**
     * Constructs IfcAddress with all required attributes.
     */
    public IfcAddress() {

        super();
        this.ofPerson = new ArrayList<>();
        this.ofOrganization = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcAddress with required and optional attributes.
     */
    public IfcAddress(IfcAddressTypeEnum purpose,IfcText description,IfcLabel userDefinedPurpose) {
        super();
        this.ofPerson = new ArrayList<>();
        this.ofOrganization = new ArrayList<>();
        this.purpose = purpose;
        this.description = description;
        this.userDefinedPurpose = userDefinedPurpose;
    }
    private void initCollections() {
        this.ofPerson = new ArrayList<>();
        this.ofOrganization = new ArrayList<>();
    }
    public IfcAddressTypeEnum getPurpose() { return this.purpose; }
    public void setPurpose(IfcAddressTypeEnum value) { this.purpose = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcLabel getUserDefinedPurpose() { return this.userDefinedPurpose; }
    public void setUserDefinedPurpose(IfcLabel value) { this.userDefinedPurpose = value; } // optional
    public Collection<IfcPerson> getOfPerson() { return this.ofPerson; }
    public void setOfPerson(Collection<IfcPerson> value) { this.ofPerson = value; } // inverse
    public Collection<IfcOrganization> getOfOrganization() { return this.ofOrganization; }
    public void setOfOrganization(Collection<IfcOrganization> value) { this.ofOrganization = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}