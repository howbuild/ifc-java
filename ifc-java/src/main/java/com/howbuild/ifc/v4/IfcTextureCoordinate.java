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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctexturecoordinate.htm">IfcTextureCoordinate</a>
 */
public abstract class IfcTextureCoordinate extends IfcPresentationItem {
    protected Collection<IfcSurfaceTexture> maps;

    protected IfcTextureCoordinate() { initCollections(); }
    /**
     * Constructs IfcTextureCoordinate with all required attributes.
     */
    public IfcTextureCoordinate(Collection<IfcSurfaceTexture> maps) {
        super();
        this.maps = maps;
    }
    private void initCollections() {
        this.maps = new ArrayList<>();
    }
    public Collection<IfcSurfaceTexture> getMaps() { return this.maps; }
    public void setMaps(Collection<IfcSurfaceTexture> value) { this.maps = value; }


    @Override public void finalizeRelationships() { this.setIfcTextureCoordinateRelationship(); }
    private void setIfcTextureCoordinateRelationship() {
		if (this.maps != null) {
		    for (Object x : this.maps) {
		        if (x instanceof IfcSurfaceTexture)
		            ((IfcSurfaceTexture)x).isMappedBy.add(this);
		    }
		}
    }
}