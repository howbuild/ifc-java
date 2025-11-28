package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcIndexedColourMap
 * SUBTYPE OF (IfcPresentationItem);
 * MappedTo : IfcTessellatedFaceSet;
 * Opacity : OPTIONAL IfcNormalisedRatioMeasure;
 * Colours : IfcColourRgbList;
 * ColourIndex : LIST [1:?] OF IfcPositiveInteger;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcindexedcolourmap.htm">IfcIndexedColourMap</a>
 */
public class IfcIndexedColourMap extends IfcPresentationItem {
    protected IfcTessellatedFaceSet mappedTo;
    protected IfcNormalisedRatioMeasure opacity;
    protected IfcColourRgbList colours;
    protected Collection<IfcPositiveInteger> colourIndex;

    protected IfcIndexedColourMap() { initCollections(); }
    /**
     * Constructs IfcIndexedColourMap with all required attributes.
     */
    public IfcIndexedColourMap(IfcTessellatedFaceSet mappedTo,IfcColourRgbList colours,Collection<IfcPositiveInteger> colourIndex) {

        super();
        this.mappedTo = mappedTo;
        this.colours = colours;
        this.colourIndex = colourIndex;
    }
    /**
     * Constructs IfcIndexedColourMap with required and optional attributes.
     */
    public IfcIndexedColourMap(IfcTessellatedFaceSet mappedTo,IfcNormalisedRatioMeasure opacity,IfcColourRgbList colours,Collection<IfcPositiveInteger> colourIndex) {
        super();
        this.mappedTo = mappedTo;
        this.opacity = opacity;
        this.colours = colours;
        this.colourIndex = colourIndex;
    }
    private void initCollections() {
        this.colourIndex = new ArrayList<>();
    }
    public IfcTessellatedFaceSet getMappedTo() { return this.mappedTo; }
    public void setMappedTo(IfcTessellatedFaceSet value) { this.mappedTo = value; }
    public IfcNormalisedRatioMeasure getOpacity() { return this.opacity; }
    public void setOpacity(IfcNormalisedRatioMeasure value) { this.opacity = value; } // optional
    public IfcColourRgbList getColours() { return this.colours; }
    public void setColours(IfcColourRgbList value) { this.colours = value; }
    public Collection<IfcPositiveInteger> getColourIndex() { return this.colourIndex; }
    public void setColourIndex(Collection<IfcPositiveInteger> value) { this.colourIndex = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(mappedTo != null ? StepUtils.toStepValue(mappedTo) : "$");
		parameters.add(opacity != null ? StepUtils.toStepValue(opacity) : "$");
		parameters.add(colours != null ? StepUtils.toStepValue(colours) : "$");
		parameters.add(colourIndex != null ? StepUtils.toStepValue(colourIndex) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcIndexedColourMapRelationship(); }
    private void setIfcIndexedColourMapRelationship() {
		if (this.mappedTo != null) {
		    if (this.mappedTo instanceof IfcTessellatedFaceSet)
		        ((IfcTessellatedFaceSet)this.mappedTo).hasColours.add(this);
		}
    }
}