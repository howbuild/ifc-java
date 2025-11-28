package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcColourRgb
 * SUBTYPE OF (IfcColourSpecification);
 * Red : IfcNormalisedRatioMeasure;
 * Green : IfcNormalisedRatioMeasure;
 * Blue : IfcNormalisedRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccolourrgb.htm">IfcColourRgb</a>
 */
public class IfcColourRgb extends IfcColourSpecification implements IfcColourOrFactor {
    protected IfcNormalisedRatioMeasure red;
    protected IfcNormalisedRatioMeasure green;
    protected IfcNormalisedRatioMeasure blue;

    protected IfcColourRgb() { initCollections(); }
    /**
     * Constructs IfcColourRgb with all required attributes.
     */
    public IfcColourRgb(IfcNormalisedRatioMeasure red,IfcNormalisedRatioMeasure green,IfcNormalisedRatioMeasure blue) {

        super();
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    /**
     * Constructs IfcColourRgb with required and optional attributes.
     */
    public IfcColourRgb(IfcLabel name,IfcNormalisedRatioMeasure red,IfcNormalisedRatioMeasure green,IfcNormalisedRatioMeasure blue) {
        super(name);
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    private void initCollections() {
    }
    public IfcNormalisedRatioMeasure getRed() { return this.red; }
    public void setRed(IfcNormalisedRatioMeasure value) { this.red = value; }
    public IfcNormalisedRatioMeasure getGreen() { return this.green; }
    public void setGreen(IfcNormalisedRatioMeasure value) { this.green = value; }
    public IfcNormalisedRatioMeasure getBlue() { return this.blue; }
    public void setBlue(IfcNormalisedRatioMeasure value) { this.blue = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(red != null ? StepUtils.toStepValue(red) : "$");
		parameters.add(green != null ? StepUtils.toStepValue(green) : "$");
		parameters.add(blue != null ? StepUtils.toStepValue(blue) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}