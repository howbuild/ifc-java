package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralAnalysisModel
 * SUBTYPE OF (IfcSystem);
 * PredefinedType : IfcAnalysisModelTypeEnum;
 * OrientationOf2DPlane : OPTIONAL IfcAxis2Placement3D;
 * LoadedBy : OPTIONAL SET [1:?] OF IfcStructuralLoadGroup;
 * HasResults : OPTIONAL SET [1:?] OF IfcStructuralResultGroup;
 * SharedPlacement : OPTIONAL IfcObjectPlacement;
 * WHERE
 * HasObjectType : (PredefinedType <> IfcAnalysisModelTypeEnum.USERDEFINED) OR EXISTS(SELF\IfcObject.ObjectType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralanalysismodel.htm">IfcStructuralAnalysisModel</a>
 */
public class IfcStructuralAnalysisModel extends IfcSystem {
    protected IfcAnalysisModelTypeEnum predefinedType;
    protected IfcAxis2Placement3D orientationOf2DPlane;
    protected Collection<IfcStructuralLoadGroup> loadedBy;
    protected Collection<IfcStructuralResultGroup> hasResults;
    protected IfcObjectPlacement sharedPlacement;

    protected IfcStructuralAnalysisModel() { initCollections(); }
    /**
     * Constructs IfcStructuralAnalysisModel with all required attributes.
     */
    public IfcStructuralAnalysisModel(IfcGloballyUniqueId globalId,IfcAnalysisModelTypeEnum predefinedType) {

        super(globalId);
        this.loadedBy = new ArrayList<>();
        this.hasResults = new ArrayList<>();
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcStructuralAnalysisModel with required and optional attributes.
     */
    public IfcStructuralAnalysisModel(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcAnalysisModelTypeEnum predefinedType,IfcAxis2Placement3D orientationOf2DPlane,Collection<IfcStructuralLoadGroup> loadedBy,Collection<IfcStructuralResultGroup> hasResults,IfcObjectPlacement sharedPlacement) {
        super(globalId,ownerHistory,name,description,objectType);
        this.predefinedType = predefinedType;
        this.orientationOf2DPlane = orientationOf2DPlane;
        this.loadedBy = loadedBy;
        this.hasResults = hasResults;
        this.sharedPlacement = sharedPlacement;
    }
    private void initCollections() {
        this.loadedBy = new ArrayList<>();
        this.hasResults = new ArrayList<>();
    }
    public IfcAnalysisModelTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcAnalysisModelTypeEnum value) { this.predefinedType = value; }
    public IfcAxis2Placement3D getOrientationOf2DPlane() { return this.orientationOf2DPlane; }
    public void setOrientationOf2DPlane(IfcAxis2Placement3D value) { this.orientationOf2DPlane = value; } // optional
    public Collection<IfcStructuralLoadGroup> getLoadedBy() { return this.loadedBy; }
    public void setLoadedBy(Collection<IfcStructuralLoadGroup> value) { this.loadedBy = value; } // optional
    public Collection<IfcStructuralResultGroup> getHasResults() { return this.hasResults; }
    public void setHasResults(Collection<IfcStructuralResultGroup> value) { this.hasResults = value; } // optional
    public IfcObjectPlacement getSharedPlacement() { return this.sharedPlacement; }
    public void setSharedPlacement(IfcObjectPlacement value) { this.sharedPlacement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(orientationOf2DPlane != null ? StepUtils.toStepValue(orientationOf2DPlane) : "$");
		parameters.add(loadedBy != null ? StepUtils.toStepValue(loadedBy) : "$");
		parameters.add(hasResults != null ? StepUtils.toStepValue(hasResults) : "$");
		parameters.add(sharedPlacement != null ? StepUtils.toStepValue(sharedPlacement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcStructuralAnalysisModelRelationship(); }
    private void setIfcStructuralAnalysisModelRelationship() {
		if (this.loadedBy != null) {
		    for (Object x : this.loadedBy) {
		        if (x instanceof IfcStructuralLoadGroup)
		            ((IfcStructuralLoadGroup)x).loadGroupFor.add(this);
		    }
		}
		if (this.hasResults != null) {
		    for (Object x : this.hasResults) {
		        if (x instanceof IfcStructuralResultGroup)
		            ((IfcStructuralResultGroup)x).resultGroupFor.add(this);
		    }
		}
    }
}