package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLightSource
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcLightSourceAmbient
 * ,IfcLightSourceDirectional
 * ,IfcLightSourceGoniometric
 * ,IfcLightSourcePositional))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * Name : OPTIONAL IfcLabel;
 * LightColour : IfcColourRgb;
 * AmbientIntensity : OPTIONAL IfcNormalisedRatioMeasure;
 * Intensity : OPTIONAL IfcNormalisedRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightsourcepositional.htm">IfcLightSourcePositional</a>
 */
public class IfcLightSourcePositional extends IfcLightSource {
    protected IfcCartesianPoint position;
    protected IfcPositiveLengthMeasure radius;
    protected IfcReal constantAttenuation;
    protected IfcReal distanceAttenuation;
    protected IfcReal quadricAttenuation;

    protected IfcLightSourcePositional() { initCollections(); }
    /**
     * Constructs IfcLightSourcePositional with all required attributes.
     */
    public IfcLightSourcePositional(IfcColourRgb lightColour,IfcCartesianPoint position,IfcPositiveLengthMeasure radius,IfcReal constantAttenuation,IfcReal distanceAttenuation,IfcReal quadricAttenuation) {

        super(lightColour);
        this.position = position;
        this.radius = radius;
        this.constantAttenuation = constantAttenuation;
        this.distanceAttenuation = distanceAttenuation;
        this.quadricAttenuation = quadricAttenuation;
    }
    /**
     * Constructs IfcLightSourcePositional with required and optional attributes.
     */
    public IfcLightSourcePositional(IfcLabel name,IfcColourRgb lightColour,IfcNormalisedRatioMeasure ambientIntensity,IfcNormalisedRatioMeasure intensity,IfcCartesianPoint position,IfcPositiveLengthMeasure radius,IfcReal constantAttenuation,IfcReal distanceAttenuation,IfcReal quadricAttenuation) {
        super(name,lightColour,ambientIntensity,intensity);
        this.position = position;
        this.radius = radius;
        this.constantAttenuation = constantAttenuation;
        this.distanceAttenuation = distanceAttenuation;
        this.quadricAttenuation = quadricAttenuation;
    }
    private void initCollections() {
    }
    public IfcCartesianPoint getPosition() { return this.position; }
    public void setPosition(IfcCartesianPoint value) { this.position = value; }
    public IfcPositiveLengthMeasure getRadius() { return this.radius; }
    public void setRadius(IfcPositiveLengthMeasure value) { this.radius = value; }
    public IfcReal getConstantAttenuation() { return this.constantAttenuation; }
    public void setConstantAttenuation(IfcReal value) { this.constantAttenuation = value; }
    public IfcReal getDistanceAttenuation() { return this.distanceAttenuation; }
    public void setDistanceAttenuation(IfcReal value) { this.distanceAttenuation = value; }
    public IfcReal getQuadricAttenuation() { return this.quadricAttenuation; }
    public void setQuadricAttenuation(IfcReal value) { this.quadricAttenuation = value; }

    
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
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}