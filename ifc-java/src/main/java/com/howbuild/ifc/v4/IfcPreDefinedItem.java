package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedColour
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcDraughtingPreDefinedColour))
 * SUBTYPE OF (IfcPreDefinedItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpredefineditem.htm">IfcPreDefinedItem</a>
 */
public abstract class IfcPreDefinedItem extends IfcPresentationItem {
    protected IfcLabel name;

    protected IfcPreDefinedItem() { initCollections(); }
    /**
     * Constructs IfcPreDefinedItem with all required attributes.
     */
    public IfcPreDefinedItem(IfcLabel name) {
        super();
        this.name = name;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }


    // inherits no-op finalizeRelationships from BaseIfc

}