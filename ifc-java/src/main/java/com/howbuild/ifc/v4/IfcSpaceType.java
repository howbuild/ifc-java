package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSpaceType
 * SUBTYPE OF (IfcSpatialStructureElementType);
 * PredefinedType : IfcSpaceTypeEnum;
 * LongName : OPTIONAL IfcLabel;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcSpaceTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcSpaceTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcSpatialElementType.ElementType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspacetype.htm">IfcSpaceType</a>
 */
public class IfcSpaceType extends IfcSpatialStructureElementType {
    protected IfcSpaceTypeEnum predefinedType;
    protected IfcLabel longName;

    protected IfcSpaceType() { initCollections(); }
    /**
     * Constructs IfcSpaceType with all required attributes.
     */
    public IfcSpaceType(IfcGloballyUniqueId globalId,IfcSpaceTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcSpaceType with required and optional attributes.
     */
    public IfcSpaceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcSpaceTypeEnum predefinedType,IfcLabel longName) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.longName = longName;
    }
    private void initCollections() {
    }
    public IfcSpaceTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSpaceTypeEnum value) { this.predefinedType = value; }
    public IfcLabel getLongName() { return this.longName; }
    public void setLongName(IfcLabel value) { this.longName = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}