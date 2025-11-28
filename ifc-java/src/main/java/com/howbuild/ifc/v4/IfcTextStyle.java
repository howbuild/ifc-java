package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPresentationStyle
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCurveStyle
 * ,IfcFillAreaStyle
 * ,IfcSurfaceStyle
 * ,IfcTextStyle));
 * Name : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctextstyle.htm">IfcTextStyle</a>
 */
public class IfcTextStyle extends IfcPresentationStyle implements IfcPresentationStyleSelect {
    protected IfcTextStyleForDefinedFont textCharacterAppearance;
    protected IfcTextStyleTextModel textStyle;
    protected IfcTextFontSelect textFontStyle;
    protected IfcBoolean modelOrDraughting;

    protected IfcTextStyle() { initCollections(); }
    /**
     * Constructs IfcTextStyle with all required attributes.
     */
    public IfcTextStyle(IfcTextFontSelect textFontStyle) {

        super();
        this.textFontStyle = textFontStyle;
    }
    /**
     * Constructs IfcTextStyle with required and optional attributes.
     */
    public IfcTextStyle(IfcLabel name,IfcTextStyleForDefinedFont textCharacterAppearance,IfcTextStyleTextModel textStyle,IfcTextFontSelect textFontStyle,IfcBoolean modelOrDraughting) {
        super(name);
        this.textCharacterAppearance = textCharacterAppearance;
        this.textStyle = textStyle;
        this.textFontStyle = textFontStyle;
        this.modelOrDraughting = modelOrDraughting;
    }
    private void initCollections() {
    }
    public IfcTextStyleForDefinedFont getTextCharacterAppearance() { return this.textCharacterAppearance; }
    public void setTextCharacterAppearance(IfcTextStyleForDefinedFont value) { this.textCharacterAppearance = value; } // optional
    public IfcTextStyleTextModel getTextStyle() { return this.textStyle; }
    public void setTextStyle(IfcTextStyleTextModel value) { this.textStyle = value; } // optional
    public IfcTextFontSelect getTextFontStyle() { return this.textFontStyle; }
    public void setTextFontStyle(IfcTextFontSelect value) { this.textFontStyle = value; }
    public IfcBoolean getModelOrDraughting() { return this.modelOrDraughting; }
    public void setModelOrDraughting(IfcBoolean value) { this.modelOrDraughting = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(textCharacterAppearance != null ? StepUtils.toStepValue(textCharacterAppearance) : "$");
		parameters.add(textStyle != null ? StepUtils.toStepValue(textStyle) : "$");
		parameters.add(textFontStyle != null ? StepUtils.toStepValue(textFontStyle) : "$");
		parameters.add(modelOrDraughting != null ? StepUtils.toStepValue(modelOrDraughting) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}