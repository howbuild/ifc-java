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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacecurve.htm">IfcSurfaceCurve</a>
 */
public class IfcSurfaceCurve extends IfcCurve implements IfcCurveOnSurface {
    protected IfcCurve curve3D;
    protected Collection<IfcPcurve> associatedGeometry;
    protected IfcPreferredSurfaceCurveRepresentation masterRepresentation;

    protected IfcSurfaceCurve() { initCollections(); }
    /**
     * Constructs IfcSurfaceCurve with all required attributes.
     */
    public IfcSurfaceCurve(IfcCurve curve3D,Collection<IfcPcurve> associatedGeometry,IfcPreferredSurfaceCurveRepresentation masterRepresentation) {
        super();
        this.curve3D = curve3D;
        this.associatedGeometry = associatedGeometry;
        this.masterRepresentation = masterRepresentation;
    }
    private void initCollections() {
        this.associatedGeometry = new ArrayList<>();
    }
    public IfcCurve getCurve3D() { return this.curve3D; }
    public void setCurve3D(IfcCurve value) { this.curve3D = value; }
    public Collection<IfcPcurve> getAssociatedGeometry() { return this.associatedGeometry; }
    public void setAssociatedGeometry(Collection<IfcPcurve> value) { this.associatedGeometry = value; }
    public IfcPreferredSurfaceCurveRepresentation getMasterRepresentation() { return this.masterRepresentation; }
    public void setMasterRepresentation(IfcPreferredSurfaceCurveRepresentation value) { this.masterRepresentation = value; }
    public Collection<IfcSurface> getBasisSurface() { throw new UnsupportedOperationException("Derived property logic has been implemented for BasisSurface."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(curve3D != null ? StepUtils.toStepValue(curve3D) : "$");
		parameters.add(associatedGeometry != null ? StepUtils.toStepValue(associatedGeometry) : "$");
		parameters.add(masterRepresentation != null ? StepUtils.toStepValue(masterRepresentation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}