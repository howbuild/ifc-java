package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGroup
 * SUPERTYPE OF (ONEOF
 * (IfcAsset
 * ,IfcInventory
 * ,IfcStructuralLoadGroup
 * ,IfcStructuralResultGroup
 * ,IfcSystem))
 * SUBTYPE OF (IfcObject);
 * INVERSE
 * IsGroupedBy : SET [0:?] OF IfcRelAssignsToGroup FOR RelatingGroup;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadgroup.htm">IfcStructuralLoadGroup</a>
 */
public class IfcStructuralLoadGroup extends IfcGroup {
    protected IfcLoadGroupTypeEnum predefinedType;
    protected IfcActionTypeEnum actionType;
    protected IfcActionSourceTypeEnum actionSource;
    protected IfcRatioMeasure coefficient;
    protected IfcLabel purpose;
    protected Collection<IfcStructuralResultGroup> sourceOfResultGroup;
    protected Collection<IfcStructuralAnalysisModel> loadGroupFor;

    protected IfcStructuralLoadGroup() { initCollections(); }
    /**
     * Constructs IfcStructuralLoadGroup with all required attributes.
     */
    public IfcStructuralLoadGroup(IfcGloballyUniqueId globalId,IfcLoadGroupTypeEnum predefinedType,IfcActionTypeEnum actionType,IfcActionSourceTypeEnum actionSource) {

        super(globalId);
        this.sourceOfResultGroup = new ArrayList<>();
        this.loadGroupFor = new ArrayList<>();
        this.predefinedType = predefinedType;
        this.actionType = actionType;
        this.actionSource = actionSource;
    }
    /**
     * Constructs IfcStructuralLoadGroup with required and optional attributes.
     */
    public IfcStructuralLoadGroup(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcLoadGroupTypeEnum predefinedType,IfcActionTypeEnum actionType,IfcActionSourceTypeEnum actionSource,IfcRatioMeasure coefficient,IfcLabel purpose) {
        super(globalId,ownerHistory,name,description,objectType);
        this.sourceOfResultGroup = new ArrayList<>();
        this.loadGroupFor = new ArrayList<>();
        this.predefinedType = predefinedType;
        this.actionType = actionType;
        this.actionSource = actionSource;
        this.coefficient = coefficient;
        this.purpose = purpose;
    }
    private void initCollections() {
        this.sourceOfResultGroup = new ArrayList<>();
        this.loadGroupFor = new ArrayList<>();
    }
    public IfcLoadGroupTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcLoadGroupTypeEnum value) { this.predefinedType = value; }
    public IfcActionTypeEnum getActionType() { return this.actionType; }
    public void setActionType(IfcActionTypeEnum value) { this.actionType = value; }
    public IfcActionSourceTypeEnum getActionSource() { return this.actionSource; }
    public void setActionSource(IfcActionSourceTypeEnum value) { this.actionSource = value; }
    public IfcRatioMeasure getCoefficient() { return this.coefficient; }
    public void setCoefficient(IfcRatioMeasure value) { this.coefficient = value; } // optional
    public IfcLabel getPurpose() { return this.purpose; }
    public void setPurpose(IfcLabel value) { this.purpose = value; } // optional
    public Collection<IfcStructuralResultGroup> getSourceOfResultGroup() { return this.sourceOfResultGroup; }
    public void setSourceOfResultGroup(Collection<IfcStructuralResultGroup> value) { this.sourceOfResultGroup = value; } // inverse
    public Collection<IfcStructuralAnalysisModel> getLoadGroupFor() { return this.loadGroupFor; }
    public void setLoadGroupFor(Collection<IfcStructuralAnalysisModel> value) { this.loadGroupFor = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(StepUtils.toStepValue(actionType));
		parameters.add(StepUtils.toStepValue(actionSource));
		parameters.add(coefficient != null ? StepUtils.toStepValue(coefficient) : "$");
		parameters.add(purpose != null ? StepUtils.toStepValue(purpose) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}