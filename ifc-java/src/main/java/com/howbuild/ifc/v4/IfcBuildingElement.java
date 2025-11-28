package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBeam
 * SUPERTYPE OF (ONEOF
 * (IfcBeamStandardCase))
 * SUBTYPE OF (IfcBuildingElement);
 * PredefinedType : OPTIONAL IfcBeamTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcBeamTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcBeamTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCBEAMTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbuildingelement.htm">IfcBuildingElement</a>
 */
public abstract class IfcBuildingElement extends IfcElement {

    protected IfcBuildingElement() { initCollections(); }
    /**
     * Constructs IfcBuildingElement with all required attributes.
     */
    public IfcBuildingElement(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcBuildingElement with required and optional attributes.
     */
    public IfcBuildingElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}