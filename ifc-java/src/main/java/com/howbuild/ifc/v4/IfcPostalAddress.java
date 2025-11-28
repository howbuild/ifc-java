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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpostaladdress.htm">IfcPostalAddress</a>
 */
public class IfcPostalAddress extends IfcAddress {
    protected IfcLabel internalLocation;
    protected Collection<IfcLabel> addressLines;
    protected IfcLabel postalBox;
    protected IfcLabel town;
    protected IfcLabel region;
    protected IfcLabel postalCode;
    protected IfcLabel country;


    /**
     * Constructs IfcPostalAddress with all required attributes.
     */
    public IfcPostalAddress() {

        super();
        this.addressLines = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcPostalAddress with required and optional attributes.
     */
    public IfcPostalAddress(IfcAddressTypeEnum purpose,IfcText description,IfcLabel userDefinedPurpose,IfcLabel internalLocation,Collection<IfcLabel> addressLines,IfcLabel postalBox,IfcLabel town,IfcLabel region,IfcLabel postalCode,IfcLabel country) {
        super(purpose,description,userDefinedPurpose);
        this.internalLocation = internalLocation;
        this.addressLines = addressLines;
        this.postalBox = postalBox;
        this.town = town;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
    }
    private void initCollections() {
        this.addressLines = new ArrayList<>();
    }
    public IfcLabel getInternalLocation() { return this.internalLocation; }
    public void setInternalLocation(IfcLabel value) { this.internalLocation = value; } // optional
    public Collection<IfcLabel> getAddressLines() { return this.addressLines; }
    public void setAddressLines(Collection<IfcLabel> value) { this.addressLines = value; } // optional
    public IfcLabel getPostalBox() { return this.postalBox; }
    public void setPostalBox(IfcLabel value) { this.postalBox = value; } // optional
    public IfcLabel getTown() { return this.town; }
    public void setTown(IfcLabel value) { this.town = value; } // optional
    public IfcLabel getRegion() { return this.region; }
    public void setRegion(IfcLabel value) { this.region = value; } // optional
    public IfcLabel getPostalCode() { return this.postalCode; }
    public void setPostalCode(IfcLabel value) { this.postalCode = value; } // optional
    public IfcLabel getCountry() { return this.country; }
    public void setCountry(IfcLabel value) { this.country = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(purpose));
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(userDefinedPurpose != null ? StepUtils.toStepValue(userDefinedPurpose) : "$");
		parameters.add(internalLocation != null ? StepUtils.toStepValue(internalLocation) : "$");
		parameters.add(addressLines != null ? StepUtils.toStepValue(addressLines) : "$");
		parameters.add(postalBox != null ? StepUtils.toStepValue(postalBox) : "$");
		parameters.add(town != null ? StepUtils.toStepValue(town) : "$");
		parameters.add(region != null ? StepUtils.toStepValue(region) : "$");
		parameters.add(postalCode != null ? StepUtils.toStepValue(postalCode) : "$");
		parameters.add(country != null ? StepUtils.toStepValue(country) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}