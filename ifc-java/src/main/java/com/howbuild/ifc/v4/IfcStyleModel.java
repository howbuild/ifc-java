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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstylemodel.htm">IfcStyleModel</a>
 */
public abstract class IfcStyleModel extends IfcRepresentation {

    protected IfcStyleModel() { initCollections(); }
    /**
     * Constructs IfcStyleModel with all required attributes.
     */
    public IfcStyleModel(IfcRepresentationContext contextOfItems,Collection<IfcRepresentationItem> items) {

        super(contextOfItems,items);
    }
    /**
     * Constructs IfcStyleModel with required and optional attributes.
     */
    public IfcStyleModel(IfcRepresentationContext contextOfItems,IfcLabel representationIdentifier,IfcLabel representationType,Collection<IfcRepresentationItem> items) {
        super(contextOfItems,representationIdentifier,representationType,items);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}