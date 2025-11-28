package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAnnotationFillArea
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * OuterBoundary : IfcCurve;
 * InnerBoundaries : OPTIONAL SET [1:?] OF IfcCurve;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgeometricrepresentationitem.htm">IfcGeometricRepresentationItem</a>
 */
public abstract class IfcGeometricRepresentationItem extends IfcRepresentationItem {


    /**
     * Constructs IfcGeometricRepresentationItem with all required attributes.
     */
    public IfcGeometricRepresentationItem() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}