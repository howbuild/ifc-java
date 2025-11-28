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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestylerefraction.htm">IfcSurfaceStyleRefraction</a>
 */
public class IfcSurfaceStyleRefraction extends IfcPresentationItem implements IfcSurfaceStyleElementSelect {
    protected IfcReal refractionIndex;
    protected IfcReal dispersionFactor;


    /**
     * Constructs IfcSurfaceStyleRefraction with all required attributes.
     */
    public IfcSurfaceStyleRefraction() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcSurfaceStyleRefraction with required and optional attributes.
     */
    public IfcSurfaceStyleRefraction(IfcReal refractionIndex,IfcReal dispersionFactor) {
        super();
        this.refractionIndex = refractionIndex;
        this.dispersionFactor = dispersionFactor;
    }
    private void initCollections() {
    }
    public IfcReal getRefractionIndex() { return this.refractionIndex; }
    public void setRefractionIndex(IfcReal value) { this.refractionIndex = value; } // optional
    public IfcReal getDispersionFactor() { return this.dispersionFactor; }
    public void setDispersionFactor(IfcReal value) { this.dispersionFactor = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(refractionIndex != null ? StepUtils.toStepValue(refractionIndex) : "$");
		parameters.add(dispersionFactor != null ? StepUtils.toStepValue(dispersionFactor) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}