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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfaceouterbound.htm">IfcFaceOuterBound</a>
 */
public class IfcFaceOuterBound extends IfcFaceBound {

    protected IfcFaceOuterBound() { initCollections(); }
    /**
     * Constructs IfcFaceOuterBound with all required attributes.
     */
    public IfcFaceOuterBound(IfcLoop bound,IfcBoolean orientation) {
        super(bound,orientation);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(bound != null ? StepUtils.toStepValue(bound) : "$");
		parameters.add(orientation != null ? StepUtils.toStepValue(orientation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}