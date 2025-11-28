package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCableCarrierFittingType
 * SUBTYPE OF (IfcFlowFittingType);
 * PredefinedType : IfcCableCarrierFittingTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcCableCarrierFittingTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcCableCarrierFittingTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowfittingtype.htm">IfcFlowFittingType</a>
 */
public abstract class IfcFlowFittingType extends IfcDistributionFlowElementType {

    protected IfcFlowFittingType() { initCollections(); }
    /**
     * Constructs IfcFlowFittingType with all required attributes.
     */
    public IfcFlowFittingType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowFittingType with required and optional attributes.
     */
    public IfcFlowFittingType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}