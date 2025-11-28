package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralConnection
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveConnection
 * ,IfcStructuralPointConnection
 * ,IfcStructuralSurfaceConnection))
 * SUBTYPE OF (IfcStructuralItem);
 * AppliedCondition : OPTIONAL IfcBoundaryCondition;
 * INVERSE
 * ConnectsStructuralMembers : SET [1:?] OF IfcRelConnectsStructuralMember FOR RelatedStructuralConnection;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralconnection.htm">IfcStructuralConnection</a>
 */
public abstract class IfcStructuralConnection extends IfcStructuralItem {
    protected IfcBoundaryCondition appliedCondition;
    protected Collection<IfcRelConnectsStructuralMember> connectsStructuralMembers;

    protected IfcStructuralConnection() { initCollections(); }
    /**
     * Constructs IfcStructuralConnection with all required attributes.
     */
    public IfcStructuralConnection(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.connectsStructuralMembers = new ArrayList<>();
    }
    /**
     * Constructs IfcStructuralConnection with required and optional attributes.
     */
    public IfcStructuralConnection(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcBoundaryCondition appliedCondition) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.connectsStructuralMembers = new ArrayList<>();
        this.appliedCondition = appliedCondition;
    }
    private void initCollections() {
        this.connectsStructuralMembers = new ArrayList<>();
    }
    public IfcBoundaryCondition getAppliedCondition() { return this.appliedCondition; }
    public void setAppliedCondition(IfcBoundaryCondition value) { this.appliedCondition = value; } // optional
    public Collection<IfcRelConnectsStructuralMember> getConnectsStructuralMembers() { return this.connectsStructuralMembers; }
    public void setConnectsStructuralMembers(Collection<IfcRelConnectsStructuralMember> value) { this.connectsStructuralMembers = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}