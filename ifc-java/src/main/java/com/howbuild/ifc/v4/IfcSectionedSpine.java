package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGeometricRepresentationItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcAnnotationFillArea
 * ,IfcBooleanResult
 * ,IfcBoundingBox
 * ,IfcCartesianPointList
 * ,IfcCartesianTransformationOperator
 * ,IfcCompositeCurveSegment
 * ,IfcCsgPrimitive3D
 * ,IfcCurve
 * ,IfcDirection
 * ,IfcFaceBasedSurfaceModel
 * ,IfcFillAreaStyleHatching
 * ,IfcFillAreaStyleTiles
 * ,IfcGeometricSet
 * ,IfcHalfSpaceSolid
 * ,IfcLightSource
 * ,IfcPlacement
 * ,IfcPlanarExtent
 * ,IfcPoint
 * ,IfcSectionedSpine
 * ,IfcShellBasedSurfaceModel
 * ,IfcSolidModel
 * ,IfcSurface
 * ,IfcTessellatedItem
 * ,IfcTextLiteral
 * ,IfcVector))
 * SUBTYPE OF (IfcRepresentationItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsectionedspine.htm">IfcSectionedSpine</a>
 */
public class IfcSectionedSpine extends IfcGeometricRepresentationItem {
    protected IfcCompositeCurve spineCurve;
    protected Collection<IfcProfileDef> crossSections;
    protected Collection<IfcAxis2Placement3D> crossSectionPositions;

    protected IfcSectionedSpine() { initCollections(); }
    /**
     * Constructs IfcSectionedSpine with all required attributes.
     */
    public IfcSectionedSpine(IfcCompositeCurve spineCurve,Collection<IfcProfileDef> crossSections,Collection<IfcAxis2Placement3D> crossSectionPositions) {
        super();
        this.spineCurve = spineCurve;
        this.crossSections = crossSections;
        this.crossSectionPositions = crossSectionPositions;
    }
    private void initCollections() {
        this.crossSections = new ArrayList<>();
        this.crossSectionPositions = new ArrayList<>();
    }
    public IfcCompositeCurve getSpineCurve() { return this.spineCurve; }
    public void setSpineCurve(IfcCompositeCurve value) { this.spineCurve = value; }
    public Collection<IfcProfileDef> getCrossSections() { return this.crossSections; }
    public void setCrossSections(Collection<IfcProfileDef> value) { this.crossSections = value; }
    public Collection<IfcAxis2Placement3D> getCrossSectionPositions() { return this.crossSectionPositions; }
    public void setCrossSectionPositions(Collection<IfcAxis2Placement3D> value) { this.crossSectionPositions = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(spineCurve != null ? StepUtils.toStepValue(spineCurve) : "$");
		parameters.add(crossSections != null ? StepUtils.toStepValue(crossSections) : "$");
		parameters.add(crossSectionPositions != null ? StepUtils.toStepValue(crossSectionPositions) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}