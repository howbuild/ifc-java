package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFeatureElementSubtraction
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcOpeningElement
 * ,IfcVoidingFeature))
 * SUBTYPE OF (IfcFeatureElement);
 * INVERSE
 * VoidsElements : IfcRelVoidsElement FOR RelatedOpeningElement;
 * WHERE
 * HasNoSubtraction : SIZEOF(SELF\IfcElement.HasOpenings) = 0;
 * IsNotFilling : SIZEOF(SELF\IfcElement.FillsVoids) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvoidingfeature.htm">IfcVoidingFeature</a>
 */
public class IfcVoidingFeature extends IfcFeatureElementSubtraction {
    protected IfcVoidingFeatureTypeEnum predefinedType;

    protected IfcVoidingFeature() { initCollections(); }
    /**
     * Constructs IfcVoidingFeature with all required attributes.
     */
    public IfcVoidingFeature(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcVoidingFeature with required and optional attributes.
     */
    public IfcVoidingFeature(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcVoidingFeatureTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcVoidingFeatureTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcVoidingFeatureTypeEnum value) { this.predefinedType = value; } // optional

    
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
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}