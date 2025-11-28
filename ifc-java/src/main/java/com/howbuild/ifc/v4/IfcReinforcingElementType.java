package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementComponentType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBuildingElementPartType
 * ,IfcDiscreteAccessoryType
 * ,IfcFastenerType
 * ,IfcMechanicalFastenerType
 * ,IfcReinforcingElementType
 * ,IfcVibrationIsolatorType))
 * SUBTYPE OF (IfcElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcingelementtype.htm">IfcReinforcingElementType</a>
 */
public abstract class IfcReinforcingElementType extends IfcElementComponentType {

    protected IfcReinforcingElementType() { initCollections(); }
    /**
     * Constructs IfcReinforcingElementType with all required attributes.
     */
    public IfcReinforcingElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcReinforcingElementType with required and optional attributes.
     */
    public IfcReinforcingElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}