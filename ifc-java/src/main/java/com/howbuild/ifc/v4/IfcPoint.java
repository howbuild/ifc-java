package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianPoint
 * SUBTYPE OF (IfcPoint);
 * Coordinates : LIST [1:3] OF IfcLengthMeasure;
 * DERIVE
 * Dim : IfcDimensionCount := HIINDEX(Coordinates);
 * WHERE
 * CP2Dor3D : HIINDEX(Coordinates) >= 2;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpoint.htm">IfcPoint</a>
 */
public abstract class IfcPoint extends IfcGeometricRepresentationItem implements IfcGeometricSetSelect, IfcPointOrVertexPoint {


    /**
     * Constructs IfcPoint with all required attributes.
     */
    public IfcPoint() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}