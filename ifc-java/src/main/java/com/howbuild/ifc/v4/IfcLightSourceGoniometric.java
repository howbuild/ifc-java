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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightsourcegoniometric.htm">IfcLightSourceGoniometric</a>
 */
public class IfcLightSourceGoniometric extends IfcLightSource {
    protected IfcAxis2Placement3D position;
    protected IfcColourRgb colourAppearance;
    protected IfcThermodynamicTemperatureMeasure colourTemperature;
    protected IfcLuminousFluxMeasure luminousFlux;
    protected IfcLightEmissionSourceEnum lightEmissionSource;
    protected IfcLightDistributionDataSourceSelect lightDistributionDataSource;

    protected IfcLightSourceGoniometric() { initCollections(); }
    /**
     * Constructs IfcLightSourceGoniometric with all required attributes.
     */
    public IfcLightSourceGoniometric(IfcColourRgb lightColour,IfcAxis2Placement3D position,IfcThermodynamicTemperatureMeasure colourTemperature,IfcLuminousFluxMeasure luminousFlux,IfcLightEmissionSourceEnum lightEmissionSource,IfcLightDistributionDataSourceSelect lightDistributionDataSource) {

        super(lightColour);
        this.position = position;
        this.colourTemperature = colourTemperature;
        this.luminousFlux = luminousFlux;
        this.lightEmissionSource = lightEmissionSource;
        this.lightDistributionDataSource = lightDistributionDataSource;
    }
    /**
     * Constructs IfcLightSourceGoniometric with required and optional attributes.
     */
    public IfcLightSourceGoniometric(IfcLabel name,IfcColourRgb lightColour,IfcNormalisedRatioMeasure ambientIntensity,IfcNormalisedRatioMeasure intensity,IfcAxis2Placement3D position,IfcColourRgb colourAppearance,IfcThermodynamicTemperatureMeasure colourTemperature,IfcLuminousFluxMeasure luminousFlux,IfcLightEmissionSourceEnum lightEmissionSource,IfcLightDistributionDataSourceSelect lightDistributionDataSource) {
        super(name,lightColour,ambientIntensity,intensity);
        this.position = position;
        this.colourAppearance = colourAppearance;
        this.colourTemperature = colourTemperature;
        this.luminousFlux = luminousFlux;
        this.lightEmissionSource = lightEmissionSource;
        this.lightDistributionDataSource = lightDistributionDataSource;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement3D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement3D value) { this.position = value; }
    public IfcColourRgb getColourAppearance() { return this.colourAppearance; }
    public void setColourAppearance(IfcColourRgb value) { this.colourAppearance = value; } // optional
    public IfcThermodynamicTemperatureMeasure getColourTemperature() { return this.colourTemperature; }
    public void setColourTemperature(IfcThermodynamicTemperatureMeasure value) { this.colourTemperature = value; }
    public IfcLuminousFluxMeasure getLuminousFlux() { return this.luminousFlux; }
    public void setLuminousFlux(IfcLuminousFluxMeasure value) { this.luminousFlux = value; }
    public IfcLightEmissionSourceEnum getLightEmissionSource() { return this.lightEmissionSource; }
    public void setLightEmissionSource(IfcLightEmissionSourceEnum value) { this.lightEmissionSource = value; }
    public IfcLightDistributionDataSourceSelect getLightDistributionDataSource() { return this.lightDistributionDataSource; }
    public void setLightDistributionDataSource(IfcLightDistributionDataSourceSelect value) { this.lightDistributionDataSource = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(lightColour != null ? StepUtils.toStepValue(lightColour) : "$");
		parameters.add(ambientIntensity != null ? StepUtils.toStepValue(ambientIntensity) : "$");
		parameters.add(intensity != null ? StepUtils.toStepValue(intensity) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(colourAppearance != null ? StepUtils.toStepValue(colourAppearance) : "$");
		parameters.add(colourTemperature != null ? StepUtils.toStepValue(colourTemperature) : "$");
		parameters.add(luminousFlux != null ? StepUtils.toStepValue(luminousFlux) : "$");
		parameters.add(StepUtils.toStepValue(lightEmissionSource));
		parameters.add(lightDistributionDataSource != null ? StepUtils.toStepValue(lightDistributionDataSource) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}