package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRepresentationMap;
 * MappingOrigin : IfcAxis2Placement;
 * MappedRepresentation : IfcRepresentation;
 * INVERSE
 * HasShapeAspects : SET [0:?] OF IfcShapeAspect FOR PartOfProductDefinitionShape;
 * MapUsage : SET [0:?] OF IfcMappedItem FOR MappingSource;
 * WHERE
 * ApplicableMappedRepr : 'IFC4.IFCSHAPEMODEL' IN TYPEOF(MappedRepresentation);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrepresentationmap.htm">IfcRepresentationMap</a>
 */
public class IfcRepresentationMap extends BaseIfc implements IfcProductRepresentationSelect {
    protected IfcAxis2Placement mappingOrigin;
    protected IfcRepresentation mappedRepresentation;
    protected Collection<IfcShapeAspect> hasShapeAspects;
    protected Collection<IfcMappedItem> mapUsage;

    protected IfcRepresentationMap() { initCollections(); }
    /**
     * Constructs IfcRepresentationMap with all required attributes.
     */
    public IfcRepresentationMap(IfcAxis2Placement mappingOrigin,IfcRepresentation mappedRepresentation) {
        super();
        this.hasShapeAspects = new ArrayList<>();
        this.mapUsage = new ArrayList<>();
        this.mappingOrigin = mappingOrigin;
        this.mappedRepresentation = mappedRepresentation;
    }
    private void initCollections() {
        this.hasShapeAspects = new ArrayList<>();
        this.mapUsage = new ArrayList<>();
    }
    public IfcAxis2Placement getMappingOrigin() { return this.mappingOrigin; }
    public void setMappingOrigin(IfcAxis2Placement value) { this.mappingOrigin = value; }
    public IfcRepresentation getMappedRepresentation() { return this.mappedRepresentation; }
    public void setMappedRepresentation(IfcRepresentation value) { this.mappedRepresentation = value; }
    public Collection<IfcShapeAspect> getHasShapeAspects() { return this.hasShapeAspects; }
    public void setHasShapeAspects(Collection<IfcShapeAspect> value) { this.hasShapeAspects = value; } // inverse
    public Collection<IfcMappedItem> getMapUsage() { return this.mapUsage; }
    public void setMapUsage(Collection<IfcMappedItem> value) { this.mapUsage = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(mappingOrigin != null ? StepUtils.toStepValue(mappingOrigin) : "$");
		parameters.add(mappedRepresentation != null ? StepUtils.toStepValue(mappedRepresentation) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRepresentationMapRelationship(); }
    private void setIfcRepresentationMapRelationship() {
		if (this.mappedRepresentation != null) {
		    if (this.mappedRepresentation instanceof IfcRepresentation)
		        ((IfcRepresentation)this.mappedRepresentation).representationMap.add(this);
		}
    }
}