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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelservicesbuildings.htm">IfcRelServicesBuildings</a>
 */
public class IfcRelServicesBuildings extends IfcRelConnects {
    protected IfcSystem relatingSystem;
    protected Collection<IfcSpatialElement> relatedBuildings;

    protected IfcRelServicesBuildings() { initCollections(); }
    /**
     * Constructs IfcRelServicesBuildings with all required attributes.
     */
    public IfcRelServicesBuildings(IfcGloballyUniqueId globalId,IfcSystem relatingSystem,Collection<IfcSpatialElement> relatedBuildings) {

        super(globalId);
        this.relatingSystem = relatingSystem;
        this.relatedBuildings = relatedBuildings;
    }
    /**
     * Constructs IfcRelServicesBuildings with required and optional attributes.
     */
    public IfcRelServicesBuildings(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcSystem relatingSystem,Collection<IfcSpatialElement> relatedBuildings) {
        super(globalId,ownerHistory,name,description);
        this.relatingSystem = relatingSystem;
        this.relatedBuildings = relatedBuildings;
    }
    private void initCollections() {
        this.relatedBuildings = new ArrayList<>();
    }
    public IfcSystem getRelatingSystem() { return this.relatingSystem; }
    public void setRelatingSystem(IfcSystem value) { this.relatingSystem = value; }
    public Collection<IfcSpatialElement> getRelatedBuildings() { return this.relatedBuildings; }
    public void setRelatedBuildings(Collection<IfcSpatialElement> value) { this.relatedBuildings = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingSystem != null ? StepUtils.toStepValue(relatingSystem) : "$");
		parameters.add(relatedBuildings != null ? StepUtils.toStepValue(relatedBuildings) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelServicesBuildingsRelationship(); }
    private void setIfcRelServicesBuildingsRelationship() {
		if (this.relatedBuildings != null) {
		    for (Object x : this.relatedBuildings) {
		        if (x instanceof IfcSpatialElement)
		            ((IfcSpatialElement)x).servicedBySystems.add(this);
		    }
		}
		if (this.relatingSystem != null) {
		    if (this.relatingSystem instanceof IfcSystem)
		        ((IfcSystem)this.relatingSystem).servicesBuildings.add(this);
		}
    }
}