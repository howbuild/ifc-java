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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectsports.htm">IfcRelConnectsPorts</a>
 */
public class IfcRelConnectsPorts extends IfcRelConnects {
    protected IfcPort relatingPort;
    protected IfcPort relatedPort;
    protected IfcElement realizingElement;

    protected IfcRelConnectsPorts() { initCollections(); }
    /**
     * Constructs IfcRelConnectsPorts with all required attributes.
     */
    public IfcRelConnectsPorts(IfcGloballyUniqueId globalId,IfcPort relatingPort,IfcPort relatedPort) {

        super(globalId);
        this.relatingPort = relatingPort;
        this.relatedPort = relatedPort;
    }
    /**
     * Constructs IfcRelConnectsPorts with required and optional attributes.
     */
    public IfcRelConnectsPorts(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPort relatingPort,IfcPort relatedPort,IfcElement realizingElement) {
        super(globalId,ownerHistory,name,description);
        this.relatingPort = relatingPort;
        this.relatedPort = relatedPort;
        this.realizingElement = realizingElement;
    }
    private void initCollections() {
    }
    public IfcPort getRelatingPort() { return this.relatingPort; }
    public void setRelatingPort(IfcPort value) { this.relatingPort = value; }
    public IfcPort getRelatedPort() { return this.relatedPort; }
    public void setRelatedPort(IfcPort value) { this.relatedPort = value; }
    public IfcElement getRealizingElement() { return this.realizingElement; }
    public void setRealizingElement(IfcElement value) { this.realizingElement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingPort != null ? StepUtils.toStepValue(relatingPort) : "$");
		parameters.add(relatedPort != null ? StepUtils.toStepValue(relatedPort) : "$");
		parameters.add(realizingElement != null ? StepUtils.toStepValue(realizingElement) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelConnectsPortsRelationship(); }
    private void setIfcRelConnectsPortsRelationship() {
		if (this.relatedPort != null) {
		    if (this.relatedPort instanceof IfcPort)
		        ((IfcPort)this.relatedPort).connectedFrom.add(this);
		}
		if (this.relatingPort != null) {
		    if (this.relatingPort instanceof IfcPort)
		        ((IfcPort)this.relatingPort).connectedTo.add(this);
		}
    }
}