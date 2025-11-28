package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSpatialElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcSpatialStructureElementType
 * ,IfcSpatialZoneType))
 * SUBTYPE OF (IfcTypeProduct);
 * ElementType : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspatialzonetype.htm">IfcSpatialZoneType</a>
 */
public class IfcSpatialZoneType extends IfcSpatialElementType {
    protected IfcSpatialZoneTypeEnum predefinedType;
    protected IfcLabel longName;

    protected IfcSpatialZoneType() { initCollections(); }
    /**
     * Constructs IfcSpatialZoneType with all required attributes.
     */
    public IfcSpatialZoneType(IfcGloballyUniqueId globalId,IfcSpatialZoneTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcSpatialZoneType with required and optional attributes.
     */
    public IfcSpatialZoneType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcSpatialZoneTypeEnum predefinedType,IfcLabel longName) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.longName = longName;
    }
    private void initCollections() {
    }
    public IfcSpatialZoneTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSpatialZoneTypeEnum value) { this.predefinedType = value; }
    public IfcLabel getLongName() { return this.longName; }
    public void setLongName(IfcLabel value) { this.longName = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}