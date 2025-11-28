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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcplanarextent.htm">IfcPlanarExtent</a>
 */
public class IfcPlanarExtent extends IfcGeometricRepresentationItem {
    protected IfcLengthMeasure sizeInX;
    protected IfcLengthMeasure sizeInY;

    protected IfcPlanarExtent() { initCollections(); }
    /**
     * Constructs IfcPlanarExtent with all required attributes.
     */
    public IfcPlanarExtent(IfcLengthMeasure sizeInX,IfcLengthMeasure sizeInY) {
        super();
        this.sizeInX = sizeInX;
        this.sizeInY = sizeInY;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getSizeInX() { return this.sizeInX; }
    public void setSizeInX(IfcLengthMeasure value) { this.sizeInX = value; }
    public IfcLengthMeasure getSizeInY() { return this.sizeInY; }
    public void setSizeInY(IfcLengthMeasure value) { this.sizeInY = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sizeInX != null ? StepUtils.toStepValue(sizeInX) : "$");
		parameters.add(sizeInY != null ? StepUtils.toStepValue(sizeInY) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}