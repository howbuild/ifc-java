package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCsgSolid
 * SUBTYPE OF (IfcSolidModel);
 * TreeRootExpression : IfcCsgSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsolidmodel.htm">IfcSolidModel</a>
 */
public abstract class IfcSolidModel extends IfcGeometricRepresentationItem implements IfcBooleanOperand, IfcSolidOrShell {


    /**
     * Constructs IfcSolidModel with all required attributes.
     */
    public IfcSolidModel() {
        super();
        initCollections();
    }
    private void initCollections() {
    }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}