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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcannotation.htm">IfcAnnotation</a>
 */
public class IfcAnnotation extends IfcProduct {
    protected Collection<IfcRelContainedInSpatialStructure> containedInStructure;

    protected IfcAnnotation() { initCollections(); }
    /**
     * Constructs IfcAnnotation with all required attributes.
     */
    public IfcAnnotation(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.containedInStructure = new ArrayList<>();
    }
    /**
     * Constructs IfcAnnotation with required and optional attributes.
     */
    public IfcAnnotation(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.containedInStructure = new ArrayList<>();
    }
    private void initCollections() {
        this.containedInStructure = new ArrayList<>();
    }
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
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}