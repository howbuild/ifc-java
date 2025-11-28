package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionEquipmentResource
 * SUBTYPE OF (IfcConstructionResource);
 * PredefinedType : OPTIONAL IfcConstructionEquipmentResourceTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcConstructionEquipmentResourceTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcConstructionEquipmentResourceTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconstructionresource.htm">IfcConstructionResource</a>
 */
public abstract class IfcConstructionResource extends IfcResource {
    protected IfcResourceTime usage;
    protected Collection<IfcAppliedValue> baseCosts;
    protected IfcPhysicalQuantity baseQuantity;

    protected IfcConstructionResource() { initCollections(); }
    /**
     * Constructs IfcConstructionResource with all required attributes.
     */
    public IfcConstructionResource(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.baseCosts = new ArrayList<>();
    }
    /**
     * Constructs IfcConstructionResource with required and optional attributes.
     */
    public IfcConstructionResource(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription,IfcResourceTime usage,Collection<IfcAppliedValue> baseCosts,IfcPhysicalQuantity baseQuantity) {
        super(globalId,ownerHistory,name,description,objectType,identification,longDescription);
        this.usage = usage;
        this.baseCosts = baseCosts;
        this.baseQuantity = baseQuantity;
    }
    private void initCollections() {
        this.baseCosts = new ArrayList<>();
    }
    public IfcResourceTime getUsage() { return this.usage; }
    public void setUsage(IfcResourceTime value) { this.usage = value; } // optional
    public Collection<IfcAppliedValue> getBaseCosts() { return this.baseCosts; }
    public void setBaseCosts(Collection<IfcAppliedValue> value) { this.baseCosts = value; } // optional
    public IfcPhysicalQuantity getBaseQuantity() { return this.baseQuantity; }
    public void setBaseQuantity(IfcPhysicalQuantity value) { this.baseQuantity = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}