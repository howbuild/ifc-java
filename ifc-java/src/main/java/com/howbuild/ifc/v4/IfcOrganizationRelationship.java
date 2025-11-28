package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcOrganizationRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingOrganization : IfcOrganization;
 * RelatedOrganizations : SET [1:?] OF IfcOrganization;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcorganizationrelationship.htm">IfcOrganizationRelationship</a>
 */
public class IfcOrganizationRelationship extends IfcResourceLevelRelationship {
    protected IfcOrganization relatingOrganization;
    protected Collection<IfcOrganization> relatedOrganizations;

    protected IfcOrganizationRelationship() { initCollections(); }
    /**
     * Constructs IfcOrganizationRelationship with all required attributes.
     */
    public IfcOrganizationRelationship(IfcOrganization relatingOrganization,Collection<IfcOrganization> relatedOrganizations) {

        super();
        this.relatingOrganization = relatingOrganization;
        this.relatedOrganizations = relatedOrganizations;
    }
    /**
     * Constructs IfcOrganizationRelationship with required and optional attributes.
     */
    public IfcOrganizationRelationship(IfcLabel name,IfcText description,IfcOrganization relatingOrganization,Collection<IfcOrganization> relatedOrganizations) {
        super(name,description);
        this.relatingOrganization = relatingOrganization;
        this.relatedOrganizations = relatedOrganizations;
    }
    private void initCollections() {
        this.relatedOrganizations = new ArrayList<>();
    }
    public IfcOrganization getRelatingOrganization() { return this.relatingOrganization; }
    public void setRelatingOrganization(IfcOrganization value) { this.relatingOrganization = value; }
    public Collection<IfcOrganization> getRelatedOrganizations() { return this.relatedOrganizations; }
    public void setRelatedOrganizations(Collection<IfcOrganization> value) { this.relatedOrganizations = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingOrganization != null ? StepUtils.toStepValue(relatingOrganization) : "$");
		parameters.add(relatedOrganizations != null ? StepUtils.toStepValue(relatedOrganizations) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcOrganizationRelationshipRelationship(); }
    private void setIfcOrganizationRelationshipRelationship() {
		if (this.relatedOrganizations != null) {
		    for (Object x : this.relatedOrganizations) {
		        if (x instanceof IfcOrganization)
		            ((IfcOrganization)x).isRelatedBy.add(this);
		    }
		}
		if (this.relatingOrganization != null) {
		    if (this.relatingOrganization instanceof IfcOrganization)
		        ((IfcOrganization)this.relatingOrganization).relates.add(this);
		}
    }
}