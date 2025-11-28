package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcIndexedPolygonalFace
 * SUPERTYPE OF (ONEOF
 * (IfcIndexedPolygonalFaceWithVoids))
 * SUBTYPE OF (IfcTessellatedItem);
 * CoordIndex : LIST [3:?] OF IfcPositiveInteger;
 * INVERSE
 * ToFaceSet : SET [1:?] OF IfcPolygonalFaceSet FOR Faces;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcindexedpolygonalface.htm">IfcIndexedPolygonalFace</a>
 */
public class IfcIndexedPolygonalFace extends IfcTessellatedItem {
    protected Collection<IfcPositiveInteger> coordIndex;
    protected Collection<IfcPolygonalFaceSet> toFaceSet;

    protected IfcIndexedPolygonalFace() { initCollections(); }
    /**
     * Constructs IfcIndexedPolygonalFace with all required attributes.
     */
    public IfcIndexedPolygonalFace(Collection<IfcPositiveInteger> coordIndex) {
        super();
        this.toFaceSet = new ArrayList<>();
        this.coordIndex = coordIndex;
    }
    private void initCollections() {
        this.coordIndex = new ArrayList<>();
        this.toFaceSet = new ArrayList<>();
    }
    public Collection<IfcPositiveInteger> getCoordIndex() { return this.coordIndex; }
    public void setCoordIndex(Collection<IfcPositiveInteger> value) { this.coordIndex = value; }
    public Collection<IfcPolygonalFaceSet> getToFaceSet() { return this.toFaceSet; }
    public void setToFaceSet(Collection<IfcPolygonalFaceSet> value) { this.toFaceSet = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordIndex != null ? StepUtils.toStepValue(coordIndex) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}