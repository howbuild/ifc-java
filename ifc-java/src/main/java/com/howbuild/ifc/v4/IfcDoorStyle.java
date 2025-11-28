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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdoorstyle.htm">IfcDoorStyle</a>
 */
public class IfcDoorStyle extends IfcTypeProduct {
    protected IfcDoorStyleOperationEnum operationType;
    protected IfcDoorStyleConstructionEnum constructionType;
    protected IfcBoolean parameterTakesPrecedence;
    protected IfcBoolean sizeable;

    protected IfcDoorStyle() { initCollections(); }
    /**
     * Constructs IfcDoorStyle with all required attributes.
     */
    public IfcDoorStyle(IfcGloballyUniqueId globalId,IfcDoorStyleOperationEnum operationType,IfcDoorStyleConstructionEnum constructionType,IfcBoolean parameterTakesPrecedence,IfcBoolean sizeable) {

        super(globalId);
        this.operationType = operationType;
        this.constructionType = constructionType;
        this.parameterTakesPrecedence = parameterTakesPrecedence;
        this.sizeable = sizeable;
    }
    /**
     * Constructs IfcDoorStyle with required and optional attributes.
     */
    public IfcDoorStyle(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcDoorStyleOperationEnum operationType,IfcDoorStyleConstructionEnum constructionType,IfcBoolean parameterTakesPrecedence,IfcBoolean sizeable) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag);
        this.operationType = operationType;
        this.constructionType = constructionType;
        this.parameterTakesPrecedence = parameterTakesPrecedence;
        this.sizeable = sizeable;
    }
    private void initCollections() {
    }
    public IfcDoorStyleOperationEnum getOperationType() { return this.operationType; }
    public void setOperationType(IfcDoorStyleOperationEnum value) { this.operationType = value; }
    public IfcDoorStyleConstructionEnum getConstructionType() { return this.constructionType; }
    public void setConstructionType(IfcDoorStyleConstructionEnum value) { this.constructionType = value; }
    public IfcBoolean getParameterTakesPrecedence() { return this.parameterTakesPrecedence; }
    public void setParameterTakesPrecedence(IfcBoolean value) { this.parameterTakesPrecedence = value; }
    public IfcBoolean getSizeable() { return this.sizeable; }
    public void setSizeable(IfcBoolean value) { this.sizeable = value; }

    
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
		parameters.add(StepUtils.toStepValue(operationType));
		parameters.add(StepUtils.toStepValue(constructionType));
		parameters.add(parameterTakesPrecedence != null ? StepUtils.toStepValue(parameterTakesPrecedence) : "$");
		parameters.add(sizeable != null ? StepUtils.toStepValue(sizeable) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}