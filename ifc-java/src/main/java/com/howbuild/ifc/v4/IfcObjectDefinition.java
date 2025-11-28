package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcContext
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcProject
 * ,IfcProjectLibrary))
 * SUBTYPE OF (IfcObjectDefinition);
 * ObjectType : OPTIONAL IfcLabel;
 * LongName : OPTIONAL IfcLabel;
 * Phase : OPTIONAL IfcLabel;
 * RepresentationContexts : OPTIONAL SET [1:?] OF IfcRepresentationContext;
 * UnitsInContext : OPTIONAL IfcUnitAssignment;
 * INVERSE
 * IsDefinedBy : SET [0:?] OF IfcRelDefinesByProperties FOR RelatedObjects;
 * Declares : SET [0:?] OF IfcRelDeclares FOR RelatingContext;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcobjectdefinition.htm">IfcObjectDefinition</a>
 */
public abstract class IfcObjectDefinition extends IfcRoot implements IfcDefinitionSelect {
    protected Collection<IfcRelAssigns> hasAssignments;
    protected Collection<IfcRelNests> nests;
    protected Collection<IfcRelNests> isNestedBy;
    protected Collection<IfcRelDeclares> hasContext;
    protected Collection<IfcRelAggregates> isDecomposedBy;
    protected Collection<IfcRelAggregates> decomposes;
    protected Collection<IfcRelAssociates> hasAssociations;

    protected IfcObjectDefinition() { initCollections(); }
    /**
     * Constructs IfcObjectDefinition with all required attributes.
     */
    public IfcObjectDefinition(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasAssignments = new ArrayList<>();
        this.nests = new ArrayList<>();
        this.isNestedBy = new ArrayList<>();
        this.hasContext = new ArrayList<>();
        this.isDecomposedBy = new ArrayList<>();
        this.decomposes = new ArrayList<>();
        this.hasAssociations = new ArrayList<>();
    }
    /**
     * Constructs IfcObjectDefinition with required and optional attributes.
     */
    public IfcObjectDefinition(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
        this.hasAssignments = new ArrayList<>();
        this.nests = new ArrayList<>();
        this.isNestedBy = new ArrayList<>();
        this.hasContext = new ArrayList<>();
        this.isDecomposedBy = new ArrayList<>();
        this.decomposes = new ArrayList<>();
        this.hasAssociations = new ArrayList<>();
    }
    private void initCollections() {
        this.hasAssignments = new ArrayList<>();
        this.nests = new ArrayList<>();
        this.isNestedBy = new ArrayList<>();
        this.hasContext = new ArrayList<>();
        this.isDecomposedBy = new ArrayList<>();
        this.decomposes = new ArrayList<>();
        this.hasAssociations = new ArrayList<>();
    }
    public Collection<IfcRelAssigns> getHasAssignments() { return this.hasAssignments; }
    public void setHasAssignments(Collection<IfcRelAssigns> value) { this.hasAssignments = value; } // inverse
    public Collection<IfcRelNests> getNests() { return this.nests; }
    public void setNests(Collection<IfcRelNests> value) { this.nests = value; } // inverse
    public Collection<IfcRelNests> getIsNestedBy() { return this.isNestedBy; }
    public void setIsNestedBy(Collection<IfcRelNests> value) { this.isNestedBy = value; } // inverse
    public Collection<IfcRelDeclares> getHasContext() { return this.hasContext; }
    public void setHasContext(Collection<IfcRelDeclares> value) { this.hasContext = value; } // inverse
    public Collection<IfcRelAggregates> getIsDecomposedBy() { return this.isDecomposedBy; }
    public void setIsDecomposedBy(Collection<IfcRelAggregates> value) { this.isDecomposedBy = value; } // inverse
    public Collection<IfcRelAggregates> getDecomposes() { return this.decomposes; }
    public void setDecomposes(Collection<IfcRelAggregates> value) { this.decomposes = value; } // inverse
    public Collection<IfcRelAssociates> getHasAssociations() { return this.hasAssociations; }
    public void setHasAssociations(Collection<IfcRelAssociates> value) { this.hasAssociations = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}