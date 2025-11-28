package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConnectionPointEccentricity
 * SUBTYPE OF (IfcConnectionPointGeometry);
 * EccentricityInX : OPTIONAL IfcLengthMeasure;
 * EccentricityInY : OPTIONAL IfcLengthMeasure;
 * EccentricityInZ : OPTIONAL IfcLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectionpointeccentricity.htm">IfcConnectionPointEccentricity</a>
 */
public class IfcConnectionPointEccentricity extends IfcConnectionPointGeometry {
    protected IfcLengthMeasure eccentricityInX;
    protected IfcLengthMeasure eccentricityInY;
    protected IfcLengthMeasure eccentricityInZ;

    protected IfcConnectionPointEccentricity() { initCollections(); }
    /**
     * Constructs IfcConnectionPointEccentricity with all required attributes.
     */
    public IfcConnectionPointEccentricity(IfcPointOrVertexPoint pointOnRelatingElement) {

        super(pointOnRelatingElement);
    }
    /**
     * Constructs IfcConnectionPointEccentricity with required and optional attributes.
     */
    public IfcConnectionPointEccentricity(IfcPointOrVertexPoint pointOnRelatingElement,IfcPointOrVertexPoint pointOnRelatedElement,IfcLengthMeasure eccentricityInX,IfcLengthMeasure eccentricityInY,IfcLengthMeasure eccentricityInZ) {
        super(pointOnRelatingElement,pointOnRelatedElement);
        this.eccentricityInX = eccentricityInX;
        this.eccentricityInY = eccentricityInY;
        this.eccentricityInZ = eccentricityInZ;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getEccentricityInX() { return this.eccentricityInX; }
    public void setEccentricityInX(IfcLengthMeasure value) { this.eccentricityInX = value; } // optional
    public IfcLengthMeasure getEccentricityInY() { return this.eccentricityInY; }
    public void setEccentricityInY(IfcLengthMeasure value) { this.eccentricityInY = value; } // optional
    public IfcLengthMeasure getEccentricityInZ() { return this.eccentricityInZ; }
    public void setEccentricityInZ(IfcLengthMeasure value) { this.eccentricityInZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(pointOnRelatingElement != null ? StepUtils.toStepValue(pointOnRelatingElement) : "$");
		parameters.add(pointOnRelatedElement != null ? StepUtils.toStepValue(pointOnRelatedElement) : "$");
		parameters.add(eccentricityInX != null ? StepUtils.toStepValue(eccentricityInX) : "$");
		parameters.add(eccentricityInY != null ? StepUtils.toStepValue(eccentricityInY) : "$");
		parameters.add(eccentricityInZ != null ? StepUtils.toStepValue(eccentricityInZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}