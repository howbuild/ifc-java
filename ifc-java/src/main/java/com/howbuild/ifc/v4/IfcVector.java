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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvector.htm">IfcVector</a>
 */
public class IfcVector extends IfcGeometricRepresentationItem implements IfcVectorOrDirection, IfcHatchLineDistanceSelect {
    protected IfcDirection orientation;
    protected IfcLengthMeasure magnitude;

    protected IfcVector() { initCollections(); }
    /**
     * Constructs IfcVector with all required attributes.
     */
    public IfcVector(IfcDirection orientation,IfcLengthMeasure magnitude) {
        super();
        this.orientation = orientation;
        this.magnitude = magnitude;
    }
    private void initCollections() {
    }
    public IfcDirection getOrientation() { return this.orientation; }
    public void setOrientation(IfcDirection value) { this.orientation = value; }
    public IfcLengthMeasure getMagnitude() { return this.magnitude; }
    public void setMagnitude(IfcLengthMeasure value) { this.magnitude = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(orientation != null ? StepUtils.toStepValue(orientation) : "$");
		parameters.add(magnitude != null ? StepUtils.toStepValue(magnitude) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}