package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElementPartType
 * SUBTYPE OF (IfcElementComponentType);
 * PredefinedType : IfcBuildingElementPartTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcBuildingElementPartTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcBuildingElementPartTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelementcomponenttype.htm">IfcElementComponentType</a>
 */
public abstract class IfcElementComponentType extends IfcElementType {

    protected IfcElementComponentType() { initCollections(); }
    /**
     * Constructs IfcElementComponentType with all required attributes.
     */
    public IfcElementComponentType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcElementComponentType with required and optional attributes.
     */
    public IfcElementComponentType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}