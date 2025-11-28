package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTypeProduct
 * SUPERTYPE OF (ONEOF
 * (IfcDoorStyle
 * ,IfcElementType
 * ,IfcSpatialElementType
 * ,IfcWindowStyle))
 * SUBTYPE OF (IfcTypeObject);
 * RepresentationMaps : OPTIONAL LIST [1:?] OF UNIQUE IfcRepresentationMap;
 * Tag : OPTIONAL IfcLabel;
 * INVERSE
 * ReferencedBy : SET [0:?] OF IfcRelAssignsToProduct FOR RelatingProduct;
 * WHERE
 * ApplicableOccurrence : NOT(EXISTS(SELF\IfcTypeObject.Types[1])) OR
 * (SIZEOF(QUERY(temp <* SELF\IfcTypeObject.Types[1].RelatedObjects |
 * NOT('IFC4.IFCPRODUCT' IN TYPEOF(temp)))
 * ) = 0);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcwindowstyle.htm">IfcWindowStyle</a>
 */
public class IfcWindowStyle extends IfcTypeProduct {
    protected IfcWindowStyleConstructionEnum constructionType;
    protected IfcWindowStyleOperationEnum operationType;
    protected IfcBoolean parameterTakesPrecedence;
    protected IfcBoolean sizeable;

    protected IfcWindowStyle() { initCollections(); }
    /**
     * Constructs IfcWindowStyle with all required attributes.
     */
    public IfcWindowStyle(IfcGloballyUniqueId globalId,IfcWindowStyleConstructionEnum constructionType,IfcWindowStyleOperationEnum operationType,IfcBoolean parameterTakesPrecedence,IfcBoolean sizeable) {

        super(globalId);
        this.constructionType = constructionType;
        this.operationType = operationType;
        this.parameterTakesPrecedence = parameterTakesPrecedence;
        this.sizeable = sizeable;
    }
    /**
     * Constructs IfcWindowStyle with required and optional attributes.
     */
    public IfcWindowStyle(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets,Collection<IfcRepresentationMap> representationMaps,IfcLabel tag,IfcWindowStyleConstructionEnum constructionType,IfcWindowStyleOperationEnum operationType,IfcBoolean parameterTakesPrecedence,IfcBoolean sizeable) {
        super(globalId,ownerHistory,name,description,applicableOccurrence,hasPropertySets,representationMaps,tag);
        this.constructionType = constructionType;
        this.operationType = operationType;
        this.parameterTakesPrecedence = parameterTakesPrecedence;
        this.sizeable = sizeable;
    }
    private void initCollections() {
    }
    public IfcWindowStyleConstructionEnum getConstructionType() { return this.constructionType; }
    public void setConstructionType(IfcWindowStyleConstructionEnum value) { this.constructionType = value; }
    public IfcWindowStyleOperationEnum getOperationType() { return this.operationType; }
    public void setOperationType(IfcWindowStyleOperationEnum value) { this.operationType = value; }
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
		parameters.add(StepUtils.toStepValue(constructionType));
		parameters.add(StepUtils.toStepValue(operationType));
		parameters.add(parameterTakesPrecedence != null ? StepUtils.toStepValue(parameterTakesPrecedence) : "$");
		parameters.add(sizeable != null ? StepUtils.toStepValue(sizeable) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}