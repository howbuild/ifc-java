package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionEquipmentResourceType
 * SUBTYPE OF (IfcConstructionResourceType);
 * PredefinedType : IfcConstructionEquipmentResourceTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcConstructionEquipmentResourceTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcConstructionEquipmentResourceTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcTypeResource.ResourceType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconstructionequipmentresourcetype.htm">IfcConstructionEquipmentResourceType</a>
 */
public class IfcConstructionEquipmentResourceType extends IfcConstructionResourceType {
    protected IfcConstructionEquipmentResourceTypeEnum predefinedType;

    protected IfcConstructionEquipmentResourceType() { initCollections(); }
    /**
     * Constructs IfcConstructionEquipmentResourceType with all required attributes.
     */
    public IfcConstructionEquipmentResourceType(IfcGloballyUniqueId globalId,IfcConstructionEquipmentResourceTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcConstructionEquipmentResourceType with required and optional attributes.
     */
    public IfcConstructionEquipmentResourceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel resourceType,Collection<IfcAppliedValue> baseCosts,IfcPhysicalQuantity baseQuantity,IfcConstructionEquipmentResourceTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,identification,longDescription,resourceType,baseCosts,baseQuantity);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcConstructionEquipmentResourceTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcConstructionEquipmentResourceTypeEnum value) { this.predefinedType = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(resourceType != null ? StepUtils.toStepValue(resourceType) : "$");
		parameters.add(baseCosts != null ? StepUtils.toStepValue(baseCosts) : "$");
		parameters.add(baseQuantity != null ? StepUtils.toStepValue(baseQuantity) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}