package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundedCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineCurve
 * ,IfcCompositeCurve
 * ,IfcIndexedPolyCurve
 * ,IfcPolyline
 * ,IfcTrimmedCurve))
 * SUBTYPE OF (IfcCurve);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurve.htm">IfcCurve</a>
 */
public abstract class IfcCurve extends IfcGeometricRepresentationItem implements IfcGeometricSetSelect {


    /**
     * Constructs IfcCurve with all required attributes.
     */
    public IfcCurve() {
        super();
        initCollections();
    }
    private void initCollections() {
    }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}