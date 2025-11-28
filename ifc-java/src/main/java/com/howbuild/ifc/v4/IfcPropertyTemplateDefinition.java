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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertytemplatedefinition.htm">IfcPropertyTemplateDefinition</a>
 */
public abstract class IfcPropertyTemplateDefinition extends IfcPropertyDefinition {

    protected IfcPropertyTemplateDefinition() { initCollections(); }
    /**
     * Constructs IfcPropertyTemplateDefinition with all required attributes.
     */
    public IfcPropertyTemplateDefinition(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcPropertyTemplateDefinition with required and optional attributes.
     */
    public IfcPropertyTemplateDefinition(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}