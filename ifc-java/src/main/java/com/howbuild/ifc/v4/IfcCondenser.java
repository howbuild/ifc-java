package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCondenser
 * SUBTYPE OF (IfcEnergyConversionDevice);
 * PredefinedType : OPTIONAL IfcCondenserTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcCondenserTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcCondenserTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCCONDENSERTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccondenser.htm">IfcCondenser</a>
 */
public class IfcCondenser extends IfcEnergyConversionDevice {
    protected IfcCondenserTypeEnum predefinedType;

    protected IfcCondenser() { initCollections(); }
    /**
     * Constructs IfcCondenser with all required attributes.
     */
    public IfcCondenser(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcCondenser with required and optional attributes.
     */
    public IfcCondenser(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcCondenserTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcCondenserTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcCondenserTypeEnum value) { this.predefinedType = value; } // optional

    
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