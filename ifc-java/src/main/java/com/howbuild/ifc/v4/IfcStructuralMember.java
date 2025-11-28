package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralCurveMember
 * SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveMemberVarying))
 * SUBTYPE OF (IfcStructuralMember);
 * PredefinedType : IfcStructuralCurveMemberTypeEnum;
 * Axis : IfcDirection;
 * WHERE
 * HasObjectType : (PredefinedType <> IfcStructuralCurveMemberTypeEnum.USERDEFINED) OR EXISTS(SELF\IfcObject.ObjectType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralmember.htm">IfcStructuralMember</a>
 */
public abstract class IfcStructuralMember extends IfcStructuralItem {
    protected Collection<IfcRelConnectsStructuralMember> connectedBy;

    protected IfcStructuralMember() { initCollections(); }
    /**
     * Constructs IfcStructuralMember with all required attributes.
     */
    public IfcStructuralMember(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.connectedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcStructuralMember with required and optional attributes.
     */
    public IfcStructuralMember(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.connectedBy = new ArrayList<>();
    }
    private void initCollections() {
        this.connectedBy = new ArrayList<>();
    }
    public Collection<IfcRelConnectsStructuralMember> getConnectedBy() { return this.connectedBy; }
    public void setConnectedBy(Collection<IfcRelConnectsStructuralMember> value) { this.connectedBy = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}