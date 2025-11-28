package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRepresentation
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcShapeModel
 * ,IfcStyleModel));
 * ContextOfItems : IfcRepresentationContext;
 * RepresentationIdentifier : OPTIONAL IfcLabel;
 * RepresentationType : OPTIONAL IfcLabel;
 * Items : SET [1:?] OF IfcRepresentationItem;
 * INVERSE
 * RepresentationMap : SET [0:1] OF IfcRepresentationMap FOR MappedRepresentation;
 * LayerAssignments : SET [0:?] OF IfcPresentationLayerAssignment FOR AssignedItems;
 * OfProductRepresentation : SET [0:?] OF IfcProductRepresentation FOR Representations;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcshapemodel.htm">IfcShapeModel</a>
 */
public abstract class IfcShapeModel extends IfcRepresentation {
    protected Collection<IfcShapeAspect> ofShapeAspect;

    protected IfcShapeModel() { initCollections(); }
    /**
     * Constructs IfcShapeModel with all required attributes.
     */
    public IfcShapeModel(IfcRepresentationContext contextOfItems,Collection<IfcRepresentationItem> items) {

        super(contextOfItems,items);
        this.ofShapeAspect = new ArrayList<>();
    }
    /**
     * Constructs IfcShapeModel with required and optional attributes.
     */
    public IfcShapeModel(IfcRepresentationContext contextOfItems,IfcLabel representationIdentifier,IfcLabel representationType,Collection<IfcRepresentationItem> items) {
        super(contextOfItems,representationIdentifier,representationType,items);
        this.ofShapeAspect = new ArrayList<>();
    }
    private void initCollections() {
        this.ofShapeAspect = new ArrayList<>();
    }
    public Collection<IfcShapeAspect> getOfShapeAspect() { return this.ofShapeAspect; }
    public void setOfShapeAspect(Collection<IfcShapeAspect> value) { this.ofShapeAspect = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}