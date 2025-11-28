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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctexturevertex.htm">IfcTextureVertex</a>
 */
public class IfcTextureVertex extends IfcPresentationItem {
    protected Collection<IfcParameterValue> coordinates;

    protected IfcTextureVertex() { initCollections(); }
    /**
     * Constructs IfcTextureVertex with all required attributes.
     */
    public IfcTextureVertex(Collection<IfcParameterValue> coordinates) {
        super();
        this.coordinates = coordinates;
    }
    private void initCollections() {
        this.coordinates = new ArrayList<>();
    }
    public Collection<IfcParameterValue> getCoordinates() { return this.coordinates; }
    public void setCoordinates(Collection<IfcParameterValue> value) { this.coordinates = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordinates != null ? StepUtils.toStepValue(coordinates) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}