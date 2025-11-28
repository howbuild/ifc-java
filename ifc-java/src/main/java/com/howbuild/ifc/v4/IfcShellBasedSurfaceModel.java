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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcshellbasedsurfacemodel.htm">IfcShellBasedSurfaceModel</a>
 */
public class IfcShellBasedSurfaceModel extends IfcGeometricRepresentationItem {
    protected Collection<IfcShell> sbsmBoundary;

    protected IfcShellBasedSurfaceModel() { initCollections(); }
    /**
     * Constructs IfcShellBasedSurfaceModel with all required attributes.
     */
    public IfcShellBasedSurfaceModel(Collection<IfcShell> sbsmBoundary) {
        super();
        this.sbsmBoundary = sbsmBoundary;
    }
    private void initCollections() {
        this.sbsmBoundary = new ArrayList<>();
    }
    public Collection<IfcShell> getSbsmBoundary() { return this.sbsmBoundary; }
    public void setSbsmBoundary(Collection<IfcShell> value) { this.sbsmBoundary = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sbsmBoundary != null ? StepUtils.toStepValue(sbsmBoundary) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}