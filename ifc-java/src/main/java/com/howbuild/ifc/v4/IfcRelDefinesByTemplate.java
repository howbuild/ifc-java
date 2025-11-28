package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelDefines
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelDefinesByObject
 * ,IfcRelDefinesByProperties
 * ,IfcRelDefinesByTemplate
 * ,IfcRelDefinesByType))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldefinesbytemplate.htm">IfcRelDefinesByTemplate</a>
 */
public class IfcRelDefinesByTemplate extends IfcRelDefines {
    protected Collection<IfcPropertySetDefinition> relatedPropertySets;
    protected IfcPropertySetTemplate relatingTemplate;

    protected IfcRelDefinesByTemplate() { initCollections(); }
    /**
     * Constructs IfcRelDefinesByTemplate with all required attributes.
     */
    public IfcRelDefinesByTemplate(IfcGloballyUniqueId globalId,Collection<IfcPropertySetDefinition> relatedPropertySets,IfcPropertySetTemplate relatingTemplate) {

        super(globalId);
        this.relatedPropertySets = relatedPropertySets;
        this.relatingTemplate = relatingTemplate;
    }
    /**
     * Constructs IfcRelDefinesByTemplate with required and optional attributes.
     */
    public IfcRelDefinesByTemplate(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcPropertySetDefinition> relatedPropertySets,IfcPropertySetTemplate relatingTemplate) {
        super(globalId,ownerHistory,name,description);
        this.relatedPropertySets = relatedPropertySets;
        this.relatingTemplate = relatingTemplate;
    }
    private void initCollections() {
        this.relatedPropertySets = new ArrayList<>();
    }
    public Collection<IfcPropertySetDefinition> getRelatedPropertySets() { return this.relatedPropertySets; }
    public void setRelatedPropertySets(Collection<IfcPropertySetDefinition> value) { this.relatedPropertySets = value; }
    public IfcPropertySetTemplate getRelatingTemplate() { return this.relatingTemplate; }
    public void setRelatingTemplate(IfcPropertySetTemplate value) { this.relatingTemplate = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedPropertySets != null ? StepUtils.toStepValue(relatedPropertySets) : "$");
		parameters.add(relatingTemplate != null ? StepUtils.toStepValue(relatingTemplate) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelDefinesByTemplateRelationship(); }
    private void setIfcRelDefinesByTemplateRelationship() {
		if (this.relatedPropertySets != null) {
		    for (Object x : this.relatedPropertySets) {
		        if (x instanceof IfcPropertySetDefinition)
		            ((IfcPropertySetDefinition)x).isDefinedBy.add(this);
		    }
		}
		if (this.relatingTemplate != null) {
		    if (this.relatingTemplate instanceof IfcPropertySetTemplate)
		        ((IfcPropertySetTemplate)this.relatingTemplate).defines.add(this);
		}
    }
}