package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGeometricCurveSet
 * SUBTYPE OF (IfcGeometricSet);
 * WHERE
 * NoSurfaces : SIZEOF(QUERY(Temp <* SELF\IfcGeometricSet.Elements |
 * 'IFC4.IFCSURFACE' IN TYPEOF(Temp))) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgeometriccurveset.htm">IfcGeometricCurveSet</a>
 */
public class IfcGeometricCurveSet extends IfcGeometricSet {

    protected IfcGeometricCurveSet() { initCollections(); }
    /**
     * Constructs IfcGeometricCurveSet with all required attributes.
     */
    public IfcGeometricCurveSet(Collection<IfcGeometricSetSelect> elements) {
        super(elements);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(elements != null ? StepUtils.toStepValue(elements) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}