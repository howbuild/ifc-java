package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElementPart
 * SUBTYPE OF (IfcElementComponent);
 * PredefinedType : OPTIONAL IfcBuildingElementPartTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcBuildingElementPartTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcBuildingElementPartTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCBUILDINGELEMENTPARTTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelementcomponent.htm">IfcElementComponent</a>
 */
public abstract class IfcElementComponent extends IfcElement {

    protected IfcElementComponent() { initCollections(); }
    /**
     * Constructs IfcElementComponent with all required attributes.
     */
    public IfcElementComponent(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcElementComponent with required and optional attributes.
     */
    public IfcElementComponent(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}