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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralcurveaction.htm">IfcStructuralCurveAction</a>
 */
public class IfcStructuralCurveAction extends IfcStructuralAction {
    protected IfcProjectedOrTrueLengthEnum projectedOrTrue;
    protected IfcStructuralCurveActivityTypeEnum predefinedType;

    protected IfcStructuralCurveAction() { initCollections(); }
    /**
     * Constructs IfcStructuralCurveAction with all required attributes.
     */
    public IfcStructuralCurveAction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcStructuralCurveActivityTypeEnum predefinedType) {

        super(globalId,appliedLoad,globalOrLocal);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcStructuralCurveAction with required and optional attributes.
     */
    public IfcStructuralCurveAction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcBoolean destabilizingLoad,IfcProjectedOrTrueLengthEnum projectedOrTrue,IfcStructuralCurveActivityTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal,destabilizingLoad);
        this.projectedOrTrue = projectedOrTrue;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcProjectedOrTrueLengthEnum getProjectedOrTrue() { return this.projectedOrTrue; }
    public void setProjectedOrTrue(IfcProjectedOrTrueLengthEnum value) { this.projectedOrTrue = value; } // optional
    public IfcStructuralCurveActivityTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcStructuralCurveActivityTypeEnum value) { this.predefinedType = value; }

    
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