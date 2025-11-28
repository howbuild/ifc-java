package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBeam
 * ,IfcBuildingElementProxy
 * ,IfcChimney
 * ,IfcColumn
 * ,IfcCovering
 * ,IfcCurtainWall
 * ,IfcDoor
 * ,IfcFooting
 * ,IfcMember
 * ,IfcPile
 * ,IfcPlate
 * ,IfcRailing
 * ,IfcRamp
 * ,IfcRampFlight
 * ,IfcRoof
 * ,IfcShadingDevice
 * ,IfcSlab
 * ,IfcStair
 * ,IfcStairFlight
 * ,IfcWall
 * ,IfcWindow))
 * SUBTYPE OF (IfcElement);
 * WHERE
 * MaxOneMaterialAssociation : SIZEOF (QUERY(temp <* SELF\IfcObjectDefinition.HasAssociations |
 * 'IFC4.IFCRELASSOCIATESMATERIAL' IN TYPEOF(temp)
 * )) <= 1;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelement.htm">IfcElement</a>
 */
public abstract class IfcElement extends IfcProduct implements IfcStructuralActivityAssignmentSelect {
    protected IfcIdentifier tag;
    protected Collection<IfcRelFillsElement> fillsVoids;
    protected Collection<IfcRelConnectsElements> connectedTo;
    protected Collection<IfcRelInterferesElements> isInterferedByElements;
    protected Collection<IfcRelInterferesElements> interferesElements;
    protected Collection<IfcRelProjectsElement> hasProjections;
    protected Collection<IfcRelReferencedInSpatialStructure> referencedInStructures;
    protected Collection<IfcRelVoidsElement> hasOpenings;
    protected Collection<IfcRelConnectsWithRealizingElements> isConnectionRealization;
    protected Collection<IfcRelSpaceBoundary> providesBoundaries;
    protected Collection<IfcRelConnectsElements> connectedFrom;
    protected Collection<IfcRelContainedInSpatialStructure> containedInStructure;
    protected Collection<IfcRelCoversBldgElements> hasCoverings;

    protected IfcElement() { initCollections(); }
    /**
     * Constructs IfcElement with all required attributes.
     */
    public IfcElement(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.fillsVoids = new ArrayList<>();
        this.connectedTo = new ArrayList<>();
        this.isInterferedByElements = new ArrayList<>();
        this.interferesElements = new ArrayList<>();
        this.hasProjections = new ArrayList<>();
        this.referencedInStructures = new ArrayList<>();
        this.hasOpenings = new ArrayList<>();
        this.isConnectionRealization = new ArrayList<>();
        this.providesBoundaries = new ArrayList<>();
        this.connectedFrom = new ArrayList<>();
        this.containedInStructure = new ArrayList<>();
        this.hasCoverings = new ArrayList<>();
    }
    /**
     * Constructs IfcElement with required and optional attributes.
     */
    public IfcElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.fillsVoids = new ArrayList<>();
        this.connectedTo = new ArrayList<>();
        this.isInterferedByElements = new ArrayList<>();
        this.interferesElements = new ArrayList<>();
        this.hasProjections = new ArrayList<>();
        this.referencedInStructures = new ArrayList<>();
        this.hasOpenings = new ArrayList<>();
        this.isConnectionRealization = new ArrayList<>();
        this.providesBoundaries = new ArrayList<>();
        this.connectedFrom = new ArrayList<>();
        this.containedInStructure = new ArrayList<>();
        this.hasCoverings = new ArrayList<>();
        this.tag = tag;
    }
    private void initCollections() {
        this.fillsVoids = new ArrayList<>();
        this.connectedTo = new ArrayList<>();
        this.isInterferedByElements = new ArrayList<>();
        this.interferesElements = new ArrayList<>();
        this.hasProjections = new ArrayList<>();
        this.referencedInStructures = new ArrayList<>();
        this.hasOpenings = new ArrayList<>();
        this.isConnectionRealization = new ArrayList<>();
        this.providesBoundaries = new ArrayList<>();
        this.connectedFrom = new ArrayList<>();
        this.containedInStructure = new ArrayList<>();
        this.hasCoverings = new ArrayList<>();
    }
    public IfcIdentifier getTag() { return this.tag; }
    public void setTag(IfcIdentifier value) { this.tag = value; } // optional
    public Collection<IfcRelFillsElement> getFillsVoids() { return this.fillsVoids; }
    public void setFillsVoids(Collection<IfcRelFillsElement> value) { this.fillsVoids = value; } // inverse
    public Collection<IfcRelConnectsElements> getConnectedTo() { return this.connectedTo; }
    public void setConnectedTo(Collection<IfcRelConnectsElements> value) { this.connectedTo = value; } // inverse
    public Collection<IfcRelInterferesElements> getIsInterferedByElements() { return this.isInterferedByElements; }
    public void setIsInterferedByElements(Collection<IfcRelInterferesElements> value) { this.isInterferedByElements = value; } // inverse
    public Collection<IfcRelInterferesElements> getInterferesElements() { return this.interferesElements; }
    public void setInterferesElements(Collection<IfcRelInterferesElements> value) { this.interferesElements = value; } // inverse
    public Collection<IfcRelProjectsElement> getHasProjections() { return this.hasProjections; }
    public void setHasProjections(Collection<IfcRelProjectsElement> value) { this.hasProjections = value; } // inverse
    public Collection<IfcRelReferencedInSpatialStructure> getReferencedInStructures() { return this.referencedInStructures; }
    public void setReferencedInStructures(Collection<IfcRelReferencedInSpatialStructure> value) { this.referencedInStructures = value; } // inverse
    public Collection<IfcRelVoidsElement> getHasOpenings() { return this.hasOpenings; }
    public void setHasOpenings(Collection<IfcRelVoidsElement> value) { this.hasOpenings = value; } // inverse
    public Collection<IfcRelConnectsWithRealizingElements> getIsConnectionRealization() { return this.isConnectionRealization; }
    public void setIsConnectionRealization(Collection<IfcRelConnectsWithRealizingElements> value) { this.isConnectionRealization = value; } // inverse
    public Collection<IfcRelSpaceBoundary> getProvidesBoundaries() { return this.providesBoundaries; }
    public void setProvidesBoundaries(Collection<IfcRelSpaceBoundary> value) { this.providesBoundaries = value; } // inverse
    public Collection<IfcRelConnectsElements> getConnectedFrom() { return this.connectedFrom; }
    public void setConnectedFrom(Collection<IfcRelConnectsElements> value) { this.connectedFrom = value; } // inverse
    public Collection<IfcRelContainedInSpatialStructure> getContainedInStructure() { return this.containedInStructure; }
    public void setContainedInStructure(Collection<IfcRelContainedInSpatialStructure> value) { this.containedInStructure = value; } // inverse
    public Collection<IfcRelCoversBldgElements> getHasCoverings() { return this.hasCoverings; }
    public void setHasCoverings(Collection<IfcRelCoversBldgElements> value) { this.hasCoverings = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}