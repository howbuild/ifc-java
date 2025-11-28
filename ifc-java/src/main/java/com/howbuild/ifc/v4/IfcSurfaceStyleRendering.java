package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSurfaceStyleRendering
 * SUBTYPE OF (IfcSurfaceStyleShading);
 * DiffuseColour : OPTIONAL IfcColourOrFactor;
 * TransmissionColour : OPTIONAL IfcColourOrFactor;
 * DiffuseTransmissionColour : OPTIONAL IfcColourOrFactor;
 * ReflectionColour : OPTIONAL IfcColourOrFactor;
 * SpecularColour : OPTIONAL IfcColourOrFactor;
 * SpecularHighlight : OPTIONAL IfcSpecularHighlightSelect;
 * ReflectanceMethod : IfcReflectanceMethodEnum;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestylerendering.htm">IfcSurfaceStyleRendering</a>
 */
public class IfcSurfaceStyleRendering extends IfcSurfaceStyleShading {
    protected IfcColourOrFactor diffuseColour;
    protected IfcColourOrFactor transmissionColour;
    protected IfcColourOrFactor diffuseTransmissionColour;
    protected IfcColourOrFactor reflectionColour;
    protected IfcColourOrFactor specularColour;
    protected IfcSpecularHighlightSelect specularHighlight;
    protected IfcReflectanceMethodEnum reflectanceMethod;

    protected IfcSurfaceStyleRendering() { initCollections(); }
    /**
     * Constructs IfcSurfaceStyleRendering with all required attributes.
     */
    public IfcSurfaceStyleRendering(IfcColourRgb surfaceColour,IfcReflectanceMethodEnum reflectanceMethod) {

        super(surfaceColour);
        this.reflectanceMethod = reflectanceMethod;
    }
    /**
     * Constructs IfcSurfaceStyleRendering with required and optional attributes.
     */
    public IfcSurfaceStyleRendering(IfcColourRgb surfaceColour,IfcNormalisedRatioMeasure transparency,IfcColourOrFactor diffuseColour,IfcColourOrFactor transmissionColour,IfcColourOrFactor diffuseTransmissionColour,IfcColourOrFactor reflectionColour,IfcColourOrFactor specularColour,IfcSpecularHighlightSelect specularHighlight,IfcReflectanceMethodEnum reflectanceMethod) {
        super(surfaceColour,transparency);
        this.diffuseColour = diffuseColour;
        this.transmissionColour = transmissionColour;
        this.diffuseTransmissionColour = diffuseTransmissionColour;
        this.reflectionColour = reflectionColour;
        this.specularColour = specularColour;
        this.specularHighlight = specularHighlight;
        this.reflectanceMethod = reflectanceMethod;
    }
    private void initCollections() {
    }
    public IfcColourOrFactor getDiffuseColour() { return this.diffuseColour; }
    public void setDiffuseColour(IfcColourOrFactor value) { this.diffuseColour = value; } // optional
    public IfcColourOrFactor getTransmissionColour() { return this.transmissionColour; }
    public void setTransmissionColour(IfcColourOrFactor value) { this.transmissionColour = value; } // optional
    public IfcColourOrFactor getDiffuseTransmissionColour() { return this.diffuseTransmissionColour; }
    public void setDiffuseTransmissionColour(IfcColourOrFactor value) { this.diffuseTransmissionColour = value; } // optional
    public IfcColourOrFactor getReflectionColour() { return this.reflectionColour; }
    public void setReflectionColour(IfcColourOrFactor value) { this.reflectionColour = value; } // optional
    public IfcColourOrFactor getSpecularColour() { return this.specularColour; }
    public void setSpecularColour(IfcColourOrFactor value) { this.specularColour = value; } // optional
    public IfcSpecularHighlightSelect getSpecularHighlight() { return this.specularHighlight; }
    public void setSpecularHighlight(IfcSpecularHighlightSelect value) { this.specularHighlight = value; } // optional
    public IfcReflectanceMethodEnum getReflectanceMethod() { return this.reflectanceMethod; }
    public void setReflectanceMethod(IfcReflectanceMethodEnum value) { this.reflectanceMethod = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(surfaceColour != null ? StepUtils.toStepValue(surfaceColour) : "$");
		parameters.add(transparency != null ? StepUtils.toStepValue(transparency) : "$");
		parameters.add(diffuseColour != null ? StepUtils.toStepValue(diffuseColour) : "$");
		parameters.add(transmissionColour != null ? StepUtils.toStepValue(transmissionColour) : "$");
		parameters.add(diffuseTransmissionColour != null ? StepUtils.toStepValue(diffuseTransmissionColour) : "$");
		parameters.add(reflectionColour != null ? StepUtils.toStepValue(reflectionColour) : "$");
		parameters.add(specularColour != null ? StepUtils.toStepValue(specularColour) : "$");
		parameters.add(specularHighlight != null ? StepUtils.toStepValue(specularHighlight) : "$");
		parameters.add(StepUtils.toStepValue(reflectanceMethod));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}