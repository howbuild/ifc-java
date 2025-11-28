package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTessellatedFaceSet
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcPolygonalFaceSet
 * ,IfcTriangulatedFaceSet))
 * SUBTYPE OF (IfcTessellatedItem);
 * Coordinates : IfcCartesianPointList3D;
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * INVERSE
 * HasColours : SET [0:1] OF IfcIndexedColourMap FOR MappedTo;
 * HasTextures : SET [0:?] OF IfcIndexedTextureMap FOR MappedTo;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctriangulatedfaceset.htm">IfcTriangulatedFaceSet</a>
 */
public class IfcTriangulatedFaceSet extends IfcTessellatedFaceSet {
    protected Collection<Collection<IfcParameterValue>> normals;
    protected IfcBoolean closed;
    protected Collection<Collection<IfcPositiveInteger>> coordIndex;
    protected Collection<IfcPositiveInteger> pnIndex;

    protected IfcTriangulatedFaceSet() { initCollections(); }
    /**
     * Constructs IfcTriangulatedFaceSet with all required attributes.
     */
    public IfcTriangulatedFaceSet(IfcCartesianPointList3D coordinates,Collection<Collection<IfcPositiveInteger>> coordIndex) {

        super(coordinates);
        this.normals = new ArrayList<>();
        this.pnIndex = new ArrayList<>();
        this.coordIndex = coordIndex;
    }
    /**
     * Constructs IfcTriangulatedFaceSet with required and optional attributes.
     */
    public IfcTriangulatedFaceSet(IfcCartesianPointList3D coordinates,Collection<Collection<IfcParameterValue>> normals,IfcBoolean closed,Collection<Collection<IfcPositiveInteger>> coordIndex,Collection<IfcPositiveInteger> pnIndex) {
        super(coordinates);
        this.normals = normals;
        this.closed = closed;
        this.coordIndex = coordIndex;
        this.pnIndex = pnIndex;
    }
    private void initCollections() {
        this.normals = new ArrayList<>();
        this.coordIndex = new ArrayList<>();
        this.pnIndex = new ArrayList<>();
    }
    public Collection<Collection<IfcParameterValue>> getNormals() { return this.normals; }
    public void setNormals(Collection<Collection<IfcParameterValue>> value) { this.normals = value; } // optional
    public IfcBoolean getClosed() { return this.closed; }
    public void setClosed(IfcBoolean value) { this.closed = value; } // optional
    public Collection<Collection<IfcPositiveInteger>> getCoordIndex() { return this.coordIndex; }
    public void setCoordIndex(Collection<Collection<IfcPositiveInteger>> value) { this.coordIndex = value; }
    public Collection<IfcPositiveInteger> getPnIndex() { return this.pnIndex; }
    public void setPnIndex(Collection<IfcPositiveInteger> value) { this.pnIndex = value; } // optional
    public IfcInteger getNumberOfTriangles() { throw new UnsupportedOperationException("Derived property logic has been implemented for NumberOfTriangles."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordinates != null ? StepUtils.toStepValue(coordinates) : "$");
		parameters.add(normals != null ? StepUtils.toStepValue(normals) : "$");
		parameters.add(closed != null ? StepUtils.toStepValue(closed) : "$");
		parameters.add(coordIndex != null ? StepUtils.toStepValue(coordIndex) : "$");
		parameters.add(pnIndex != null ? StepUtils.toStepValue(pnIndex) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}