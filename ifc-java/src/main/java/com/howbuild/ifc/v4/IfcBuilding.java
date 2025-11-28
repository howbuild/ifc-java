package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuilding
 * SUBTYPE OF (IfcSpatialStructureElement);
 * ElevationOfRefHeight : OPTIONAL IfcLengthMeasure;
 * ElevationOfTerrain : OPTIONAL IfcLengthMeasure;
 * BuildingAddress : OPTIONAL IfcPostalAddress;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbuilding.htm">IfcBuilding</a>
 */
public class IfcBuilding extends IfcSpatialStructureElement {
    protected IfcLengthMeasure elevationOfRefHeight;
    protected IfcLengthMeasure elevationOfTerrain;
    protected IfcPostalAddress buildingAddress;

    protected IfcBuilding() { initCollections(); }
    /**
     * Constructs IfcBuilding with all required attributes.
     */
    public IfcBuilding(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcBuilding with required and optional attributes.
     */
    public IfcBuilding(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcElementCompositionEnum compositionType,IfcLengthMeasure elevationOfRefHeight,IfcLengthMeasure elevationOfTerrain,IfcPostalAddress buildingAddress) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName,compositionType);
        this.elevationOfRefHeight = elevationOfRefHeight;
        this.elevationOfTerrain = elevationOfTerrain;
        this.buildingAddress = buildingAddress;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getElevationOfRefHeight() { return this.elevationOfRefHeight; }
    public void setElevationOfRefHeight(IfcLengthMeasure value) { this.elevationOfRefHeight = value; } // optional
    public IfcLengthMeasure getElevationOfTerrain() { return this.elevationOfTerrain; }
    public void setElevationOfTerrain(IfcLengthMeasure value) { this.elevationOfTerrain = value; } // optional
    public IfcPostalAddress getBuildingAddress() { return this.buildingAddress; }
    public void setBuildingAddress(IfcPostalAddress value) { this.buildingAddress = value; } // optional

    
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
		parameters.add(elevationOfRefHeight != null ? StepUtils.toStepValue(elevationOfRefHeight) : "$");
		parameters.add(elevationOfTerrain != null ? StepUtils.toStepValue(elevationOfTerrain) : "$");
		parameters.add(buildingAddress != null ? StepUtils.toStepValue(buildingAddress) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}