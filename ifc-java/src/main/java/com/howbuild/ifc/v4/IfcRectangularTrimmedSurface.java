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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrectangulartrimmedsurface.htm">IfcRectangularTrimmedSurface</a>
 */
public class IfcRectangularTrimmedSurface extends IfcBoundedSurface {
    protected IfcSurface basisSurface;
    protected IfcParameterValue u1;
    protected IfcParameterValue v1;
    protected IfcParameterValue u2;
    protected IfcParameterValue v2;
    protected IfcBoolean usense;
    protected IfcBoolean vsense;

    protected IfcRectangularTrimmedSurface() { initCollections(); }
    /**
     * Constructs IfcRectangularTrimmedSurface with all required attributes.
     */
    public IfcRectangularTrimmedSurface(IfcSurface basisSurface,IfcParameterValue u1,IfcParameterValue v1,IfcParameterValue u2,IfcParameterValue v2,IfcBoolean usense,IfcBoolean vsense) {
        super();
        this.basisSurface = basisSurface;
        this.u1 = u1;
        this.v1 = v1;
        this.u2 = u2;
        this.v2 = v2;
        this.usense = usense;
        this.vsense = vsense;
    }
    private void initCollections() {
    }
    public IfcSurface getBasisSurface() { return this.basisSurface; }
    public void setBasisSurface(IfcSurface value) { this.basisSurface = value; }
    public IfcParameterValue getU1() { return this.u1; }
    public void setU1(IfcParameterValue value) { this.u1 = value; }
    public IfcParameterValue getV1() { return this.v1; }
    public void setV1(IfcParameterValue value) { this.v1 = value; }
    public IfcParameterValue getU2() { return this.u2; }
    public void setU2(IfcParameterValue value) { this.u2 = value; }
    public IfcParameterValue getV2() { return this.v2; }
    public void setV2(IfcParameterValue value) { this.v2 = value; }
    public IfcBoolean getUsense() { return this.usense; }
    public void setUsense(IfcBoolean value) { this.usense = value; }
    public IfcBoolean getVsense() { return this.vsense; }
    public void setVsense(IfcBoolean value) { this.vsense = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisSurface != null ? StepUtils.toStepValue(basisSurface) : "$");
		parameters.add(u1 != null ? StepUtils.toStepValue(u1) : "$");
		parameters.add(v1 != null ? StepUtils.toStepValue(v1) : "$");
		parameters.add(u2 != null ? StepUtils.toStepValue(u2) : "$");
		parameters.add(v2 != null ? StepUtils.toStepValue(v2) : "$");
		parameters.add(usense != null ? StepUtils.toStepValue(usense) : "$");
		parameters.add(vsense != null ? StepUtils.toStepValue(vsense) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}