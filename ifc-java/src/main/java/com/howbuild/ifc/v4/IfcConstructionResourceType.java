package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConstructionEquipmentResourceType
 * SUBTYPE OF (IfcConstructionResourceType);
 * PredefinedType : IfcConstructionEquipmentResourceTypeEnum;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcConstructionEquipmentResourceTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcConstructionEquipmentResourceTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcTypeResource.ResourceType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconstructionresourcetype.htm">IfcConstructionResourceType</a>
 */
public abstract class IfcConstructionResourceType extends IfcTypeResource {
    protected Collection<IfcAppliedValue> baseCosts;
    protected IfcPhysicalQuantity baseQuantity;

    protected IfcConstructionResourceType() { initCollections(); }
    /**
     * Constructs IfcConstructionResourceType with all required attributes.
     */
    public IfcConstructionResourceType(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.baseCosts = new ArrayList<>();
    }
    /**
     * Constructs IfcConstructionResourceType with required and optional attributes.
     */
    public IfcConstructionResourceType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel resourceType,Collection<IfcAppliedValue> baseCosts,IfcPhysicalQuantity baseQuantity) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,identification,longDescription,resourceType);
        this.baseCosts = baseCosts;
        this.baseQuantity = baseQuantity;
    }
    private void initCollections() {
        this.baseCosts = new ArrayList<>();
    }
    public Collection<IfcAppliedValue> getBaseCosts() { return this.baseCosts; }
    public void setBaseCosts(Collection<IfcAppliedValue> value) { this.baseCosts = value; } // optional
    public IfcPhysicalQuantity getBaseQuantity() { return this.baseQuantity; }
    public void setBaseQuantity(IfcPhysicalQuantity value) { this.baseQuantity = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}