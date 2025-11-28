package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcIndexedTextureMap
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcIndexedTriangleTextureMap))
 * SUBTYPE OF (IfcTextureCoordinate);
 * MappedTo : IfcTessellatedFaceSet;
 * TexCoords : IfcTextureVertexList;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcindexedtexturemap.htm">IfcIndexedTextureMap</a>
 */
public abstract class IfcIndexedTextureMap extends IfcTextureCoordinate {
    protected IfcTessellatedFaceSet mappedTo;
    protected IfcTextureVertexList texCoords;

    protected IfcIndexedTextureMap() { initCollections(); }
    /**
     * Constructs IfcIndexedTextureMap with all required attributes.
     */
    public IfcIndexedTextureMap(Collection<IfcSurfaceTexture> maps,IfcTessellatedFaceSet mappedTo,IfcTextureVertexList texCoords) {
        super(maps);
        this.mappedTo = mappedTo;
        this.texCoords = texCoords;
    }
    private void initCollections() {
    }
    public IfcTessellatedFaceSet getMappedTo() { return this.mappedTo; }
    public void setMappedTo(IfcTessellatedFaceSet value) { this.mappedTo = value; }
    public IfcTextureVertexList getTexCoords() { return this.texCoords; }
    public void setTexCoords(IfcTextureVertexList value) { this.texCoords = value; }


    @Override public void finalizeRelationships() { this.setIfcIndexedTextureMapRelationship(); }
    private void setIfcIndexedTextureMapRelationship() {
		if (this.mappedTo != null) {
		    if (this.mappedTo instanceof IfcTessellatedFaceSet)
		        ((IfcTessellatedFaceSet)this.mappedTo).hasTextures.add(this);
		}
    }
}