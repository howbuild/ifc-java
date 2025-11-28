package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcIShapeProfileDef
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * OverallWidth : IfcPositiveLengthMeasure;
 * OverallDepth : IfcPositiveLengthMeasure;
 * WebThickness : IfcPositiveLengthMeasure;
 * FlangeThickness : IfcPositiveLengthMeasure;
 * FilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * FlangeEdgeRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * FlangeSlope : OPTIONAL IfcPlaneAngleMeasure;
 * WHERE
 * ValidFlangeThickness : (2. * FlangeThickness) < OverallDepth;
 * ValidWebThickness : WebThickness < OverallWidth;
 * ValidFilletRadius : NOT(EXISTS(FilletRadius)) OR
 * ((FilletRadius <= (OverallWidth - WebThickness)/2.) AND
 * (FilletRadius <= (OverallDepth - (2. * FlangeThickness))/2.));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcishapeprofiledef.htm">IfcIShapeProfileDef</a>
 */
public class IfcIShapeProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure overallWidth;
    protected IfcPositiveLengthMeasure overallDepth;
    protected IfcPositiveLengthMeasure webThickness;
    protected IfcPositiveLengthMeasure flangeThickness;
    protected IfcNonNegativeLengthMeasure filletRadius;
    protected IfcNonNegativeLengthMeasure flangeEdgeRadius;
    protected IfcPlaneAngleMeasure flangeSlope;

    protected IfcIShapeProfileDef() { initCollections(); }
    /**
     * Constructs IfcIShapeProfileDef with all required attributes.
     */
    public IfcIShapeProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure overallWidth,IfcPositiveLengthMeasure overallDepth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure flangeThickness) {

        super(profileType);
        this.overallWidth = overallWidth;
        this.overallDepth = overallDepth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
    }
    /**
     * Constructs IfcIShapeProfileDef with required and optional attributes.
     */
    public IfcIShapeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure overallWidth,IfcPositiveLengthMeasure overallDepth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure flangeThickness,IfcNonNegativeLengthMeasure filletRadius,IfcNonNegativeLengthMeasure flangeEdgeRadius,IfcPlaneAngleMeasure flangeSlope) {
        super(profileType,profileName,position);
        this.overallWidth = overallWidth;
        this.overallDepth = overallDepth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
        this.filletRadius = filletRadius;
        this.flangeEdgeRadius = flangeEdgeRadius;
        this.flangeSlope = flangeSlope;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getOverallWidth() { return this.overallWidth; }
    public void setOverallWidth(IfcPositiveLengthMeasure value) { this.overallWidth = value; }
    public IfcPositiveLengthMeasure getOverallDepth() { return this.overallDepth; }
    public void setOverallDepth(IfcPositiveLengthMeasure value) { this.overallDepth = value; }
    public IfcPositiveLengthMeasure getWebThickness() { return this.webThickness; }
    public void setWebThickness(IfcPositiveLengthMeasure value) { this.webThickness = value; }
    public IfcPositiveLengthMeasure getFlangeThickness() { return this.flangeThickness; }
    public void setFlangeThickness(IfcPositiveLengthMeasure value) { this.flangeThickness = value; }
    public IfcNonNegativeLengthMeasure getFilletRadius() { return this.filletRadius; }
    public void setFilletRadius(IfcNonNegativeLengthMeasure value) { this.filletRadius = value; } // optional
    public IfcNonNegativeLengthMeasure getFlangeEdgeRadius() { return this.flangeEdgeRadius; }
    public void setFlangeEdgeRadius(IfcNonNegativeLengthMeasure value) { this.flangeEdgeRadius = value; } // optional
    public IfcPlaneAngleMeasure getFlangeSlope() { return this.flangeSlope; }
    public void setFlangeSlope(IfcPlaneAngleMeasure value) { this.flangeSlope = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(overallWidth != null ? StepUtils.toStepValue(overallWidth) : "$");
		parameters.add(overallDepth != null ? StepUtils.toStepValue(overallDepth) : "$");
		parameters.add(webThickness != null ? StepUtils.toStepValue(webThickness) : "$");
		parameters.add(flangeThickness != null ? StepUtils.toStepValue(flangeThickness) : "$");
		parameters.add(filletRadius != null ? StepUtils.toStepValue(filletRadius) : "$");
		parameters.add(flangeEdgeRadius != null ? StepUtils.toStepValue(flangeEdgeRadius) : "$");
		parameters.add(flangeSlope != null ? StepUtils.toStepValue(flangeSlope) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}