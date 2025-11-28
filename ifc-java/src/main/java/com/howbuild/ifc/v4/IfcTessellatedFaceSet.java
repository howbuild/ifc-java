package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPolygonalFaceSet
 * SUBTYPE OF (IfcTessellatedFaceSet);
 * Closed : OPTIONAL IfcBoolean;
 * Faces : LIST [1:?] OF IfcIndexedPolygonalFace;
 * PnIndex : OPTIONAL LIST [1:?] OF IfcPositiveInteger;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctessellatedfaceset.htm">IfcTessellatedFaceSet</a>
 */
public abstract class IfcTessellatedFaceSet extends IfcTessellatedItem implements IfcBooleanOperand {
    protected IfcCartesianPointList3D coordinates;
    protected Collection<IfcIndexedColourMap> hasColours;
    protected Collection<IfcIndexedTextureMap> hasTextures;

    protected IfcTessellatedFaceSet() { initCollections(); }
    /**
     * Constructs IfcTessellatedFaceSet with all required attributes.
     */
    public IfcTessellatedFaceSet(IfcCartesianPointList3D coordinates) {
        super();
        this.hasColours = new ArrayList<>();
        this.hasTextures = new ArrayList<>();
        this.coordinates = coordinates;
    }
    private void initCollections() {
        this.hasColours = new ArrayList<>();
        this.hasTextures = new ArrayList<>();
    }
    public IfcCartesianPointList3D getCoordinates() { return this.coordinates; }
    public void setCoordinates(IfcCartesianPointList3D value) { this.coordinates = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived
    public Collection<IfcIndexedColourMap> getHasColours() { return this.hasColours; }
    public void setHasColours(Collection<IfcIndexedColourMap> value) { this.hasColours = value; } // inverse
    public Collection<IfcIndexedTextureMap> getHasTextures() { return this.hasTextures; }
    public void setHasTextures(Collection<IfcIndexedTextureMap> value) { this.hasTextures = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}