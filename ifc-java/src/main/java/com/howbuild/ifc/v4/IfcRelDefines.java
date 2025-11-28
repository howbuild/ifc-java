package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelDefines
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelDefinesByObject
 * ,IfcRelDefinesByProperties
 * ,IfcRelDefinesByTemplate
 * ,IfcRelDefinesByType))
 * SUBTYPE OF (IfcRelationship);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldefines.htm">IfcRelDefines</a>
 */
public abstract class IfcRelDefines extends IfcRelationship {

    protected IfcRelDefines() { initCollections(); }
    /**
     * Constructs IfcRelDefines with all required attributes.
     */
    public IfcRelDefines(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcRelDefines with required and optional attributes.
     */
    public IfcRelDefines(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}