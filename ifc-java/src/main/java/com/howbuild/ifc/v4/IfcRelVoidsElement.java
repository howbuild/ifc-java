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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelvoidselement.htm">IfcRelVoidsElement</a>
 */
public class IfcRelVoidsElement extends IfcRelDecomposes {
    protected IfcElement relatingBuildingElement;
    protected IfcFeatureElementSubtraction relatedOpeningElement;

    protected IfcRelVoidsElement() { initCollections(); }
    /**
     * Constructs IfcRelVoidsElement with all required attributes.
     */
    public IfcRelVoidsElement(IfcGloballyUniqueId globalId,IfcElement relatingBuildingElement,IfcFeatureElementSubtraction relatedOpeningElement) {

        super(globalId);
        this.relatingBuildingElement = relatingBuildingElement;
        this.relatedOpeningElement = relatedOpeningElement;
    }
    /**
     * Constructs IfcRelVoidsElement with required and optional attributes.
     */
    public IfcRelVoidsElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcElement relatingBuildingElement,IfcFeatureElementSubtraction relatedOpeningElement) {
        super(globalId,ownerHistory,name,description);
        this.relatingBuildingElement = relatingBuildingElement;
        this.relatedOpeningElement = relatedOpeningElement;
    }
    private void initCollections() {
    }
    public IfcElement getRelatingBuildingElement() { return this.relatingBuildingElement; }
    public void setRelatingBuildingElement(IfcElement value) { this.relatingBuildingElement = value; }
    public IfcFeatureElementSubtraction getRelatedOpeningElement() { return this.relatedOpeningElement; }
    public void setRelatedOpeningElement(IfcFeatureElementSubtraction value) { this.relatedOpeningElement = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingBuildingElement != null ? StepUtils.toStepValue(relatingBuildingElement) : "$");
		parameters.add(relatedOpeningElement != null ? StepUtils.toStepValue(relatedOpeningElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelVoidsElementRelationship(); }
    private void setIfcRelVoidsElementRelationship() {
		if (this.relatingBuildingElement != null) {
		    if (this.relatingBuildingElement instanceof IfcElement)
		        ((IfcElement)this.relatingBuildingElement).hasOpenings.add(this);
		}
		if (this.relatedOpeningElement != null) {
		    if (this.relatedOpeningElement instanceof IfcFeatureElementSubtraction)
		        ((IfcFeatureElementSubtraction)this.relatedOpeningElement).voidsElements = this;
		}
    }
}