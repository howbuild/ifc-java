package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelConnectsElements
 * SUPERTYPE OF (ONEOF
 * (IfcRelConnectsPathElements
 * ,IfcRelConnectsWithRealizingElements))
 * SUBTYPE OF (IfcRelConnects);
 * ConnectionGeometry : OPTIONAL IfcConnectionGeometry;
 * RelatingElement : IfcElement;
 * RelatedElement : IfcElement;
 * WHERE
 * NoSelfReference : RelatingElement :<>: RelatedElement;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectswithrealizingelements.htm">IfcRelConnectsWithRealizingElements</a>
 */
public class IfcRelConnectsWithRealizingElements extends IfcRelConnectsElements {
    protected Collection<IfcElement> realizingElements;
    protected IfcLabel connectionType;

    protected IfcRelConnectsWithRealizingElements() { initCollections(); }
    /**
     * Constructs IfcRelConnectsWithRealizingElements with all required attributes.
     */
    public IfcRelConnectsWithRealizingElements(IfcGloballyUniqueId globalId,IfcElement relatingElement,IfcElement relatedElement,Collection<IfcElement> realizingElements) {

        super(globalId,relatingElement,relatedElement);
        this.realizingElements = realizingElements;
    }
    /**
     * Constructs IfcRelConnectsWithRealizingElements with required and optional attributes.
     */
    public IfcRelConnectsWithRealizingElements(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcConnectionGeometry connectionGeometry,IfcElement relatingElement,IfcElement relatedElement,Collection<IfcElement> realizingElements,IfcLabel connectionType) {
        super(globalId,ownerHistory,name,description,connectionGeometry,relatingElement,relatedElement);
        this.realizingElements = realizingElements;
        this.connectionType = connectionType;
    }
    private void initCollections() {
        this.realizingElements = new ArrayList<>();
    }
    public Collection<IfcElement> getRealizingElements() { return this.realizingElements; }
    public void setRealizingElements(Collection<IfcElement> value) { this.realizingElements = value; }
    public IfcLabel getConnectionType() { return this.connectionType; }
    public void setConnectionType(IfcLabel value) { this.connectionType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(connectionGeometry != null ? StepUtils.toStepValue(connectionGeometry) : "$");
		parameters.add(relatingElement != null ? StepUtils.toStepValue(relatingElement) : "$");
		parameters.add(relatedElement != null ? StepUtils.toStepValue(relatedElement) : "$");
		parameters.add(realizingElements != null ? StepUtils.toStepValue(realizingElements) : "$");
		parameters.add(connectionType != null ? StepUtils.toStepValue(connectionType) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelConnectsWithRealizingElementsRelationship(); }
    private void setIfcRelConnectsWithRealizingElementsRelationship() {
		if (this.realizingElements != null) {
		    for (Object x : this.realizingElements) {
		        if (x instanceof IfcElement)
		            ((IfcElement)x).isConnectionRealization.add(this);
		    }
		}
    }
}