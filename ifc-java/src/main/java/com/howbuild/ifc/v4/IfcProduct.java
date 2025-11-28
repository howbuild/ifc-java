package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAnnotation
 * SUBTYPE OF (IfcProduct);
 * INVERSE
 * ContainedInStructure : SET [0:1] OF IfcRelContainedInSpatialStructure FOR RelatedElements;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproduct.htm">IfcProduct</a>
 */
public abstract class IfcProduct extends IfcObject implements IfcProductSelect {
    protected IfcObjectPlacement objectPlacement;
    protected IfcProductRepresentation representation;
    protected Collection<IfcRelAssignsToProduct> referencedBy;

    protected IfcProduct() { initCollections(); }
    /**
     * Constructs IfcProduct with all required attributes.
     */
    public IfcProduct(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.referencedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcProduct with required and optional attributes.
     */
    public IfcProduct(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation) {
        super(globalId,ownerHistory,name,description,objectType);
        this.referencedBy = new ArrayList<>();
        this.objectPlacement = objectPlacement;
        this.representation = representation;
    }
    private void initCollections() {
        this.referencedBy = new ArrayList<>();
    }
    public IfcObjectPlacement getObjectPlacement() { return this.objectPlacement; }
    public void setObjectPlacement(IfcObjectPlacement value) { this.objectPlacement = value; } // optional
    public IfcProductRepresentation getRepresentation() { return this.representation; }
    public void setRepresentation(IfcProductRepresentation value) { this.representation = value; } // optional
    public Collection<IfcRelAssignsToProduct> getReferencedBy() { return this.referencedBy; }
    public void setReferencedBy(Collection<IfcRelAssignsToProduct> value) { this.referencedBy = value; } // inverse


    @Override public void finalizeRelationships() { this.setIfcProductRelationship(); }
    private void setIfcProductRelationship() {
		if (this.objectPlacement != null) {
		    if (this.objectPlacement instanceof IfcObjectPlacement)
		        ((IfcObjectPlacement)this.objectPlacement).placesObject.add(this);
		}
		if (this.representation != null) {
		    if (this.representation instanceof IfcProductDefinitionShape)
		        ((IfcProductDefinitionShape)this.representation).shapeOfProduct.add(this);
		}
    }
}