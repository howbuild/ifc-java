package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSeamCurve
 * SUBTYPE OF (IfcSurfaceCurve);
 * WHERE
 * TwoPCurves : SIZEOF(SELF\IfcSurfaceCurve.AssociatedGeometry) = 2;
 * SameSurface : IfcAssociatedSurface(SELF\IfcSurfaceCurve.AssociatedGeometry[1]) = IfcAssociatedSurface(SELF\IfcSurfaceCurve.AssociatedGeometry[2]);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcseamcurve.htm">IfcSeamCurve</a>
 */
public class IfcSeamCurve extends IfcSurfaceCurve {

    protected IfcSeamCurve() { initCollections(); }
    /**
     * Constructs IfcSeamCurve with all required attributes.
     */
    public IfcSeamCurve(IfcCurve curve3D,Collection<IfcPcurve> associatedGeometry,IfcPreferredSurfaceCurveRepresentation masterRepresentation) {
        super(curve3D,associatedGeometry,masterRepresentation);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(curve3D != null ? StepUtils.toStepValue(curve3D) : "$");
		parameters.add(associatedGeometry != null ? StepUtils.toStepValue(associatedGeometry) : "$");
		parameters.add(masterRepresentation != null ? StepUtils.toStepValue(masterRepresentation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}