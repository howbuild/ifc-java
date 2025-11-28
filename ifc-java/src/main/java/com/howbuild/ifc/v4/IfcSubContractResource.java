package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionResource
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConstructionEquipmentResource
 * ,IfcConstructionMaterialResource
 * ,IfcConstructionProductResource
 * ,IfcCrewResource
 * ,IfcLaborResource
 * ,IfcSubContractResource))
 * SUBTYPE OF (IfcResource);
 * Usage : OPTIONAL IfcResourceTime;
 * BaseCosts : OPTIONAL LIST [1:?] OF IfcAppliedValue;
 * BaseQuantity : OPTIONAL IfcPhysicalQuantity;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsubcontractresource.htm">IfcSubContractResource</a>
 */
public class IfcSubContractResource extends IfcConstructionResource {
    protected IfcSubContractResourceTypeEnum predefinedType;

    protected IfcSubContractResource() { initCollections(); }
    /**
     * Constructs IfcSubContractResource with all required attributes.
     */
    public IfcSubContractResource(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSubContractResource with required and optional attributes.
     */
    public IfcSubContractResource(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription,IfcResourceTime usage,Collection<IfcAppliedValue> baseCosts,IfcPhysicalQuantity baseQuantity,IfcSubContractResourceTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,identification,longDescription,usage,baseCosts,baseQuantity);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcSubContractResourceTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSubContractResourceTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(usage != null ? StepUtils.toStepValue(usage) : "$");
		parameters.add(baseCosts != null ? StepUtils.toStepValue(baseCosts) : "$");
		parameters.add(baseQuantity != null ? StepUtils.toStepValue(baseQuantity) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}