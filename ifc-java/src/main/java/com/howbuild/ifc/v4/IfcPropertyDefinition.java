package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyDefinition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcPropertySetDefinition
 * ,IfcPropertyTemplateDefinition))
 * SUBTYPE OF (IfcRoot);
 * INVERSE
 * HasContext : SET [0:1] OF IfcRelDeclares FOR RelatedDefinitions;
 * HasAssociations : SET [0:?] OF IfcRelAssociates FOR RelatedObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertydefinition.htm">IfcPropertyDefinition</a>
 */
public abstract class IfcPropertyDefinition extends IfcRoot implements IfcDefinitionSelect {
    protected Collection<IfcRelDeclares> hasContext;
    protected Collection<IfcRelAssociates> hasAssociations;

    protected IfcPropertyDefinition() { initCollections(); }
    /**
     * Constructs IfcPropertyDefinition with all required attributes.
     */
    public IfcPropertyDefinition(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasContext = new ArrayList<>();
        this.hasAssociations = new ArrayList<>();
    }
    /**
     * Constructs IfcPropertyDefinition with required and optional attributes.
     */
    public IfcPropertyDefinition(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
        this.hasContext = new ArrayList<>();
        this.hasAssociations = new ArrayList<>();
    }
    private void initCollections() {
        this.hasContext = new ArrayList<>();
        this.hasAssociations = new ArrayList<>();
    }
    public Collection<IfcRelDeclares> getHasContext() { return this.hasContext; }
    public void setHasContext(Collection<IfcRelDeclares> value) { this.hasContext = value; } // inverse
    public Collection<IfcRelAssociates> getHasAssociations() { return this.hasAssociations; }
    public void setHasAssociations(Collection<IfcRelAssociates> value) { this.hasAssociations = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}