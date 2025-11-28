package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDoorLiningProperties
 * SUBTYPE OF (IfcPreDefinedPropertySet);
 * LiningDepth : OPTIONAL IfcPositiveLengthMeasure;
 * LiningThickness : OPTIONAL IfcNonNegativeLengthMeasure;
 * ThresholdDepth : OPTIONAL IfcPositiveLengthMeasure;
 * ThresholdThickness : OPTIONAL IfcNonNegativeLengthMeasure;
 * TransomThickness : OPTIONAL IfcNonNegativeLengthMeasure;
 * TransomOffset : OPTIONAL IfcLengthMeasure;
 * LiningOffset : OPTIONAL IfcLengthMeasure;
 * ThresholdOffset : OPTIONAL IfcLengthMeasure;
 * CasingThickness : OPTIONAL IfcPositiveLengthMeasure;
 * CasingDepth : OPTIONAL IfcPositiveLengthMeasure;
 * ShapeAspectStyle : OPTIONAL IfcShapeAspect;
 * LiningToPanelOffsetX : OPTIONAL IfcLengthMeasure;
 * LiningToPanelOffsetY : OPTIONAL IfcLengthMeasure;
 * WHERE
 * WR31 : NOT(EXISTS(LiningDepth) AND NOT(EXISTS(LiningThickness)));
 * WR32 : NOT(EXISTS(ThresholdDepth) AND NOT(EXISTS(ThresholdThickness)));
 * WR33 : (EXISTS(TransomOffset) AND EXISTS(TransomThickness)) XOR
 * (NOT(EXISTS(TransomOffset)) AND NOT(EXISTS(TransomThickness)));
 * WR34 : (EXISTS(CasingDepth) AND EXISTS(CasingThickness)) XOR
 * (NOT(EXISTS(CasingDepth)) AND NOT(EXISTS(CasingThickness)));
 * WR35 : (EXISTS(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * AND
 * (
 * ('IFC4.IFCDOORTYPE' IN TYPEOF(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * OR
 * ('IFC4.IFCDOORSTYLE' IN TYPEOF(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * );
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdoorliningproperties.htm">IfcDoorLiningProperties</a>
 */
public class IfcDoorLiningProperties extends IfcPreDefinedPropertySet {
    protected IfcPositiveLengthMeasure liningDepth;
    protected IfcNonNegativeLengthMeasure liningThickness;
    protected IfcPositiveLengthMeasure thresholdDepth;
    protected IfcNonNegativeLengthMeasure thresholdThickness;
    protected IfcNonNegativeLengthMeasure transomThickness;
    protected IfcLengthMeasure transomOffset;
    protected IfcLengthMeasure liningOffset;
    protected IfcLengthMeasure thresholdOffset;
    protected IfcPositiveLengthMeasure casingThickness;
    protected IfcPositiveLengthMeasure casingDepth;
    protected IfcShapeAspect shapeAspectStyle;
    protected IfcLengthMeasure liningToPanelOffsetX;
    protected IfcLengthMeasure liningToPanelOffsetY;

    protected IfcDoorLiningProperties() { initCollections(); }
    /**
     * Constructs IfcDoorLiningProperties with all required attributes.
     */
    public IfcDoorLiningProperties(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcDoorLiningProperties with required and optional attributes.
     */
    public IfcDoorLiningProperties(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPositiveLengthMeasure liningDepth,IfcNonNegativeLengthMeasure liningThickness,IfcPositiveLengthMeasure thresholdDepth,IfcNonNegativeLengthMeasure thresholdThickness,IfcNonNegativeLengthMeasure transomThickness,IfcLengthMeasure transomOffset,IfcLengthMeasure liningOffset,IfcLengthMeasure thresholdOffset,IfcPositiveLengthMeasure casingThickness,IfcPositiveLengthMeasure casingDepth,IfcShapeAspect shapeAspectStyle,IfcLengthMeasure liningToPanelOffsetX,IfcLengthMeasure liningToPanelOffsetY) {
        super(globalId,ownerHistory,name,description);
        this.liningDepth = liningDepth;
        this.liningThickness = liningThickness;
        this.thresholdDepth = thresholdDepth;
        this.thresholdThickness = thresholdThickness;
        this.transomThickness = transomThickness;
        this.transomOffset = transomOffset;
        this.liningOffset = liningOffset;
        this.thresholdOffset = thresholdOffset;
        this.casingThickness = casingThickness;
        this.casingDepth = casingDepth;
        this.shapeAspectStyle = shapeAspectStyle;
        this.liningToPanelOffsetX = liningToPanelOffsetX;
        this.liningToPanelOffsetY = liningToPanelOffsetY;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getLiningDepth() { return this.liningDepth; }
    public void setLiningDepth(IfcPositiveLengthMeasure value) { this.liningDepth = value; } // optional
    public IfcNonNegativeLengthMeasure getLiningThickness() { return this.liningThickness; }
    public void setLiningThickness(IfcNonNegativeLengthMeasure value) { this.liningThickness = value; } // optional
    public IfcPositiveLengthMeasure getThresholdDepth() { return this.thresholdDepth; }
    public void setThresholdDepth(IfcPositiveLengthMeasure value) { this.thresholdDepth = value; } // optional
    public IfcNonNegativeLengthMeasure getThresholdThickness() { return this.thresholdThickness; }
    public void setThresholdThickness(IfcNonNegativeLengthMeasure value) { this.thresholdThickness = value; } // optional
    public IfcNonNegativeLengthMeasure getTransomThickness() { return this.transomThickness; }
    public void setTransomThickness(IfcNonNegativeLengthMeasure value) { this.transomThickness = value; } // optional
    public IfcLengthMeasure getTransomOffset() { return this.transomOffset; }
    public void setTransomOffset(IfcLengthMeasure value) { this.transomOffset = value; } // optional
    public IfcLengthMeasure getLiningOffset() { return this.liningOffset; }
    public void setLiningOffset(IfcLengthMeasure value) { this.liningOffset = value; } // optional
    public IfcLengthMeasure getThresholdOffset() { return this.thresholdOffset; }
    public void setThresholdOffset(IfcLengthMeasure value) { this.thresholdOffset = value; } // optional
    public IfcPositiveLengthMeasure getCasingThickness() { return this.casingThickness; }
    public void setCasingThickness(IfcPositiveLengthMeasure value) { this.casingThickness = value; } // optional
    public IfcPositiveLengthMeasure getCasingDepth() { return this.casingDepth; }
    public void setCasingDepth(IfcPositiveLengthMeasure value) { this.casingDepth = value; } // optional
    public IfcShapeAspect getShapeAspectStyle() { return this.shapeAspectStyle; }
    public void setShapeAspectStyle(IfcShapeAspect value) { this.shapeAspectStyle = value; } // optional
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
		parameters.add(thresholdDepth != null ? StepUtils.toStepValue(thresholdDepth) : "$");
		parameters.add(thresholdThickness != null ? StepUtils.toStepValue(thresholdThickness) : "$");
		parameters.add(transomThickness != null ? StepUtils.toStepValue(transomThickness) : "$");
		parameters.add(transomOffset != null ? StepUtils.toStepValue(transomOffset) : "$");
		parameters.add(liningOffset != null ? StepUtils.toStepValue(liningOffset) : "$");
		parameters.add(thresholdOffset != null ? StepUtils.toStepValue(thresholdOffset) : "$");
		parameters.add(casingThickness != null ? StepUtils.toStepValue(casingThickness) : "$");
		parameters.add(casingDepth != null ? StepUtils.toStepValue(casingDepth) : "$");
		parameters.add(shapeAspectStyle != null ? StepUtils.toStepValue(shapeAspectStyle) : "$");
		parameters.add(liningToPanelOffsetX != null ? StepUtils.toStepValue(liningToPanelOffsetX) : "$");
		parameters.add(liningToPanelOffsetY != null ? StepUtils.toStepValue(liningToPanelOffsetY) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}