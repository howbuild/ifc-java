package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCableCarrierSegmentType
 * SUBTYPE OF (IfcFlowSegmentType);
 * PredefinedType : IfcCableCarrierSegmentTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcCableCarrierSegmentTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcCableCarrierSegmentTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowsegmenttype.htm">IfcFlowSegmentType</a>
 */
public abstract class IfcFlowSegmentType extends IfcDistributionFlowElementType {

    protected IfcFlowSegmentType() { initCollections(); }
    /**
     * Constructs IfcFlowSegmentType with all required attributes.
     */
    public IfcFlowSegmentType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowSegmentType with required and optional attributes.
     */
    public IfcFlowSegmentType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}