package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadLinearForce
 * SUBTYPE OF (IfcStructuralLoadStatic);
 * LinearForceX : OPTIONAL IfcLinearForceMeasure;
 * LinearForceY : OPTIONAL IfcLinearForceMeasure;
 * LinearForceZ : OPTIONAL IfcLinearForceMeasure;
 * LinearMomentX : OPTIONAL IfcLinearMomentMeasure;
 * LinearMomentY : OPTIONAL IfcLinearMomentMeasure;
 * LinearMomentZ : OPTIONAL IfcLinearMomentMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadstatic.htm">IfcStructuralLoadStatic</a>
 */
public abstract class IfcStructuralLoadStatic extends IfcStructuralLoadOrResult {


    /**
     * Constructs IfcStructuralLoadStatic with all required attributes.
     */
    public IfcStructuralLoadStatic() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadStatic with required and optional attributes.
     */
    public IfcStructuralLoadStatic(IfcLabel name) {
        super(name);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}