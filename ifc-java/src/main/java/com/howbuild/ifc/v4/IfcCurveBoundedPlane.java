package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundedSurface
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineSurface
 * ,IfcCurveBoundedPlane
 * ,IfcCurveBoundedSurface
 * ,IfcRectangularTrimmedSurface))
 * SUBTYPE OF (IfcSurface);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurveboundedplane.htm">IfcCurveBoundedPlane</a>
 */
public class IfcCurveBoundedPlane extends IfcBoundedSurface {
    protected IfcPlane basisSurface;
    protected IfcCurve outerBoundary;
    protected Collection<IfcCurve> innerBoundaries;

    protected IfcCurveBoundedPlane() { initCollections(); }
    /**
     * Constructs IfcCurveBoundedPlane with all required attributes.
     */
    public IfcCurveBoundedPlane(IfcPlane basisSurface,IfcCurve outerBoundary,Collection<IfcCurve> innerBoundaries) {
        super();
        this.basisSurface = basisSurface;
        this.outerBoundary = outerBoundary;
        this.innerBoundaries = innerBoundaries;
    }
    private void initCollections() {
        this.innerBoundaries = new ArrayList<>();
    }
    public IfcPlane getBasisSurface() { return this.basisSurface; }
    public void setBasisSurface(IfcPlane value) { this.basisSurface = value; }
    public IfcCurve getOuterBoundary() { return this.outerBoundary; }
    public void setOuterBoundary(IfcCurve value) { this.outerBoundary = value; }
    public Collection<IfcCurve> getInnerBoundaries() { return this.innerBoundaries; }
    public void setInnerBoundaries(Collection<IfcCurve> value) { this.innerBoundaries = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisSurface != null ? StepUtils.toStepValue(basisSurface) : "$");
		parameters.add(outerBoundary != null ? StepUtils.toStepValue(outerBoundary) : "$");
		parameters.add(innerBoundaries != null ? StepUtils.toStepValue(innerBoundaries) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}