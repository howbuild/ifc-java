package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActor
 * SUPERTYPE OF (ONEOF
 * (IfcOccupant))
 * SUBTYPE OF (IfcObject);
 * TheActor : IfcActorSelect;
 * INVERSE
 * IsActingUpon : SET [0:?] OF IfcRelAssignsToActor FOR RelatingActor;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcobject.htm">IfcObject</a>
 */
public abstract class IfcObject extends IfcObjectDefinition {
    protected IfcLabel objectType;
    protected Collection<IfcRelDefinesByObject> isDeclaredBy;
    protected Collection<IfcRelDefinesByObject> declares;
    protected Collection<IfcRelDefinesByType> isTypedBy;
    protected Collection<IfcRelDefinesByProperties> isDefinedBy;

    protected IfcObject() { initCollections(); }
    /**
     * Constructs IfcObject with all required attributes.
     */
    public IfcObject(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.isDeclaredBy = new ArrayList<>();
        this.declares = new ArrayList<>();
        this.isTypedBy = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcObject with required and optional attributes.
     */
    public IfcObject(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType) {
        super(globalId,ownerHistory,name,description);
        this.isDeclaredBy = new ArrayList<>();
        this.declares = new ArrayList<>();
        this.isTypedBy = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
        this.objectType = objectType;
    }
    private void initCollections() {
        this.isDeclaredBy = new ArrayList<>();
        this.declares = new ArrayList<>();
        this.isTypedBy = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
    }
    public IfcLabel getObjectType() { return this.objectType; }
    public void setObjectType(IfcLabel value) { this.objectType = value; } // optional
    public Collection<IfcRelDefinesByObject> getIsDeclaredBy() { return this.isDeclaredBy; }
    public void setIsDeclaredBy(Collection<IfcRelDefinesByObject> value) { this.isDeclaredBy = value; } // inverse
    public Collection<IfcRelDefinesByObject> getDeclares() { return this.declares; }
    public void setDeclares(Collection<IfcRelDefinesByObject> value) { this.declares = value; } // inverse
    public Collection<IfcRelDefinesByType> getIsTypedBy() { return this.isTypedBy; }
    public void setIsTypedBy(Collection<IfcRelDefinesByType> value) { this.isTypedBy = value; } // inverse
    public Collection<IfcRelDefinesByProperties> getIsDefinedBy() { return this.isDefinedBy; }
    public void setIsDefinedBy(Collection<IfcRelDefinesByProperties> value) { this.isDefinedBy = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}