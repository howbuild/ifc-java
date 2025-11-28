package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAirTerminalType
 * SUBTYPE OF (IfcFlowTerminalType);
 * PredefinedType : IfcAirTerminalTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcAirTerminalTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcAirTerminalTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowterminaltype.htm">IfcFlowTerminalType</a>
 */
public abstract class IfcFlowTerminalType extends IfcDistributionFlowElementType {

    protected IfcFlowTerminalType() { initCollections(); }
    /**
     * Constructs IfcFlowTerminalType with all required attributes.
     */
    public IfcFlowTerminalType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowTerminalType with required and optional attributes.
     */
    public IfcFlowTerminalType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}