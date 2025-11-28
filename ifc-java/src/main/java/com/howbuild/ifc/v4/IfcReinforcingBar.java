package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcReinforcingBar
 * SUBTYPE OF (IfcReinforcingElement);
 * NominalDiameter : OPTIONAL IfcPositiveLengthMeasure;
 * CrossSectionArea : OPTIONAL IfcAreaMeasure;
 * BarLength : OPTIONAL IfcPositiveLengthMeasure;
 * PredefinedType : OPTIONAL IfcReinforcingBarTypeEnum;
 * BarSurface : OPTIONAL IfcReinforcingBarSurfaceEnum;
 * WHERE
 * CorrectPredefinedType : NOT EXISTS(PredefinedType) OR
 * (PredefinedType <> IfcReinforcingBarTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcReinforcingBarTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCREINFORCINGBARTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcingbar.htm">IfcReinforcingBar</a>
 */
public class IfcReinforcingBar extends IfcReinforcingElement {
    protected IfcPositiveLengthMeasure nominalDiameter;
    protected IfcAreaMeasure crossSectionArea;
    protected IfcPositiveLengthMeasure barLength;
    protected IfcReinforcingBarTypeEnum predefinedType;
    protected IfcReinforcingBarSurfaceEnum barSurface;

    protected IfcReinforcingBar() { initCollections(); }
    /**
     * Constructs IfcReinforcingBar with all required attributes.
     */
    public IfcReinforcingBar(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcReinforcingBar with required and optional attributes.
     */
    public IfcReinforcingBar(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcLabel steelGrade,IfcPositiveLengthMeasure nominalDiameter,IfcAreaMeasure crossSectionArea,IfcPositiveLengthMeasure barLength,IfcReinforcingBarTypeEnum predefinedType,IfcReinforcingBarSurfaceEnum barSurface) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag,steelGrade);
        this.nominalDiameter = nominalDiameter;
        this.crossSectionArea = crossSectionArea;
        this.barLength = barLength;
        this.predefinedType = predefinedType;
        this.barSurface = barSurface;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getNominalDiameter() { return this.nominalDiameter; }
    public void setNominalDiameter(IfcPositiveLengthMeasure value) { this.nominalDiameter = value; } // optional
    public IfcAreaMeasure getCrossSectionArea() { return this.crossSectionArea; }
    public void setCrossSectionArea(IfcAreaMeasure value) { this.crossSectionArea = value; } // optional
    public IfcPositiveLengthMeasure getBarLength() { return this.barLength; }
    public void setBarLength(IfcPositiveLengthMeasure value) { this.barLength = value; } // optional
    public IfcReinforcingBarTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcReinforcingBarTypeEnum value) { this.predefinedType = value; } // optional
    public IfcReinforcingBarSurfaceEnum getBarSurface() { return this.barSurface; }
    public void setBarSurface(IfcReinforcingBarSurfaceEnum value) { this.barSurface = value; } // optional

    
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
		parameters.add(steelGrade != null ? StepUtils.toStepValue(steelGrade) : "$");
		parameters.add(nominalDiameter != null ? StepUtils.toStepValue(nominalDiameter) : "$");
		parameters.add(crossSectionArea != null ? StepUtils.toStepValue(crossSectionArea) : "$");
		parameters.add(barLength != null ? StepUtils.toStepValue(barLength) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(StepUtils.toStepValue(barSurface));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}