package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedPropertySet
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcDoorLiningProperties
 * ,IfcDoorPanelProperties
 * ,IfcPermeableCoveringProperties
 * ,IfcReinforcementDefinitionProperties
 * ,IfcWindowLiningProperties
 * ,IfcWindowPanelProperties))
 * SUBTYPE OF (IfcPropertySetDefinition);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcwindowliningproperties.htm">IfcWindowLiningProperties</a>
 */
public class IfcWindowLiningProperties extends IfcPreDefinedPropertySet {
    protected IfcPositiveLengthMeasure liningDepth;
    protected IfcNonNegativeLengthMeasure liningThickness;
    protected IfcNonNegativeLengthMeasure transomThickness;
    protected IfcNonNegativeLengthMeasure mullionThickness;
    protected IfcNormalisedRatioMeasure firstTransomOffset;
    protected IfcNormalisedRatioMeasure secondTransomOffset;
    protected IfcNormalisedRatioMeasure firstMullionOffset;
    protected IfcNormalisedRatioMeasure secondMullionOffset;
    protected IfcShapeAspect shapeAspectStyle;
    protected IfcLengthMeasure liningOffset;
    protected IfcLengthMeasure liningToPanelOffsetX;
    protected IfcLengthMeasure liningToPanelOffsetY;

    protected IfcWindowLiningProperties() { initCollections(); }
    /**
     * Constructs IfcWindowLiningProperties with all required attributes.
     */
    public IfcWindowLiningProperties(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcWindowLiningProperties with required and optional attributes.
     */
    public IfcWindowLiningProperties(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPositiveLengthMeasure liningDepth,IfcNonNegativeLengthMeasure liningThickness,IfcNonNegativeLengthMeasure transomThickness,IfcNonNegativeLengthMeasure mullionThickness,IfcNormalisedRatioMeasure firstTransomOffset,IfcNormalisedRatioMeasure secondTransomOffset,IfcNormalisedRatioMeasure firstMullionOffset,IfcNormalisedRatioMeasure secondMullionOffset,IfcShapeAspect shapeAspectStyle,IfcLengthMeasure liningOffset,IfcLengthMeasure liningToPanelOffsetX,IfcLengthMeasure liningToPanelOffsetY) {
        super(globalId,ownerHistory,name,description);
        this.liningDepth = liningDepth;
        this.liningThickness = liningThickness;
        this.transomThickness = transomThickness;
        this.mullionThickness = mullionThickness;
        this.firstTransomOffset = firstTransomOffset;
        this.secondTransomOffset = secondTransomOffset;
        this.firstMullionOffset = firstMullionOffset;
        this.secondMullionOffset = secondMullionOffset;
        this.shapeAspectStyle = shapeAspectStyle;
        this.liningOffset = liningOffset;
        this.liningToPanelOffsetX = liningToPanelOffsetX;
        this.liningToPanelOffsetY = liningToPanelOffsetY;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getLiningDepth() { return this.liningDepth; }
    public void setLiningDepth(IfcPositiveLengthMeasure value) { this.liningDepth = value; } // optional
    public IfcNonNegativeLengthMeasure getLiningThickness() { return this.liningThickness; }
    public void setLiningThickness(IfcNonNegativeLengthMeasure value) { this.liningThickness = value; } // optional
    public IfcNonNegativeLengthMeasure getTransomThickness() { return this.transomThickness; }
    public void setTransomThickness(IfcNonNegativeLengthMeasure value) { this.transomThickness = value; } // optional
    public IfcNonNegativeLengthMeasure getMullionThickness() { return this.mullionThickness; }
    public void setMullionThickness(IfcNonNegativeLengthMeasure value) { this.mullionThickness = value; } // optional
    public IfcNormalisedRatioMeasure getFirstTransomOffset() { return this.firstTransomOffset; }
    public void setFirstTransomOffset(IfcNormalisedRatioMeasure value) { this.firstTransomOffset = value; } // optional
    public IfcNormalisedRatioMeasure getSecondTransomOffset() { return this.secondTransomOffset; }
    public void setSecondTransomOffset(IfcNormalisedRatioMeasure value) { this.secondTransomOffset = value; } // optional
    public IfcNormalisedRatioMeasure getFirstMullionOffset() { return this.firstMullionOffset; }
    public void setFirstMullionOffset(IfcNormalisedRatioMeasure value) { this.firstMullionOffset = value; } // optional
    public IfcNormalisedRatioMeasure getSecondMullionOffset() { return this.secondMullionOffset; }
    public void setSecondMullionOffset(IfcNormalisedRatioMeasure value) { this.secondMullionOffset = value; } // optional
    public IfcShapeAspect getShapeAspectStyle() { return this.shapeAspectStyle; }
    public void setShapeAspectStyle(IfcShapeAspect value) { this.shapeAspectStyle = value; } // optional
    public IfcLengthMeasure getLiningOffset() { return this.liningOffset; }
    public void setLiningOffset(IfcLengthMeasure value) { this.liningOffset = value; } // optional
    public IfcLengthMeasure getLiningToPanelOffsetX() { return this.liningToPanelOffsetX; }
    public void setLiningToPanelOffsetX(IfcLengthMeasure value) { this.liningToPanelOffsetX = value; } // optional
    public IfcLengthMeasure getLiningToPanelOffsetY() { return this.liningToPanelOffsetY; }
    public void setLiningToPanelOffsetY(IfcLengthMeasure value) { this.liningToPanelOffsetY = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(liningDepth != null ? StepUtils.toStepValue(liningDepth) : "$");
		parameters.add(liningThickness != null ? StepUtils.toStepValue(liningThickness) : "$");
		parameters.add(transomThickness != null ? StepUtils.toStepValue(transomThickness) : "$");
		parameters.add(mullionThickness != null ? StepUtils.toStepValue(mullionThickness) : "$");
		parameters.add(firstTransomOffset != null ? StepUtils.toStepValue(firstTransomOffset) : "$");
		parameters.add(secondTransomOffset != null ? StepUtils.toStepValue(secondTransomOffset) : "$");
		parameters.add(firstMullionOffset != null ? StepUtils.toStepValue(firstMullionOffset) : "$");
		parameters.add(secondMullionOffset != null ? StepUtils.toStepValue(secondMullionOffset) : "$");
		parameters.add(shapeAspectStyle != null ? StepUtils.toStepValue(shapeAspectStyle) : "$");
		parameters.add(liningOffset != null ? StepUtils.toStepValue(liningOffset) : "$");
		parameters.add(liningToPanelOffsetX != null ? StepUtils.toStepValue(liningToPanelOffsetX) : "$");
		parameters.add(liningToPanelOffsetY != null ? StepUtils.toStepValue(liningToPanelOffsetY) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}