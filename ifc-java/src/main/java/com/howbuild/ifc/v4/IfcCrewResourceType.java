package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionResourceType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConstructionEquipmentResourceType
 * ,IfcConstructionMaterialResourceType
 * ,IfcConstructionProductResourceType
 * ,IfcCrewResourceType
 * ,IfcLaborResourceType
 * ,IfcSubContractResourceType))
 * SUBTYPE OF (IfcTypeResource);
 * BaseCosts : OPTIONAL LIST [1:?] OF IfcAppliedValue;
 * BaseQuantity : OPTIONAL IfcPhysicalQuantity;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccrewresourcetype.htm">IfcCrewResourceType</a>
 */
public class IfcCrewResourceType extends IfcConstructionResourceType {
    protected IfcCrewResourceTypeEnum predefinedType;

    protected IfcCrewResourceType() { initCollections(); }
    /**
     * Constructs IfcCrewResourceType with all required attributes.
     */
    public IfcCrewResourceType(IfcGloballyUniqueId globalId,IfcCrewResourceTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcCrewResourceType with required and optional attributes.
     */
    public IfcCrewResourceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel resourceType,Collection<IfcAppliedValue> baseCosts,IfcPhysicalQuantity baseQuantity,IfcCrewResourceTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,identification,longDescription,resourceType,baseCosts,baseQuantity);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcCrewResourceTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcCrewResourceTypeEnum value) { this.predefinedType = value; }

    
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