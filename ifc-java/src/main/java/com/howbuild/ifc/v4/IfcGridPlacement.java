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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgridplacement.htm">IfcGridPlacement</a>
 */
public class IfcGridPlacement extends IfcObjectPlacement {
    protected IfcVirtualGridIntersection placementLocation;
    protected IfcGridPlacementDirectionSelect placementRefDirection;

    protected IfcGridPlacement() { initCollections(); }
    /**
     * Constructs IfcGridPlacement with all required attributes.
     */
    public IfcGridPlacement(IfcVirtualGridIntersection placementLocation) {

        super();
        this.placementLocation = placementLocation;
    }
    /**
     * Constructs IfcGridPlacement with required and optional attributes.
     */
    public IfcGridPlacement(IfcVirtualGridIntersection placementLocation,IfcGridPlacementDirectionSelect placementRefDirection) {
        super();
        this.placementLocation = placementLocation;
        this.placementRefDirection = placementRefDirection;
    }
    private void initCollections() {
    }
    public IfcVirtualGridIntersection getPlacementLocation() { return this.placementLocation; }
    public void setPlacementLocation(IfcVirtualGridIntersection value) { this.placementLocation = value; }
    public IfcGridPlacementDirectionSelect getPlacementRefDirection() { return this.placementRefDirection; }
    public void setPlacementRefDirection(IfcGridPlacementDirectionSelect value) { this.placementRefDirection = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(placementLocation != null ? StepUtils.toStepValue(placementLocation) : "$");
		parameters.add(placementRefDirection != null ? StepUtils.toStepValue(placementRefDirection) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}