package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExternalSpatialStructureElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcExternalSpatialElement))
 * SUBTYPE OF (IfcSpatialElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspatialelement.htm">IfcSpatialElement</a>
 */
public abstract class IfcSpatialElement extends IfcProduct {
    protected IfcLabel longName;
    protected Collection<IfcRelContainedInSpatialStructure> containsElements;
    protected Collection<IfcRelServicesBuildings> servicedBySystems;
    protected Collection<IfcRelReferencedInSpatialStructure> referencesElements;

    protected IfcSpatialElement() { initCollections(); }
    /**
     * Constructs IfcSpatialElement with all required attributes.
     */
    public IfcSpatialElement(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.containsElements = new ArrayList<>();
        this.servicedBySystems = new ArrayList<>();
        this.referencesElements = new ArrayList<>();
    }
    /**
     * Constructs IfcSpatialElement with required and optional attributes.
     */
    public IfcSpatialElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.containsElements = new ArrayList<>();
        this.servicedBySystems = new ArrayList<>();
        this.referencesElements = new ArrayList<>();
        this.longName = longName;
    }
    private void initCollections() {
        this.containsElements = new ArrayList<>();
        this.servicedBySystems = new ArrayList<>();
        this.referencesElements = new ArrayList<>();
    }
    public IfcLabel getLongName() { return this.longName; }
    public void setLongName(IfcLabel value) { this.longName = value; } // optional
    public Collection<IfcRelContainedInSpatialStructure> getContainsElements() { return this.containsElements; }
    public void setContainsElements(Collection<IfcRelContainedInSpatialStructure> value) { this.containsElements = value; } // inverse
    public Collection<IfcRelServicesBuildings> getServicedBySystems() { return this.servicedBySystems; }
    public void setServicedBySystems(Collection<IfcRelServicesBuildings> value) { this.servicedBySystems = value; } // inverse
    public Collection<IfcRelReferencedInSpatialStructure> getReferencesElements() { return this.referencesElements; }
    public void setReferencesElements(Collection<IfcRelReferencedInSpatialStructure> value) { this.referencesElements = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}