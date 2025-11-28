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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectionvolumegeometry.htm">IfcConnectionVolumeGeometry</a>
 */
public class IfcConnectionVolumeGeometry extends IfcConnectionGeometry {
    protected IfcSolidOrShell volumeOnRelatingElement;
    protected IfcSolidOrShell volumeOnRelatedElement;

    protected IfcConnectionVolumeGeometry() { initCollections(); }
    /**
     * Constructs IfcConnectionVolumeGeometry with all required attributes.
     */
    public IfcConnectionVolumeGeometry(IfcSolidOrShell volumeOnRelatingElement) {

        super();
        this.volumeOnRelatingElement = volumeOnRelatingElement;
    }
    /**
     * Constructs IfcConnectionVolumeGeometry with required and optional attributes.
     */
    public IfcConnectionVolumeGeometry(IfcSolidOrShell volumeOnRelatingElement,IfcSolidOrShell volumeOnRelatedElement) {
        super();
        this.volumeOnRelatingElement = volumeOnRelatingElement;
        this.volumeOnRelatedElement = volumeOnRelatedElement;
    }
    private void initCollections() {
    }
    public IfcSolidOrShell getVolumeOnRelatingElement() { return this.volumeOnRelatingElement; }
    public void setVolumeOnRelatingElement(IfcSolidOrShell value) { this.volumeOnRelatingElement = value; }
    public IfcSolidOrShell getVolumeOnRelatedElement() { return this.volumeOnRelatedElement; }
    public void setVolumeOnRelatedElement(IfcSolidOrShell value) { this.volumeOnRelatedElement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(volumeOnRelatingElement != null ? StepUtils.toStepValue(volumeOnRelatingElement) : "$");
		parameters.add(volumeOnRelatedElement != null ? StepUtils.toStepValue(volumeOnRelatedElement) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}