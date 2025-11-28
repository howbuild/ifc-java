package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTextureCoordinate
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcIndexedTextureMap
 * ,IfcTextureCoordinateGenerator
 * ,IfcTextureMap))
 * SUBTYPE OF (IfcPresentationItem);
 * Maps : LIST [1:?] OF IfcSurfaceTexture;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctexturemap.htm">IfcTextureMap</a>
 */
public class IfcTextureMap extends IfcTextureCoordinate {
    protected Collection<IfcTextureVertex> vertices;
    protected IfcFace mappedTo;

    protected IfcTextureMap() { initCollections(); }
    /**
     * Constructs IfcTextureMap with all required attributes.
     */
    public IfcTextureMap(Collection<IfcSurfaceTexture> maps,Collection<IfcTextureVertex> vertices,IfcFace mappedTo) {
        super(maps);
        this.vertices = vertices;
        this.mappedTo = mappedTo;
    }
    private void initCollections() {
        this.vertices = new ArrayList<>();
    }
    public Collection<IfcTextureVertex> getVertices() { return this.vertices; }
    public void setVertices(Collection<IfcTextureVertex> value) { this.vertices = value; }
    public IfcFace getMappedTo() { return this.mappedTo; }
    public void setMappedTo(IfcFace value) { this.mappedTo = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(maps != null ? StepUtils.toStepValue(maps) : "$");
		parameters.add(vertices != null ? StepUtils.toStepValue(vertices) : "$");
		parameters.add(mappedTo != null ? StepUtils.toStepValue(mappedTo) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcTextureMapRelationship(); }
    private void setIfcTextureMapRelationship() {
		if (this.mappedTo != null) {
		    if (this.mappedTo instanceof IfcFace)
		        ((IfcFace)this.mappedTo).hasTextureMaps.add(this);
		}
    }
}