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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelspaceboundary.htm">IfcRelSpaceBoundary</a>
 */
public class IfcRelSpaceBoundary extends IfcRelConnects {
    protected IfcSpaceBoundarySelect relatingSpace;
    protected IfcElement relatedBuildingElement;
    protected IfcConnectionGeometry connectionGeometry;
    protected IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary;
    protected IfcInternalOrExternalEnum internalOrExternalBoundary;

    protected IfcRelSpaceBoundary() { initCollections(); }
    /**
     * Constructs IfcRelSpaceBoundary with all required attributes.
     */
    public IfcRelSpaceBoundary(IfcGloballyUniqueId globalId,IfcSpaceBoundarySelect relatingSpace,IfcElement relatedBuildingElement,IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary,IfcInternalOrExternalEnum internalOrExternalBoundary) {

        super(globalId);
        this.relatingSpace = relatingSpace;
        this.relatedBuildingElement = relatedBuildingElement;
        this.physicalOrVirtualBoundary = physicalOrVirtualBoundary;
        this.internalOrExternalBoundary = internalOrExternalBoundary;
    }
    /**
     * Constructs IfcRelSpaceBoundary with required and optional attributes.
     */
    public IfcRelSpaceBoundary(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcSpaceBoundarySelect relatingSpace,IfcElement relatedBuildingElement,IfcConnectionGeometry connectionGeometry,IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary,IfcInternalOrExternalEnum internalOrExternalBoundary) {
        super(globalId,ownerHistory,name,description);
        this.relatingSpace = relatingSpace;
        this.relatedBuildingElement = relatedBuildingElement;
        this.connectionGeometry = connectionGeometry;
        this.physicalOrVirtualBoundary = physicalOrVirtualBoundary;
        this.internalOrExternalBoundary = internalOrExternalBoundary;
    }
    private void initCollections() {
    }
    public IfcSpaceBoundarySelect getRelatingSpace() { return this.relatingSpace; }
    public void setRelatingSpace(IfcSpaceBoundarySelect value) { this.relatingSpace = value; }
    public IfcElement getRelatedBuildingElement() { return this.relatedBuildingElement; }
    public void setRelatedBuildingElement(IfcElement value) { this.relatedBuildingElement = value; }
    public IfcConnectionGeometry getConnectionGeometry() { return this.connectionGeometry; }
    public void setConnectionGeometry(IfcConnectionGeometry value) { this.connectionGeometry = value; } // optional
    public IfcPhysicalOrVirtualEnum getPhysicalOrVirtualBoundary() { return this.physicalOrVirtualBoundary; }
    public void setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum value) { this.physicalOrVirtualBoundary = value; }
    public IfcInternalOrExternalEnum getInternalOrExternalBoundary() { return this.internalOrExternalBoundary; }
    public void setInternalOrExternalBoundary(IfcInternalOrExternalEnum value) { this.internalOrExternalBoundary = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingSpace != null ? StepUtils.toStepValue(relatingSpace) : "$");
		parameters.add(relatedBuildingElement != null ? StepUtils.toStepValue(relatedBuildingElement) : "$");
		parameters.add(connectionGeometry != null ? StepUtils.toStepValue(connectionGeometry) : "$");
		parameters.add(StepUtils.toStepValue(physicalOrVirtualBoundary));
		parameters.add(StepUtils.toStepValue(internalOrExternalBoundary));
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelSpaceBoundaryRelationship(); }
    private void setIfcRelSpaceBoundaryRelationship() {
		if (this.relatedBuildingElement != null) {
		    if (this.relatedBuildingElement instanceof IfcElement)
		        ((IfcElement)this.relatedBuildingElement).providesBoundaries.add(this);
		}
		if (this.relatingSpace != null) {
		    if (this.relatingSpace instanceof IfcExternalSpatialElement)
		        ((IfcExternalSpatialElement)this.relatingSpace).boundedBy.add(this);
		}
		if (this.relatingSpace != null) {
		    if (this.relatingSpace instanceof IfcSpace)
		        ((IfcSpace)this.relatingSpace).boundedBy.add(this);
		}
    }
}