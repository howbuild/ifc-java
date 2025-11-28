package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionResource
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConstructionEquipmentResource
 * ,IfcConstructionMaterialResource
 * ,IfcConstructionProductResource
 * ,IfcCrewResource
 * ,IfcLaborResource
 * ,IfcSubContractResource))
 * SUBTYPE OF (IfcResource);
 * Usage : OPTIONAL IfcResourceTime;
 * BaseCosts : OPTIONAL LIST [1:?] OF IfcAppliedValue;
 * BaseQuantity : OPTIONAL IfcPhysicalQuantity;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcresource.htm">IfcResource</a>
 */
public abstract class IfcResource extends IfcObject implements IfcResourceSelect {
    protected IfcIdentifier identification;
    protected IfcText longDescription;
    protected Collection<IfcRelAssignsToResource> resourceOf;

    protected IfcResource() { initCollections(); }
    /**
     * Constructs IfcResource with all required attributes.
     */
    public IfcResource(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.resourceOf = new ArrayList<>();
    }
    /**
     * Constructs IfcResource with required and optional attributes.
     */
    public IfcResource(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription) {
        super(globalId,ownerHistory,name,description,objectType);
        this.resourceOf = new ArrayList<>();
        this.identification = identification;
        this.longDescription = longDescription;
    }
    private void initCollections() {
        this.resourceOf = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcText getLongDescription() { return this.longDescription; }
    public void setLongDescription(IfcText value) { this.longDescription = value; } // optional
    public Collection<IfcRelAssignsToResource> getResourceOf() { return this.resourceOf; }
    public void setResourceOf(Collection<IfcRelAssignsToResource> value) { this.resourceOf = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}