package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPresentationItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcColourRgbList
 * ,IfcColourSpecification
 * ,IfcCurveStyleFont
 * ,IfcCurveStyleFontAndScaling
 * ,IfcCurveStyleFontPattern
 * ,IfcIndexedColourMap
 * ,IfcPreDefinedItem
 * ,IfcSurfaceStyleLighting
 * ,IfcSurfaceStyleRefraction
 * ,IfcSurfaceStyleShading
 * ,IfcSurfaceStyleWithTextures
 * ,IfcSurfaceTexture
 * ,IfcTextStyleForDefinedFont
 * ,IfcTextStyleTextModel
 * ,IfcTextureCoordinate
 * ,IfcTextureVertex
 * ,IfcTextureVertexList));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestyleshading.htm">IfcSurfaceStyleShading</a>
 */
public class IfcSurfaceStyleShading extends IfcPresentationItem implements IfcSurfaceStyleElementSelect {
    protected IfcColourRgb surfaceColour;
    protected IfcNormalisedRatioMeasure transparency;

    protected IfcSurfaceStyleShading() { initCollections(); }
    /**
     * Constructs IfcSurfaceStyleShading with all required attributes.
     */
    public IfcSurfaceStyleShading(IfcColourRgb surfaceColour) {

        super();
        this.surfaceColour = surfaceColour;
    }
    /**
     * Constructs IfcSurfaceStyleShading with required and optional attributes.
     */
    public IfcSurfaceStyleShading(IfcColourRgb surfaceColour,IfcNormalisedRatioMeasure transparency) {
        super();
        this.surfaceColour = surfaceColour;
        this.transparency = transparency;
    }
    private void initCollections() {
    }
    public IfcColourRgb getSurfaceColour() { return this.surfaceColour; }
    public void setSurfaceColour(IfcColourRgb value) { this.surfaceColour = value; }
    public IfcNormalisedRatioMeasure getTransparency() { return this.transparency; }
    public void setTransparency(IfcNormalisedRatioMeasure value) { this.transparency = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(surfaceColour != null ? StepUtils.toStepValue(surfaceColour) : "$");
		parameters.add(transparency != null ? StepUtils.toStepValue(transparency) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}