package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedProperties
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcementBarProperties
 * ,IfcSectionProperties
 * ,IfcSectionReinforcementProperties))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpredefinedproperties.htm">IfcPreDefinedProperties</a>
 */
public abstract class IfcPreDefinedProperties extends IfcPropertyAbstraction {


    /**
     * Constructs IfcPreDefinedProperties with all required attributes.
     */
    public IfcPreDefinedProperties() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}