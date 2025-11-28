package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurveStyle
 * SUBTYPE OF (IfcPresentationStyle);
 * CurveFont : OPTIONAL IfcCurveFontOrScaledCurveFontSelect;
 * CurveWidth : OPTIONAL IfcSizeSelect;
 * CurveColour : OPTIONAL IfcColour;
 * ModelOrDraughting : OPTIONAL IfcBoolean;
 * WHERE
 * MeasureOfWidth : (NOT(EXISTS(CurveWidth))) OR
 * ('IFC4.IFCPOSITIVELENGTHMEASURE' IN TYPEOF(CurveWidth)) OR
 * (('IFC4.IFCDESCRIPTIVEMEASURE' IN TYPEOF(CurveWidth)) AND
 * (CurveWidth = 'by layer'));
 * IdentifiableCurveStyle : EXISTS(CurveFont) OR EXISTS(CurveWidth) OR EXISTS(CurveColour);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurvestyle.htm">IfcCurveStyle</a>
 */
public class IfcCurveStyle extends IfcPresentationStyle implements IfcPresentationStyleSelect {
    protected IfcCurveFontOrScaledCurveFontSelect curveFont;
    protected IfcSizeSelect curveWidth;
    protected IfcColour curveColour;
    protected IfcBoolean modelOrDraughting;


    /**
     * Constructs IfcCurveStyle with all required attributes.
     */
    public IfcCurveStyle() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcCurveStyle with required and optional attributes.
     */
    public IfcCurveStyle(IfcLabel name,IfcCurveFontOrScaledCurveFontSelect curveFont,IfcSizeSelect curveWidth,IfcColour curveColour,IfcBoolean modelOrDraughting) {
        super(name);
        this.curveFont = curveFont;
        this.curveWidth = curveWidth;
        this.curveColour = curveColour;
        this.modelOrDraughting = modelOrDraughting;
    }
    private void initCollections() {
    }
    public IfcCurveFontOrScaledCurveFontSelect getCurveFont() { return this.curveFont; }
    public void setCurveFont(IfcCurveFontOrScaledCurveFontSelect value) { this.curveFont = value; } // optional
    public IfcSizeSelect getCurveWidth() { return this.curveWidth; }
    public void setCurveWidth(IfcSizeSelect value) { this.curveWidth = value; } // optional
    public IfcColour getCurveColour() { return this.curveColour; }
    public void setCurveColour(IfcColour value) { this.curveColour = value; } // optional
    public IfcBoolean getModelOrDraughting() { return this.modelOrDraughting; }
    public void setModelOrDraughting(IfcBoolean value) { this.modelOrDraughting = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(curveFont != null ? StepUtils.toStepValue(curveFont) : "$");
		parameters.add(curveWidth != null ? StepUtils.toStepValue(curveWidth) : "$");
		parameters.add(curveColour != null ? StepUtils.toStepValue(curveColour) : "$");
		parameters.add(modelOrDraughting != null ? StepUtils.toStepValue(modelOrDraughting) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}