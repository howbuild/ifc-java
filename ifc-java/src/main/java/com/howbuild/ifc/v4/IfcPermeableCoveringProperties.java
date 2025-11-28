package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPermeableCoveringProperties
 * SUBTYPE OF (IfcPreDefinedPropertySet);
 * OperationType : IfcPermeableCoveringOperationEnum;
 * PanelPosition : IfcWindowPanelPositionEnum;
 * FrameDepth : OPTIONAL IfcPositiveLengthMeasure;
 * FrameThickness : OPTIONAL IfcPositiveLengthMeasure;
 * ShapeAspectStyle : OPTIONAL IfcShapeAspect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpermeablecoveringproperties.htm">IfcPermeableCoveringProperties</a>
 */
public class IfcPermeableCoveringProperties extends IfcPreDefinedPropertySet {
    protected IfcPermeableCoveringOperationEnum operationType;
    protected IfcWindowPanelPositionEnum panelPosition;
    protected IfcPositiveLengthMeasure frameDepth;
    protected IfcPositiveLengthMeasure frameThickness;
    protected IfcShapeAspect shapeAspectStyle;

    protected IfcPermeableCoveringProperties() { initCollections(); }
    /**
     * Constructs IfcPermeableCoveringProperties with all required attributes.
     */
    public IfcPermeableCoveringProperties(IfcGloballyUniqueId globalId,IfcPermeableCoveringOperationEnum operationType,IfcWindowPanelPositionEnum panelPosition) {

        super(globalId);
        this.operationType = operationType;
        this.panelPosition = panelPosition;
    }
    /**
     * Constructs IfcPermeableCoveringProperties with required and optional attributes.
     */
    public IfcPermeableCoveringProperties(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPermeableCoveringOperationEnum operationType,IfcWindowPanelPositionEnum panelPosition,IfcPositiveLengthMeasure frameDepth,IfcPositiveLengthMeasure frameThickness,IfcShapeAspect shapeAspectStyle) {
        super(globalId,ownerHistory,name,description);
        this.operationType = operationType;
        this.panelPosition = panelPosition;
        this.frameDepth = frameDepth;
        this.frameThickness = frameThickness;
        this.shapeAspectStyle = shapeAspectStyle;
    }
    private void initCollections() {
    }
    public IfcPermeableCoveringOperationEnum getOperationType() { return this.operationType; }
    public void setOperationType(IfcPermeableCoveringOperationEnum value) { this.operationType = value; }
    public IfcWindowPanelPositionEnum getPanelPosition() { return this.panelPosition; }
    public void setPanelPosition(IfcWindowPanelPositionEnum value) { this.panelPosition = value; }
    public IfcPositiveLengthMeasure getFrameDepth() { return this.frameDepth; }
    public void setFrameDepth(IfcPositiveLengthMeasure value) { this.frameDepth = value; } // optional
    public IfcPositiveLengthMeasure getFrameThickness() { return this.frameThickness; }
    public void setFrameThickness(IfcPositiveLengthMeasure value) { this.frameThickness = value; } // optional
    public IfcShapeAspect getShapeAspectStyle() { return this.shapeAspectStyle; }
    public void setShapeAspectStyle(IfcShapeAspect value) { this.shapeAspectStyle = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(StepUtils.toStepValue(operationType));
		parameters.add(StepUtils.toStepValue(panelPosition));
		parameters.add(frameDepth != null ? StepUtils.toStepValue(frameDepth) : "$");
		parameters.add(frameThickness != null ? StepUtils.toStepValue(frameThickness) : "$");
		parameters.add(shapeAspectStyle != null ? StepUtils.toStepValue(shapeAspectStyle) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}