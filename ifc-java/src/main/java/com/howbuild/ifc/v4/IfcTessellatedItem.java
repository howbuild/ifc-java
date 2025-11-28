package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGeometricRepresentationItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcAnnotationFillArea
 * ,IfcBooleanResult
 * ,IfcBoundingBox
 * ,IfcCartesianPointList
 * ,IfcCartesianTransformationOperator
 * ,IfcCompositeCurveSegment
 * ,IfcCsgPrimitive3D
 * ,IfcCurve
 * ,IfcDirection
 * ,IfcFaceBasedSurfaceModel
 * ,IfcFillAreaStyleHatching
 * ,IfcFillAreaStyleTiles
 * ,IfcGeometricSet
 * ,IfcHalfSpaceSolid
 * ,IfcLightSource
 * ,IfcPlacement
 * ,IfcPlanarExtent
 * ,IfcPoint
 * ,IfcSectionedSpine
 * ,IfcShellBasedSurfaceModel
 * ,IfcSolidModel
 * ,IfcSurface
 * ,IfcTessellatedItem
 * ,IfcTextLiteral
 * ,IfcVector))
 * SUBTYPE OF (IfcRepresentationItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctessellateditem.htm">IfcTessellatedItem</a>
 */
public abstract class IfcTessellatedItem extends IfcGeometricRepresentationItem {


    /**
     * Constructs IfcTessellatedItem with all required attributes.
     */
    public IfcTessellatedItem() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}