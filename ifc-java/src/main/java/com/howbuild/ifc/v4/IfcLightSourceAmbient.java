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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightsourceambient.htm">IfcLightSourceAmbient</a>
 */
public class IfcLightSourceAmbient extends IfcLightSource {

    protected IfcLightSourceAmbient() { initCollections(); }
    /**
     * Constructs IfcLightSourceAmbient with all required attributes.
     */
    public IfcLightSourceAmbient(IfcColourRgb lightColour) {

        super(lightColour);
    }
    /**
     * Constructs IfcLightSourceAmbient with required and optional attributes.
     */
    public IfcLightSourceAmbient(IfcLabel name,IfcColourRgb lightColour,IfcNormalisedRatioMeasure ambientIntensity,IfcNormalisedRatioMeasure intensity) {
        super(name,lightColour,ambientIntensity,intensity);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(lightColour != null ? StepUtils.toStepValue(lightColour) : "$");
		parameters.add(ambientIntensity != null ? StepUtils.toStepValue(ambientIntensity) : "$");
		parameters.add(intensity != null ? StepUtils.toStepValue(intensity) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}