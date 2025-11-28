package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFurnishingElementType
 * SUPERTYPE OF (ONEOF
 * (IfcFurnitureType
 * ,IfcSystemFurnitureElementType))
 * SUBTYPE OF (IfcElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfurnituretype.htm">IfcFurnitureType</a>
 */
public class IfcFurnitureType extends IfcFurnishingElementType {
    protected IfcAssemblyPlaceEnum assemblyPlace;
    protected IfcFurnitureTypeEnum predefinedType;

    protected IfcFurnitureType() { initCollections(); }
    /**
     * Constructs IfcFurnitureType with all required attributes.
     */
    public IfcFurnitureType(IfcGloballyUniqueId globalId,IfcAssemblyPlaceEnum assemblyPlace) {

        super(globalId);
        this.assemblyPlace = assemblyPlace;
    }
    /**
     * Constructs IfcFurnitureType with required and optional attributes.
     */
    public IfcFurnitureType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcAssemblyPlaceEnum assemblyPlace,IfcFurnitureTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.assemblyPlace = assemblyPlace;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcAssemblyPlaceEnum getAssemblyPlace() { return this.assemblyPlace; }
    public void setAssemblyPlace(IfcAssemblyPlaceEnum value) { this.assemblyPlace = value; }
    public IfcFurnitureTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcFurnitureTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(representationMaps != null ? StepUtils.toStepValue(representationMaps) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(elementType != null ? StepUtils.toStepValue(elementType) : "$");
		parameters.add(StepUtils.toStepValue(assemblyPlace));
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}