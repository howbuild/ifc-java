package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingStorey
 * SUBTYPE OF (IfcSpatialStructureElement);
 * Elevation : OPTIONAL IfcLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbuildingstorey.htm">IfcBuildingStorey</a>
 */
public class IfcBuildingStorey extends IfcSpatialStructureElement {
    protected IfcLengthMeasure elevation;

    protected IfcBuildingStorey() { initCollections(); }
    /**
     * Constructs IfcBuildingStorey with all required attributes.
     */
    public IfcBuildingStorey(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcBuildingStorey with required and optional attributes.
     */
    public IfcBuildingStorey(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcElementCompositionEnum compositionType,IfcLengthMeasure elevation) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName,compositionType);
        this.elevation = elevation;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getElevation() { return this.elevation; }
    public void setElevation(IfcLengthMeasure value) { this.elevation = value; } // optional

    
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
		parameters.add(elevation != null ? StepUtils.toStepValue(elevation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}