package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementQuantity
 * SUBTYPE OF (IfcQuantitySet);
 * MethodOfMeasurement : OPTIONAL IfcLabel;
 * Quantities : SET [1:?] OF IfcPhysicalQuantity;
 * WHERE
 * UniqueQuantityNames : IfcUniqueQuantityNames(Quantities);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantityset.htm">IfcQuantitySet</a>
 */
public abstract class IfcQuantitySet extends IfcPropertySetDefinition {

    protected IfcQuantitySet() { initCollections(); }
    /**
     * Constructs IfcQuantitySet with all required attributes.
     */
    public IfcQuantitySet(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcQuantitySet with required and optional attributes.
     */
    public IfcQuantitySet(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}