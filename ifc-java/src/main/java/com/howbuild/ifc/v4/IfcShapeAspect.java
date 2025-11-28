package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcShapeAspect;
 * ShapeRepresentations : LIST [1:?] OF IfcShapeModel;
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * ProductDefinitional : IfcLogical;
 * PartOfProductDefinitionShape : OPTIONAL IfcProductRepresentationSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcshapeaspect.htm">IfcShapeAspect</a>
 */
public class IfcShapeAspect extends BaseIfc {
    protected Collection<IfcShapeModel> shapeRepresentations;
    protected IfcLabel name;
    protected IfcText description;
    protected IfcLogical productDefinitional;
    protected IfcProductRepresentationSelect partOfProductDefinitionShape;

    protected IfcShapeAspect() { initCollections(); }
    /**
     * Constructs IfcShapeAspect with all required attributes.
     */
    public IfcShapeAspect(Collection<IfcShapeModel> shapeRepresentations,IfcLogical productDefinitional) {

        super();
        this.shapeRepresentations = shapeRepresentations;
        this.productDefinitional = productDefinitional;
    }
    /**
     * Constructs IfcShapeAspect with required and optional attributes.
     */
    public IfcShapeAspect(Collection<IfcShapeModel> shapeRepresentations,IfcLabel name,IfcText description,IfcLogical productDefinitional,IfcProductRepresentationSelect partOfProductDefinitionShape) {
        super();
        this.shapeRepresentations = shapeRepresentations;
        this.name = name;
        this.description = description;
        this.productDefinitional = productDefinitional;
        this.partOfProductDefinitionShape = partOfProductDefinitionShape;
    }
    private void initCollections() {
        this.shapeRepresentations = new ArrayList<>();
    }
    public Collection<IfcShapeModel> getShapeRepresentations() { return this.shapeRepresentations; }
    public void setShapeRepresentations(Collection<IfcShapeModel> value) { this.shapeRepresentations = value; }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcLogical getProductDefinitional() { return this.productDefinitional; }
    public void setProductDefinitional(IfcLogical value) { this.productDefinitional = value; }
    public IfcProductRepresentationSelect getPartOfProductDefinitionShape() { return this.partOfProductDefinitionShape; }
    public void setPartOfProductDefinitionShape(IfcProductRepresentationSelect value) { this.partOfProductDefinitionShape = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(shapeRepresentations != null ? StepUtils.toStepValue(shapeRepresentations) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(productDefinitional != null ? StepUtils.toStepValue(productDefinitional) : "$");
		parameters.add(partOfProductDefinitionShape != null ? StepUtils.toStepValue(partOfProductDefinitionShape) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcShapeAspectRelationship(); }
    private void setIfcShapeAspectRelationship() {
		if (this.partOfProductDefinitionShape != null) {
		    if (this.partOfProductDefinitionShape instanceof IfcProductDefinitionShape)
		        ((IfcProductDefinitionShape)this.partOfProductDefinitionShape).hasShapeAspects.add(this);
		}
		if (this.partOfProductDefinitionShape != null) {
		    if (this.partOfProductDefinitionShape instanceof IfcRepresentationMap)
		        ((IfcRepresentationMap)this.partOfProductDefinitionShape).hasShapeAspects.add(this);
		}
		if (this.shapeRepresentations != null) {
		    for (Object x : this.shapeRepresentations) {
		        if (x instanceof IfcShapeModel)
		            ((IfcShapeModel)x).ofShapeAspect.add(this);
		    }
		}
    }
}