package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDistributionFlowElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcDistributionChamberElementType
 * ,IfcEnergyConversionDeviceType
 * ,IfcFlowControllerType
 * ,IfcFlowFittingType
 * ,IfcFlowMovingDeviceType
 * ,IfcFlowSegmentType
 * ,IfcFlowStorageDeviceType
 * ,IfcFlowTerminalType
 * ,IfcFlowTreatmentDeviceType))
 * SUBTYPE OF (IfcDistributionElementType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowtreatmentdevicetype.htm">IfcFlowTreatmentDeviceType</a>
 */
public abstract class IfcFlowTreatmentDeviceType extends IfcDistributionFlowElementType {

    protected IfcFlowTreatmentDeviceType() { initCollections(); }
    /**
     * Constructs IfcFlowTreatmentDeviceType with all required attributes.
     */
    public IfcFlowTreatmentDeviceType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowTreatmentDeviceType with required and optional attributes.
     */
    public IfcFlowTreatmentDeviceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}