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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralsurfaceaction.htm">IfcStructuralSurfaceAction</a>
 */
public class IfcStructuralSurfaceAction extends IfcStructuralAction {
    protected IfcProjectedOrTrueLengthEnum projectedOrTrue;
    protected IfcStructuralSurfaceActivityTypeEnum predefinedType;

    protected IfcStructuralSurfaceAction() { initCollections(); }
    /**
     * Constructs IfcStructuralSurfaceAction with all required attributes.
     */
    public IfcStructuralSurfaceAction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcStructuralSurfaceActivityTypeEnum predefinedType) {

        super(globalId,appliedLoad,globalOrLocal);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcStructuralSurfaceAction with required and optional attributes.
     */
    public IfcStructuralSurfaceAction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcBoolean destabilizingLoad,IfcProjectedOrTrueLengthEnum projectedOrTrue,IfcStructuralSurfaceActivityTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal,destabilizingLoad);
        this.projectedOrTrue = projectedOrTrue;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcProjectedOrTrueLengthEnum getProjectedOrTrue() { return this.projectedOrTrue; }
    public void setProjectedOrTrue(IfcProjectedOrTrueLengthEnum value) { this.projectedOrTrue = value; } // optional
    public IfcStructuralSurfaceActivityTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcStructuralSurfaceActivityTypeEnum value) { this.predefinedType = value; }

    
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