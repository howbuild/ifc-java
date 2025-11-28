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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctextliteral.htm">IfcTextLiteral</a>
 */
public class IfcTextLiteral extends IfcGeometricRepresentationItem {
    protected IfcPresentableText literal;
    protected IfcAxis2Placement placement;
    protected IfcTextPath path;

    protected IfcTextLiteral() { initCollections(); }
    /**
     * Constructs IfcTextLiteral with all required attributes.
     */
    public IfcTextLiteral(IfcPresentableText literal,IfcAxis2Placement placement,IfcTextPath path) {
        super();
        this.literal = literal;
        this.placement = placement;
        this.path = path;
    }
    private void initCollections() {
    }
    public IfcPresentableText getLiteral() { return this.literal; }
    public void setLiteral(IfcPresentableText value) { this.literal = value; }
    public IfcAxis2Placement getPlacement() { return this.placement; }
    public void setPlacement(IfcAxis2Placement value) { this.placement = value; }
    public IfcTextPath getPath() { return this.path; }
    public void setPath(IfcTextPath value) { this.path = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(literal != null ? StepUtils.toStepValue(literal) : "$");
		parameters.add(placement != null ? StepUtils.toStepValue(placement) : "$");
		parameters.add(path != null ? StepUtils.toStepValue(path) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}