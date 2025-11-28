package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcContextDependentUnit
 * SUBTYPE OF (IfcNamedUnit);
 * Name : IfcLabel;
 * INVERSE
 * HasExternalReference : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcnamedunit.htm">IfcNamedUnit</a>
 */
public abstract class IfcNamedUnit extends BaseIfc implements IfcUnit {
    protected IfcDimensionalExponents dimensions;
    protected IfcUnitEnum unitType;

    protected IfcNamedUnit() { initCollections(); }
    /**
     * Constructs IfcNamedUnit with all required attributes.
     */
    public IfcNamedUnit(IfcDimensionalExponents dimensions,IfcUnitEnum unitType) {
        super();
        this.dimensions = dimensions;
        this.unitType = unitType;
    }
    private void initCollections() {
    }
    public IfcDimensionalExponents getDimensions() { return this.dimensions; }
    public void setDimensions(IfcDimensionalExponents value) { this.dimensions = value; }
    public IfcUnitEnum getUnitType() { return this.unitType; }
    public void setUnitType(IfcUnitEnum value) { this.unitType = value; }


    // inherits no-op finalizeRelationships from BaseIfc

}