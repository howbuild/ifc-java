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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspatialstructureelement.htm">IfcSpatialStructureElement</a>
 */
public abstract class IfcSpatialStructureElement extends IfcSpatialElement {
    protected IfcElementCompositionEnum compositionType;

    protected IfcSpatialStructureElement() { initCollections(); }
    /**
     * Constructs IfcSpatialStructureElement with all required attributes.
     */
    public IfcSpatialStructureElement(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSpatialStructureElement with required and optional attributes.
     */
    public IfcSpatialStructureElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcElementCompositionEnum compositionType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName);
        this.compositionType = compositionType;
    }
    private void initCollections() {
    }
    public IfcElementCompositionEnum getCompositionType() { return this.compositionType; }
    public void setCompositionType(IfcElementCompositionEnum value) { this.compositionType = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}