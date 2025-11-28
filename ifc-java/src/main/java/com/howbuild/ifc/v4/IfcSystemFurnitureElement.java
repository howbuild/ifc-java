package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFurnishingElement
 * SUPERTYPE OF (ONEOF
 * (IfcFurniture
 * ,IfcSystemFurnitureElement))
 * SUBTYPE OF (IfcElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsystemfurnitureelement.htm">IfcSystemFurnitureElement</a>
 */
public class IfcSystemFurnitureElement extends IfcFurnishingElement {
    protected IfcSystemFurnitureElementTypeEnum predefinedType;

    protected IfcSystemFurnitureElement() { initCollections(); }
    /**
     * Constructs IfcSystemFurnitureElement with all required attributes.
     */
    public IfcSystemFurnitureElement(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSystemFurnitureElement with required and optional attributes.
     */
    public IfcSystemFurnitureElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcSystemFurnitureElementTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcSystemFurnitureElementTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcSystemFurnitureElementTypeEnum value) { this.predefinedType = value; } // optional

    
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