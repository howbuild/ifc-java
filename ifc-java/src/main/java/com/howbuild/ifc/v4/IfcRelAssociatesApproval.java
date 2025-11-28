package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAssociates
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAssociatesApproval
 * ,IfcRelAssociatesClassification
 * ,IfcRelAssociatesConstraint
 * ,IfcRelAssociatesDocument
 * ,IfcRelAssociatesLibrary
 * ,IfcRelAssociatesMaterial))
 * SUBTYPE OF (IfcRelationship);
 * RelatedObjects : SET [1:?] OF IfcDefinitionSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociatesapproval.htm">IfcRelAssociatesApproval</a>
 */
public class IfcRelAssociatesApproval extends IfcRelAssociates {
    protected IfcApproval relatingApproval;

    protected IfcRelAssociatesApproval() { initCollections(); }
    /**
     * Constructs IfcRelAssociatesApproval with all required attributes.
     */
    public IfcRelAssociatesApproval(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects,IfcApproval relatingApproval) {

        super(globalId,relatedObjects);
        this.relatingApproval = relatingApproval;
    }
    /**
     * Constructs IfcRelAssociatesApproval with required and optional attributes.
     */
    public IfcRelAssociatesApproval(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects,IfcApproval relatingApproval) {
        super(globalId,ownerHistory,name,description,relatedObjects);
        this.relatingApproval = relatingApproval;
    }
    private void initCollections() {
    }
    public IfcApproval getRelatingApproval() { return this.relatingApproval; }
    public void setRelatingApproval(IfcApproval value) { this.relatingApproval = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(relatingApproval != null ? StepUtils.toStepValue(relatingApproval) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelAssociatesApprovalRelationship(); }
    private void setIfcRelAssociatesApprovalRelationship() {
		if (this.relatingApproval != null) {
		    if (this.relatingApproval instanceof IfcApproval)
		        ((IfcApproval)this.relatingApproval).approvedObjects.add(this);
		}
    }
}