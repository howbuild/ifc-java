package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBeamType
 * SUBTYPE OF (IfcBuildingElementType);
 * PredefinedType : IfcBeamTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcBeamTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcBeamTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbuildingelementtype.htm">IfcBuildingElementType</a>
 */
public abstract class IfcBuildingElementType extends IfcElementType {

    protected IfcBuildingElementType() { initCollections(); }
    /**
     * Constructs IfcBuildingElementType with all required attributes.
     */
    public IfcBuildingElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcBuildingElementType with required and optional attributes.
     */
    public IfcBuildingElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}