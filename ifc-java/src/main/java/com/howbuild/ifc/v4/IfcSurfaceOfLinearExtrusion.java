package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSurfaceOfLinearExtrusion
 * SUBTYPE OF (IfcSweptSurface);
 * ExtrudedDirection : IfcDirection;
 * Depth : IfcLengthMeasure;
 * DERIVE
 * ExtrusionAxis : IfcVector := IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcVector (ExtrudedDirection, Depth);
 * WHERE
 * DepthGreaterZero : Depth > 0.;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfaceoflinearextrusion.htm">IfcSurfaceOfLinearExtrusion</a>
 */
public class IfcSurfaceOfLinearExtrusion extends IfcSweptSurface {
    protected IfcDirection extrudedDirection;
    protected IfcLengthMeasure depth;

    protected IfcSurfaceOfLinearExtrusion() { initCollections(); }
    /**
     * Constructs IfcSurfaceOfLinearExtrusion with all required attributes.
     */
    public IfcSurfaceOfLinearExtrusion(IfcProfileDef sweptCurve,IfcDirection extrudedDirection,IfcLengthMeasure depth) {

        super(sweptCurve);
        this.extrudedDirection = extrudedDirection;
        this.depth = depth;
    }
    /**
     * Constructs IfcSurfaceOfLinearExtrusion with required and optional attributes.
     */
    public IfcSurfaceOfLinearExtrusion(IfcProfileDef sweptCurve,IfcAxis2Placement3D position,IfcDirection extrudedDirection,IfcLengthMeasure depth) {
        super(sweptCurve,position);
        this.extrudedDirection = extrudedDirection;
        this.depth = depth;
    }
    private void initCollections() {
    }
    public IfcDirection getExtrudedDirection() { return this.extrudedDirection; }
    public void setExtrudedDirection(IfcDirection value) { this.extrudedDirection = value; }
    public IfcLengthMeasure getDepth() { return this.depth; }
    public void setDepth(IfcLengthMeasure value) { this.depth = value; }
    public IfcVector getExtrusionAxis() { throw new UnsupportedOperationException("Derived property logic has been implemented for ExtrusionAxis."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sweptCurve != null ? StepUtils.toStepValue(sweptCurve) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(extrudedDirection != null ? StepUtils.toStepValue(extrudedDirection) : "$");
		parameters.add(depth != null ? StepUtils.toStepValue(depth) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}