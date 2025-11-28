package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDoorStyle
 * SUBTYPE OF (IfcTypeProduct);
 * OperationType : IfcDoorStyleOperationEnum;
 * ConstructionType : IfcDoorStyleConstructionEnum;
 * ParameterTakesPrecedence : IfcBoolean;
 * Sizeable : IfcBoolean;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctypeproduct.htm">IfcTypeProduct</a>
 */
public class IfcTypeProduct extends IfcTypeObject implements IfcProductSelect {
    protected Collection<IfcRepresentationMap> representationMaps;
    protected IfcLabel tag;
    protected Collection<IfcRelAssignsToProduct> referencedBy;

    protected IfcTypeProduct() { initCollections(); }
    /**
     * Constructs IfcTypeProduct with all required attributes.
     */
    public IfcTypeProduct(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.representationMaps = new ArrayList<>();
        this.referencedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcTypeProduct with required and optional attributes.
     */
    public IfcTypeProduct(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets);
        this.referencedBy = new ArrayList<>();
        this.representationMaps = representationMaps;
        this.tag = tag;
    }
    private void initCollections() {
        this.representationMaps = new ArrayList<>();
        this.referencedBy = new ArrayList<>();
    }
    public Collection<IfcRepresentationMap> getRepresentationMaps() { return this.representationMaps; }
    public void setRepresentationMaps(Collection<IfcRepresentationMap> value) { this.representationMaps = value; } // optional
    public IfcLabel getTag() { return this.tag; }
    public void setTag(IfcLabel value) { this.tag = value; } // optional
    public Collection<IfcRelAssignsToProduct> getReferencedBy() { return this.referencedBy; }
    public void setReferencedBy(Collection<IfcRelAssignsToProduct> value) { this.referencedBy = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(representationMaps != null ? StepUtils.toStepValue(representationMaps) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}