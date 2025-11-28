package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcProductDefinitionShape
 * SUBTYPE OF (IfcProductRepresentation);
 * INVERSE
 * ShapeOfProduct : SET [1:?] OF IfcProduct FOR Representation;
 * HasShapeAspects : SET [0:?] OF IfcShapeAspect FOR PartOfProductDefinitionShape;
 * WHERE
 * OnlyShapeModel : SIZEOF(QUERY(temp <* Representations |
 * (NOT('IFC4.IFCSHAPEMODEL' IN TYPEOF(temp)))
 * )) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproductdefinitionshape.htm">IfcProductDefinitionShape</a>
 */
public class IfcProductDefinitionShape extends IfcProductRepresentation implements IfcProductRepresentationSelect {
    protected Collection<IfcProduct> shapeOfProduct;
    protected Collection<IfcShapeAspect> hasShapeAspects;

    protected IfcProductDefinitionShape() { initCollections(); }
    /**
     * Constructs IfcProductDefinitionShape with all required attributes.
     */
    public IfcProductDefinitionShape(Collection<IfcRepresentation> representations) {

        super(representations);
        this.shapeOfProduct = new ArrayList<>();
        this.hasShapeAspects = new ArrayList<>();
    }
    /**
     * Constructs IfcProductDefinitionShape with required and optional attributes.
     */
    public IfcProductDefinitionShape(IfcLabel name,IfcText description,Collection<IfcRepresentation> representations) {
        super(name,description,representations);
        this.shapeOfProduct = new ArrayList<>();
        this.hasShapeAspects = new ArrayList<>();
    }
    private void initCollections() {
        this.shapeOfProduct = new ArrayList<>();
        this.hasShapeAspects = new ArrayList<>();
    }
    public Collection<IfcProduct> getShapeOfProduct() { return this.shapeOfProduct; }
    public void setShapeOfProduct(Collection<IfcProduct> value) { this.shapeOfProduct = value; } // inverse
    public Collection<IfcShapeAspect> getHasShapeAspects() { return this.hasShapeAspects; }
    public void setHasShapeAspects(Collection<IfcShapeAspect> value) { this.hasShapeAspects = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(representations != null ? StepUtils.toStepValue(representations) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}