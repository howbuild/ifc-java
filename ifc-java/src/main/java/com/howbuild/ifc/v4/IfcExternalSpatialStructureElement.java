package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExternalSpatialElement
 * SUBTYPE OF (IfcExternalSpatialStructureElement);
 * PredefinedType : OPTIONAL IfcExternalSpatialElementTypeEnum;
 * INVERSE
 * BoundedBy : SET [0:?] OF IfcRelSpaceBoundary FOR RelatingSpace;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcexternalspatialstructureelement.htm">IfcExternalSpatialStructureElement</a>
 */
public abstract class IfcExternalSpatialStructureElement extends IfcSpatialElement {

    protected IfcExternalSpatialStructureElement() { initCollections(); }
    /**
     * Constructs IfcExternalSpatialStructureElement with all required attributes.
     */
    public IfcExternalSpatialStructureElement(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcExternalSpatialStructureElement with required and optional attributes.
     */
    public IfcExternalSpatialStructureElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}