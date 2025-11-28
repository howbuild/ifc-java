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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpolygonalfaceset.htm">IfcPolygonalFaceSet</a>
 */
public class IfcPolygonalFaceSet extends IfcTessellatedFaceSet {
    protected IfcBoolean closed;
    protected Collection<IfcIndexedPolygonalFace> faces;
    protected Collection<IfcPositiveInteger> pnIndex;

    protected IfcPolygonalFaceSet() { initCollections(); }
    /**
     * Constructs IfcPolygonalFaceSet with all required attributes.
     */
    public IfcPolygonalFaceSet(IfcCartesianPointList3D coordinates,Collection<IfcIndexedPolygonalFace> faces) {

        super(coordinates);
        this.pnIndex = new ArrayList<>();
        this.faces = faces;
    }
    /**
     * Constructs IfcPolygonalFaceSet with required and optional attributes.
     */
    public IfcPolygonalFaceSet(IfcCartesianPointList3D coordinates,IfcBoolean closed,Collection<IfcIndexedPolygonalFace> faces,Collection<IfcPositiveInteger> pnIndex) {
        super(coordinates);
        this.closed = closed;
        this.faces = faces;
        this.pnIndex = pnIndex;
    }
    private void initCollections() {
        this.faces = new ArrayList<>();
        this.pnIndex = new ArrayList<>();
    }
    public IfcBoolean getClosed() { return this.closed; }
    public void setClosed(IfcBoolean value) { this.closed = value; } // optional
    public Collection<IfcIndexedPolygonalFace> getFaces() { return this.faces; }
    public void setFaces(Collection<IfcIndexedPolygonalFace> value) { this.faces = value; }
    public Collection<IfcPositiveInteger> getPnIndex() { return this.pnIndex; }
    public void setPnIndex(Collection<IfcPositiveInteger> value) { this.pnIndex = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordinates != null ? StepUtils.toStepValue(coordinates) : "$");
		parameters.add(closed != null ? StepUtils.toStepValue(closed) : "$");
		parameters.add(faces != null ? StepUtils.toStepValue(faces) : "$");
		parameters.add(pnIndex != null ? StepUtils.toStepValue(pnIndex) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPolygonalFaceSetRelationship(); }
    private void setIfcPolygonalFaceSetRelationship() {
		if (this.faces != null) {
		    for (Object x : this.faces) {
		        if (x instanceof IfcIndexedPolygonalFace)
		            ((IfcIndexedPolygonalFace)x).toFaceSet.add(this);
		    }
		}
    }
}