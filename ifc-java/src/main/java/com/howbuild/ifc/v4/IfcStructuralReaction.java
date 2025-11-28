package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralActivity
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralAction
 * ,IfcStructuralReaction))
 * SUBTYPE OF (IfcProduct);
 * AppliedLoad : IfcStructuralLoad;
 * GlobalOrLocal : IfcGlobalOrLocalEnum;
 * INVERSE
 * AssignedToStructuralItem : SET [0:1] OF IfcRelConnectsStructuralActivity FOR RelatedStructuralActivity;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralreaction.htm">IfcStructuralReaction</a>
 */
public abstract class IfcStructuralReaction extends IfcStructuralActivity {

    protected IfcStructuralReaction() { initCollections(); }
    /**
     * Constructs IfcStructuralReaction with all required attributes.
     */
    public IfcStructuralReaction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {

        super(globalId,appliedLoad,globalOrLocal);
    }
    /**
     * Constructs IfcStructuralReaction with required and optional attributes.
     */
    public IfcStructuralReaction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}