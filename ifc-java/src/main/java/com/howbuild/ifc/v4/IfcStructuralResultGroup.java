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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralresultgroup.htm">IfcStructuralResultGroup</a>
 */
public class IfcStructuralResultGroup extends IfcGroup {
    protected IfcAnalysisTheoryTypeEnum theoryType;
    protected IfcStructuralLoadGroup resultForLoadGroup;
    protected IfcBoolean isLinear;
    protected Collection<IfcStructuralAnalysisModel> resultGroupFor;

    protected IfcStructuralResultGroup() { initCollections(); }
    /**
     * Constructs IfcStructuralResultGroup with all required attributes.
     */
    public IfcStructuralResultGroup(IfcGloballyUniqueId globalId,IfcAnalysisTheoryTypeEnum theoryType,IfcBoolean isLinear) {

        super(globalId);
        this.resultGroupFor = new ArrayList<>();
        this.theoryType = theoryType;
        this.isLinear = isLinear;
    }
    /**
     * Constructs IfcStructuralResultGroup with required and optional attributes.
     */
    public IfcStructuralResultGroup(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcAnalysisTheoryTypeEnum theoryType,IfcStructuralLoadGroup resultForLoadGroup,IfcBoolean isLinear) {
        super(globalId,ownerHistory,name,description,objectType);
        this.resultGroupFor = new ArrayList<>();
        this.theoryType = theoryType;
        this.resultForLoadGroup = resultForLoadGroup;
        this.isLinear = isLinear;
    }
    private void initCollections() {
        this.resultGroupFor = new ArrayList<>();
    }
    public IfcAnalysisTheoryTypeEnum getTheoryType() { return this.theoryType; }
    public void setTheoryType(IfcAnalysisTheoryTypeEnum value) { this.theoryType = value; }
    public IfcStructuralLoadGroup getResultForLoadGroup() { return this.resultForLoadGroup; }
    public void setResultForLoadGroup(IfcStructuralLoadGroup value) { this.resultForLoadGroup = value; } // optional
    public IfcBoolean getIsLinear() { return this.isLinear; }
    public void setIsLinear(IfcBoolean value) { this.isLinear = value; }
    public Collection<IfcStructuralAnalysisModel> getResultGroupFor() { return this.resultGroupFor; }
    public void setResultGroupFor(Collection<IfcStructuralAnalysisModel> value) { this.resultGroupFor = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(StepUtils.toStepValue(theoryType));
		parameters.add(resultForLoadGroup != null ? StepUtils.toStepValue(resultForLoadGroup) : "$");
		parameters.add(isLinear != null ? StepUtils.toStepValue(isLinear) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcStructuralResultGroupRelationship(); }
    private void setIfcStructuralResultGroupRelationship() {
		if (this.resultForLoadGroup != null) {
		    if (this.resultForLoadGroup instanceof IfcStructuralLoadGroup)
		        ((IfcStructuralLoadGroup)this.resultForLoadGroup).sourceOfResultGroup.add(this);
		}
    }
}