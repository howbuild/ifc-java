package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionResourceType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConstructionEquipmentResourceType
 * ,IfcConstructionMaterialResourceType
 * ,IfcConstructionProductResourceType
 * ,IfcCrewResourceType
 * ,IfcLaborResourceType
 * ,IfcSubContractResourceType))
 * SUBTYPE OF (IfcTypeResource);
 * BaseCosts : OPTIONAL LIST [1:?] OF IfcAppliedValue;
 * BaseQuantity : OPTIONAL IfcPhysicalQuantity;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctyperesource.htm">IfcTypeResource</a>
 */
public abstract class IfcTypeResource extends IfcTypeObject implements IfcResourceSelect {
    protected IfcIdentifier identification;
    protected IfcText longDescription;
    protected IfcLabel resourceType;
    protected Collection<IfcRelAssignsToResource> resourceOf;

    protected IfcTypeResource() { initCollections(); }
    /**
     * Constructs IfcTypeResource with all required attributes.
     */
    public IfcTypeResource(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.resourceOf = new ArrayList<>();
    }
    /**
     * Constructs IfcTypeResource with required and optional attributes.
     */
    public IfcTypeResource(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel resourceType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets);
        this.resourceOf = new ArrayList<>();
        this.identification = identification;
        this.longDescription = longDescription;
        this.resourceType = resourceType;
    }
    private void initCollections() {
        this.resourceOf = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcText getLongDescription() { return this.longDescription; }
    public void setLongDescription(IfcText value) { this.longDescription = value; } // optional
    public IfcLabel getResourceType() { return this.resourceType; }
    public void setResourceType(IfcLabel value) { this.resourceType = value; } // optional
    public Collection<IfcRelAssignsToResource> getResourceOf() { return this.resourceOf; }
    public void setResourceOf(Collection<IfcRelAssignsToResource> value) { this.resourceOf = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}