package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGrid
 * SUBTYPE OF (IfcProduct);
 * UAxes : LIST [1:?] OF UNIQUE IfcGridAxis;
 * VAxes : LIST [1:?] OF UNIQUE IfcGridAxis;
 * WAxes : OPTIONAL LIST [1:?] OF UNIQUE IfcGridAxis;
 * PredefinedType : OPTIONAL IfcGridTypeEnum;
 * INVERSE
 * ContainedInStructure : SET [0:1] OF IfcRelContainedInSpatialStructure FOR RelatedElements;
 * WHERE
 * HasPlacement : EXISTS(SELF\IfcProduct.ObjectPlacement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgrid.htm">IfcGrid</a>
 */
public class IfcGrid extends IfcProduct {
    protected Collection<IfcGridAxis> uAxes;
    protected Collection<IfcGridAxis> vAxes;
    protected Collection<IfcGridAxis> wAxes;
    protected IfcGridTypeEnum predefinedType;
    protected Collection<IfcRelContainedInSpatialStructure> containedInStructure;

    protected IfcGrid() { initCollections(); }
    /**
     * Constructs IfcGrid with all required attributes.
     */
    public IfcGrid(IfcGloballyUniqueId globalId,Collection<IfcGridAxis> uAxes,Collection<IfcGridAxis> vAxes) {

        super(globalId);
        this.wAxes = new ArrayList<>();
        this.containedInStructure = new ArrayList<>();
        this.uAxes = uAxes;
        this.vAxes = vAxes;
    }
    /**
     * Constructs IfcGrid with required and optional attributes.
     */
    public IfcGrid(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,Collection<IfcGridAxis> uAxes,Collection<IfcGridAxis> vAxes,Collection<IfcGridAxis> wAxes,IfcGridTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.containedInStructure = new ArrayList<>();
        this.uAxes = uAxes;
        this.vAxes = vAxes;
        this.wAxes = wAxes;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
        this.uAxes = new ArrayList<>();
        this.vAxes = new ArrayList<>();
        this.wAxes = new ArrayList<>();
        this.containedInStructure = new ArrayList<>();
    }
    public Collection<IfcGridAxis> getUAxes() { return this.uAxes; }
    public void setUAxes(Collection<IfcGridAxis> value) { this.uAxes = value; }
    public Collection<IfcGridAxis> getVAxes() { return this.vAxes; }
    public void setVAxes(Collection<IfcGridAxis> value) { this.vAxes = value; }
    public Collection<IfcGridAxis> getWAxes() { return this.wAxes; }
    public void setWAxes(Collection<IfcGridAxis> value) { this.wAxes = value; } // optional
    public IfcGridTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcGridTypeEnum value) { this.predefinedType = value; } // optional
    public Collection<IfcRelContainedInSpatialStructure> getContainedInStructure() { return this.containedInStructure; }
    public void setContainedInStructure(Collection<IfcRelContainedInSpatialStructure> value) { this.containedInStructure = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(uAxes != null ? StepUtils.toStepValue(uAxes) : "$");
		parameters.add(vAxes != null ? StepUtils.toStepValue(vAxes) : "$");
		parameters.add(wAxes != null ? StepUtils.toStepValue(wAxes) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcGridRelationship(); }
    private void setIfcGridRelationship() {
		if (this.wAxes != null) {
		    for (Object x : this.wAxes) {
		        if (x instanceof IfcGridAxis)
		            ((IfcGridAxis)x).partOfW.add(this);
		    }
		}
		if (this.vAxes != null) {
		    for (Object x : this.vAxes) {
		        if (x instanceof IfcGridAxis)
		            ((IfcGridAxis)x).partOfV.add(this);
		    }
		}
		if (this.uAxes != null) {
		    for (Object x : this.uAxes) {
		        if (x instanceof IfcGridAxis)
		            ((IfcGridAxis)x).partOfU.add(this);
		    }
		}
    }
}