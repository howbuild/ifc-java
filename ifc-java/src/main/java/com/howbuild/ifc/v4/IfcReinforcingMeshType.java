package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcReinforcingElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcingBarType
 * ,IfcReinforcingMeshType
 * ,IfcTendonAnchorType
 * ,IfcTendonType))
 * SUBTYPE OF (IfcElementComponentType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcingmeshtype.htm">IfcReinforcingMeshType</a>
 */
public class IfcReinforcingMeshType extends IfcReinforcingElementType {
    protected IfcReinforcingMeshTypeEnum predefinedType;
    protected IfcPositiveLengthMeasure meshLength;
    protected IfcPositiveLengthMeasure meshWidth;
    protected IfcPositiveLengthMeasure longitudinalBarNominalDiameter;
    protected IfcPositiveLengthMeasure transverseBarNominalDiameter;
    protected IfcAreaMeasure longitudinalBarCrossSectionArea;
    protected IfcAreaMeasure transverseBarCrossSectionArea;
    protected IfcPositiveLengthMeasure longitudinalBarSpacing;
    protected IfcPositiveLengthMeasure transverseBarSpacing;
    protected IfcLabel bendingShapeCode;
    protected Collection<IfcBendingParameterSelect> bendingParameters;

    protected IfcReinforcingMeshType() { initCollections(); }
    /**
     * Constructs IfcReinforcingMeshType with all required attributes.
     */
    public IfcReinforcingMeshType(IfcGloballyUniqueId globalId,IfcReinforcingMeshTypeEnum predefinedType) {

        super(globalId);
        this.bendingParameters = new ArrayList<>();
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcReinforcingMeshType with required and optional attributes.
     */
    public IfcReinforcingMeshType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType,IfcReinforcingMeshTypeEnum predefinedType,IfcPositiveLengthMeasure meshLength,IfcPositiveLengthMeasure meshWidth,IfcPositiveLengthMeasure longitudinalBarNominalDiameter,IfcPositiveLengthMeasure transverseBarNominalDiameter,IfcAreaMeasure longitudinalBarCrossSectionArea,IfcAreaMeasure transverseBarCrossSectionArea,IfcPositiveLengthMeasure longitudinalBarSpacing,IfcPositiveLengthMeasure transverseBarSpacing,IfcLabel bendingShapeCode,Collection<IfcBendingParameterSelect> bendingParameters) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag,elementType);
        this.predefinedType = predefinedType;
        this.meshLength = meshLength;
        this.meshWidth = meshWidth;
        this.longitudinalBarNominalDiameter = longitudinalBarNominalDiameter;
        this.transverseBarNominalDiameter = transverseBarNominalDiameter;
        this.longitudinalBarCrossSectionArea = longitudinalBarCrossSectionArea;
        this.transverseBarCrossSectionArea = transverseBarCrossSectionArea;
        this.longitudinalBarSpacing = longitudinalBarSpacing;
        this.transverseBarSpacing = transverseBarSpacing;
        this.bendingShapeCode = bendingShapeCode;
        this.bendingParameters = bendingParameters;
    }
    private void initCollections() {
        this.bendingParameters = new ArrayList<>();
    }
    public IfcReinforcingMeshTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcReinforcingMeshTypeEnum value) { this.predefinedType = value; }
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
		parameters.add(meshLength != null ? StepUtils.toStepValue(meshLength) : "$");
		parameters.add(meshWidth != null ? StepUtils.toStepValue(meshWidth) : "$");
		parameters.add(longitudinalBarNominalDiameter != null ? StepUtils.toStepValue(longitudinalBarNominalDiameter) : "$");
		parameters.add(transverseBarNominalDiameter != null ? StepUtils.toStepValue(transverseBarNominalDiameter) : "$");
		parameters.add(longitudinalBarCrossSectionArea != null ? StepUtils.toStepValue(longitudinalBarCrossSectionArea) : "$");
		parameters.add(transverseBarCrossSectionArea != null ? StepUtils.toStepValue(transverseBarCrossSectionArea) : "$");
		parameters.add(longitudinalBarSpacing != null ? StepUtils.toStepValue(longitudinalBarSpacing) : "$");
		parameters.add(transverseBarSpacing != null ? StepUtils.toStepValue(transverseBarSpacing) : "$");
		parameters.add(bendingShapeCode != null ? StepUtils.toStepValue(bendingShapeCode) : "$");
		parameters.add(bendingParameters != null ? StepUtils.toStepValue(bendingParameters) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}