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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralactivity.htm">IfcStructuralActivity</a>
 */
public abstract class IfcStructuralActivity extends IfcProduct {
    protected IfcStructuralLoad appliedLoad;
    protected IfcGlobalOrLocalEnum globalOrLocal;
    protected Collection<IfcRelConnectsStructuralActivity> assignedToStructuralItem;

    protected IfcStructuralActivity() { initCollections(); }
    /**
     * Constructs IfcStructuralActivity with all required attributes.
     */
    public IfcStructuralActivity(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {

        super(globalId);
        this.assignedToStructuralItem = new ArrayList<>();
        this.appliedLoad = appliedLoad;
        this.globalOrLocal = globalOrLocal;
    }
    /**
     * Constructs IfcStructuralActivity with required and optional attributes.
     */
    public IfcStructuralActivity(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.assignedToStructuralItem = new ArrayList<>();
        this.appliedLoad = appliedLoad;
        this.globalOrLocal = globalOrLocal;
    }
    private void initCollections() {
        this.assignedToStructuralItem = new ArrayList<>();
    }
    public IfcStructuralLoad getAppliedLoad() { return this.appliedLoad; }
    public void setAppliedLoad(IfcStructuralLoad value) { this.appliedLoad = value; }
    public IfcGlobalOrLocalEnum getGlobalOrLocal() { return this.globalOrLocal; }
    public void setGlobalOrLocal(IfcGlobalOrLocalEnum value) { this.globalOrLocal = value; }
    public Collection<IfcRelConnectsStructuralActivity> getAssignedToStructuralItem() { return this.assignedToStructuralItem; }
    public void setAssignedToStructuralItem(Collection<IfcRelConnectsStructuralActivity> value) { this.assignedToStructuralItem = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}