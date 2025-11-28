package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralCurveAction
 * SUPERTYPE OF (ONEOF
 * (IfcStructuralLinearAction))
 * SUBTYPE OF (IfcStructuralAction);
 * ProjectedOrTrue : OPTIONAL IfcProjectedOrTrueLengthEnum;
 * PredefinedType : IfcStructuralCurveActivityTypeEnum;
 * WHERE
 * ProjectedIsGlobal : (NOT EXISTS(ProjectedOrTrue)) OR
 * ((ProjectedOrTrue <> PROJECTED_LENGTH) OR
 * (SELF\IfcStructuralActivity.GlobalOrLocal = GLOBAL_COORDS));
 * HasObjectType : (PredefinedType <> IfcStructuralCurveActivityTypeEnum.USERDEFINED) OR EXISTS(SELF\IfcObject.ObjectType);
 * SuitablePredefinedType : PredefinedType <> IfcStructuralCurveActivityTypeEnum.EQUIDISTANT;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructurallinearaction.htm">IfcStructuralLinearAction</a>
 */
public class IfcStructuralLinearAction extends IfcStructuralCurveAction {

    protected IfcStructuralLinearAction() { initCollections(); }
    /**
     * Constructs IfcStructuralLinearAction with all required attributes.
     */
    public IfcStructuralLinearAction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcStructuralCurveActivityTypeEnum predefinedType) {

        super(globalId,appliedLoad,globalOrLocal,predefinedType);
    }
    /**
     * Constructs IfcStructuralLinearAction with required and optional attributes.
     */
    public IfcStructuralLinearAction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcBoolean destabilizingLoad,IfcProjectedOrTrueLengthEnum projectedOrTrue,IfcStructuralCurveActivityTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal,destabilizingLoad,projectedOrTrue,predefinedType);
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
		parameters.add(StepUtils.toStepValue(projectedOrTrue));
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}