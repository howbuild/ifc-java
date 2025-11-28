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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightsource.htm">IfcLightSource</a>
 */
public abstract class IfcLightSource extends IfcGeometricRepresentationItem {
    protected IfcLabel name;
    protected IfcColourRgb lightColour;
    protected IfcNormalisedRatioMeasure ambientIntensity;
    protected IfcNormalisedRatioMeasure intensity;

    protected IfcLightSource() { initCollections(); }
    /**
     * Constructs IfcLightSource with all required attributes.
     */
    public IfcLightSource(IfcColourRgb lightColour) {

        super();
        this.lightColour = lightColour;
    }
    /**
     * Constructs IfcLightSource with required and optional attributes.
     */
    public IfcLightSource(IfcLabel name,IfcColourRgb lightColour,IfcNormalisedRatioMeasure ambientIntensity,IfcNormalisedRatioMeasure intensity) {
        super();
        this.name = name;
        this.lightColour = lightColour;
        this.ambientIntensity = ambientIntensity;
        this.intensity = intensity;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcColourRgb getLightColour() { return this.lightColour; }
    public void setLightColour(IfcColourRgb value) { this.lightColour = value; }
    public IfcNormalisedRatioMeasure getAmbientIntensity() { return this.ambientIntensity; }
    public void setAmbientIntensity(IfcNormalisedRatioMeasure value) { this.ambientIntensity = value; } // optional
    public IfcNormalisedRatioMeasure getIntensity() { return this.intensity; }
    public void setIntensity(IfcNormalisedRatioMeasure value) { this.intensity = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}