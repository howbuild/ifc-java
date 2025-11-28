package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBeam
 * ,IfcBuildingElementProxy
 * ,IfcChimney
 * ,IfcColumn
 * ,IfcCovering
 * ,IfcCurtainWall
 * ,IfcDoor
 * ,IfcFooting
 * ,IfcMember
 * ,IfcPile
 * ,IfcPlate
 * ,IfcRailing
 * ,IfcRamp
 * ,IfcRampFlight
 * ,IfcRoof
 * ,IfcShadingDevice
 * ,IfcSlab
 * ,IfcStair
 * ,IfcStairFlight
 * ,IfcWall
 * ,IfcWindow))
 * SUBTYPE OF (IfcElement);
 * WHERE
 * MaxOneMaterialAssociation : SIZEOF (QUERY(temp <* SELF\IfcObjectDefinition.HasAssociations |
 * 'IFC4.IFCRELASSOCIATESMATERIAL' IN TYPEOF(temp)
 * )) <= 1;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstair.htm">IfcStair</a>
 */
public class IfcStair extends IfcBuildingElement {
    protected IfcStairTypeEnum predefinedType;

    protected IfcStair() { initCollections(); }
    /**
     * Constructs IfcStair with all required attributes.
     */
    public IfcStair(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcStair with required and optional attributes.
     */
    public IfcStair(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcStairTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcStairTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcStairTypeEnum value) { this.predefinedType = value; } // optional

    
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