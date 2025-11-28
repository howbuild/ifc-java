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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelinterfereselements.htm">IfcRelInterferesElements</a>
 */
public class IfcRelInterferesElements extends IfcRelConnects {
    protected IfcElement relatingElement;
    protected IfcElement relatedElement;
    protected IfcConnectionGeometry interferenceGeometry;
    protected IfcIdentifier interferenceType;
    protected IfcLogicalValue impliedOrder;

    protected IfcRelInterferesElements() { initCollections(); }
    /**
     * Constructs IfcRelInterferesElements with all required attributes.
     */
    public IfcRelInterferesElements(IfcGloballyUniqueId globalId,IfcElement relatingElement,IfcElement relatedElement,IfcLogicalValue impliedOrder) {

        super(globalId);
        this.relatingElement = relatingElement;
        this.relatedElement = relatedElement;
        this.impliedOrder = impliedOrder;
    }
    /**
     * Constructs IfcRelInterferesElements with required and optional attributes.
     */
    public IfcRelInterferesElements(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcElement relatingElement,IfcElement relatedElement,IfcConnectionGeometry interferenceGeometry,IfcIdentifier interferenceType,IfcLogicalValue impliedOrder) {
        super(globalId,ownerHistory,name,description);
        this.relatingElement = relatingElement;
        this.relatedElement = relatedElement;
        this.interferenceGeometry = interferenceGeometry;
        this.interferenceType = interferenceType;
        this.impliedOrder = impliedOrder;
    }
    private void initCollections() {
    }
    public IfcElement getRelatingElement() { return this.relatingElement; }
    public void setRelatingElement(IfcElement value) { this.relatingElement = value; }
    public IfcElement getRelatedElement() { return this.relatedElement; }
    public void setRelatedElement(IfcElement value) { this.relatedElement = value; }
    public IfcConnectionGeometry getInterferenceGeometry() { return this.interferenceGeometry; }
    public void setInterferenceGeometry(IfcConnectionGeometry value) { this.interferenceGeometry = value; } // optional
    public IfcIdentifier getInterferenceType() { return this.interferenceType; }
    public void setInterferenceType(IfcIdentifier value) { this.interferenceType = value; } // optional
    public IfcLogicalValue getImpliedOrder() { return this.impliedOrder; }
    public void setImpliedOrder(IfcLogicalValue value) { this.impliedOrder = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingElement != null ? StepUtils.toStepValue(relatingElement) : "$");
		parameters.add(relatedElement != null ? StepUtils.toStepValue(relatedElement) : "$");
		parameters.add(interferenceGeometry != null ? StepUtils.toStepValue(interferenceGeometry) : "$");
		parameters.add(interferenceType != null ? StepUtils.toStepValue(interferenceType) : "$");
		parameters.add(impliedOrder != null ? StepUtils.toStepValue(impliedOrder) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelInterferesElementsRelationship(); }
    private void setIfcRelInterferesElementsRelationship() {
		if (this.relatedElement != null) {
		    if (this.relatedElement instanceof IfcElement)
		        ((IfcElement)this.relatedElement).isInterferedByElements.add(this);
		}
		if (this.relatingElement != null) {
		    if (this.relatingElement instanceof IfcElement)
		        ((IfcElement)this.relatingElement).interferesElements.add(this);
		}
    }
}