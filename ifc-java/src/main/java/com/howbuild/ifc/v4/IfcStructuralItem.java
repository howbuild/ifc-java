package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcProduct
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcAnnotation
 * ,IfcElement
 * ,IfcGrid
 * ,IfcPort
 * ,IfcProxy
 * ,IfcSpatialElement
 * ,IfcStructuralActivity
 * ,IfcStructuralItem))
 * SUBTYPE OF (IfcObject);
 * ObjectPlacement : OPTIONAL IfcObjectPlacement;
 * Representation : OPTIONAL IfcProductRepresentation;
 * INVERSE
 * ReferencedBy : SET [0:?] OF IfcRelAssignsToProduct FOR RelatingProduct;
 * WHERE
 * PlacementForShapeRepresentation : (EXISTS(Representation) AND EXISTS(ObjectPlacement))
 * OR (EXISTS(Representation) AND
 * (SIZEOF(QUERY(temp <* Representation.Representations | 'IFC4.IFCSHAPEREPRESENTATION' IN TYPEOF(temp))) = 0))
 * OR (NOT(EXISTS(Representation)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralitem.htm">IfcStructuralItem</a>
 */
public abstract class IfcStructuralItem extends IfcProduct implements IfcStructuralActivityAssignmentSelect {
    protected Collection<IfcRelConnectsStructuralActivity> assignedStructuralActivity;

    protected IfcStructuralItem() { initCollections(); }
    /**
     * Constructs IfcStructuralItem with all required attributes.
     */
    public IfcStructuralItem(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.assignedStructuralActivity = new ArrayList<>();
    }
    /**
     * Constructs IfcStructuralItem with required and optional attributes.
     */
    public IfcStructuralItem(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.assignedStructuralActivity = new ArrayList<>();
    }
    private void initCollections() {
        this.assignedStructuralActivity = new ArrayList<>();
    }
    public Collection<IfcRelConnectsStructuralActivity> getAssignedStructuralActivity() { return this.assignedStructuralActivity; }
    public void setAssignedStructuralActivity(Collection<IfcRelConnectsStructuralActivity> value) { this.assignedStructuralActivity = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}