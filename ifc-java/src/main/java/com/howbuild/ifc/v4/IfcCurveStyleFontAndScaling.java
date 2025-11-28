package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurveStyleFontAndScaling
 * SUBTYPE OF (IfcPresentationItem);
 * Name : OPTIONAL IfcLabel;
 * CurveFont : IfcCurveStyleFontSelect;
 * CurveFontScaling : IfcPositiveRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurvestylefontandscaling.htm">IfcCurveStyleFontAndScaling</a>
 */
public class IfcCurveStyleFontAndScaling extends IfcPresentationItem implements IfcCurveFontOrScaledCurveFontSelect {
    protected IfcLabel name;
    protected IfcCurveStyleFontSelect curveFont;
    protected IfcPositiveRatioMeasure curveFontScaling;

    protected IfcCurveStyleFontAndScaling() { initCollections(); }
    /**
     * Constructs IfcCurveStyleFontAndScaling with all required attributes.
     */
    public IfcCurveStyleFontAndScaling(IfcCurveStyleFontSelect curveFont,IfcPositiveRatioMeasure curveFontScaling) {

        super();
        this.curveFont = curveFont;
        this.curveFontScaling = curveFontScaling;
    }
    /**
     * Constructs IfcCurveStyleFontAndScaling with required and optional attributes.
     */
    public IfcCurveStyleFontAndScaling(IfcLabel name,IfcCurveStyleFontSelect curveFont,IfcPositiveRatioMeasure curveFontScaling) {
        super();
        this.name = name;
        this.curveFont = curveFont;
        this.curveFontScaling = curveFontScaling;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcCurveStyleFontSelect getCurveFont() { return this.curveFont; }
    public void setCurveFont(IfcCurveStyleFontSelect value) { this.curveFont = value; }
    public IfcPositiveRatioMeasure getCurveFontScaling() { return this.curveFontScaling; }
    public void setCurveFontScaling(IfcPositiveRatioMeasure value) { this.curveFontScaling = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(curveFont != null ? StepUtils.toStepValue(curveFont) : "$");
		parameters.add(curveFontScaling != null ? StepUtils.toStepValue(curveFontScaling) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}