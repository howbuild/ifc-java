package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDoorPanelProperties
 * SUBTYPE OF (IfcPreDefinedPropertySet);
 * PanelDepth : OPTIONAL IfcPositiveLengthMeasure;
 * PanelOperation : IfcDoorPanelOperationEnum;
 * PanelWidth : OPTIONAL IfcNormalisedRatioMeasure;
 * PanelPosition : IfcDoorPanelPositionEnum;
 * ShapeAspectStyle : OPTIONAL IfcShapeAspect;
 * WHERE
 * ApplicableToType : (EXISTS(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * AND
 * (
 * ('IFC4.IFCDOORTYPE' IN TYPEOF(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * OR
 * ('IFC4.IFCDOORSTYLE' IN TYPEOF(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * );
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdoorpanelproperties.htm">IfcDoorPanelProperties</a>
 */
public class IfcDoorPanelProperties extends IfcPreDefinedPropertySet {
    protected IfcPositiveLengthMeasure panelDepth;
    protected IfcDoorPanelOperationEnum panelOperation;
    protected IfcNormalisedRatioMeasure panelWidth;
    protected IfcDoorPanelPositionEnum panelPosition;
    protected IfcShapeAspect shapeAspectStyle;

    protected IfcDoorPanelProperties() { initCollections(); }
    /**
     * Constructs IfcDoorPanelProperties with all required attributes.
     */
    public IfcDoorPanelProperties(IfcGloballyUniqueId globalId,IfcDoorPanelOperationEnum panelOperation,IfcDoorPanelPositionEnum panelPosition) {

        super(globalId);
        this.panelOperation = panelOperation;
        this.panelPosition = panelPosition;
    }
    /**
     * Constructs IfcDoorPanelProperties with required and optional attributes.
     */
    public IfcDoorPanelProperties(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPositiveLengthMeasure panelDepth,IfcDoorPanelOperationEnum panelOperation,IfcNormalisedRatioMeasure panelWidth,IfcDoorPanelPositionEnum panelPosition,IfcShapeAspect shapeAspectStyle) {
        super(globalId,ownerHistory,name,description);
        this.panelDepth = panelDepth;
        this.panelOperation = panelOperation;
        this.panelWidth = panelWidth;
        this.panelPosition = panelPosition;
        this.shapeAspectStyle = shapeAspectStyle;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getPanelDepth() { return this.panelDepth; }
    public void setPanelDepth(IfcPositiveLengthMeasure value) { this.panelDepth = value; } // optional
    public IfcDoorPanelOperationEnum getPanelOperation() { return this.panelOperation; }
    public void setPanelOperation(IfcDoorPanelOperationEnum value) { this.panelOperation = value; }
    public IfcNormalisedRatioMeasure getPanelWidth() { return this.panelWidth; }
    public void setPanelWidth(IfcNormalisedRatioMeasure value) { this.panelWidth = value; } // optional
    public IfcDoorPanelPositionEnum getPanelPosition() { return this.panelPosition; }
    public void setPanelPosition(IfcDoorPanelPositionEnum value) { this.panelPosition = value; }
    public IfcShapeAspect getShapeAspectStyle() { return this.shapeAspectStyle; }
    public void setShapeAspectStyle(IfcShapeAspect value) { this.shapeAspectStyle = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(panelDepth != null ? StepUtils.toStepValue(panelDepth) : "$");
		parameters.add(StepUtils.toStepValue(panelOperation));
		parameters.add(panelWidth != null ? StepUtils.toStepValue(panelWidth) : "$");
		parameters.add(StepUtils.toStepValue(panelPosition));
		parameters.add(shapeAspectStyle != null ? StepUtils.toStepValue(shapeAspectStyle) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}