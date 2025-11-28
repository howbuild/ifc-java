package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEllipseProfileDef
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * SemiAxis1 : IfcPositiveLengthMeasure;
 * SemiAxis2 : IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcellipseprofiledef.htm">IfcEllipseProfileDef</a>
 */
public class IfcEllipseProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure semiAxis1;
    protected IfcPositiveLengthMeasure semiAxis2;

    protected IfcEllipseProfileDef() { initCollections(); }
    /**
     * Constructs IfcEllipseProfileDef with all required attributes.
     */
    public IfcEllipseProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure semiAxis1,IfcPositiveLengthMeasure semiAxis2) {

        super(profileType);
        this.semiAxis1 = semiAxis1;
        this.semiAxis2 = semiAxis2;
    }
    /**
     * Constructs IfcEllipseProfileDef with required and optional attributes.
     */
    public IfcEllipseProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure semiAxis1,IfcPositiveLengthMeasure semiAxis2) {
        super(profileType,profileName,position);
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
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(semiAxis1 != null ? StepUtils.toStepValue(semiAxis1) : "$");
		parameters.add(semiAxis2 != null ? StepUtils.toStepValue(semiAxis2) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}