package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDoor
 * SUPERTYPE OF (ONEOF
 * (IfcDoorStandardCase))
 * SUBTYPE OF (IfcBuildingElement);
 * OverallHeight : OPTIONAL IfcPositiveLengthMeasure;
 * OverallWidth : OPTIONAL IfcPositiveLengthMeasure;
 * PredefinedType : OPTIONAL IfcDoorTypeEnum;
 * OperationType : OPTIONAL IfcDoorTypeOperationEnum;
 * UserDefinedOperationType : OPTIONAL IfcLabel;
 * WHERE
 * CorrectStyleAssigned : (SIZEOF(IsTypedBy) = 0)
 * OR ('IFC4.IFCDOORTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdoorstandardcase.htm">IfcDoorStandardCase</a>
 */
public class IfcDoorStandardCase extends IfcDoor {

    protected IfcDoorStandardCase() { initCollections(); }
    /**
     * Constructs IfcDoorStandardCase with all required attributes.
     */
    public IfcDoorStandardCase(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcDoorStandardCase with required and optional attributes.
     */
    public IfcDoorStandardCase(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcPositiveLengthMeasure overallHeight,IfcPositiveLengthMeasure overallWidth,IfcDoorTypeEnum predefinedType,IfcDoorTypeOperationEnum operationType,IfcLabel userDefinedOperationType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag,overallHeight,overallWidth,predefinedType,operationType,userDefinedOperationType);
    }
    private void initCollections() {
    }

    
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
		parameters.add(overallHeight != null ? StepUtils.toStepValue(overallHeight) : "$");
		parameters.add(overallWidth != null ? StepUtils.toStepValue(overallWidth) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(StepUtils.toStepValue(operationType));
		parameters.add(userDefinedOperationType != null ? StepUtils.toStepValue(userDefinedOperationType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}