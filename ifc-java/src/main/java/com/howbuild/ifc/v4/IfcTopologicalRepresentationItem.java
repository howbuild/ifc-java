package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConnectedFaceSet
 * SUPERTYPE OF (ONEOF
 * (IfcClosedShell
 * ,IfcOpenShell))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * CfsFaces : SET [1:?] OF IfcFace;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctopologicalrepresentationitem.htm">IfcTopologicalRepresentationItem</a>
 */
public abstract class IfcTopologicalRepresentationItem extends IfcRepresentationItem {


    /**
     * Constructs IfcTopologicalRepresentationItem with all required attributes.
     */
    public IfcTopologicalRepresentationItem() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}