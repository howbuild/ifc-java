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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcindexedpolygonalfacewithvoids.htm">IfcIndexedPolygonalFaceWithVoids</a>
 */
public class IfcIndexedPolygonalFaceWithVoids extends IfcIndexedPolygonalFace {
    protected Collection<Collection<IfcPositiveInteger>> innerCoordIndices;

    protected IfcIndexedPolygonalFaceWithVoids() { initCollections(); }
    /**
     * Constructs IfcIndexedPolygonalFaceWithVoids with all required attributes.
     */
    public IfcIndexedPolygonalFaceWithVoids(Collection<IfcPositiveInteger> coordIndex,Collection<Collection<IfcPositiveInteger>> innerCoordIndices) {
        super(coordIndex);
        this.innerCoordIndices = innerCoordIndices;
    }
    private void initCollections() {
        this.innerCoordIndices = new ArrayList<>();
    }
    public Collection<Collection<IfcPositiveInteger>> getInnerCoordIndices() { return this.innerCoordIndices; }
    public void setInnerCoordIndices(Collection<Collection<IfcPositiveInteger>> value) { this.innerCoordIndices = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordIndex != null ? StepUtils.toStepValue(coordIndex) : "$");
		parameters.add(innerCoordIndices != null ? StepUtils.toStepValue(innerCoordIndices) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}