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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrepresentationcontext.htm">IfcRepresentationContext</a>
 */
public abstract class IfcRepresentationContext extends BaseIfc {
    protected IfcLabel contextIdentifier;
    protected IfcLabel contextType;
    protected Collection<IfcRepresentation> representationsInContext;


    /**
     * Constructs IfcRepresentationContext with all required attributes.
     */
    public IfcRepresentationContext() {

        super();
        this.representationsInContext = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcRepresentationContext with required and optional attributes.
     */
    public IfcRepresentationContext(IfcLabel contextIdentifier,IfcLabel contextType) {
        super();
        this.representationsInContext = new ArrayList<>();
        this.contextIdentifier = contextIdentifier;
        this.contextType = contextType;
    }
    private void initCollections() {
        this.representationsInContext = new ArrayList<>();
    }
    public IfcLabel getContextIdentifier() { return this.contextIdentifier; }
    public void setContextIdentifier(IfcLabel value) { this.contextIdentifier = value; } // optional
    public IfcLabel getContextType() { return this.contextType; }
    public void setContextType(IfcLabel value) { this.contextType = value; } // optional
    public Collection<IfcRepresentation> getRepresentationsInContext() { return this.representationsInContext; }
    public void setRepresentationsInContext(Collection<IfcRepresentation> value) { this.representationsInContext = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}