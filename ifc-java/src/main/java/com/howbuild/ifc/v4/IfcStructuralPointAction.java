package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralAction
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveAction
 * ,IfcStructuralPointAction
 * ,IfcStructuralSurfaceAction))
 * SUBTYPE OF (IfcStructuralActivity);
 * DestabilizingLoad : OPTIONAL IfcBoolean;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralpointaction.htm">IfcStructuralPointAction</a>
 */
public class IfcStructuralPointAction extends IfcStructuralAction {

    protected IfcStructuralPointAction() { initCollections(); }
    /**
     * Constructs IfcStructuralPointAction with all required attributes.
     */
    public IfcStructuralPointAction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {

        super(globalId,appliedLoad,globalOrLocal);
    }
    /**
     * Constructs IfcStructuralPointAction with required and optional attributes.
     */
    public IfcStructuralPointAction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcBoolean destabilizingLoad) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal,destabilizingLoad);
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
		parameters.add(appliedLoad != null ? StepUtils.toStepValue(appliedLoad) : "$");
		parameters.add(StepUtils.toStepValue(globalOrLocal));
		parameters.add(destabilizingLoad != null ? StepUtils.toStepValue(destabilizingLoad) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}