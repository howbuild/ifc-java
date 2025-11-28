package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPhysicalQuantity
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcPhysicalComplexQuantity
 * ,IfcPhysicalSimpleQuantity));
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * INVERSE
 * HasExternalReferences : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * PartOfComplex : SET [0:1] OF IfcPhysicalComplexQuantity FOR HasQuantities;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcphysicalsimplequantity.htm">IfcPhysicalSimpleQuantity</a>
 */
public abstract class IfcPhysicalSimpleQuantity extends IfcPhysicalQuantity {
    protected IfcNamedUnit unit;

    protected IfcPhysicalSimpleQuantity() { initCollections(); }
    /**
     * Constructs IfcPhysicalSimpleQuantity with all required attributes.
     */
    public IfcPhysicalSimpleQuantity(IfcLabel name) {

        super(name);
    }
    /**
     * Constructs IfcPhysicalSimpleQuantity with required and optional attributes.
     */
    public IfcPhysicalSimpleQuantity(IfcLabel name,IfcText description,IfcNamedUnit unit) {
        super(name,description);
        this.unit = unit;
    }
    private void initCollections() {
    }
    public IfcNamedUnit getUnit() { return this.unit; }
    public void setUnit(IfcNamedUnit value) { this.unit = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}