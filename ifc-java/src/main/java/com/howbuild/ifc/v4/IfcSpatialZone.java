package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSpatialElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcExternalSpatialStructureElement
 * ,IfcSpatialStructureElement
 * ,IfcSpatialZone))
 * SUBTYPE OF (IfcProduct);
 * LongName : OPTIONAL IfcLabel;
 * INVERSE
 * ContainsElements : SET [0:?] OF IfcRelContainedInSpatialStructure FOR RelatingStructure;
 * ServicedBySystems : SET [0:?] OF IfcRelServicesBuildings FOR RelatedBuildings;
 * ReferencesElements : SET [0:?] OF IfcRelReferencedInSpatialStructure FOR RelatingStructure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspatialzone.htm">IfcSpatialZone</a>
 */
public class IfcSpatialZone extends IfcSpatialElement {
    protected IfcSpatialZoneTypeEnum predefinedType;

    protected IfcSpatialZone() { initCollections(); }
    /**
     * Constructs IfcSpatialZone with all required attributes.
     */
    public IfcSpatialZone(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSpatialZone with required and optional attributes.
     */
    public IfcSpatialZone(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcSpatialZoneTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcSpatialZoneTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSpatialZoneTypeEnum value) { this.predefinedType = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}