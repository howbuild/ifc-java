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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfeatureelement.htm">IfcFeatureElement</a>
 */
public abstract class IfcFeatureElement extends IfcElement {

    protected IfcFeatureElement() { initCollections(); }
    /**
     * Constructs IfcFeatureElement with all required attributes.
     */
    public IfcFeatureElement(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFeatureElement with required and optional attributes.
     */
    public IfcFeatureElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}