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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcline.htm">IfcLine</a>
 */
public class IfcLine extends IfcCurve {
    protected IfcCartesianPoint pnt;
    protected IfcVector dir;

    protected IfcLine() { initCollections(); }
    /**
     * Constructs IfcLine with all required attributes.
     */
    public IfcLine(IfcCartesianPoint pnt,IfcVector dir) {
        super();
        this.pnt = pnt;
        this.dir = dir;
    }
    private void initCollections() {
    }
    public IfcCartesianPoint getPnt() { return this.pnt; }
    public void setPnt(IfcCartesianPoint value) { this.pnt = value; }
    public IfcVector getDir() { return this.dir; }
    public void setDir(IfcVector value) { this.dir = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(pnt != null ? StepUtils.toStepValue(pnt) : "$");
		parameters.add(dir != null ? StepUtils.toStepValue(dir) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}