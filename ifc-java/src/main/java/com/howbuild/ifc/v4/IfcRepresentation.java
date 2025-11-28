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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrepresentation.htm">IfcRepresentation</a>
 */
public abstract class IfcRepresentation extends BaseIfc implements IfcLayeredItem {
    protected IfcRepresentationContext contextOfItems;
    protected IfcLabel representationIdentifier;
    protected IfcLabel representationType;
    protected Collection<IfcRepresentationItem> items;
    protected Collection<IfcRepresentationMap> representationMap;
    protected Collection<IfcPresentationLayerAssignment> layerAssignments;
    protected Collection<IfcProductRepresentation> ofProductRepresentation;

    protected IfcRepresentation() { initCollections(); }
    /**
     * Constructs IfcRepresentation with all required attributes.
     */
    public IfcRepresentation(IfcRepresentationContext contextOfItems,Collection<IfcRepresentationItem> items) {

        super();
        this.representationMap = new ArrayList<>();
        this.layerAssignments = new ArrayList<>();
        this.ofProductRepresentation = new ArrayList<>();
        this.contextOfItems = contextOfItems;
        this.items = items;
    }
    /**
     * Constructs IfcRepresentation with required and optional attributes.
     */
    public IfcRepresentation(IfcRepresentationContext contextOfItems,IfcLabel representationIdentifier,IfcLabel representationType,Collection<IfcRepresentationItem> items) {
        super();
        this.representationMap = new ArrayList<>();
        this.layerAssignments = new ArrayList<>();
        this.ofProductRepresentation = new ArrayList<>();
        this.contextOfItems = contextOfItems;
        this.representationIdentifier = representationIdentifier;
        this.representationType = representationType;
        this.items = items;
    }
    private void initCollections() {
        this.items = new ArrayList<>();
        this.representationMap = new ArrayList<>();
        this.layerAssignments = new ArrayList<>();
        this.ofProductRepresentation = new ArrayList<>();
    }
    public IfcRepresentationContext getContextOfItems() { return this.contextOfItems; }
    public void setContextOfItems(IfcRepresentationContext value) { this.contextOfItems = value; }
    public IfcLabel getRepresentationIdentifier() { return this.representationIdentifier; }
    public void setRepresentationIdentifier(IfcLabel value) { this.representationIdentifier = value; } // optional
    public IfcLabel getRepresentationType() { return this.representationType; }
    public void setRepresentationType(IfcLabel value) { this.representationType = value; } // optional
    public Collection<IfcRepresentationItem> getItems() { return this.items; }
    public void setItems(Collection<IfcRepresentationItem> value) { this.items = value; }
    public Collection<IfcRepresentationMap> getRepresentationMap() { return this.representationMap; }
    public void setRepresentationMap(Collection<IfcRepresentationMap> value) { this.representationMap = value; } // inverse
    public Collection<IfcPresentationLayerAssignment> getLayerAssignments() { return this.layerAssignments; }
    public void setLayerAssignments(Collection<IfcPresentationLayerAssignment> value) { this.layerAssignments = value; } // inverse
    public Collection<IfcProductRepresentation> getOfProductRepresentation() { return this.ofProductRepresentation; }
    public void setOfProductRepresentation(Collection<IfcProductRepresentation> value) { this.ofProductRepresentation = value; } // inverse


    @Override public void finalizeRelationships() { this.setIfcRepresentationRelationship(); }
    private void setIfcRepresentationRelationship() {
		if (this.contextOfItems != null) {
		    if (this.contextOfItems instanceof IfcRepresentationContext)
		        ((IfcRepresentationContext)this.contextOfItems).representationsInContext.add(this);
		}
    }
}