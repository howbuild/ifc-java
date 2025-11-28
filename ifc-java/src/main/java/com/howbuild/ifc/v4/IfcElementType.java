package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBeamType
 * ,IfcBuildingElementProxyType
 * ,IfcChimneyType
 * ,IfcColumnType
 * ,IfcCoveringType
 * ,IfcCurtainWallType
 * ,IfcDoorType
 * ,IfcFootingType
 * ,IfcMemberType
 * ,IfcPileType
 * ,IfcPlateType
 * ,IfcRailingType
 * ,IfcRampFlightType
 * ,IfcRampType
 * ,IfcRoofType
 * ,IfcShadingDeviceType
 * ,IfcSlabType
 * ,IfcStairFlightType
 * ,IfcStairType
 * ,IfcWallType
 * ,IfcWindowType))
 * SUBTYPE OF (IfcElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelementtype.htm">IfcElementType</a>
 */
public abstract class IfcElementType extends IfcTypeProduct {
    protected IfcLabel elementType;

    protected IfcElementType() { initCollections(); }
    /**
     * Constructs IfcElementType with all required attributes.
     */
    public IfcElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcElementType with required and optional attributes.
     */
    public IfcElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag);
        this.elementType = elementType;
    }
    private void initCollections() {
    }
    public IfcLabel getElementType() { return this.elementType; }
    public void setElementType(IfcLabel value) { this.elementType = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}