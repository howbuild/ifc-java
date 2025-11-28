package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundaryCondition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBoundaryEdgeCondition
 * ,IfcBoundaryFaceCondition
 * ,IfcBoundaryNodeCondition));
 * Name : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundarycondition.htm">IfcBoundaryCondition</a>
 */
public abstract class IfcBoundaryCondition extends BaseIfc {
    protected IfcLabel name;


    /**
     * Constructs IfcBoundaryCondition with all required attributes.
     */
    public IfcBoundaryCondition() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcBoundaryCondition with required and optional attributes.
     */
    public IfcBoundaryCondition(IfcLabel name) {
        super();
        this.name = name;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}