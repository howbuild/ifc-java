package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCompressorType
 * SUBTYPE OF (IfcFlowMovingDeviceType);
 * PredefinedType : IfcCompressorTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcCompressorTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcCompressorTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowmovingdevicetype.htm">IfcFlowMovingDeviceType</a>
 */
public abstract class IfcFlowMovingDeviceType extends IfcDistributionFlowElementType {

    protected IfcFlowMovingDeviceType() { initCollections(); }
    /**
     * Constructs IfcFlowMovingDeviceType with all required attributes.
     */
    public IfcFlowMovingDeviceType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowMovingDeviceType with required and optional attributes.
     */
    public IfcFlowMovingDeviceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}