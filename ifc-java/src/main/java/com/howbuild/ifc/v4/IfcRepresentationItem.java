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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrepresentationitem.htm">IfcRepresentationItem</a>
 */
public abstract class IfcRepresentationItem extends BaseIfc implements IfcLayeredItem {
    protected Collection<IfcPresentationLayerAssignment> layerAssignment;
    protected Collection<IfcStyledItem> styledByItem;


    /**
     * Constructs IfcRepresentationItem with all required attributes.
     */
    public IfcRepresentationItem() {
        super();
        this.layerAssignment = new ArrayList<>();
        this.styledByItem = new ArrayList<>();
        initCollections();
    }
    private void initCollections() {
        this.layerAssignment = new ArrayList<>();
        this.styledByItem = new ArrayList<>();
    }
    public Collection<IfcPresentationLayerAssignment> getLayerAssignment() { return this.layerAssignment; }
    public void setLayerAssignment(Collection<IfcPresentationLayerAssignment> value) { this.layerAssignment = value; } // inverse
    public Collection<IfcStyledItem> getStyledByItem() { return this.styledByItem; }
    public void setStyledByItem(Collection<IfcStyledItem> value) { this.styledByItem = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}