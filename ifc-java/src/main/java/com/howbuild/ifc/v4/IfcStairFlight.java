package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBeam
 * ,IfcBuildingElementProxy
 * ,IfcChimney
 * ,IfcColumn
 * ,IfcCovering
 * ,IfcCurtainWall
 * ,IfcDoor
 * ,IfcFooting
 * ,IfcMember
 * ,IfcPile
 * ,IfcPlate
 * ,IfcRailing
 * ,IfcRamp
 * ,IfcRampFlight
 * ,IfcRoof
 * ,IfcShadingDevice
 * ,IfcSlab
 * ,IfcStair
 * ,IfcStairFlight
 * ,IfcWall
 * ,IfcWindow))
 * SUBTYPE OF (IfcElement);
 * WHERE
 * MaxOneMaterialAssociation : SIZEOF (QUERY(temp <* SELF\IfcObjectDefinition.HasAssociations |
 * 'IFC4.IFCRELASSOCIATESMATERIAL' IN TYPEOF(temp)
 * )) <= 1;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstairflight.htm">IfcStairFlight</a>
 */
public class IfcStairFlight extends IfcBuildingElement {
    protected IfcInteger numberOfRisers;
    protected IfcInteger numberOfTreads;
    protected IfcPositiveLengthMeasure riserHeight;
    protected IfcPositiveLengthMeasure treadLength;
    protected IfcStairFlightTypeEnum predefinedType;

    protected IfcStairFlight() { initCollections(); }
    /**
     * Constructs IfcStairFlight with all required attributes.
     */
    public IfcStairFlight(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcStairFlight with required and optional attributes.
     */
    public IfcStairFlight(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcInteger numberOfRisers,IfcInteger numberOfTreads,IfcPositiveLengthMeasure riserHeight,IfcPositiveLengthMeasure treadLength,IfcStairFlightTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.numberOfRisers = numberOfRisers;
        this.numberOfTreads = numberOfTreads;
        this.riserHeight = riserHeight;
        this.treadLength = treadLength;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcInteger getNumberOfRisers() { return this.numberOfRisers; }
    public void setNumberOfRisers(IfcInteger value) { this.numberOfRisers = value; } // optional
    public IfcInteger getNumberOfTreads() { return this.numberOfTreads; }
    public void setNumberOfTreads(IfcInteger value) { this.numberOfTreads = value; } // optional
    public IfcPositiveLengthMeasure getRiserHeight() { return this.riserHeight; }
    public void setRiserHeight(IfcPositiveLengthMeasure value) { this.riserHeight = value; } // optional
    public IfcPositiveLengthMeasure getTreadLength() { return this.treadLength; }
    public void setTreadLength(IfcPositiveLengthMeasure value) { this.treadLength = value; } // optional
    public IfcStairFlightTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcStairFlightTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(numberOfRisers != null ? StepUtils.toStepValue(numberOfRisers) : "$");
		parameters.add(numberOfTreads != null ? StepUtils.toStepValue(numberOfTreads) : "$");
		parameters.add(riserHeight != null ? StepUtils.toStepValue(riserHeight) : "$");
		parameters.add(treadLength != null ? StepUtils.toStepValue(treadLength) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}