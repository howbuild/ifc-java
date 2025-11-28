package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcApprovalRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingApproval : IfcApproval;
 * RelatedApprovals : SET [1:?] OF IfcApproval;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcapprovalrelationship.htm">IfcApprovalRelationship</a>
 */
public class IfcApprovalRelationship extends IfcResourceLevelRelationship {
    protected IfcApproval relatingApproval;
    protected Collection<IfcApproval> relatedApprovals;

    protected IfcApprovalRelationship() { initCollections(); }
    /**
     * Constructs IfcApprovalRelationship with all required attributes.
     */
    public IfcApprovalRelationship(IfcApproval relatingApproval,Collection<IfcApproval> relatedApprovals) {

        super();
        this.relatingApproval = relatingApproval;
        this.relatedApprovals = relatedApprovals;
    }
    /**
     * Constructs IfcApprovalRelationship with required and optional attributes.
     */
    public IfcApprovalRelationship(IfcLabel name,IfcText description,IfcApproval relatingApproval,Collection<IfcApproval> relatedApprovals) {
        super(name,description);
        this.relatingApproval = relatingApproval;
        this.relatedApprovals = relatedApprovals;
    }
    private void initCollections() {
        this.relatedApprovals = new ArrayList<>();
    }
    public IfcApproval getRelatingApproval() { return this.relatingApproval; }
    public void setRelatingApproval(IfcApproval value) { this.relatingApproval = value; }
    public Collection<IfcApproval> getRelatedApprovals() { return this.relatedApprovals; }
    public void setRelatedApprovals(Collection<IfcApproval> value) { this.relatedApprovals = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingApproval != null ? StepUtils.toStepValue(relatingApproval) : "$");
		parameters.add(relatedApprovals != null ? StepUtils.toStepValue(relatedApprovals) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcApprovalRelationshipRelationship(); }
    private void setIfcApprovalRelationshipRelationship() {
		if (this.relatedApprovals != null) {
		    for (Object x : this.relatedApprovals) {
		        if (x instanceof IfcApproval)
		            ((IfcApproval)x).isRelatedWith.add(this);
		    }
		}
		if (this.relatingApproval != null) {
		    if (this.relatingApproval instanceof IfcApproval)
		        ((IfcApproval)this.relatingApproval).relates.add(this);
		}
    }
}