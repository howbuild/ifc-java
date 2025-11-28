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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurveboundedsurface.htm">IfcCurveBoundedSurface</a>
 */
public class IfcCurveBoundedSurface extends IfcBoundedSurface {
    protected IfcSurface basisSurface;
    protected Collection<IfcBoundaryCurve> boundaries;
    protected IfcBoolean implicitOuter;

    protected IfcCurveBoundedSurface() { initCollections(); }
    /**
     * Constructs IfcCurveBoundedSurface with all required attributes.
     */
    public IfcCurveBoundedSurface(IfcSurface basisSurface,Collection<IfcBoundaryCurve> boundaries,IfcBoolean implicitOuter) {
        super();
        this.basisSurface = basisSurface;
        this.boundaries = boundaries;
        this.implicitOuter = implicitOuter;
    }
    private void initCollections() {
        this.boundaries = new ArrayList<>();
    }
    public IfcSurface getBasisSurface() { return this.basisSurface; }
    public void setBasisSurface(IfcSurface value) { this.basisSurface = value; }
    public Collection<IfcBoundaryCurve> getBoundaries() { return this.boundaries; }
    public void setBoundaries(Collection<IfcBoundaryCurve> value) { this.boundaries = value; }
    public IfcBoolean getImplicitOuter() { return this.implicitOuter; }
    public void setImplicitOuter(IfcBoolean value) { this.implicitOuter = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisSurface != null ? StepUtils.toStepValue(basisSurface) : "$");
		parameters.add(boundaries != null ? StepUtils.toStepValue(boundaries) : "$");
		parameters.add(implicitOuter != null ? StepUtils.toStepValue(implicitOuter) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}