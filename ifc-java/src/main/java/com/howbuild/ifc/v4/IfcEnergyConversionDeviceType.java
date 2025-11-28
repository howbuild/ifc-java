package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAirToAirHeatRecoveryType
 * SUBTYPE OF (IfcEnergyConversionDeviceType);
 * PredefinedType : IfcAirToAirHeatRecoveryTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcAirToAirHeatRecoveryTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcAirToAirHeatRecoveryTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcenergyconversiondevicetype.htm">IfcEnergyConversionDeviceType</a>
 */
public abstract class IfcEnergyConversionDeviceType extends IfcDistributionFlowElementType {

    protected IfcEnergyConversionDeviceType() { initCollections(); }
    /**
     * Constructs IfcEnergyConversionDeviceType with all required attributes.
     */
    public IfcEnergyConversionDeviceType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcEnergyConversionDeviceType with required and optional attributes.
     */
    public IfcEnergyConversionDeviceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}