package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadCase
 * SUBTYPE OF (IfcStructuralLoadGroup);
 * SelfWeightCoefficients : OPTIONAL LIST [3:3] OF IfcRatioMeasure;
 * WHERE
 * IsLoadCasePredefinedType : SELF\IfcStructuralLoadGroup.PredefinedType = IfcLoadGroupTypeEnum.LOAD_CASE;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadcase.htm">IfcStructuralLoadCase</a>
 */
public class IfcStructuralLoadCase extends IfcStructuralLoadGroup {
    protected Collection<IfcRatioMeasure> selfWeightCoefficients;

    protected IfcStructuralLoadCase() { initCollections(); }
    /**
     * Constructs IfcStructuralLoadCase with all required attributes.
     */
    public IfcStructuralLoadCase(IfcGloballyUniqueId globalId,IfcLoadGroupTypeEnum predefinedType,IfcActionTypeEnum actionType,IfcActionSourceTypeEnum actionSource) {

        super(globalId,predefinedType,actionType,actionSource);
        this.selfWeightCoefficients = new ArrayList<>();
    }
    /**
     * Constructs IfcStructuralLoadCase with required and optional attributes.
     */
    public IfcStructuralLoadCase(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcLoadGroupTypeEnum predefinedType,IfcActionTypeEnum actionType,IfcActionSourceTypeEnum actionSource,IfcRatioMeasure coefficient,IfcLabel purpose,Collection<IfcRatioMeasure> selfWeightCoefficients) {
        super(globalId,ownerHistory,name,description,objectType,predefinedType,actionType,actionSource,coefficient,purpose);
        this.selfWeightCoefficients = selfWeightCoefficients;
    }
    private void initCollections() {
        this.selfWeightCoefficients = new ArrayList<>();
    }
    public Collection<IfcRatioMeasure> getSelfWeightCoefficients() { return this.selfWeightCoefficients; }
    public void setSelfWeightCoefficients(Collection<IfcRatioMeasure> value) { this.selfWeightCoefficients = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(StepUtils.toStepValue(actionType));
		parameters.add(StepUtils.toStepValue(actionSource));
		parameters.add(coefficient != null ? StepUtils.toStepValue(coefficient) : "$");
		parameters.add(purpose != null ? StepUtils.toStepValue(purpose) : "$");
		parameters.add(selfWeightCoefficients != null ? StepUtils.toStepValue(selfWeightCoefficients) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}