package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundedSurface
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineSurface
 * ,IfcCurveBoundedPlane
 * ,IfcCurveBoundedSurface
 * ,IfcRectangularTrimmedSurface))
 * SUBTYPE OF (IfcSurface);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurface.htm">IfcSurface</a>
 */
public abstract class IfcSurface extends IfcGeometricRepresentationItem implements IfcGeometricSetSelect, IfcSurfaceOrFaceSurface {


    /**
     * Constructs IfcSurface with all required attributes.
     */
    public IfcSurface() {
        super();
        initCollections();
    }
    private void initCollections() {
    }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}