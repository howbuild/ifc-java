package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedPropertySet
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcDoorLiningProperties
 * ,IfcDoorPanelProperties
 * ,IfcPermeableCoveringProperties
 * ,IfcReinforcementDefinitionProperties
 * ,IfcWindowLiningProperties
 * ,IfcWindowPanelProperties))
 * SUBTYPE OF (IfcPropertySetDefinition);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertysetdefinition.htm">IfcPropertySetDefinition</a>
 */
public abstract class IfcPropertySetDefinition extends IfcPropertyDefinition implements IfcPropertySetDefinitionSelect {
    protected Collection<IfcTypeObject> definesType;
    protected Collection<IfcRelDefinesByTemplate> isDefinedBy;
    protected Collection<IfcRelDefinesByProperties> definesOccurrence;

    protected IfcPropertySetDefinition() { initCollections(); }
    /**
     * Constructs IfcPropertySetDefinition with all required attributes.
     */
    public IfcPropertySetDefinition(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.definesType = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
        this.definesOccurrence = new ArrayList<>();
    }
    /**
     * Constructs IfcPropertySetDefinition with required and optional attributes.
     */
    public IfcPropertySetDefinition(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
        this.definesType = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
        this.definesOccurrence = new ArrayList<>();
    }
    private void initCollections() {
        this.definesType = new ArrayList<>();
        this.isDefinedBy = new ArrayList<>();
        this.definesOccurrence = new ArrayList<>();
    }
    public Collection<IfcTypeObject> getDefinesType() { return this.definesType; }
    public void setDefinesType(Collection<IfcTypeObject> value) { this.definesType = value; } // inverse
    public Collection<IfcRelDefinesByTemplate> getIsDefinedBy() { return this.isDefinedBy; }
    public void setIsDefinedBy(Collection<IfcRelDefinesByTemplate> value) { this.isDefinedBy = value; } // inverse
    public Collection<IfcRelDefinesByProperties> getDefinesOccurrence() { return this.definesOccurrence; }
    public void setDefinesOccurrence(Collection<IfcRelDefinesByProperties> value) { this.definesOccurrence = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}