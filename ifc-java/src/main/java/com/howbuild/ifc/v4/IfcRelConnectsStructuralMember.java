package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelConnects
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelConnectsElements
 * ,IfcRelConnectsPortToElement
 * ,IfcRelConnectsPorts
 * ,IfcRelConnectsStructuralActivity
 * ,IfcRelConnectsStructuralMember
 * ,IfcRelContainedInSpatialStructure
 * ,IfcRelCoversBldgElements
 * ,IfcRelCoversSpaces
 * ,IfcRelFillsElement
 * ,IfcRelFlowControlElements
 * ,IfcRelInterferesElements
 * ,IfcRelReferencedInSpatialStructure
 * ,IfcRelSequence
 * ,IfcRelServicesBuildings
 * ,IfcRelSpaceBoundary))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectsstructuralmember.htm">IfcRelConnectsStructuralMember</a>
 */
public class IfcRelConnectsStructuralMember extends IfcRelConnects {
    protected IfcStructuralMember relatingStructuralMember;
    protected IfcStructuralConnection relatedStructuralConnection;
    protected IfcBoundaryCondition appliedCondition;
    protected IfcStructuralConnectionCondition additionalConditions;
    protected IfcLengthMeasure supportedLength;
    protected IfcAxis2Placement3D conditionCoordinateSystem;

    protected IfcRelConnectsStructuralMember() { initCollections(); }
    /**
     * Constructs IfcRelConnectsStructuralMember with all required attributes.
     */
    public IfcRelConnectsStructuralMember(IfcGloballyUniqueId globalId,IfcStructuralMember relatingStructuralMember,IfcStructuralConnection relatedStructuralConnection) {

        super(globalId);
        this.relatingStructuralMember = relatingStructuralMember;
        this.relatedStructuralConnection = relatedStructuralConnection;
    }
    /**
     * Constructs IfcRelConnectsStructuralMember with required and optional attributes.
     */
    public IfcRelConnectsStructuralMember(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcStructuralMember relatingStructuralMember,IfcStructuralConnection relatedStructuralConnection,IfcBoundaryCondition appliedCondition,IfcStructuralConnectionCondition additionalConditions,IfcLengthMeasure supportedLength,IfcAxis2Placement3D conditionCoordinateSystem) {
        super(globalId,ownerHistory,name,description);
        this.relatingStructuralMember = relatingStructuralMember;
        this.relatedStructuralConnection = relatedStructuralConnection;
        this.appliedCondition = appliedCondition;
        this.additionalConditions = additionalConditions;
        this.supportedLength = supportedLength;
        this.conditionCoordinateSystem = conditionCoordinateSystem;
    }
    private void initCollections() {
    }
    public IfcStructuralMember getRelatingStructuralMember() { return this.relatingStructuralMember; }
    public void setRelatingStructuralMember(IfcStructuralMember value) { this.relatingStructuralMember = value; }
    public IfcStructuralConnection getRelatedStructuralConnection() { return this.relatedStructuralConnection; }
    public void setRelatedStructuralConnection(IfcStructuralConnection value) { this.relatedStructuralConnection = value; }
    public IfcBoundaryCondition getAppliedCondition() { return this.appliedCondition; }
    public void setAppliedCondition(IfcBoundaryCondition value) { this.appliedCondition = value; } // optional
    public IfcStructuralConnectionCondition getAdditionalConditions() { return this.additionalConditions; }
    public void setAdditionalConditions(IfcStructuralConnectionCondition value) { this.additionalConditions = value; } // optional
    public IfcLengthMeasure getSupportedLength() { return this.supportedLength; }
    public void setSupportedLength(IfcLengthMeasure value) { this.supportedLength = value; } // optional
    public IfcAxis2Placement3D getConditionCoordinateSystem() { return this.conditionCoordinateSystem; }
    public void setConditionCoordinateSystem(IfcAxis2Placement3D value) { this.conditionCoordinateSystem = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingStructuralMember != null ? StepUtils.toStepValue(relatingStructuralMember) : "$");
		parameters.add(relatedStructuralConnection != null ? StepUtils.toStepValue(relatedStructuralConnection) : "$");
		parameters.add(appliedCondition != null ? StepUtils.toStepValue(appliedCondition) : "$");
		parameters.add(additionalConditions != null ? StepUtils.toStepValue(additionalConditions) : "$");
		parameters.add(supportedLength != null ? StepUtils.toStepValue(supportedLength) : "$");
		parameters.add(conditionCoordinateSystem != null ? StepUtils.toStepValue(conditionCoordinateSystem) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelConnectsStructuralMemberRelationship(); }
    private void setIfcRelConnectsStructuralMemberRelationship() {
		if (this.relatedStructuralConnection != null) {
		    if (this.relatedStructuralConnection instanceof IfcStructuralConnection)
		        ((IfcStructuralConnection)this.relatedStructuralConnection).connectsStructuralMembers.add(this);
		}
		if (this.relatingStructuralMember != null) {
		    if (this.relatingStructuralMember instanceof IfcStructuralMember)
		        ((IfcStructuralMember)this.relatingStructuralMember).connectedBy.add(this);
		}
    }
}