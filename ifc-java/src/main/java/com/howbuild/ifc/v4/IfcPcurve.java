package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBoundedCurve
 * ,IfcConic
 * ,IfcLine
 * ,IfcOffsetCurve2D
 * ,IfcOffsetCurve3D
 * ,IfcPcurve
 * ,IfcSurfaceCurve))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DERIVE
 * Dim : IfcDimensionCount := IfcCurveDim(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpcurve.htm">IfcPcurve</a>
 */
public class IfcPcurve extends IfcCurve implements IfcCurveOnSurface {
    protected IfcSurface basisSurface;
    protected IfcCurve referenceCurve;

    protected IfcPcurve() { initCollections(); }
    /**
     * Constructs IfcPcurve with all required attributes.
     */
    public IfcPcurve(IfcSurface basisSurface,IfcCurve referenceCurve) {
        super();
        this.basisSurface = basisSurface;
        this.referenceCurve = referenceCurve;
    }
    private void initCollections() {
    }
    public IfcSurface getBasisSurface() { return this.basisSurface; }
    public void setBasisSurface(IfcSurface value) { this.basisSurface = value; }
    public IfcCurve getReferenceCurve() { return this.referenceCurve; }
    public void setReferenceCurve(IfcCurve value) { this.referenceCurve = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisSurface != null ? StepUtils.toStepValue(basisSurface) : "$");
		parameters.add(referenceCurve != null ? StepUtils.toStepValue(referenceCurve) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}