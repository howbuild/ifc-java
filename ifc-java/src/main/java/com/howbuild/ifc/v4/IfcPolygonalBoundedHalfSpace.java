package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcHalfSpaceSolid
 * SUPERTYPE OF (ONEOF
 * (IfcBoxedHalfSpace
 * ,IfcPolygonalBoundedHalfSpace))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * BaseSurface : IfcSurface;
 * AgreementFlag : IfcBoolean;
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpolygonalboundedhalfspace.htm">IfcPolygonalBoundedHalfSpace</a>
 */
public class IfcPolygonalBoundedHalfSpace extends IfcHalfSpaceSolid {
    protected IfcAxis2Placement3D position;
    protected IfcBoundedCurve polygonalBoundary;

    protected IfcPolygonalBoundedHalfSpace() { initCollections(); }
    /**
     * Constructs IfcPolygonalBoundedHalfSpace with all required attributes.
     */
    public IfcPolygonalBoundedHalfSpace(IfcSurface baseSurface,IfcBoolean agreementFlag,IfcAxis2Placement3D position,IfcBoundedCurve polygonalBoundary) {
        super(baseSurface,agreementFlag);
        this.position = position;
        this.polygonalBoundary = polygonalBoundary;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement3D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement3D value) { this.position = value; }
    public IfcBoundedCurve getPolygonalBoundary() { return this.polygonalBoundary; }
    public void setPolygonalBoundary(IfcBoundedCurve value) { this.polygonalBoundary = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(baseSurface != null ? StepUtils.toStepValue(baseSurface) : "$");
		parameters.add(agreementFlag != null ? StepUtils.toStepValue(agreementFlag) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(polygonalBoundary != null ? StepUtils.toStepValue(polygonalBoundary) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}