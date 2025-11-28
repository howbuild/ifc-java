package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConic
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCircle
 * ,IfcEllipse))
 * SUBTYPE OF (IfcCurve);
 * Position : IfcAxis2Placement;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcellipse.htm">IfcEllipse</a>
 */
public class IfcEllipse extends IfcConic {
    protected IfcPositiveLengthMeasure semiAxis1;
    protected IfcPositiveLengthMeasure semiAxis2;

    protected IfcEllipse() { initCollections(); }
    /**
     * Constructs IfcEllipse with all required attributes.
     */
    public IfcEllipse(IfcAxis2Placement position,IfcPositiveLengthMeasure semiAxis1,IfcPositiveLengthMeasure semiAxis2) {
        super(position);
        this.semiAxis1 = semiAxis1;
        this.semiAxis2 = semiAxis2;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getSemiAxis1() { return this.semiAxis1; }
    public void setSemiAxis1(IfcPositiveLengthMeasure value) { this.semiAxis1 = value; }
    public IfcPositiveLengthMeasure getSemiAxis2() { return this.semiAxis2; }
    public void setSemiAxis2(IfcPositiveLengthMeasure value) { this.semiAxis2 = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(semiAxis1 != null ? StepUtils.toStepValue(semiAxis1) : "$");
		parameters.add(semiAxis2 != null ? StepUtils.toStepValue(semiAxis2) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}