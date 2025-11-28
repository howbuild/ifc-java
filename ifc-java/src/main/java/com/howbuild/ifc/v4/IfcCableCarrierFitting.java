package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCableCarrierFitting
 * SUBTYPE OF (IfcFlowFitting);
 * PredefinedType : OPTIONAL IfcCableCarrierFittingTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcCableCarrierFittingTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcCableCarrierFittingTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCCABLECARRIERFITTINGTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccablecarrierfitting.htm">IfcCableCarrierFitting</a>
 */
public class IfcCableCarrierFitting extends IfcFlowFitting {
    protected IfcCableCarrierFittingTypeEnum predefinedType;

    protected IfcCableCarrierFitting() { initCollections(); }
    /**
     * Constructs IfcCableCarrierFitting with all required attributes.
     */
    public IfcCableCarrierFitting(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcCableCarrierFitting with required and optional attributes.
     */
    public IfcCableCarrierFitting(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcCableCarrierFittingTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcCableCarrierFittingTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcCableCarrierFittingTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}