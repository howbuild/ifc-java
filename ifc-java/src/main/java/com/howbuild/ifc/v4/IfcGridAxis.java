package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGridAxis;
 * AxisTag : OPTIONAL IfcLabel;
 * AxisCurve : IfcCurve;
 * SameSense : IfcBoolean;
 * INVERSE
 * PartOfW : SET [0:1] OF IfcGrid FOR WAxes;
 * PartOfV : SET [0:1] OF IfcGrid FOR VAxes;
 * PartOfU : SET [0:1] OF IfcGrid FOR UAxes;
 * HasIntersections : SET [0:?] OF IfcVirtualGridIntersection FOR IntersectingAxes;
 * WHERE
 * WR1 : AxisCurve.Dim = 2;
 * WR2 : (SIZEOF(PartOfU) = 1) XOR (SIZEOF(PartOfV) = 1) XOR (SIZEOF(PartOfW) = 1);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgridaxis.htm">IfcGridAxis</a>
 */
public class IfcGridAxis extends BaseIfc {
    protected IfcLabel axisTag;
    protected IfcCurve axisCurve;
    protected IfcBoolean sameSense;
    protected Collection<IfcGrid> partOfW;
    protected Collection<IfcGrid> partOfV;
    protected Collection<IfcGrid> partOfU;
    protected Collection<IfcVirtualGridIntersection> hasIntersections;

    protected IfcGridAxis() { initCollections(); }
    /**
     * Constructs IfcGridAxis with all required attributes.
     */
    public IfcGridAxis(IfcCurve axisCurve,IfcBoolean sameSense) {

        super();
        this.partOfW = new ArrayList<>();
        this.partOfV = new ArrayList<>();
        this.partOfU = new ArrayList<>();
        this.hasIntersections = new ArrayList<>();
        this.axisCurve = axisCurve;
        this.sameSense = sameSense;
    }
    /**
     * Constructs IfcGridAxis with required and optional attributes.
     */
    public IfcGridAxis(IfcLabel axisTag,IfcCurve axisCurve,IfcBoolean sameSense) {
        super();
        this.partOfW = new ArrayList<>();
        this.partOfV = new ArrayList<>();
        this.partOfU = new ArrayList<>();
        this.hasIntersections = new ArrayList<>();
        this.axisTag = axisTag;
        this.axisCurve = axisCurve;
        this.sameSense = sameSense;
    }
    private void initCollections() {
        this.partOfW = new ArrayList<>();
        this.partOfV = new ArrayList<>();
        this.partOfU = new ArrayList<>();
        this.hasIntersections = new ArrayList<>();
    }
    public IfcLabel getAxisTag() { return this.axisTag; }
    public void setAxisTag(IfcLabel value) { this.axisTag = value; } // optional
    public IfcCurve getAxisCurve() { return this.axisCurve; }
    public void setAxisCurve(IfcCurve value) { this.axisCurve = value; }
    public IfcBoolean getSameSense() { return this.sameSense; }
    public void setSameSense(IfcBoolean value) { this.sameSense = value; }
    public Collection<IfcGrid> getPartOfW() { return this.partOfW; }
    public void setPartOfW(Collection<IfcGrid> value) { this.partOfW = value; } // inverse
    public Collection<IfcGrid> getPartOfV() { return this.partOfV; }
    public void setPartOfV(Collection<IfcGrid> value) { this.partOfV = value; } // inverse
    public Collection<IfcGrid> getPartOfU() { return this.partOfU; }
    public void setPartOfU(Collection<IfcGrid> value) { this.partOfU = value; } // inverse
    public Collection<IfcVirtualGridIntersection> getHasIntersections() { return this.hasIntersections; }
    public void setHasIntersections(Collection<IfcVirtualGridIntersection> value) { this.hasIntersections = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(axisTag != null ? StepUtils.toStepValue(axisTag) : "$");
		parameters.add(axisCurve != null ? StepUtils.toStepValue(axisCurve) : "$");
		parameters.add(sameSense != null ? StepUtils.toStepValue(sameSense) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}