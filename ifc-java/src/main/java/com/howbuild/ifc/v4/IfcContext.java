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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccontext.htm">IfcContext</a>
 */
public abstract class IfcContext extends IfcObjectDefinition {
    protected IfcLabel objectType;
    protected IfcLabel longName;
    protected IfcLabel phase;
    protected Collection<IfcRepresentationContext> representationContexts;
    protected IfcUnitAssignment unitsInContext;
    protected Collection<IfcRelDefinesByProperties> isDefinedBy;
    protected Collection<IfcRelDeclares> declares;

    protected IfcContext() { initCollections(); }
    /**
     * Constructs IfcContext with all required attributes.
     */
    public IfcContext(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.representationContexts = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
        this.declares = new ArrayList<>();
    }
    /**
     * Constructs IfcContext with required and optional attributes.
     */
    public IfcContext(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcLabel longName,IfcLabel phase,Collection<IfcRepresentationContext> representationContexts,IfcUnitAssignment unitsInContext) {
        super(globalId,ownerHistory,name,description);
        this.isDefinedBy = new ArrayList<>();
        this.declares = new ArrayList<>();
        this.objectType = objectType;
        this.longName = longName;
        this.phase = phase;
        this.representationContexts = representationContexts;
        this.unitsInContext = unitsInContext;
    }
    private void initCollections() {
        this.representationContexts = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
        this.declares = new ArrayList<>();
    }
    public IfcLabel getObjectType() { return this.objectType; }
    public void setObjectType(IfcLabel value) { this.objectType = value; } // optional
    public IfcLabel getLongName() { return this.longName; }
    public void setLongName(IfcLabel value) { this.longName = value; } // optional
    public IfcLabel getPhase() { return this.phase; }
    public void setPhase(IfcLabel value) { this.phase = value; } // optional
    public Collection<IfcRepresentationContext> getRepresentationContexts() { return this.representationContexts; }
    public void setRepresentationContexts(Collection<IfcRepresentationContext> value) { this.representationContexts = value; } // optional
    public IfcUnitAssignment getUnitsInContext() { return this.unitsInContext; }
    public void setUnitsInContext(IfcUnitAssignment value) { this.unitsInContext = value; } // optional
    public Collection<IfcRelDefinesByProperties> getIsDefinedBy() { return this.isDefinedBy; }
    public void setIsDefinedBy(Collection<IfcRelDefinesByProperties> value) { this.isDefinedBy = value; } // inverse
    public Collection<IfcRelDeclares> getDeclares() { return this.declares; }
    public void setDeclares(Collection<IfcRelDeclares> value) { this.declares = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}