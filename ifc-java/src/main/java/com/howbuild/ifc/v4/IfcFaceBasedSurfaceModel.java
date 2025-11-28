package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFaceBasedSurfaceModel
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * FbsmFaces : SET [1:?] OF IfcConnectedFaceSet;
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfacebasedsurfacemodel.htm">IfcFaceBasedSurfaceModel</a>
 */
public class IfcFaceBasedSurfaceModel extends IfcGeometricRepresentationItem implements IfcSurfaceOrFaceSurface {
    protected Collection<IfcConnectedFaceSet> fbsmFaces;

    protected IfcFaceBasedSurfaceModel() { initCollections(); }
    /**
     * Constructs IfcFaceBasedSurfaceModel with all required attributes.
     */
    public IfcFaceBasedSurfaceModel(Collection<IfcConnectedFaceSet> fbsmFaces) {
        super();
        this.fbsmFaces = fbsmFaces;
    }
    private void initCollections() {
        this.fbsmFaces = new ArrayList<>();
    }
    public Collection<IfcConnectedFaceSet> getFbsmFaces() { return this.fbsmFaces; }
    public void setFbsmFaces(Collection<IfcConnectedFaceSet> value) { this.fbsmFaces = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(fbsmFaces != null ? StepUtils.toStepValue(fbsmFaces) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}