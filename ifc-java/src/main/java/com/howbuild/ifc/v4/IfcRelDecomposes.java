package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAggregates
 * SUBTYPE OF (IfcRelDecomposes);
 * RelatingObject : IfcObjectDefinition;
 * RelatedObjects : SET [1:?] OF IfcObjectDefinition;
 * WHERE
 * NoSelfReference : SIZEOF(QUERY(Temp <* RelatedObjects | RelatingObject :=: Temp)) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldecomposes.htm">IfcRelDecomposes</a>
 */
public abstract class IfcRelDecomposes extends IfcRelationship {

    protected IfcRelDecomposes() { initCollections(); }
    /**
     * Constructs IfcRelDecomposes with all required attributes.
     */
    public IfcRelDecomposes(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcRelDecomposes with required and optional attributes.
     */
    public IfcRelDecomposes(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}