package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelDecomposes
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAggregates
 * ,IfcRelNests
 * ,IfcRelProjectsElement
 * ,IfcRelVoidsElement))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelprojectselement.htm">IfcRelProjectsElement</a>
 */
public class IfcRelProjectsElement extends IfcRelDecomposes {
    protected IfcElement relatingElement;
    protected IfcFeatureElementAddition relatedFeatureElement;

    protected IfcRelProjectsElement() { initCollections(); }
    /**
     * Constructs IfcRelProjectsElement with all required attributes.
     */
    public IfcRelProjectsElement(IfcGloballyUniqueId globalId,IfcElement relatingElement,IfcFeatureElementAddition relatedFeatureElement) {

        super(globalId);
        this.relatingElement = relatingElement;
        this.relatedFeatureElement = relatedFeatureElement;
    }
    /**
     * Constructs IfcRelProjectsElement with required and optional attributes.
     */
    public IfcRelProjectsElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcElement relatingElement,IfcFeatureElementAddition relatedFeatureElement) {
        super(globalId,ownerHistory,name,description);
        this.relatingElement = relatingElement;
        this.relatedFeatureElement = relatedFeatureElement;
    }
    private void initCollections() {
    }
    public IfcElement getRelatingElement() { return this.relatingElement; }
    public void setRelatingElement(IfcElement value) { this.relatingElement = value; }
    public IfcFeatureElementAddition getRelatedFeatureElement() { return this.relatedFeatureElement; }
    public void setRelatedFeatureElement(IfcFeatureElementAddition value) { this.relatedFeatureElement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingElement != null ? StepUtils.toStepValue(relatingElement) : "$");
		parameters.add(relatedFeatureElement != null ? StepUtils.toStepValue(relatedFeatureElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelProjectsElementRelationship(); }
    private void setIfcRelProjectsElementRelationship() {
		if (this.relatingElement != null) {
		    if (this.relatingElement instanceof IfcElement)
		        ((IfcElement)this.relatingElement).hasProjections.add(this);
		}
		if (this.relatedFeatureElement != null) {
		    if (this.relatedFeatureElement instanceof IfcFeatureElementAddition)
		        ((IfcFeatureElementAddition)this.relatedFeatureElement).projectsElements = this;
		}
    }
}