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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadorresult.htm">IfcStructuralLoadOrResult</a>
 */
public abstract class IfcStructuralLoadOrResult extends IfcStructuralLoad {


    /**
     * Constructs IfcStructuralLoadOrResult with all required attributes.
     */
    public IfcStructuralLoadOrResult() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadOrResult with required and optional attributes.
     */
    public IfcStructuralLoadOrResult(IfcLabel name) {
        super(name);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}