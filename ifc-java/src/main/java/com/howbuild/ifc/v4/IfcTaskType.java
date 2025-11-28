package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTaskType
 * SUBTYPE OF (IfcTypeProcess);
 * PredefinedType : IfcTaskTypeEnum;
 * WorkMethod : OPTIONAL IfcLabel;
 * WHERE
 * CorrectPredefinedType : (PredefinedType <> IfcTaskTypeEnum.USERDEFINED) OR ((PredefinedType = IfcTaskTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcTypeProcess.ProcessType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctasktype.htm">IfcTaskType</a>
 */
public class IfcTaskType extends IfcTypeProcess {
    protected IfcTaskTypeEnum predefinedType;
    protected IfcLabel workMethod;

    protected IfcTaskType() { initCollections(); }
    /**
     * Constructs IfcTaskType with all required attributes.
     */
    public IfcTaskType(IfcGloballyUniqueId globalId,IfcTaskTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcTaskType with required and optional attributes.
     */
    public IfcTaskType(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,IfcIdentifier identification,IfcText longDescription,IfcLabel processType,IfcTaskTypeEnum predefinedType,IfcLabel workMethod) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,identification,longDescription,processType);
        this.predefinedType = predefinedType;
        this.workMethod = workMethod;
    }
    private void initCollections() {
    }
    public IfcTaskTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcTaskTypeEnum value) { this.predefinedType = value; }
    public IfcLabel getWorkMethod() { return this.workMethod; }
    public void setWorkMethod(IfcLabel value) { this.workMethod = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(processType != null ? StepUtils.toStepValue(processType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(workMethod != null ? StepUtils.toStepValue(workMethod) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}