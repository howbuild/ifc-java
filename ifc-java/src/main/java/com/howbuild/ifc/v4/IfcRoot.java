package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcObjectDefinition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcContext
 * ,IfcObject
 * ,IfcTypeObject))
 * SUBTYPE OF (IfcRoot);
 * INVERSE
 * HasAssignments : SET [0:?] OF IfcRelAssigns FOR RelatedObjects;
 * Nests : SET [0:1] OF IfcRelNests FOR RelatedObjects;
 * IsNestedBy : SET [0:?] OF IfcRelNests FOR RelatingObject;
 * HasContext : SET [0:1] OF IfcRelDeclares FOR RelatedDefinitions;
 * IsDecomposedBy : SET [0:?] OF IfcRelAggregates FOR RelatingObject;
 * Decomposes : SET [0:1] OF IfcRelAggregates FOR RelatedObjects;
 * HasAssociations : SET [0:?] OF IfcRelAssociates FOR RelatedObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcroot.htm">IfcRoot</a>
 */
public abstract class IfcRoot extends BaseIfc {
    protected IfcGloballyUniqueId globalId;
    protected IfcOwnerHistory ownerHistory;
    protected IfcLabel name;
    protected IfcText description;

    protected IfcRoot() { initCollections(); }
    /**
     * Constructs IfcRoot with all required attributes.
     */
    public IfcRoot(IfcGloballyUniqueId globalId) {

        super();
        this.globalId = globalId;
    }
    /**
     * Constructs IfcRoot with required and optional attributes.
     */
    public IfcRoot(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super();
        this.globalId = globalId;
        this.ownerHistory = ownerHistory;
        this.name = name;
        this.description = description;
    }
    private void initCollections() {
    }
    public IfcGloballyUniqueId getGlobalId() { return this.globalId; }
    public void setGlobalId(IfcGloballyUniqueId value) { this.globalId = value; }
    public IfcOwnerHistory getOwnerHistory() { return this.ownerHistory; }
    public void setOwnerHistory(IfcOwnerHistory value) { this.ownerHistory = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}