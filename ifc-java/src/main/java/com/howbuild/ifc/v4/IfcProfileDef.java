package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcArbitraryClosedProfileDef
 * SUPERTYPE OF (ONEOF
 * (IfcArbitraryProfileDefWithVoids))
 * SUBTYPE OF (IfcProfileDef);
 * OuterCurve : IfcCurve;
 * WHERE
 * WR1 : OuterCurve.Dim = 2;
 * WR2 : NOT('IFC4.IFCLINE' IN TYPEOF(OuterCurve));
 * WR3 : NOT('IFC4.IFCOFFSETCURVE2D' IN TYPEOF(OuterCurve));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcprofiledef.htm">IfcProfileDef</a>
 */
public class IfcProfileDef extends BaseIfc implements IfcResourceObjectSelect {
    protected IfcProfileTypeEnum profileType;
    protected IfcLabel profileName;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReference;
    protected Collection<IfcProfileProperties> hasProperties;

    protected IfcProfileDef() { initCollections(); }
    /**
     * Constructs IfcProfileDef with all required attributes.
     */
    public IfcProfileDef(IfcProfileTypeEnum profileType) {

        super();
        this.hasExternalReference = new ArrayList<>();
        this.hasProperties = new ArrayList<>();
        this.profileType = profileType;
    }
    /**
     * Constructs IfcProfileDef with required and optional attributes.
     */
    public IfcProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName) {
        super();
        this.hasExternalReference = new ArrayList<>();
        this.hasProperties = new ArrayList<>();
        this.profileType = profileType;
        this.profileName = profileName;
    }
    private void initCollections() {
        this.hasExternalReference = new ArrayList<>();
        this.hasProperties = new ArrayList<>();
    }
    public IfcProfileTypeEnum getProfileType() { return this.profileType; }
    public void setProfileType(IfcProfileTypeEnum value) { this.profileType = value; }
    public IfcLabel getProfileName() { return this.profileName; }
    public void setProfileName(IfcLabel value) { this.profileName = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReference() { return this.hasExternalReference; }
    public void setHasExternalReference(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReference = value; } // inverse
    public Collection<IfcProfileProperties> getHasProperties() { return this.hasProperties; }
    public void setHasProperties(Collection<IfcProfileProperties> value) { this.hasProperties = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}