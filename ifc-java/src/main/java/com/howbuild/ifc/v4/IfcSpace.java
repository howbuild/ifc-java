package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSpace
 * SUBTYPE OF (IfcSpatialStructureElement);
 * PredefinedType : OPTIONAL IfcSpaceTypeEnum;
 * ElevationWithFlooring : OPTIONAL IfcLengthMeasure;
 * INVERSE
 * HasCoverings : SET [0:?] OF IfcRelCoversSpaces FOR RelatingSpace;
 * BoundedBy : SET [0:?] OF IfcRelSpaceBoundary FOR RelatingSpace;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcSpaceTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcSpaceTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCSPACETYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspace.htm">IfcSpace</a>
 */
public class IfcSpace extends IfcSpatialStructureElement implements IfcSpaceBoundarySelect {
    protected IfcSpaceTypeEnum predefinedType;
    protected IfcLengthMeasure elevationWithFlooring;
    protected Collection<IfcRelCoversSpaces> hasCoverings;
    protected Collection<IfcRelSpaceBoundary> boundedBy;

    protected IfcSpace() { initCollections(); }
    /**
     * Constructs IfcSpace with all required attributes.
     */
    public IfcSpace(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasCoverings = new ArrayList<>();
        this.boundedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcSpace with required and optional attributes.
     */
    public IfcSpace(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcElementCompositionEnum compositionType,IfcSpaceTypeEnum predefinedType,IfcLengthMeasure elevationWithFlooring) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName,compositionType);
        this.hasCoverings = new ArrayList<>();
        this.boundedBy = new ArrayList<>();
        this.predefinedType = predefinedType;
        this.elevationWithFlooring = elevationWithFlooring;
    }
    private void initCollections() {
        this.hasCoverings = new ArrayList<>();
        this.boundedBy = new ArrayList<>();
    }
    public IfcSpaceTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSpaceTypeEnum value) { this.predefinedType = value; } // optional
    public IfcLengthMeasure getElevationWithFlooring() { return this.elevationWithFlooring; }
    public void setElevationWithFlooring(IfcLengthMeasure value) { this.elevationWithFlooring = value; } // optional
    public Collection<IfcRelCoversSpaces> getHasCoverings() { return this.hasCoverings; }
    public void setHasCoverings(Collection<IfcRelCoversSpaces> value) { this.hasCoverings = value; } // inverse
    public Collection<IfcRelSpaceBoundary> getBoundedBy() { return this.boundedBy; }
    public void setBoundedBy(Collection<IfcRelSpaceBoundary> value) { this.boundedBy = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
		parameters.add(StepUtils.toStepValue(compositionType));
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(elevationWithFlooring != null ? StepUtils.toStepValue(elevationWithFlooring) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}