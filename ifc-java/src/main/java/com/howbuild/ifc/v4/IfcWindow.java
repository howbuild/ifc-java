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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcwindow.htm">IfcWindow</a>
 */
public class IfcWindow extends IfcBuildingElement {
    protected IfcPositiveLengthMeasure overallHeight;
    protected IfcPositiveLengthMeasure overallWidth;
    protected IfcWindowTypeEnum predefinedType;
    protected IfcWindowTypePartitioningEnum partitioningType;
    protected IfcLabel userDefinedPartitioningType;

    protected IfcWindow() { initCollections(); }
    /**
     * Constructs IfcWindow with all required attributes.
     */
    public IfcWindow(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcWindow with required and optional attributes.
     */
    public IfcWindow(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcPositiveLengthMeasure overallHeight,IfcPositiveLengthMeasure overallWidth,IfcWindowTypeEnum predefinedType,IfcWindowTypePartitioningEnum partitioningType,IfcLabel userDefinedPartitioningType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.overallHeight = overallHeight;
        this.overallWidth = overallWidth;
        this.predefinedType = predefinedType;
        this.partitioningType = partitioningType;
        this.userDefinedPartitioningType = userDefinedPartitioningType;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getOverallHeight() { return this.overallHeight; }
    public void setOverallHeight(IfcPositiveLengthMeasure value) { this.overallHeight = value; } // optional
    public IfcPositiveLengthMeasure getOverallWidth() { return this.overallWidth; }
    public void setOverallWidth(IfcPositiveLengthMeasure value) { this.overallWidth = value; } // optional
    public IfcWindowTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcWindowTypeEnum value) { this.predefinedType = value; } // optional
    public IfcWindowTypePartitioningEnum getPartitioningType() { return this.partitioningType; }
    public void setPartitioningType(IfcWindowTypePartitioningEnum value) { this.partitioningType = value; } // optional
    public IfcLabel getUserDefinedPartitioningType() { return this.userDefinedPartitioningType; }
    public void setUserDefinedPartitioningType(IfcLabel value) { this.userDefinedPartitioningType = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(partitioningType));
		parameters.add(userDefinedPartitioningType != null ? StepUtils.toStepValue(userDefinedPartitioningType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}