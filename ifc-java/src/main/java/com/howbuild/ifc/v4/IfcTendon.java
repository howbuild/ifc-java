package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcReinforcingElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcingBar
 * ,IfcReinforcingMesh
 * ,IfcTendon
 * ,IfcTendonAnchor))
 * SUBTYPE OF (IfcElementComponent);
 * SteelGrade : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctendon.htm">IfcTendon</a>
 */
public class IfcTendon extends IfcReinforcingElement {
    protected IfcTendonTypeEnum predefinedType;
    protected IfcPositiveLengthMeasure nominalDiameter;
    protected IfcAreaMeasure crossSectionArea;
    protected IfcForceMeasure tensionForce;
    protected IfcPressureMeasure preStress;
    protected IfcNormalisedRatioMeasure frictionCoefficient;
    protected IfcPositiveLengthMeasure anchorageSlip;
    protected IfcPositiveLengthMeasure minCurvatureRadius;

    protected IfcTendon() { initCollections(); }
    /**
     * Constructs IfcTendon with all required attributes.
     */
    public IfcTendon(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcTendon with required and optional attributes.
     */
    public IfcTendon(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcLabel steelGrade,IfcTendonTypeEnum predefinedType,IfcPositiveLengthMeasure nominalDiameter,IfcAreaMeasure crossSectionArea,IfcForceMeasure tensionForce,IfcPressureMeasure preStress,IfcNormalisedRatioMeasure frictionCoefficient,IfcPositiveLengthMeasure anchorageSlip,IfcPositiveLengthMeasure minCurvatureRadius) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag,steelGrade);
        this.predefinedType = predefinedType;
        this.nominalDiameter = nominalDiameter;
        this.crossSectionArea = crossSectionArea;
        this.tensionForce = tensionForce;
        this.preStress = preStress;
        this.frictionCoefficient = frictionCoefficient;
        this.anchorageSlip = anchorageSlip;
        this.minCurvatureRadius = minCurvatureRadius;
    }
    private void initCollections() {
    }
    public IfcTendonTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcTendonTypeEnum value) { this.predefinedType = value; } // optional
    public IfcPositiveLengthMeasure getNominalDiameter() { return this.nominalDiameter; }
    public void setNominalDiameter(IfcPositiveLengthMeasure value) { this.nominalDiameter = value; } // optional
    public IfcAreaMeasure getCrossSectionArea() { return this.crossSectionArea; }
    public void setCrossSectionArea(IfcAreaMeasure value) { this.crossSectionArea = value; } // optional
    public IfcForceMeasure getTensionForce() { return this.tensionForce; }
    public void setTensionForce(IfcForceMeasure value) { this.tensionForce = value; } // optional
    public IfcPressureMeasure getPreStress() { return this.preStress; }
    public void setPreStress(IfcPressureMeasure value) { this.preStress = value; } // optional
    public IfcNormalisedRatioMeasure getFrictionCoefficient() { return this.frictionCoefficient; }
    public void setFrictionCoefficient(IfcNormalisedRatioMeasure value) { this.frictionCoefficient = value; } // optional
    public IfcPositiveLengthMeasure getAnchorageSlip() { return this.anchorageSlip; }
    public void setAnchorageSlip(IfcPositiveLengthMeasure value) { this.anchorageSlip = value; } // optional
    public IfcPositiveLengthMeasure getMinCurvatureRadius() { return this.minCurvatureRadius; }
    public void setMinCurvatureRadius(IfcPositiveLengthMeasure value) { this.minCurvatureRadius = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(nominalDiameter != null ? StepUtils.toStepValue(nominalDiameter) : "$");
		parameters.add(crossSectionArea != null ? StepUtils.toStepValue(crossSectionArea) : "$");
		parameters.add(tensionForce != null ? StepUtils.toStepValue(tensionForce) : "$");
		parameters.add(preStress != null ? StepUtils.toStepValue(preStress) : "$");
		parameters.add(frictionCoefficient != null ? StepUtils.toStepValue(frictionCoefficient) : "$");
		parameters.add(anchorageSlip != null ? StepUtils.toStepValue(anchorageSlip) : "$");
		parameters.add(minCurvatureRadius != null ? StepUtils.toStepValue(minCurvatureRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}