package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMappedItem
 * SUBTYPE OF (IfcRepresentationItem);
 * MappingSource : IfcRepresentationMap;
 * MappingTarget : IfcCartesianTransformationOperator;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmappeditem.htm">IfcMappedItem</a>
 */
public class IfcMappedItem extends IfcRepresentationItem {
    protected IfcRepresentationMap mappingSource;
    protected IfcCartesianTransformationOperator mappingTarget;

    protected IfcMappedItem() { initCollections(); }
    /**
     * Constructs IfcMappedItem with all required attributes.
     */
    public IfcMappedItem(IfcRepresentationMap mappingSource,IfcCartesianTransformationOperator mappingTarget) {
        super();
        this.mappingSource = mappingSource;
        this.mappingTarget = mappingTarget;
    }
    private void initCollections() {
    }
    public IfcRepresentationMap getMappingSource() { return this.mappingSource; }
    public void setMappingSource(IfcRepresentationMap value) { this.mappingSource = value; }
    public IfcCartesianTransformationOperator getMappingTarget() { return this.mappingTarget; }
    public void setMappingTarget(IfcCartesianTransformationOperator value) { this.mappingTarget = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(mappingSource != null ? StepUtils.toStepValue(mappingSource) : "$");
		parameters.add(mappingTarget != null ? StepUtils.toStepValue(mappingTarget) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMappedItemRelationship(); }
    private void setIfcMappedItemRelationship() {
		if (this.mappingSource != null) {
		    if (this.mappingSource instanceof IfcRepresentationMap)
		        ((IfcRepresentationMap)this.mappingSource).mapUsage.add(this);
		}
    }
}