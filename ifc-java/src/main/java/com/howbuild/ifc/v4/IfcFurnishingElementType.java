package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBuildingElementType
 * ,IfcCivilElementType
 * ,IfcDistributionElementType
 * ,IfcElementAssemblyType
 * ,IfcElementComponentType
 * ,IfcFurnishingElementType
 * ,IfcGeographicElementType
 * ,IfcTransportElementType))
 * SUBTYPE OF (IfcTypeProduct);
 * ElementType : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfurnishingelementtype.htm">IfcFurnishingElementType</a>
 */
public class IfcFurnishingElementType extends IfcElementType {

    protected IfcFurnishingElementType() { initCollections(); }
    /**
     * Constructs IfcFurnishingElementType with all required attributes.
     */
    public IfcFurnishingElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFurnishingElementType with required and optional attributes.
     */
    public IfcFurnishingElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(representationMaps != null ? StepUtils.toStepValue(representationMaps) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(elementType != null ? StepUtils.toStepValue(elementType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}