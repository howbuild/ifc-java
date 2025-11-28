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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestylewithtextures.htm">IfcSurfaceStyleWithTextures</a>
 */
public class IfcSurfaceStyleWithTextures extends IfcPresentationItem implements IfcSurfaceStyleElementSelect {
    protected Collection<IfcSurfaceTexture> textures;

    protected IfcSurfaceStyleWithTextures() { initCollections(); }
    /**
     * Constructs IfcSurfaceStyleWithTextures with all required attributes.
     */
    public IfcSurfaceStyleWithTextures(Collection<IfcSurfaceTexture> textures) {
        super();
        this.textures = textures;
    }
    private void initCollections() {
        this.textures = new ArrayList<>();
    }
    public Collection<IfcSurfaceTexture> getTextures() { return this.textures; }
    public void setTextures(Collection<IfcSurfaceTexture> value) { this.textures = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(textures != null ? StepUtils.toStepValue(textures) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcSurfaceStyleWithTexturesRelationship(); }
    private void setIfcSurfaceStyleWithTexturesRelationship() {
		if (this.textures != null) {
		    for (Object x : this.textures) {
		        if (x instanceof IfcSurfaceTexture)
		            ((IfcSurfaceTexture)x).usedInStyles.add(this);
		    }
		}
    }
}