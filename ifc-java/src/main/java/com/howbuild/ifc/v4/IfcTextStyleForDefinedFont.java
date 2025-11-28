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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctextstylefordefinedfont.htm">IfcTextStyleForDefinedFont</a>
 */
public class IfcTextStyleForDefinedFont extends IfcPresentationItem {
    protected IfcColour colour;
    protected IfcColour backgroundColour;

    protected IfcTextStyleForDefinedFont() { initCollections(); }
    /**
     * Constructs IfcTextStyleForDefinedFont with all required attributes.
     */
    public IfcTextStyleForDefinedFont(IfcColour colour) {

        super();
        this.colour = colour;
    }
    /**
     * Constructs IfcTextStyleForDefinedFont with required and optional attributes.
     */
    public IfcTextStyleForDefinedFont(IfcColour colour,IfcColour backgroundColour) {
        super();
        this.colour = colour;
        this.backgroundColour = backgroundColour;
    }
    private void initCollections() {
    }
    public IfcColour getColour() { return this.colour; }
    public void setColour(IfcColour value) { this.colour = value; }
    public IfcColour getBackgroundColour() { return this.backgroundColour; }
    public void setBackgroundColour(IfcColour value) { this.backgroundColour = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(colour != null ? StepUtils.toStepValue(colour) : "$");
		parameters.add(backgroundColour != null ? StepUtils.toStepValue(backgroundColour) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}