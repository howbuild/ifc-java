package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSpatialElementType
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcSpatialStructureElementType
 * ,IfcSpatialZoneType))
 * SUBTYPE OF (IfcTypeProduct);
 * ElementType : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcspatialelementtype.htm">IfcSpatialElementType</a>
 */
public abstract class IfcSpatialElementType extends IfcTypeProduct {
    protected IfcLabel elementType;

    protected IfcSpatialElementType() { initCollections(); }
    /**
     * Constructs IfcSpatialElementType with all required attributes.
     */
    public IfcSpatialElementType(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSpatialElementType with required and optional attributes.
     */
    public IfcSpatialElementType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcLabel elementType) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag);
        this.elementType = elementType;
    }
    private void initCollections() {
    }
    public IfcLabel getElementType() { return this.elementType; }
    public void setElementType(IfcLabel value) { this.elementType = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}