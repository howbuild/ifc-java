package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFeatureElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcFeatureElementAddition
 * ,IfcFeatureElementSubtraction
 * ,IfcSurfaceFeature))
 * SUBTYPE OF (IfcElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacefeature.htm">IfcSurfaceFeature</a>
 */
public class IfcSurfaceFeature extends IfcFeatureElement {
    protected IfcSurfaceFeatureTypeEnum predefinedType;

    protected IfcSurfaceFeature() { initCollections(); }
    /**
     * Constructs IfcSurfaceFeature with all required attributes.
     */
    public IfcSurfaceFeature(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSurfaceFeature with required and optional attributes.
     */
    public IfcSurfaceFeature(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcSurfaceFeatureTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcSurfaceFeatureTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSurfaceFeatureTypeEnum value) { this.predefinedType = value; } // optional

    
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