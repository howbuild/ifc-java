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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctelecomaddress.htm">IfcTelecomAddress</a>
 */
public class IfcTelecomAddress extends IfcAddress {
    protected Collection<IfcLabel> telephoneNumbers;
    protected Collection<IfcLabel> facsimileNumbers;
    protected IfcLabel pagerNumber;
    protected Collection<IfcLabel> electronicMailAddresses;
    protected IfcURIReference wWWHomePageURL;
    protected Collection<IfcURIReference> messagingIDs;


    /**
     * Constructs IfcTelecomAddress with all required attributes.
     */
    public IfcTelecomAddress() {

        super();
        this.telephoneNumbers = new ArrayList<>();
        this.facsimileNumbers = new ArrayList<>();
        this.electronicMailAddresses = new ArrayList<>();
        this.messagingIDs = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcTelecomAddress with required and optional attributes.
     */
    public IfcTelecomAddress(IfcAddressTypeEnum purpose,IfcText description,IfcLabel userDefinedPurpose,Collection<IfcLabel> telephoneNumbers,Collection<IfcLabel> facsimileNumbers,IfcLabel pagerNumber,Collection<IfcLabel> electronicMailAddresses,IfcURIReference wWWHomePageURL,Collection<IfcURIReference> messagingIDs) {
        super(purpose,description,userDefinedPurpose);
        this.telephoneNumbers = telephoneNumbers;
        this.facsimileNumbers = facsimileNumbers;
        this.pagerNumber = pagerNumber;
        this.electronicMailAddresses = electronicMailAddresses;
        this.wWWHomePageURL = wWWHomePageURL;
        this.messagingIDs = messagingIDs;
    }
    private void initCollections() {
        this.telephoneNumbers = new ArrayList<>();
        this.facsimileNumbers = new ArrayList<>();
        this.electronicMailAddresses = new ArrayList<>();
        this.messagingIDs = new ArrayList<>();
    }
    public Collection<IfcLabel> getTelephoneNumbers() { return this.telephoneNumbers; }
    public void setTelephoneNumbers(Collection<IfcLabel> value) { this.telephoneNumbers = value; } // optional
    public Collection<IfcLabel> getFacsimileNumbers() { return this.facsimileNumbers; }
    public void setFacsimileNumbers(Collection<IfcLabel> value) { this.facsimileNumbers = value; } // optional
    public IfcLabel getPagerNumber() { return this.pagerNumber; }
    public void setPagerNumber(IfcLabel value) { this.pagerNumber = value; } // optional
    public Collection<IfcLabel> getElectronicMailAddresses() { return this.electronicMailAddresses; }
    public void setElectronicMailAddresses(Collection<IfcLabel> value) { this.electronicMailAddresses = value; } // optional
    public IfcURIReference getWWWHomePageURL() { return this.wWWHomePageURL; }
    public void setWWWHomePageURL(IfcURIReference value) { this.wWWHomePageURL = value; } // optional
    public Collection<IfcURIReference> getMessagingIDs() { return this.messagingIDs; }
    public void setMessagingIDs(Collection<IfcURIReference> value) { this.messagingIDs = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(purpose));
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(userDefinedPurpose != null ? StepUtils.toStepValue(userDefinedPurpose) : "$");
		parameters.add(telephoneNumbers != null ? StepUtils.toStepValue(telephoneNumbers) : "$");
		parameters.add(facsimileNumbers != null ? StepUtils.toStepValue(facsimileNumbers) : "$");
		parameters.add(pagerNumber != null ? StepUtils.toStepValue(pagerNumber) : "$");
		parameters.add(electronicMailAddresses != null ? StepUtils.toStepValue(electronicMailAddresses) : "$");
		parameters.add(wWWHomePageURL != null ? StepUtils.toStepValue(wWWHomePageURL) : "$");
		parameters.add(messagingIDs != null ? StepUtils.toStepValue(messagingIDs) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}