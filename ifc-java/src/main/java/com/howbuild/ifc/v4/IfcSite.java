package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSite
 * SUBTYPE OF (IfcSpatialStructureElement);
 * RefLatitude : OPTIONAL IfcCompoundPlaneAngleMeasure;
 * RefLongitude : OPTIONAL IfcCompoundPlaneAngleMeasure;
 * RefElevation : OPTIONAL IfcLengthMeasure;
 * LandTitleNumber : OPTIONAL IfcLabel;
 * SiteAddress : OPTIONAL IfcPostalAddress;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsite.htm">IfcSite</a>
 */
public class IfcSite extends IfcSpatialStructureElement {
    protected IfcCompoundPlaneAngleMeasure refLatitude;
    protected IfcCompoundPlaneAngleMeasure refLongitude;
    protected IfcLengthMeasure refElevation;
    protected IfcLabel landTitleNumber;
    protected IfcPostalAddress siteAddress;

    protected IfcSite() { initCollections(); }
    /**
     * Constructs IfcSite with all required attributes.
     */
    public IfcSite(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSite with required and optional attributes.
     */
    public IfcSite(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcElementCompositionEnum compositionType,IfcCompoundPlaneAngleMeasure refLatitude,IfcCompoundPlaneAngleMeasure refLongitude,IfcLengthMeasure refElevation,IfcLabel landTitleNumber,IfcPostalAddress siteAddress) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName,compositionType);
        this.refLatitude = refLatitude;
        this.refLongitude = refLongitude;
        this.refElevation = refElevation;
        this.landTitleNumber = landTitleNumber;
        this.siteAddress = siteAddress;
    }
    private void initCollections() {
    }
    public IfcCompoundPlaneAngleMeasure getRefLatitude() { return this.refLatitude; }
    public void setRefLatitude(IfcCompoundPlaneAngleMeasure value) { this.refLatitude = value; } // optional
    public IfcCompoundPlaneAngleMeasure getRefLongitude() { return this.refLongitude; }
    public void setRefLongitude(IfcCompoundPlaneAngleMeasure value) { this.refLongitude = value; } // optional
    public IfcLengthMeasure getRefElevation() { return this.refElevation; }
    public void setRefElevation(IfcLengthMeasure value) { this.refElevation = value; } // optional
    public IfcLabel getLandTitleNumber() { return this.landTitleNumber; }
    public void setLandTitleNumber(IfcLabel value) { this.landTitleNumber = value; } // optional
    public IfcPostalAddress getSiteAddress() { return this.siteAddress; }
    public void setSiteAddress(IfcPostalAddress value) { this.siteAddress = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
		parameters.add(StepUtils.toStepValue(compositionType));
		parameters.add(refLatitude != null ? StepUtils.toStepValue(refLatitude) : "$");
		parameters.add(refLongitude != null ? StepUtils.toStepValue(refLongitude) : "$");
		parameters.add(refElevation != null ? StepUtils.toStepValue(refElevation) : "$");
		parameters.add(landTitleNumber != null ? StepUtils.toStepValue(landTitleNumber) : "$");
		parameters.add(siteAddress != null ? StepUtils.toStepValue(siteAddress) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}