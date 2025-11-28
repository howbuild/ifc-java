package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedTextFont
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcTextStyleFontModel))
 * SUBTYPE OF (IfcPreDefinedItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctextstylefontmodel.htm">IfcTextStyleFontModel</a>
 */
public class IfcTextStyleFontModel extends IfcPreDefinedTextFont {
    protected Collection<IfcTextFontName> fontFamily;
    protected IfcFontStyle fontStyle;
    protected IfcFontVariant fontVariant;
    protected IfcFontWeight fontWeight;
    protected IfcSizeSelect fontSize;

    protected IfcTextStyleFontModel() { initCollections(); }
    /**
     * Constructs IfcTextStyleFontModel with all required attributes.
     */
    public IfcTextStyleFontModel(IfcLabel name,Collection<IfcTextFontName> fontFamily,IfcSizeSelect fontSize) {

        super(name);
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }
    /**
     * Constructs IfcTextStyleFontModel with required and optional attributes.
     */
    public IfcTextStyleFontModel(IfcLabel name,Collection<IfcTextFontName> fontFamily,IfcFontStyle fontStyle,IfcFontVariant fontVariant,IfcFontWeight fontWeight,IfcSizeSelect fontSize) {
        super(name);
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.fontVariant = fontVariant;
        this.fontWeight = fontWeight;
        this.fontSize = fontSize;
    }
    private void initCollections() {
        this.fontFamily = new ArrayList<>();
    }
    public Collection<IfcTextFontName> getFontFamily() { return this.fontFamily; }
    public void setFontFamily(Collection<IfcTextFontName> value) { this.fontFamily = value; }
    public IfcFontStyle getFontStyle() { return this.fontStyle; }
    public void setFontStyle(IfcFontStyle value) { this.fontStyle = value; } // optional
    public IfcFontVariant getFontVariant() { return this.fontVariant; }
    public void setFontVariant(IfcFontVariant value) { this.fontVariant = value; } // optional
    public IfcFontWeight getFontWeight() { return this.fontWeight; }
    public void setFontWeight(IfcFontWeight value) { this.fontWeight = value; } // optional
    public IfcSizeSelect getFontSize() { return this.fontSize; }
    public void setFontSize(IfcSizeSelect value) { this.fontSize = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(fontFamily != null ? StepUtils.toStepValue(fontFamily) : "$");
		parameters.add(fontStyle != null ? StepUtils.toStepValue(fontStyle) : "$");
		parameters.add(fontVariant != null ? StepUtils.toStepValue(fontVariant) : "$");
		parameters.add(fontWeight != null ? StepUtils.toStepValue(fontWeight) : "$");
		parameters.add(fontSize != null ? StepUtils.toStepValue(fontSize) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}