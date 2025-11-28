package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLocalPlacement
 * SUBTYPE OF (IfcObjectPlacement);
 * PlacementRelTo : OPTIONAL IfcObjectPlacement;
 * RelativePlacement : IfcAxis2Placement;
 * WHERE
 * WR21 : IfcCorrectLocalPlacement(RelativePlacement, PlacementRelTo);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclocalplacement.htm">IfcLocalPlacement</a>
 */
public class IfcLocalPlacement extends IfcObjectPlacement {
    protected IfcObjectPlacement placementRelTo;
    protected IfcAxis2Placement relativePlacement;

    protected IfcLocalPlacement() { initCollections(); }
    /**
     * Constructs IfcLocalPlacement with all required attributes.
     */
    public IfcLocalPlacement(IfcAxis2Placement relativePlacement) {

        super();
        this.relativePlacement = relativePlacement;
    }
    /**
     * Constructs IfcLocalPlacement with required and optional attributes.
     */
    public IfcLocalPlacement(IfcObjectPlacement placementRelTo,IfcAxis2Placement relativePlacement) {
        super();
        this.placementRelTo = placementRelTo;
        this.relativePlacement = relativePlacement;
    }
    private void initCollections() {
    }
    public IfcObjectPlacement getPlacementRelTo() { return this.placementRelTo; }
    public void setPlacementRelTo(IfcObjectPlacement value) { this.placementRelTo = value; } // optional
    public IfcAxis2Placement getRelativePlacement() { return this.relativePlacement; }
    public void setRelativePlacement(IfcAxis2Placement value) { this.relativePlacement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(placementRelTo != null ? StepUtils.toStepValue(placementRelTo) : "$");
		parameters.add(relativePlacement != null ? StepUtils.toStepValue(relativePlacement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcLocalPlacementRelationship(); }
    private void setIfcLocalPlacementRelationship() {
		if (this.placementRelTo != null) {
		    if (this.placementRelTo instanceof IfcObjectPlacement)
		        ((IfcObjectPlacement)this.placementRelTo).referencedByPlacements.add(this);
		}
    }
}