package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoad
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralLoadConfiguration
 * ,IfcStructuralLoadOrResult));
 * Name : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralload.htm">IfcStructuralLoad</a>
 */
public abstract class IfcStructuralLoad extends BaseIfc {
    protected IfcLabel name;


    /**
     * Constructs IfcStructuralLoad with all required attributes.
     */
    public IfcStructuralLoad() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoad with required and optional attributes.
     */
    public IfcStructuralLoad(IfcLabel name) {
        super();
        this.name = name;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}