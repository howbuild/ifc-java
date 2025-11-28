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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctexturevertexlist.htm">IfcTextureVertexList</a>
 */
public class IfcTextureVertexList extends IfcPresentationItem {
    protected Collection<Collection<IfcParameterValue>> texCoordsList;

    protected IfcTextureVertexList() { initCollections(); }
    /**
     * Constructs IfcTextureVertexList with all required attributes.
     */
    public IfcTextureVertexList(Collection<Collection<IfcParameterValue>> texCoordsList) {
        super();
        this.texCoordsList = texCoordsList;
    }
    private void initCollections() {
        this.texCoordsList = new ArrayList<>();
    }
    public Collection<Collection<IfcParameterValue>> getTexCoordsList() { return this.texCoordsList; }
    public void setTexCoordsList(Collection<Collection<IfcParameterValue>> value) { this.texCoordsList = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(texCoordsList != null ? StepUtils.toStepValue(texCoordsList) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}