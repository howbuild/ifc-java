package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGeometricRepresentationContext
 * SUPERTYPE OF (ONEOF
 * (IfcGeometricRepresentationSubContext))
 * SUBTYPE OF (IfcRepresentationContext);
 * CoordinateSpaceDimension : IfcDimensionCount;
 * Precision : OPTIONAL IfcReal;
 * WorldCoordinateSystem : IfcAxis2Placement;
 * TrueNorth : OPTIONAL IfcDirection;
 * INVERSE
 * HasSubContexts : SET [0:?] OF IfcGeometricRepresentationSubContext FOR ParentContext;
 * HasCoordinateOperation : SET [0:1] OF IfcCoordinateOperation FOR SourceCRS;
 * WHERE
 * North2D : NOT(EXISTS(TrueNorth)) OR (HIINDEX(TrueNorth.DirectionRatios) = 2);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgeometricrepresentationsubcontext.htm">IfcGeometricRepresentationSubContext</a>
 */
public class IfcGeometricRepresentationSubContext extends IfcGeometricRepresentationContext {
    protected IfcGeometricRepresentationContext parentContext;
    protected IfcPositiveRatioMeasure targetScale;
    protected IfcGeometricProjectionEnum targetView;
    protected IfcLabel userDefinedTargetView;

    protected IfcGeometricRepresentationSubContext() { initCollections(); }
    /**
     * Constructs IfcGeometricRepresentationSubContext with all required attributes.
     */
    public IfcGeometricRepresentationSubContext(IfcDimensionCount coordinateSpaceDimension,IfcAxis2Placement worldCoordinateSystem,IfcGeometricRepresentationContext parentContext,IfcGeometricProjectionEnum targetView) {

        super(coordinateSpaceDimension,worldCoordinateSystem);
        this.parentContext = parentContext;
        this.targetView = targetView;
    }
    /**
     * Constructs IfcGeometricRepresentationSubContext with required and optional attributes.
     */
    public IfcGeometricRepresentationSubContext(IfcLabel contextIdentifier,IfcLabel contextType,IfcDimensionCount coordinateSpaceDimension,IfcReal precision,IfcAxis2Placement worldCoordinateSystem,IfcDirection trueNorth,IfcGeometricRepresentationContext parentContext,IfcPositiveRatioMeasure targetScale,IfcGeometricProjectionEnum targetView,IfcLabel userDefinedTargetView) {
        super(contextIdentifier,contextType,coordinateSpaceDimension,precision,worldCoordinateSystem,trueNorth);
        this.parentContext = parentContext;
        this.targetScale = targetScale;
        this.targetView = targetView;
        this.userDefinedTargetView = userDefinedTargetView;
    }
    private void initCollections() {
    }
    public IfcGeometricRepresentationContext getParentContext() { return this.parentContext; }
    public void setParentContext(IfcGeometricRepresentationContext value) { this.parentContext = value; }
    public IfcPositiveRatioMeasure getTargetScale() { return this.targetScale; }
    public void setTargetScale(IfcPositiveRatioMeasure value) { this.targetScale = value; } // optional
    public IfcGeometricProjectionEnum getTargetView() { return this.targetView; }
    public void setTargetView(IfcGeometricProjectionEnum value) { this.targetView = value; }
    public IfcLabel getUserDefinedTargetView() { return this.userDefinedTargetView; }
    public void setUserDefinedTargetView(IfcLabel value) { this.userDefinedTargetView = value; } // optional
    public IfcAxis2Placement getWorldCoordinateSystem() { throw new UnsupportedOperationException("Derived property logic has been implemented for WorldCoordinateSystem."); } // derived
    public IfcDimensionCount getCoordinateSpaceDimension() { throw new UnsupportedOperationException("Derived property logic has been implemented for CoordinateSpaceDimension."); } // derived
    public IfcDirection getTrueNorth() { throw new UnsupportedOperationException("Derived property logic has been implemented for TrueNorth."); } // derived
    public IfcReal getPrecision() { throw new UnsupportedOperationException("Derived property logic has been implemented for Precision."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(contextIdentifier != null ? StepUtils.toStepValue(contextIdentifier) : "$");
		parameters.add(contextType != null ? StepUtils.toStepValue(contextType) : "$");
		parameters.add("*");
		parameters.add("*");
		parameters.add("*");
		parameters.add("*");
		parameters.add(parentContext != null ? StepUtils.toStepValue(parentContext) : "$");
		parameters.add(targetScale != null ? StepUtils.toStepValue(targetScale) : "$");
		parameters.add(StepUtils.toStepValue(targetView));
		parameters.add(userDefinedTargetView != null ? StepUtils.toStepValue(userDefinedTargetView) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcGeometricRepresentationSubContextRelationship(); }
    private void setIfcGeometricRepresentationSubContextRelationship() {
		if (this.parentContext != null) {
		    if (this.parentContext instanceof IfcGeometricRepresentationContext)
		        ((IfcGeometricRepresentationContext)this.parentContext).hasSubContexts.add(this);
		}
    }
}