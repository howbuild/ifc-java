package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPlanarBox
 * SUBTYPE OF (IfcPlanarExtent);
 * Placement : IfcAxis2Placement;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcplanarbox.htm">IfcPlanarBox</a>
 */
public class IfcPlanarBox extends IfcPlanarExtent {
    protected IfcAxis2Placement placement;

    protected IfcPlanarBox() { initCollections(); }
    /**
     * Constructs IfcPlanarBox with all required attributes.
     */
    public IfcPlanarBox(IfcLengthMeasure sizeInX,IfcLengthMeasure sizeInY,IfcAxis2Placement placement) {
        super(sizeInX,sizeInY);
        this.placement = placement;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement getPlacement() { return this.placement; }
    public void setPlacement(IfcAxis2Placement value) { this.placement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sizeInX != null ? StepUtils.toStepValue(sizeInX) : "$");
		parameters.add(sizeInY != null ? StepUtils.toStepValue(sizeInY) : "$");
		parameters.add(placement != null ? StepUtils.toStepValue(placement) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}