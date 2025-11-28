package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDistributionChamberElement
 * SUBTYPE OF (IfcDistributionFlowElement);
 * PredefinedType : OPTIONAL IfcDistributionChamberElementTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcDistributionChamberElementTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcDistributionChamberElementTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCDISTRIBUTIONCHAMBERELEMENTTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdistributionflowelement.htm">IfcDistributionFlowElement</a>
 */
public class IfcDistributionFlowElement extends IfcDistributionElement {
    protected Collection<IfcRelFlowControlElements> hasControlElements;

    protected IfcDistributionFlowElement() { initCollections(); }
    /**
     * Constructs IfcDistributionFlowElement with all required attributes.
     */
    public IfcDistributionFlowElement(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasControlElements = new ArrayList<>();
    }
    /**
     * Constructs IfcDistributionFlowElement with required and optional attributes.
     */
    public IfcDistributionFlowElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.hasControlElements = new ArrayList<>();
    }
    private void initCollections() {
        this.hasControlElements = new ArrayList<>();
    }
    public Collection<IfcRelFlowControlElements> getHasControlElements() { return this.hasControlElements; }
    public void setHasControlElements(Collection<IfcRelFlowControlElements> value) { this.hasControlElements = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}