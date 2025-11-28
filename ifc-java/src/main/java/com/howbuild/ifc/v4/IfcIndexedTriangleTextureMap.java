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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcindexedtriangletexturemap.htm">IfcIndexedTriangleTextureMap</a>
 */
public class IfcIndexedTriangleTextureMap extends IfcIndexedTextureMap {
    protected Collection<Collection<IfcPositiveInteger>> texCoordIndex;

    protected IfcIndexedTriangleTextureMap() { initCollections(); }
    /**
     * Constructs IfcIndexedTriangleTextureMap with all required attributes.
     */
    public IfcIndexedTriangleTextureMap(Collection<IfcSurfaceTexture> maps,IfcTessellatedFaceSet mappedTo,IfcTextureVertexList texCoords) {

        super(maps,mappedTo,texCoords);
        this.texCoordIndex = new ArrayList<>();
    }
    /**
     * Constructs IfcIndexedTriangleTextureMap with required and optional attributes.
     */
    public IfcIndexedTriangleTextureMap(Collection<IfcSurfaceTexture> maps,IfcTessellatedFaceSet mappedTo,IfcTextureVertexList texCoords,Collection<Collection<IfcPositiveInteger>> texCoordIndex) {
        super(maps,mappedTo,texCoords);
        this.texCoordIndex = texCoordIndex;
    }
    private void initCollections() {
        this.texCoordIndex = new ArrayList<>();
    }
    public Collection<Collection<IfcPositiveInteger>> getTexCoordIndex() { return this.texCoordIndex; }
    public void setTexCoordIndex(Collection<Collection<IfcPositiveInteger>> value) { this.texCoordIndex = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(maps != null ? StepUtils.toStepValue(maps) : "$");
		parameters.add(mappedTo != null ? StepUtils.toStepValue(mappedTo) : "$");
		parameters.add(texCoords != null ? StepUtils.toStepValue(texCoords) : "$");
		parameters.add(texCoordIndex != null ? StepUtils.toStepValue(texCoordIndex) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}