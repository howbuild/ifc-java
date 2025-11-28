package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundaryCurve
 * SUPERTYPE OF (ONEOF
 * (IfcOuterBoundaryCurve))
 * SUBTYPE OF (IfcCompositeCurveOnSurface);
 * WHERE
 * IsClosed : SELF\IfcCompositeCurve.ClosedCurve;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcouterboundarycurve.htm">IfcOuterBoundaryCurve</a>
 */
public class IfcOuterBoundaryCurve extends IfcBoundaryCurve {

    protected IfcOuterBoundaryCurve() { initCollections(); }
    /**
     * Constructs IfcOuterBoundaryCurve with all required attributes.
     */
    public IfcOuterBoundaryCurve(Collection<IfcCompositeCurveSegment> segments,IfcLogical selfIntersect) {
        super(segments,selfIntersect);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(segments != null ? StepUtils.toStepValue(segments) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}