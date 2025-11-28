package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAnnotationFillArea
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * OuterBoundary : IfcCurve;
 * InnerBoundaries : OPTIONAL SET [1:?] OF IfcCurve;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcannotationfillarea.htm">IfcAnnotationFillArea</a>
 */
public class IfcAnnotationFillArea extends IfcGeometricRepresentationItem {
    protected IfcCurve outerBoundary;
    protected Collection<IfcCurve> innerBoundaries;

    protected IfcAnnotationFillArea() { initCollections(); }
    /**
     * Constructs IfcAnnotationFillArea with all required attributes.
     */
    public IfcAnnotationFillArea(IfcCurve outerBoundary) {

        super();
        this.innerBoundaries = new ArrayList<>();
        this.outerBoundary = outerBoundary;
    }
    /**
     * Constructs IfcAnnotationFillArea with required and optional attributes.
     */
    public IfcAnnotationFillArea(IfcCurve outerBoundary,Collection<IfcCurve> innerBoundaries) {
        super();
        this.outerBoundary = outerBoundary;
        this.innerBoundaries = innerBoundaries;
    }
    private void initCollections() {
        this.innerBoundaries = new ArrayList<>();
    }
    public IfcCurve getOuterBoundary() { return this.outerBoundary; }
    public void setOuterBoundary(IfcCurve value) { this.outerBoundary = value; }
    public Collection<IfcCurve> getInnerBoundaries() { return this.innerBoundaries; }
    public void setInnerBoundaries(Collection<IfcCurve> value) { this.innerBoundaries = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(outerBoundary != null ? StepUtils.toStepValue(outerBoundary) : "$");
		parameters.add(innerBoundaries != null ? StepUtils.toStepValue(innerBoundaries) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}