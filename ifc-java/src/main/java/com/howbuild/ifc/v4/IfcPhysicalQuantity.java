package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPhysicalComplexQuantity
 * SUBTYPE OF (IfcPhysicalQuantity);
 * HasQuantities : SET [1:?] OF IfcPhysicalQuantity;
 * Discrimination : IfcLabel;
 * Quality : OPTIONAL IfcLabel;
 * Usage : OPTIONAL IfcLabel;
 * WHERE
 * NoSelfReference : SIZEOF(QUERY(temp <* HasQuantities | SELF :=: temp)) = 0;
 * UniqueQuantityNames : IfcUniqueQuantityNames(HasQuantities);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcphysicalquantity.htm">IfcPhysicalQuantity</a>
 */
public abstract class IfcPhysicalQuantity extends BaseIfc implements IfcResourceObjectSelect {
    protected IfcLabel name;
    protected IfcText description;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReferences;
    protected Collection<IfcPhysicalComplexQuantity> partOfComplex;

    protected IfcPhysicalQuantity() { initCollections(); }
    /**
     * Constructs IfcPhysicalQuantity with all required attributes.
     */
    public IfcPhysicalQuantity(IfcLabel name) {

        super();
        this.hasExternalReferences = new ArrayList<>();
        this.partOfComplex = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcPhysicalQuantity with required and optional attributes.
     */
    public IfcPhysicalQuantity(IfcLabel name,IfcText description) {
        super();
        this.hasExternalReferences = new ArrayList<>();
        this.partOfComplex = new ArrayList<>();
        this.name = name;
        this.description = description;
    }
    private void initCollections() {
        this.hasExternalReferences = new ArrayList<>();
        this.partOfComplex = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReferences() { return this.hasExternalReferences; }
    public void setHasExternalReferences(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReferences = value; } // inverse
    public Collection<IfcPhysicalComplexQuantity> getPartOfComplex() { return this.partOfComplex; }
    public void setPartOfComplex(Collection<IfcPhysicalComplexQuantity> value) { this.partOfComplex = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}