package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianPointList
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCartesianPointList2D
 * ,IfcCartesianPointList3D))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DERIVE
 * Dim : IfcDimensionCount := IfcPointListDim(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesianpointlist.htm">IfcCartesianPointList</a>
 */
public abstract class IfcCartesianPointList extends IfcGeometricRepresentationItem {


    /**
     * Constructs IfcCartesianPointList with all required attributes.
     */
    public IfcCartesianPointList() {
        super();
        initCollections();
    }
    private void initCollections() {
    }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}