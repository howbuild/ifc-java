package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcResourceApprovalRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatedResourceObjects : SET [1:?] OF IfcResourceObjectSelect;
 * RelatingApproval : IfcApproval;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcresourceapprovalrelationship.htm">IfcResourceApprovalRelationship</a>
 */
public class IfcResourceApprovalRelationship extends IfcResourceLevelRelationship {
    protected Collection<IfcResourceObjectSelect> relatedResourceObjects;
    protected IfcApproval relatingApproval;

    protected IfcResourceApprovalRelationship() { initCollections(); }
    /**
     * Constructs IfcResourceApprovalRelationship with all required attributes.
     */
    public IfcResourceApprovalRelationship(Collection<IfcResourceObjectSelect> relatedResourceObjects,IfcApproval relatingApproval) {

        super();
        this.relatedResourceObjects = relatedResourceObjects;
        this.relatingApproval = relatingApproval;
    }
    /**
     * Constructs IfcResourceApprovalRelationship with required and optional attributes.
     */
    public IfcResourceApprovalRelationship(IfcLabel name,IfcText description,Collection<IfcResourceObjectSelect> relatedResourceObjects,IfcApproval relatingApproval) {
        super(name,description);
        this.relatedResourceObjects = relatedResourceObjects;
        this.relatingApproval = relatingApproval;
    }
    private void initCollections() {
        this.relatedResourceObjects = new ArrayList<>();
    }
    public Collection<IfcResourceObjectSelect> getRelatedResourceObjects() { return this.relatedResourceObjects; }
    public void setRelatedResourceObjects(Collection<IfcResourceObjectSelect> value) { this.relatedResourceObjects = value; }
    public IfcApproval getRelatingApproval() { return this.relatingApproval; }
    public void setRelatingApproval(IfcApproval value) { this.relatingApproval = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedResourceObjects != null ? StepUtils.toStepValue(relatedResourceObjects) : "$");
		parameters.add(relatingApproval != null ? StepUtils.toStepValue(relatingApproval) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcResourceApprovalRelationshipRelationship(); }
    private void setIfcResourceApprovalRelationshipRelationship() {
		if (this.relatingApproval != null) {
		    if (this.relatingApproval instanceof IfcApproval)
		        ((IfcApproval)this.relatingApproval).approvedResources.add(this);
		}
		if (this.relatedResourceObjects != null) {
		    for (Object x : this.relatedResourceObjects) {
		        if (x instanceof IfcProperty)
		            ((IfcProperty)x).hasApprovals.add(this);
		    }
		}
    }
}