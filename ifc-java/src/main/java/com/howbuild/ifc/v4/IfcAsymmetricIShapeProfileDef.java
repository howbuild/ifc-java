package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAsymmetricIShapeProfileDef
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * BottomFlangeWidth : IfcPositiveLengthMeasure;
 * OverallDepth : IfcPositiveLengthMeasure;
 * WebThickness : IfcPositiveLengthMeasure;
 * BottomFlangeThickness : IfcPositiveLengthMeasure;
 * BottomFlangeFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * TopFlangeWidth : IfcPositiveLengthMeasure;
 * TopFlangeThickness : OPTIONAL IfcPositiveLengthMeasure;
 * TopFlangeFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * BottomFlangeEdgeRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * BottomFlangeSlope : OPTIONAL IfcPlaneAngleMeasure;
 * TopFlangeEdgeRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * TopFlangeSlope : OPTIONAL IfcPlaneAngleMeasure;
 * WHERE
 * ValidFlangeThickness : NOT(EXISTS(TopFlangeThickness)) OR ((BottomFlangeThickness + TopFlangeThickness) < OverallDepth);
 * ValidWebThickness : (WebThickness < BottomFlangeWidth) AND (WebThickness < TopFlangeWidth);
 * ValidBottomFilletRadius : (NOT(EXISTS(BottomFlangeFilletRadius))) OR
 * (BottomFlangeFilletRadius <= (BottomFlangeWidth - WebThickness)/2.);
 * ValidTopFilletRadius : (NOT(EXISTS(TopFlangeFilletRadius))) OR
 * (TopFlangeFilletRadius <= (TopFlangeWidth - WebThickness)/2.);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcasymmetricishapeprofiledef.htm">IfcAsymmetricIShapeProfileDef</a>
 */
public class IfcAsymmetricIShapeProfileDef extends IfcParameterizedProfileDef {
    protected IfcPositiveLengthMeasure bottomFlangeWidth;
    protected IfcPositiveLengthMeasure overallDepth;
    protected IfcPositiveLengthMeasure webThickness;
    protected IfcPositiveLengthMeasure bottomFlangeThickness;
    protected IfcNonNegativeLengthMeasure bottomFlangeFilletRadius;
    protected IfcPositiveLengthMeasure topFlangeWidth;
    protected IfcPositiveLengthMeasure topFlangeThickness;
    protected IfcNonNegativeLengthMeasure topFlangeFilletRadius;
    protected IfcNonNegativeLengthMeasure bottomFlangeEdgeRadius;
    protected IfcPlaneAngleMeasure bottomFlangeSlope;
    protected IfcNonNegativeLengthMeasure topFlangeEdgeRadius;
    protected IfcPlaneAngleMeasure topFlangeSlope;

    protected IfcAsymmetricIShapeProfileDef() { initCollections(); }
    /**
     * Constructs IfcAsymmetricIShapeProfileDef with all required attributes.
     */
    public IfcAsymmetricIShapeProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure bottomFlangeWidth,IfcPositiveLengthMeasure overallDepth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure bottomFlangeThickness,IfcPositiveLengthMeasure topFlangeWidth) {

        super(profileType);
        this.bottomFlangeWidth = bottomFlangeWidth;
        this.overallDepth = overallDepth;
        this.webThickness = webThickness;
        this.bottomFlangeThickness = bottomFlangeThickness;
        this.topFlangeWidth = topFlangeWidth;
    }
    /**
     * Constructs IfcAsymmetricIShapeProfileDef with required and optional attributes.
     */
    public IfcAsymmetricIShapeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure bottomFlangeWidth,IfcPositiveLengthMeasure overallDepth,IfcPositiveLengthMeasure webThickness,IfcPositiveLengthMeasure bottomFlangeThickness,IfcNonNegativeLengthMeasure bottomFlangeFilletRadius,IfcPositiveLengthMeasure topFlangeWidth,IfcPositiveLengthMeasure topFlangeThickness,IfcNonNegativeLengthMeasure topFlangeFilletRadius,IfcNonNegativeLengthMeasure bottomFlangeEdgeRadius,IfcPlaneAngleMeasure bottomFlangeSlope,IfcNonNegativeLengthMeasure topFlangeEdgeRadius,IfcPlaneAngleMeasure topFlangeSlope) {
        super(profileType,profileName,position);
        this.bottomFlangeWidth = bottomFlangeWidth;
        this.overallDepth = overallDepth;
        this.webThickness = webThickness;
        this.bottomFlangeThickness = bottomFlangeThickness;
        this.bottomFlangeFilletRadius = bottomFlangeFilletRadius;
        this.topFlangeWidth = topFlangeWidth;
        this.topFlangeThickness = topFlangeThickness;
        this.topFlangeFilletRadius = topFlangeFilletRadius;
        this.bottomFlangeEdgeRadius = bottomFlangeEdgeRadius;
        this.bottomFlangeSlope = bottomFlangeSlope;
        this.topFlangeEdgeRadius = topFlangeEdgeRadius;
        this.topFlangeSlope = topFlangeSlope;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getBottomFlangeWidth() { return this.bottomFlangeWidth; }
    public void setBottomFlangeWidth(IfcPositiveLengthMeasure value) { this.bottomFlangeWidth = value; }
    public IfcPositiveLengthMeasure getOverallDepth() { return this.overallDepth; }
    public void setOverallDepth(IfcPositiveLengthMeasure value) { this.overallDepth = value; }
    public IfcPositiveLengthMeasure getWebThickness() { return this.webThickness; }
    public void setWebThickness(IfcPositiveLengthMeasure value) { this.webThickness = value; }
    public IfcPositiveLengthMeasure getBottomFlangeThickness() { return this.bottomFlangeThickness; }
    public void setBottomFlangeThickness(IfcPositiveLengthMeasure value) { this.bottomFlangeThickness = value; }
    public IfcNonNegativeLengthMeasure getBottomFlangeFilletRadius() { return this.bottomFlangeFilletRadius; }
    public void setBottomFlangeFilletRadius(IfcNonNegativeLengthMeasure value) { this.bottomFlangeFilletRadius = value; } // optional
    public IfcPositiveLengthMeasure getTopFlangeWidth() { return this.topFlangeWidth; }
    public void setTopFlangeWidth(IfcPositiveLengthMeasure value) { this.topFlangeWidth = value; }
    public IfcPositiveLengthMeasure getTopFlangeThickness() { return this.topFlangeThickness; }
    public void setTopFlangeThickness(IfcPositiveLengthMeasure value) { this.topFlangeThickness = value; } // optional
    public IfcNonNegativeLengthMeasure getTopFlangeFilletRadius() { return this.topFlangeFilletRadius; }
    public void setTopFlangeFilletRadius(IfcNonNegativeLengthMeasure value) { this.topFlangeFilletRadius = value; } // optional
    public IfcNonNegativeLengthMeasure getBottomFlangeEdgeRadius() { return this.bottomFlangeEdgeRadius; }
    public void setBottomFlangeEdgeRadius(IfcNonNegativeLengthMeasure value) { this.bottomFlangeEdgeRadius = value; } // optional
    public IfcPlaneAngleMeasure getBottomFlangeSlope() { return this.bottomFlangeSlope; }
    public void setBottomFlangeSlope(IfcPlaneAngleMeasure value) { this.bottomFlangeSlope = value; } // optional
    public IfcNonNegativeLengthMeasure getTopFlangeEdgeRadius() { return this.topFlangeEdgeRadius; }
    public void setTopFlangeEdgeRadius(IfcNonNegativeLengthMeasure value) { this.topFlangeEdgeRadius = value; } // optional
    public IfcPlaneAngleMeasure getTopFlangeSlope() { return this.topFlangeSlope; }
    public void setTopFlangeSlope(IfcPlaneAngleMeasure value) { this.topFlangeSlope = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(bottomFlangeWidth != null ? StepUtils.toStepValue(bottomFlangeWidth) : "$");
		parameters.add(overallDepth != null ? StepUtils.toStepValue(overallDepth) : "$");
		parameters.add(webThickness != null ? StepUtils.toStepValue(webThickness) : "$");
		parameters.add(bottomFlangeThickness != null ? StepUtils.toStepValue(bottomFlangeThickness) : "$");
		parameters.add(bottomFlangeFilletRadius != null ? StepUtils.toStepValue(bottomFlangeFilletRadius) : "$");
		parameters.add(topFlangeWidth != null ? StepUtils.toStepValue(topFlangeWidth) : "$");
		parameters.add(topFlangeThickness != null ? StepUtils.toStepValue(topFlangeThickness) : "$");
		parameters.add(topFlangeFilletRadius != null ? StepUtils.toStepValue(topFlangeFilletRadius) : "$");
		parameters.add(bottomFlangeEdgeRadius != null ? StepUtils.toStepValue(bottomFlangeEdgeRadius) : "$");
		parameters.add(bottomFlangeSlope != null ? StepUtils.toStepValue(bottomFlangeSlope) : "$");
		parameters.add(topFlangeEdgeRadius != null ? StepUtils.toStepValue(topFlangeEdgeRadius) : "$");
		parameters.add(topFlangeSlope != null ? StepUtils.toStepValue(topFlangeSlope) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}