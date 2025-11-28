package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGridPlacement
 * SUBTYPE OF (IfcObjectPlacement);
 * PlacementLocation : IfcVirtualGridIntersection;
 * PlacementRefDirection : OPTIONAL IfcGridPlacementDirectionSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcobjectplacement.htm">IfcObjectPlacement</a>
 */
public abstract class IfcObjectPlacement extends BaseIfc {
    protected Collection<IfcProduct> placesObject;
    protected Collection<IfcLocalPlacement> referencedByPlacements;


    /**
     * Constructs IfcObjectPlacement with all required attributes.
     */
    public IfcObjectPlacement() {
        super();
        this.placesObject = new ArrayList<>();
        this.referencedByPlacements = new ArrayList<>();
        initCollections();
    }
    private void initCollections() {
        this.placesObject = new ArrayList<>();
        this.referencedByPlacements = new ArrayList<>();
    }
    public Collection<IfcProduct> getPlacesObject() { return this.placesObject; }
    public void setPlacesObject(Collection<IfcProduct> value) { this.placesObject = value; } // inverse
    public Collection<IfcLocalPlacement> getReferencedByPlacements() { return this.referencedByPlacements; }
    public void setReferencedByPlacements(Collection<IfcLocalPlacement> value) { this.referencedByPlacements = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}