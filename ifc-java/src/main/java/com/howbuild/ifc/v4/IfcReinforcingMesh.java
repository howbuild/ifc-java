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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcingmesh.htm">IfcReinforcingMesh</a>
 */
public class IfcReinforcingMesh extends IfcReinforcingElement {
    protected IfcPositiveLengthMeasure meshLength;
    protected IfcPositiveLengthMeasure meshWidth;
    protected IfcPositiveLengthMeasure longitudinalBarNominalDiameter;
    protected IfcPositiveLengthMeasure transverseBarNominalDiameter;
    protected IfcAreaMeasure longitudinalBarCrossSectionArea;
    protected IfcAreaMeasure transverseBarCrossSectionArea;
    protected IfcPositiveLengthMeasure longitudinalBarSpacing;
    protected IfcPositiveLengthMeasure transverseBarSpacing;
    protected IfcReinforcingMeshTypeEnum predefinedType;

    protected IfcReinforcingMesh() { initCollections(); }
    /**
     * Constructs IfcReinforcingMesh with all required attributes.
     */
    public IfcReinforcingMesh(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcReinforcingMesh with required and optional attributes.
     */
    public IfcReinforcingMesh(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcLabel steelGrade,IfcPositiveLengthMeasure meshLength,IfcPositiveLengthMeasure meshWidth,IfcPositiveLengthMeasure longitudinalBarNominalDiameter,IfcPositiveLengthMeasure transverseBarNominalDiameter,IfcAreaMeasure longitudinalBarCrossSectionArea,IfcAreaMeasure transverseBarCrossSectionArea,IfcPositiveLengthMeasure longitudinalBarSpacing,IfcPositiveLengthMeasure transverseBarSpacing,IfcReinforcingMeshTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag,steelGrade);
        this.meshLength = meshLength;
        this.meshWidth = meshWidth;
        this.longitudinalBarNominalDiameter = longitudinalBarNominalDiameter;
        this.transverseBarNominalDiameter = transverseBarNominalDiameter;
        this.longitudinalBarCrossSectionArea = longitudinalBarCrossSectionArea;
        this.transverseBarCrossSectionArea = transverseBarCrossSectionArea;
        this.longitudinalBarSpacing = longitudinalBarSpacing;
        this.transverseBarSpacing = transverseBarSpacing;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getMeshLength() { return this.meshLength; }
    public void setMeshLength(IfcPositiveLengthMeasure value) { this.meshLength = value; } // optional
    public IfcPositiveLengthMeasure getMeshWidth() { return this.meshWidth; }
    public void setMeshWidth(IfcPositiveLengthMeasure value) { this.meshWidth = value; } // optional
    public IfcPositiveLengthMeasure getLongitudinalBarNominalDiameter() { return this.longitudinalBarNominalDiameter; }
    public void setLongitudinalBarNominalDiameter(IfcPositiveLengthMeasure value) { this.longitudinalBarNominalDiameter = value; } // optional
    public IfcPositiveLengthMeasure getTransverseBarNominalDiameter() { return this.transverseBarNominalDiameter; }
    public void setTransverseBarNominalDiameter(IfcPositiveLengthMeasure value) { this.transverseBarNominalDiameter = value; } // optional
    public IfcAreaMeasure getLongitudinalBarCrossSectionArea() { return this.longitudinalBarCrossSectionArea; }
    public void setLongitudinalBarCrossSectionArea(IfcAreaMeasure value) { this.longitudinalBarCrossSectionArea = value; } // optional
    public IfcAreaMeasure getTransverseBarCrossSectionArea() { return this.transverseBarCrossSectionArea; }
    public void setTransverseBarCrossSectionArea(IfcAreaMeasure value) { this.transverseBarCrossSectionArea = value; } // optional
    public IfcPositiveLengthMeasure getLongitudinalBarSpacing() { return this.longitudinalBarSpacing; }
    public void setLongitudinalBarSpacing(IfcPositiveLengthMeasure value) { this.longitudinalBarSpacing = value; } // optional
    public IfcPositiveLengthMeasure getTransverseBarSpacing() { return this.transverseBarSpacing; }
    public void setTransverseBarSpacing(IfcPositiveLengthMeasure value) { this.transverseBarSpacing = value; } // optional
    public IfcReinforcingMeshTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcReinforcingMeshTypeEnum value) { this.predefinedType = value; } // optional

    
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
		parameters.add(meshLength != null ? StepUtils.toStepValue(meshLength) : "$");
		parameters.add(meshWidth != null ? StepUtils.toStepValue(meshWidth) : "$");
		parameters.add(longitudinalBarNominalDiameter != null ? StepUtils.toStepValue(longitudinalBarNominalDiameter) : "$");
		parameters.add(transverseBarNominalDiameter != null ? StepUtils.toStepValue(transverseBarNominalDiameter) : "$");
		parameters.add(longitudinalBarCrossSectionArea != null ? StepUtils.toStepValue(longitudinalBarCrossSectionArea) : "$");
		parameters.add(transverseBarCrossSectionArea != null ? StepUtils.toStepValue(transverseBarCrossSectionArea) : "$");
		parameters.add(longitudinalBarSpacing != null ? StepUtils.toStepValue(longitudinalBarSpacing) : "$");
		parameters.add(transverseBarSpacing != null ? StepUtils.toStepValue(transverseBarSpacing) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}