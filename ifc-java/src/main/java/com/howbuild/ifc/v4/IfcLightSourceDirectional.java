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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightsourcedirectional.htm">IfcLightSourceDirectional</a>
 */
public class IfcLightSourceDirectional extends IfcLightSource {
    protected IfcDirection orientation;

    protected IfcLightSourceDirectional() { initCollections(); }
    /**
     * Constructs IfcLightSourceDirectional with all required attributes.
     */
    public IfcLightSourceDirectional(IfcColourRgb lightColour,IfcDirection orientation) {

        super(lightColour);
        this.orientation = orientation;
    }
    /**
     * Constructs IfcLightSourceDirectional with required and optional attributes.
     */
    public IfcLightSourceDirectional(IfcLabel name,IfcColourRgb lightColour,IfcNormalisedRatioMeasure ambientIntensity,IfcNormalisedRatioMeasure intensity,IfcDirection orientation) {
        super(name,lightColour,ambientIntensity,intensity);
        this.orientation = orientation;
    }
    private void initCollections() {
    }
    public IfcDirection getOrientation() { return this.orientation; }
    public void setOrientation(IfcDirection value) { this.orientation = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(lightColour != null ? StepUtils.toStepValue(lightColour) : "$");
		parameters.add(ambientIntensity != null ? StepUtils.toStepValue(ambientIntensity) : "$");
		parameters.add(intensity != null ? StepUtils.toStepValue(intensity) : "$");
		parameters.add(orientation != null ? StepUtils.toStepValue(orientation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}