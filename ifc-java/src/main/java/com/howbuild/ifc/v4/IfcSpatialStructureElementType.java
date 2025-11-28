package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSpaceType
 * SUBTYPE OF (IfcSpatialStructureElementType);
 * PredefinedType : IfcSpaceTypeEnum;
 * LongName : OPTIONAL IfcLabel;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcSpaceTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcSpaceTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcSpatialElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspatialstructureelementtype.htm">IfcSpatialStructureElementType</a>
 */
public abstract class IfcSpatialStructureElementType extends IfcSpatialElementType {

    protected IfcSpatialStructureElementType() { initCollections(); }
    /**
     * Constructs IfcSpatialStructureElementType with all required attributes.
     */
    public IfcSpatialStructureElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSpatialStructureElementType with required and optional attributes.
     */
    public IfcSpatialStructureElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}