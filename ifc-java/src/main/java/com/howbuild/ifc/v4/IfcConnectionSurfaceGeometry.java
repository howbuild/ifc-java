package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConnectionGeometry
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConnectionCurveGeometry
 * ,IfcConnectionPointGeometry
 * ,IfcConnectionSurfaceGeometry
 * ,IfcConnectionVolumeGeometry));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectionsurfacegeometry.htm">IfcConnectionSurfaceGeometry</a>
 */
public class IfcConnectionSurfaceGeometry extends IfcConnectionGeometry {
    protected IfcSurfaceOrFaceSurface surfaceOnRelatingElement;
    protected IfcSurfaceOrFaceSurface surfaceOnRelatedElement;

    protected IfcConnectionSurfaceGeometry() { initCollections(); }
    /**
     * Constructs IfcConnectionSurfaceGeometry with all required attributes.
     */
    public IfcConnectionSurfaceGeometry(IfcSurfaceOrFaceSurface surfaceOnRelatingElement) {

        super();
        this.surfaceOnRelatingElement = surfaceOnRelatingElement;
    }
    /**
     * Constructs IfcConnectionSurfaceGeometry with required and optional attributes.
     */
    public IfcConnectionSurfaceGeometry(IfcSurfaceOrFaceSurface surfaceOnRelatingElement,IfcSurfaceOrFaceSurface surfaceOnRelatedElement) {
        super();
        this.surfaceOnRelatingElement = surfaceOnRelatingElement;
        this.surfaceOnRelatedElement = surfaceOnRelatedElement;
    }
    private void initCollections() {
    }
    public IfcSurfaceOrFaceSurface getSurfaceOnRelatingElement() { return this.surfaceOnRelatingElement; }
    public void setSurfaceOnRelatingElement(IfcSurfaceOrFaceSurface value) { this.surfaceOnRelatingElement = value; }
    public IfcSurfaceOrFaceSurface getSurfaceOnRelatedElement() { return this.surfaceOnRelatedElement; }
    public void setSurfaceOnRelatedElement(IfcSurfaceOrFaceSurface value) { this.surfaceOnRelatedElement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(surfaceOnRelatingElement != null ? StepUtils.toStepValue(surfaceOnRelatingElement) : "$");
		parameters.add(surfaceOnRelatedElement != null ? StepUtils.toStepValue(surfaceOnRelatedElement) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}