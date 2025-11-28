package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLightSourcePositional
 * SUPERTYPE OF (ONEOF
 * (IfcLightSourceSpot))
 * SUBTYPE OF (IfcLightSource);
 * Position : IfcCartesianPoint;
 * Radius : IfcPositiveLengthMeasure;
 * ConstantAttenuation : IfcReal;
 * DistanceAttenuation : IfcReal;
 * QuadricAttenuation : IfcReal;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightsourcespot.htm">IfcLightSourceSpot</a>
 */
public class IfcLightSourceSpot extends IfcLightSourcePositional {
    protected IfcDirection orientation;
    protected IfcReal concentrationExponent;
    protected IfcPositivePlaneAngleMeasure spreadAngle;
    protected IfcPositivePlaneAngleMeasure beamWidthAngle;

    protected IfcLightSourceSpot() { initCollections(); }
    /**
     * Constructs IfcLightSourceSpot with all required attributes.
     */
    public IfcLightSourceSpot(IfcColourRgb lightColour,IfcCartesianPoint position,IfcPositiveLengthMeasure radius,IfcReal constantAttenuation,IfcReal distanceAttenuation,IfcReal quadricAttenuation,IfcDirection orientation,IfcPositivePlaneAngleMeasure spreadAngle,IfcPositivePlaneAngleMeasure beamWidthAngle) {

        super(lightColour,position,radius,constantAttenuation,distanceAttenuation,quadricAttenuation);
        this.orientation = orientation;
        this.spreadAngle = spreadAngle;
        this.beamWidthAngle = beamWidthAngle;
    }
    /**
     * Constructs IfcLightSourceSpot with required and optional attributes.
     */
    public IfcLightSourceSpot(IfcLabel name,IfcColourRgb lightColour,IfcNormalisedRatioMeasure ambientIntensity,IfcNormalisedRatioMeasure intensity,IfcCartesianPoint position,IfcPositiveLengthMeasure radius,IfcReal constantAttenuation,IfcReal distanceAttenuation,IfcReal quadricAttenuation,IfcDirection orientation,IfcReal concentrationExponent,IfcPositivePlaneAngleMeasure spreadAngle,IfcPositivePlaneAngleMeasure beamWidthAngle) {
        super(name,lightColour,ambientIntensity,intensity,position,radius,constantAttenuation,distanceAttenuation,quadricAttenuation);
        this.orientation = orientation;
        this.concentrationExponent = concentrationExponent;
        this.spreadAngle = spreadAngle;
        this.beamWidthAngle = beamWidthAngle;
    }
    private void initCollections() {
    }
    public IfcDirection getOrientation() { return this.orientation; }
    public void setOrientation(IfcDirection value) { this.orientation = value; }
    public IfcReal getConcentrationExponent() { return this.concentrationExponent; }
    public void setConcentrationExponent(IfcReal value) { this.concentrationExponent = value; } // optional
    public IfcPositivePlaneAngleMeasure getSpreadAngle() { return this.spreadAngle; }
    public void setSpreadAngle(IfcPositivePlaneAngleMeasure value) { this.spreadAngle = value; }
    public IfcPositivePlaneAngleMeasure getBeamWidthAngle() { return this.beamWidthAngle; }
    public void setBeamWidthAngle(IfcPositivePlaneAngleMeasure value) { this.beamWidthAngle = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(lightColour != null ? StepUtils.toStepValue(lightColour) : "$");
		parameters.add(ambientIntensity != null ? StepUtils.toStepValue(ambientIntensity) : "$");
		parameters.add(intensity != null ? StepUtils.toStepValue(intensity) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
		parameters.add(constantAttenuation != null ? StepUtils.toStepValue(constantAttenuation) : "$");
		parameters.add(distanceAttenuation != null ? StepUtils.toStepValue(distanceAttenuation) : "$");
		parameters.add(quadricAttenuation != null ? StepUtils.toStepValue(quadricAttenuation) : "$");
		parameters.add(orientation != null ? StepUtils.toStepValue(orientation) : "$");
		parameters.add(concentrationExponent != null ? StepUtils.toStepValue(concentrationExponent) : "$");
		parameters.add(spreadAngle != null ? StepUtils.toStepValue(spreadAngle) : "$");
		parameters.add(beamWidthAngle != null ? StepUtils.toStepValue(beamWidthAngle) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}