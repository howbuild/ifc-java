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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestylelighting.htm">IfcSurfaceStyleLighting</a>
 */
public class IfcSurfaceStyleLighting extends IfcPresentationItem implements IfcSurfaceStyleElementSelect {
    protected IfcColourRgb diffuseTransmissionColour;
    protected IfcColourRgb diffuseReflectionColour;
    protected IfcColourRgb transmissionColour;
    protected IfcColourRgb reflectanceColour;

    protected IfcSurfaceStyleLighting() { initCollections(); }
    /**
     * Constructs IfcSurfaceStyleLighting with all required attributes.
     */
    public IfcSurfaceStyleLighting(IfcColourRgb diffuseTransmissionColour,IfcColourRgb diffuseReflectionColour,IfcColourRgb transmissionColour,IfcColourRgb reflectanceColour) {
        super();
        this.diffuseTransmissionColour = diffuseTransmissionColour;
        this.diffuseReflectionColour = diffuseReflectionColour;
        this.transmissionColour = transmissionColour;
        this.reflectanceColour = reflectanceColour;
    }
    private void initCollections() {
    }
    public IfcColourRgb getDiffuseTransmissionColour() { return this.diffuseTransmissionColour; }
    public void setDiffuseTransmissionColour(IfcColourRgb value) { this.diffuseTransmissionColour = value; }
    public IfcColourRgb getDiffuseReflectionColour() { return this.diffuseReflectionColour; }
    public void setDiffuseReflectionColour(IfcColourRgb value) { this.diffuseReflectionColour = value; }
    public IfcColourRgb getTransmissionColour() { return this.transmissionColour; }
    public void setTransmissionColour(IfcColourRgb value) { this.transmissionColour = value; }
    public IfcColourRgb getReflectanceColour() { return this.reflectanceColour; }
    public void setReflectanceColour(IfcColourRgb value) { this.reflectanceColour = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(diffuseTransmissionColour != null ? StepUtils.toStepValue(diffuseTransmissionColour) : "$");
		parameters.add(diffuseReflectionColour != null ? StepUtils.toStepValue(diffuseReflectionColour) : "$");
		parameters.add(transmissionColour != null ? StepUtils.toStepValue(transmissionColour) : "$");
		parameters.add(reflectanceColour != null ? StepUtils.toStepValue(reflectanceColour) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}