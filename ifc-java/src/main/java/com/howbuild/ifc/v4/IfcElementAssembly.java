package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBuildingElement
 * ,IfcCivilElement
 * ,IfcDistributionElement
 * ,IfcElementAssembly
 * ,IfcElementComponent
 * ,IfcFeatureElement
 * ,IfcFurnishingElement
 * ,IfcGeographicElement
 * ,IfcTransportElement
 * ,IfcVirtualElement))
 * SUBTYPE OF (IfcProduct);
 * Tag : OPTIONAL IfcIdentifier;
 * INVERSE
 * FillsVoids : SET [0:1] OF IfcRelFillsElement FOR RelatedBuildingElement;
 * ConnectedTo : SET [0:?] OF IfcRelConnectsElements FOR RelatingElement;
 * IsInterferedByElements : SET [0:?] OF IfcRelInterferesElements FOR RelatedElement;
 * InterferesElements : SET [0:?] OF IfcRelInterferesElements FOR RelatingElement;
 * HasProjections : SET [0:?] OF IfcRelProjectsElement FOR RelatingElement;
 * ReferencedInStructures : SET [0:?] OF IfcRelReferencedInSpatialStructure FOR RelatedElements;
 * HasOpenings : SET [0:?] OF IfcRelVoidsElement FOR RelatingBuildingElement;
 * IsConnectionRealization : SET [0:?] OF IfcRelConnectsWithRealizingElements FOR RealizingElements;
 * ProvidesBoundaries : SET [0:?] OF IfcRelSpaceBoundary FOR RelatedBuildingElement;
 * ConnectedFrom : SET [0:?] OF IfcRelConnectsElements FOR RelatedElement;
 * ContainedInStructure : SET [0:1] OF IfcRelContainedInSpatialStructure FOR RelatedElements;
 * HasCoverings : SET [0:?] OF IfcRelCoversBldgElements FOR RelatingBuildingElement;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelementassembly.htm">IfcElementAssembly</a>
 */
public class IfcElementAssembly extends IfcElement {
    protected IfcAssemblyPlaceEnum assemblyPlace;
    protected IfcElementAssemblyTypeEnum predefinedType;

    protected IfcElementAssembly() { initCollections(); }
    /**
     * Constructs IfcElementAssembly with all required attributes.
     */
    public IfcElementAssembly(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcElementAssembly with required and optional attributes.
     */
    public IfcElementAssembly(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcAssemblyPlaceEnum assemblyPlace,IfcElementAssemblyTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.assemblyPlace = assemblyPlace;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcAssemblyPlaceEnum getAssemblyPlace() { return this.assemblyPlace; }
    public void setAssemblyPlace(IfcAssemblyPlaceEnum value) { this.assemblyPlace = value; } // optional
    public IfcElementAssemblyTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcElementAssemblyTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
		parameters.add(StepUtils.toStepValue(assemblyPlace));
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}