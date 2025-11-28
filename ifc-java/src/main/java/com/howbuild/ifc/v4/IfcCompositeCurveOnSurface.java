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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccompositecurveonsurface.htm">IfcCompositeCurveOnSurface</a>
 */
public class IfcCompositeCurveOnSurface extends IfcCompositeCurve implements IfcCurveOnSurface {

    protected IfcCompositeCurveOnSurface() { initCollections(); }
    /**
     * Constructs IfcCompositeCurveOnSurface with all required attributes.
     */
    public IfcCompositeCurveOnSurface(Collection<IfcCompositeCurveSegment> segments,IfcLogical selfIntersect) {
        super(segments,selfIntersect);
    }
    private void initCollections() {
    }
    public Collection<IfcSurface> getBasisSurface() { throw new UnsupportedOperationException("Derived property logic has been implemented for BasisSurface."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(segments != null ? StepUtils.toStepValue(segments) : "$");
		parameters.add(selfIntersect != null ? StepUtils.toStepValue(selfIntersect) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}