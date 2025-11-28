package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAirTerminalBox
 * SUBTYPE OF (IfcFlowController);
 * PredefinedType : OPTIONAL IfcAirTerminalBoxTypeEnum;
 * WHERE
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR
 * (PredefinedType <> IfcAirTerminalBoxTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcAirTerminalBoxTypeEnum.USERDEFINED) AND EXISTS (SELF\IfcObject.ObjectType));
 * CorrectTypeAssigned : (SIZEOF(IsTypedBy) = 0) OR
 * ('IFC4.IFCAIRTERMINALBOXTYPE' IN TYPEOF(SELF\IfcObject.IsTypedBy[1].RelatingType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcflowcontroller.htm">IfcFlowController</a>
 */
public class IfcFlowController extends IfcDistributionFlowElement {

    protected IfcFlowController() { initCollections(); }
    /**
     * Constructs IfcFlowController with all required attributes.
     */
    public IfcFlowController(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFlowController with required and optional attributes.
     */
    public IfcFlowController(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
    }
    private void initCollections() {
    }

    
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