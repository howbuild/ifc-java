package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActuatorType
 * SUBTYPE OF (IfcDistributionControlElementType);
 * PredefinedType : IfcActuatorTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcActuatorTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcActuatorTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdistributioncontrolelementtype.htm">IfcDistributionControlElementType</a>
 */
public abstract class IfcDistributionControlElementType extends IfcDistributionElementType {

    protected IfcDistributionControlElementType() { initCollections(); }
    /**
     * Constructs IfcDistributionControlElementType with all required attributes.
     */
    public IfcDistributionControlElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcDistributionControlElementType with required and optional attributes.
     */
    public IfcDistributionControlElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}