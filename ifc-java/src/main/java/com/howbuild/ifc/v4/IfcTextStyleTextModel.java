package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPresentationItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcColourRgbList
 * ,IfcColourSpecification
 * ,IfcCurveStyleFont
 * ,IfcCurveStyleFontAndScaling
 * ,IfcCurveStyleFontPattern
 * ,IfcIndexedColourMap
 * ,IfcPreDefinedItem
 * ,IfcSurfaceStyleLighting
 * ,IfcSurfaceStyleRefraction
 * ,IfcSurfaceStyleShading
 * ,IfcSurfaceStyleWithTextures
 * ,IfcSurfaceTexture
 * ,IfcTextStyleForDefinedFont
 * ,IfcTextStyleTextModel
 * ,IfcTextureCoordinate
 * ,IfcTextureVertex
 * ,IfcTextureVertexList));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctextstyletextmodel.htm">IfcTextStyleTextModel</a>
 */
public class IfcTextStyleTextModel extends IfcPresentationItem {
    protected IfcSizeSelect textIndent;
    protected IfcTextAlignment textAlign;
    protected IfcTextDecoration textDecoration;
    protected IfcSizeSelect letterSpacing;
    protected IfcSizeSelect wordSpacing;
    protected IfcTextTransformation textTransform;
    protected IfcSizeSelect lineHeight;


    /**
     * Constructs IfcTextStyleTextModel with all required attributes.
     */
    public IfcTextStyleTextModel() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcTextStyleTextModel with required and optional attributes.
     */
    public IfcTextStyleTextModel(IfcSizeSelect textIndent,IfcTextAlignment textAlign,IfcTextDecoration textDecoration,IfcSizeSelect letterSpacing,IfcSizeSelect wordSpacing,IfcTextTransformation textTransform,IfcSizeSelect lineHeight) {
        super();
        this.textIndent = textIndent;
        this.textAlign = textAlign;
        this.textDecoration = textDecoration;
        this.letterSpacing = letterSpacing;
        this.wordSpacing = wordSpacing;
        this.textTransform = textTransform;
        this.lineHeight = lineHeight;
    }
    private void initCollections() {
    }
    public IfcSizeSelect getTextIndent() { return this.textIndent; }
    public void setTextIndent(IfcSizeSelect value) { this.textIndent = value; } // optional
    public IfcTextAlignment getTextAlign() { return this.textAlign; }
    public void setTextAlign(IfcTextAlignment value) { this.textAlign = value; } // optional
    public IfcTextDecoration getTextDecoration() { return this.textDecoration; }
    public void setTextDecoration(IfcTextDecoration value) { this.textDecoration = value; } // optional
    public IfcSizeSelect getLetterSpacing() { return this.letterSpacing; }
    public void setLetterSpacing(IfcSizeSelect value) { this.letterSpacing = value; } // optional
    public IfcSizeSelect getWordSpacing() { return this.wordSpacing; }
    public void setWordSpacing(IfcSizeSelect value) { this.wordSpacing = value; } // optional
    public IfcTextTransformation getTextTransform() { return this.textTransform; }
    public void setTextTransform(IfcTextTransformation value) { this.textTransform = value; } // optional
    public IfcSizeSelect getLineHeight() { return this.lineHeight; }
    public void setLineHeight(IfcSizeSelect value) { this.lineHeight = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(textIndent != null ? StepUtils.toStepValue(textIndent) : "$");
		parameters.add(textAlign != null ? StepUtils.toStepValue(textAlign) : "$");
		parameters.add(textDecoration != null ? StepUtils.toStepValue(textDecoration) : "$");
		parameters.add(letterSpacing != null ? StepUtils.toStepValue(letterSpacing) : "$");
		parameters.add(wordSpacing != null ? StepUtils.toStepValue(wordSpacing) : "$");
		parameters.add(textTransform != null ? StepUtils.toStepValue(textTransform) : "$");
		parameters.add(lineHeight != null ? StepUtils.toStepValue(lineHeight) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}