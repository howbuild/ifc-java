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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadsingledisplacementdistortion.htm">IfcStructuralLoadSingleDisplacementDistortion</a>
 */
public class IfcStructuralLoadSingleDisplacementDistortion extends IfcStructuralLoadSingleDisplacement {
    protected IfcCurvatureMeasure distortion;


    /**
     * Constructs IfcStructuralLoadSingleDisplacementDistortion with all required attributes.
     */
    public IfcStructuralLoadSingleDisplacementDistortion() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadSingleDisplacementDistortion with required and optional attributes.
     */
    public IfcStructuralLoadSingleDisplacementDistortion(IfcLabel name,IfcLengthMeasure displacementX,IfcLengthMeasure displacementY,IfcLengthMeasure displacementZ,IfcPlaneAngleMeasure rotationalDisplacementRX,IfcPlaneAngleMeasure rotationalDisplacementRY,IfcPlaneAngleMeasure rotationalDisplacementRZ,IfcCurvatureMeasure distortion) {
        super(name,displacementX,displacementY,displacementZ,rotationalDisplacementRX,rotationalDisplacementRY,rotationalDisplacementRZ);
        this.distortion = distortion;
    }
    private void initCollections() {
    }
    public IfcCurvatureMeasure getDistortion() { return this.distortion; }
    public void setDistortion(IfcCurvatureMeasure value) { this.distortion = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(displacementX != null ? StepUtils.toStepValue(displacementX) : "$");
		parameters.add(displacementY != null ? StepUtils.toStepValue(displacementY) : "$");
		parameters.add(displacementZ != null ? StepUtils.toStepValue(displacementZ) : "$");
		parameters.add(rotationalDisplacementRX != null ? StepUtils.toStepValue(rotationalDisplacementRX) : "$");
		parameters.add(rotationalDisplacementRY != null ? StepUtils.toStepValue(rotationalDisplacementRY) : "$");
		parameters.add(rotationalDisplacementRZ != null ? StepUtils.toStepValue(rotationalDisplacementRZ) : "$");
		parameters.add(distortion != null ? StepUtils.toStepValue(distortion) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}