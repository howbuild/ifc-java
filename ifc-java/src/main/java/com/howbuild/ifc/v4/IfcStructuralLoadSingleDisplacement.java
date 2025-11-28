package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadSingleDisplacement
 * SUPERTYPE OF (ONEOF
 * (IfcStructuralLoadSingleDisplacementDistortion))
 * SUBTYPE OF (IfcStructuralLoadStatic);
 * DisplacementX : OPTIONAL IfcLengthMeasure;
 * DisplacementY : OPTIONAL IfcLengthMeasure;
 * DisplacementZ : OPTIONAL IfcLengthMeasure;
 * RotationalDisplacementRX : OPTIONAL IfcPlaneAngleMeasure;
 * RotationalDisplacementRY : OPTIONAL IfcPlaneAngleMeasure;
 * RotationalDisplacementRZ : OPTIONAL IfcPlaneAngleMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadsingledisplacement.htm">IfcStructuralLoadSingleDisplacement</a>
 */
public class IfcStructuralLoadSingleDisplacement extends IfcStructuralLoadStatic {
    protected IfcLengthMeasure displacementX;
    protected IfcLengthMeasure displacementY;
    protected IfcLengthMeasure displacementZ;
    protected IfcPlaneAngleMeasure rotationalDisplacementRX;
    protected IfcPlaneAngleMeasure rotationalDisplacementRY;
    protected IfcPlaneAngleMeasure rotationalDisplacementRZ;


    /**
     * Constructs IfcStructuralLoadSingleDisplacement with all required attributes.
     */
    public IfcStructuralLoadSingleDisplacement() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadSingleDisplacement with required and optional attributes.
     */
    public IfcStructuralLoadSingleDisplacement(IfcLabel name,IfcLengthMeasure displacementX,IfcLengthMeasure displacementY,IfcLengthMeasure displacementZ,IfcPlaneAngleMeasure rotationalDisplacementRX,IfcPlaneAngleMeasure rotationalDisplacementRY,IfcPlaneAngleMeasure rotationalDisplacementRZ) {
        super(name);
        this.displacementX = displacementX;
        this.displacementY = displacementY;
        this.displacementZ = displacementZ;
        this.rotationalDisplacementRX = rotationalDisplacementRX;
        this.rotationalDisplacementRY = rotationalDisplacementRY;
        this.rotationalDisplacementRZ = rotationalDisplacementRZ;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getDisplacementX() { return this.displacementX; }
    public void setDisplacementX(IfcLengthMeasure value) { this.displacementX = value; } // optional
    public IfcLengthMeasure getDisplacementY() { return this.displacementY; }
    public void setDisplacementY(IfcLengthMeasure value) { this.displacementY = value; } // optional
    public IfcLengthMeasure getDisplacementZ() { return this.displacementZ; }
    public void setDisplacementZ(IfcLengthMeasure value) { this.displacementZ = value; } // optional
    public IfcPlaneAngleMeasure getRotationalDisplacementRX() { return this.rotationalDisplacementRX; }
    public void setRotationalDisplacementRX(IfcPlaneAngleMeasure value) { this.rotationalDisplacementRX = value; } // optional
    public IfcPlaneAngleMeasure getRotationalDisplacementRY() { return this.rotationalDisplacementRY; }
    public void setRotationalDisplacementRY(IfcPlaneAngleMeasure value) { this.rotationalDisplacementRY = value; } // optional
    public IfcPlaneAngleMeasure getRotationalDisplacementRZ() { return this.rotationalDisplacementRZ; }
    public void setRotationalDisplacementRZ(IfcPlaneAngleMeasure value) { this.rotationalDisplacementRZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(displacementX != null ? StepUtils.toStepValue(displacementX) : "$");
		parameters.add(displacementY != null ? StepUtils.toStepValue(displacementY) : "$");
		parameters.add(displacementZ != null ? StepUtils.toStepValue(displacementZ) : "$");
		parameters.add(rotationalDisplacementRX != null ? StepUtils.toStepValue(rotationalDisplacementRX) : "$");
		parameters.add(rotationalDisplacementRY != null ? StepUtils.toStepValue(rotationalDisplacementRY) : "$");
		parameters.add(rotationalDisplacementRZ != null ? StepUtils.toStepValue(rotationalDisplacementRZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}