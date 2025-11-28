package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFaceBound
 * SUPERTYPE OF (ONEOF
 * (IfcFaceOuterBound))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * Bound : IfcLoop;
 * Orientation : IfcBoolean;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfacebound.htm">IfcFaceBound</a>
 */
public class IfcFaceBound extends IfcTopologicalRepresentationItem {
    protected IfcLoop bound;
    protected IfcBoolean orientation;

    protected IfcFaceBound() { initCollections(); }
    /**
     * Constructs IfcFaceBound with all required attributes.
     */
    public IfcFaceBound(IfcLoop bound,IfcBoolean orientation) {
        super();
        this.bound = bound;
        this.orientation = orientation;
    }
    private void initCollections() {
    }
    public IfcLoop getBound() { return this.bound; }
    public void setBound(IfcLoop value) { this.bound = value; }
    public IfcBoolean getOrientation() { return this.orientation; }
    public void setOrientation(IfcBoolean value) { this.orientation = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(bound != null ? StepUtils.toStepValue(bound) : "$");
		parameters.add(orientation != null ? StepUtils.toStepValue(orientation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}