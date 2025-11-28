package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBeam
 * ,IfcBuildingElementProxy
 * ,IfcChimney
 * ,IfcColumn
 * ,IfcCovering
 * ,IfcCurtainWall
 * ,IfcDoor
 * ,IfcFooting
 * ,IfcMember
 * ,IfcPile
 * ,IfcPlate
 * ,IfcRailing
 * ,IfcRamp
 * ,IfcRampFlight
 * ,IfcRoof
 * ,IfcShadingDevice
 * ,IfcSlab
 * ,IfcStair
 * ,IfcStairFlight
 * ,IfcWall
 * ,IfcWindow))
 * SUBTYPE OF (IfcElement);
 * WHERE
 * MaxOneMaterialAssociation : SIZEOF (QUERY(temp <* SELF\IfcObjectDefinition.HasAssociations |
 * 'IFC4.IFCRELASSOCIATESMATERIAL' IN TYPEOF(temp)
 * )) <= 1;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdoor.htm">IfcDoor</a>
 */
public class IfcDoor extends IfcBuildingElement {
    protected IfcPositiveLengthMeasure overallHeight;
    protected IfcPositiveLengthMeasure overallWidth;
    protected IfcDoorTypeEnum predefinedType;
    protected IfcDoorTypeOperationEnum operationType;
    protected IfcLabel userDefinedOperationType;

    protected IfcDoor() { initCollections(); }
    /**
     * Constructs IfcDoor with all required attributes.
     */
    public IfcDoor(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcDoor with required and optional attributes.
     */
    public IfcDoor(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcPositiveLengthMeasure overallHeight,IfcPositiveLengthMeasure overallWidth,IfcDoorTypeEnum predefinedType,IfcDoorTypeOperationEnum operationType,IfcLabel userDefinedOperationType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.overallHeight = overallHeight;
        this.overallWidth = overallWidth;
        this.predefinedType = predefinedType;
        this.operationType = operationType;
        this.userDefinedOperationType = userDefinedOperationType;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getOverallHeight() { return this.overallHeight; }
    public void setOverallHeight(IfcPositiveLengthMeasure value) { this.overallHeight = value; } // optional
    public IfcPositiveLengthMeasure getOverallWidth() { return this.overallWidth; }
    public void setOverallWidth(IfcPositiveLengthMeasure value) { this.overallWidth = value; } // optional
    public IfcDoorTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcDoorTypeEnum value) { this.predefinedType = value; } // optional
    public IfcDoorTypeOperationEnum getOperationType() { return this.operationType; }
    public void setOperationType(IfcDoorTypeOperationEnum value) { this.operationType = value; } // optional
    public IfcLabel getUserDefinedOperationType() { return this.userDefinedOperationType; }
    public void setUserDefinedOperationType(IfcLabel value) { this.userDefinedOperationType = value; } // optional

    
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