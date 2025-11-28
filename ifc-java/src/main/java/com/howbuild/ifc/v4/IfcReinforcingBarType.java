package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcReinforcingBarType
 * SUBTYPE OF (IfcReinforcingElementType);
 * PredefinedType : IfcReinforcingBarTypeEnum;
 * NominalDiameter : OPTIONAL IfcPositiveLengthMeasure;
 * CrossSectionArea : OPTIONAL IfcAreaMeasure;
 * BarLength : OPTIONAL IfcPositiveLengthMeasure;
 * BarSurface : OPTIONAL IfcReinforcingBarSurfaceEnum;
 * BendingShapeCode : OPTIONAL IfcLabel;
 * BendingParameters : OPTIONAL LIST [1:?] OF IfcBendingParameterSelect;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcReinforcingBarTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcReinforcingBarTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcElementType.ElementType));
 * BendingShapeCodeProvided : NOT EXISTS(BendingParameters) OR EXISTS(BendingShapeCode);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcingbartype.htm">IfcReinforcingBarType</a>
 */
public class IfcReinforcingBarType extends IfcReinforcingElementType {
    protected IfcReinforcingBarTypeEnum predefinedType;
    protected IfcPositiveLengthMeasure nominalDiameter;
    protected IfcAreaMeasure crossSectionArea;
    protected IfcPositiveLengthMeasure barLength;
    protected IfcReinforcingBarSurfaceEnum barSurface;
    protected IfcLabel bendingShapeCode;
    protected Collection<IfcBendingParameterSelect> bendingParameters;

    protected IfcReinforcingBarType() { initCollections(); }
    /**
     * Constructs IfcReinforcingBarType with all required attributes.
     */
    public IfcReinforcingBarType(IfcGloballyUniqueId globalId,IfcReinforcingBarTypeEnum predefinedType) {

        super(globalId);
        this.bendingParameters = new ArrayList<>();
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcReinforcingBarType with required and optional attributes.
     */
    public IfcReinforcingBarType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcReinforcingBarTypeEnum predefinedType,IfcPositiveLengthMeasure nominalDiameter,IfcAreaMeasure crossSectionArea,IfcPositiveLengthMeasure barLength,IfcReinforcingBarSurfaceEnum barSurface,IfcLabel bendingShapeCode,Collection<IfcBendingParameterSelect> bendingParameters) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.nominalDiameter = nominalDiameter;
        this.crossSectionArea = crossSectionArea;
        this.barLength = barLength;
        this.barSurface = barSurface;
        this.bendingShapeCode = bendingShapeCode;
        this.bendingParameters = bendingParameters;
    }
    private void initCollections() {
        this.bendingParameters = new ArrayList<>();
    }
    public IfcReinforcingBarTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcReinforcingBarTypeEnum value) { this.predefinedType = value; }
    public IfcPositiveLengthMeasure getNominalDiameter() { return this.nominalDiameter; }
    public void setNominalDiameter(IfcPositiveLengthMeasure value) { this.nominalDiameter = value; } // optional
    public IfcAreaMeasure getCrossSectionArea() { return this.crossSectionArea; }
    public void setCrossSectionArea(IfcAreaMeasure value) { this.crossSectionArea = value; } // optional
    public IfcPositiveLengthMeasure getBarLength() { return this.barLength; }
    public void setBarLength(IfcPositiveLengthMeasure value) { this.barLength = value; } // optional
    public IfcReinforcingBarSurfaceEnum getBarSurface() { return this.barSurface; }
    public void setBarSurface(IfcReinforcingBarSurfaceEnum value) { this.barSurface = value; } // optional
    public IfcLabel getBendingShapeCode() { return this.bendingShapeCode; }
    public void setBendingShapeCode(IfcLabel value) { this.bendingShapeCode = value; } // optional
    public Collection<IfcBendingParameterSelect> getBendingParameters() { return this.bendingParameters; }
    public void setBendingParameters(Collection<IfcBendingParameterSelect> value) { this.bendingParameters = value; } // optional

    
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
		parameters.add(nominalDiameter != null ? StepUtils.toStepValue(nominalDiameter) : "$");
		parameters.add(crossSectionArea != null ? StepUtils.toStepValue(crossSectionArea) : "$");
		parameters.add(barLength != null ? StepUtils.toStepValue(barLength) : "$");
		parameters.add(StepUtils.toStepValue(barSurface));
		parameters.add(bendingShapeCode != null ? StepUtils.toStepValue(bendingShapeCode) : "$");
		parameters.add(bendingParameters != null ? StepUtils.toStepValue(bendingParameters) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}