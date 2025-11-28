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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgeometricrepresentationcontext.htm">IfcGeometricRepresentationContext</a>
 */
public class IfcGeometricRepresentationContext extends IfcRepresentationContext implements IfcCoordinateReferenceSystemSelect {
    protected IfcDimensionCount coordinateSpaceDimension;
    protected IfcReal precision;
    protected IfcAxis2Placement worldCoordinateSystem;
    protected IfcDirection trueNorth;
    protected Collection<IfcGeometricRepresentationSubContext> hasSubContexts;
    protected Collection<IfcCoordinateOperation> hasCoordinateOperation;

    protected IfcGeometricRepresentationContext() { initCollections(); }
    /**
     * Constructs IfcGeometricRepresentationContext with all required attributes.
     */
    public IfcGeometricRepresentationContext(IfcDimensionCount coordinateSpaceDimension,IfcAxis2Placement worldCoordinateSystem) {

        super();
        this.hasSubContexts = new ArrayList<>();
        this.hasCoordinateOperation = new ArrayList<>();
        this.coordinateSpaceDimension = coordinateSpaceDimension;
        this.worldCoordinateSystem = worldCoordinateSystem;
    }
    /**
     * Constructs IfcGeometricRepresentationContext with required and optional attributes.
     */
    public IfcGeometricRepresentationContext(IfcLabel contextIdentifier,IfcLabel contextType,IfcDimensionCount coordinateSpaceDimension,IfcReal precision,IfcAxis2Placement worldCoordinateSystem,IfcDirection trueNorth) {
        super(contextIdentifier,contextType);
        this.hasSubContexts = new ArrayList<>();
        this.hasCoordinateOperation = new ArrayList<>();
        this.coordinateSpaceDimension = coordinateSpaceDimension;
        this.precision = precision;
        this.worldCoordinateSystem = worldCoordinateSystem;
        this.trueNorth = trueNorth;
    }
    private void initCollections() {
        this.hasSubContexts = new ArrayList<>();
        this.hasCoordinateOperation = new ArrayList<>();
    }
    public IfcDimensionCount getCoordinateSpaceDimension() { return this.coordinateSpaceDimension; }
    public void setCoordinateSpaceDimension(IfcDimensionCount value) { this.coordinateSpaceDimension = value; }
    public IfcReal getPrecision() { return this.precision; }
    public void setPrecision(IfcReal value) { this.precision = value; } // optional
    public IfcAxis2Placement getWorldCoordinateSystem() { return this.worldCoordinateSystem; }
    public void setWorldCoordinateSystem(IfcAxis2Placement value) { this.worldCoordinateSystem = value; }
    public IfcDirection getTrueNorth() { return this.trueNorth; }
    public void setTrueNorth(IfcDirection value) { this.trueNorth = value; } // optional
    public Collection<IfcGeometricRepresentationSubContext> getHasSubContexts() { return this.hasSubContexts; }
    public void setHasSubContexts(Collection<IfcGeometricRepresentationSubContext> value) { this.hasSubContexts = value; } // inverse
    public Collection<IfcCoordinateOperation> getHasCoordinateOperation() { return this.hasCoordinateOperation; }
    public void setHasCoordinateOperation(Collection<IfcCoordinateOperation> value) { this.hasCoordinateOperation = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(contextIdentifier != null ? StepUtils.toStepValue(contextIdentifier) : "$");
		parameters.add(contextType != null ? StepUtils.toStepValue(contextType) : "$");
		parameters.add(coordinateSpaceDimension != null ? StepUtils.toStepValue(coordinateSpaceDimension) : "$");
		parameters.add(precision != null ? StepUtils.toStepValue(precision) : "$");
		parameters.add(worldCoordinateSystem != null ? StepUtils.toStepValue(worldCoordinateSystem) : "$");
		parameters.add(trueNorth != null ? StepUtils.toStepValue(trueNorth) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}