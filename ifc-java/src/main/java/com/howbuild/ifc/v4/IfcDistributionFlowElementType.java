package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDistributionChamberElementType
 * SUBTYPE OF (IfcDistributionFlowElementType);
 * PredefinedType : IfcDistributionChamberElementTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcDistributionChamberElementTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcDistributionChamberElementTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdistributionflowelementtype.htm">IfcDistributionFlowElementType</a>
 */
public abstract class IfcDistributionFlowElementType extends IfcDistributionElementType {

    protected IfcDistributionFlowElementType() { initCollections(); }
    /**
     * Constructs IfcDistributionFlowElementType with all required attributes.
     */
    public IfcDistributionFlowElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcDistributionFlowElementType with required and optional attributes.
     */
    public IfcDistributionFlowElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}