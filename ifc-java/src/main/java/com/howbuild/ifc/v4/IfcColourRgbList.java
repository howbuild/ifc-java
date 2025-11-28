package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcColourRgbList
 * SUBTYPE OF (IfcPresentationItem);
 * ColourList : LIST [1:?] OF LIST [3:3] OF IfcNormalisedRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccolourrgblist.htm">IfcColourRgbList</a>
 */
public class IfcColourRgbList extends IfcPresentationItem {
    protected Collection<Collection<IfcNormalisedRatioMeasure>> colourList;

    protected IfcColourRgbList() { initCollections(); }
    /**
     * Constructs IfcColourRgbList with all required attributes.
     */
    public IfcColourRgbList(Collection<Collection<IfcNormalisedRatioMeasure>> colourList) {
        super();
        this.colourList = colourList;
    }
    private void initCollections() {
        this.colourList = new ArrayList<>();
    }
    public Collection<Collection<IfcNormalisedRatioMeasure>> getColourList() { return this.colourList; }
    public void setColourList(Collection<Collection<IfcNormalisedRatioMeasure>> value) { this.colourList = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(colourList != null ? StepUtils.toStepValue(colourList) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}