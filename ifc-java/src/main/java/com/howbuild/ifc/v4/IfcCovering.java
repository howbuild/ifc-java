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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccovering.htm">IfcCovering</a>
 */
public class IfcCovering extends IfcBuildingElement {
    protected IfcCoveringTypeEnum predefinedType;
    protected Collection<IfcRelCoversSpaces> coversSpaces;
    protected Collection<IfcRelCoversBldgElements> coversElements;

    protected IfcCovering() { initCollections(); }
    /**
     * Constructs IfcCovering with all required attributes.
     */
    public IfcCovering(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.coversSpaces = new ArrayList<>();
        this.coversElements = new ArrayList<>();
    }
    /**
     * Constructs IfcCovering with required and optional attributes.
     */
    public IfcCovering(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcCoveringTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.coversSpaces = new ArrayList<>();
        this.coversElements = new ArrayList<>();
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
        this.coversSpaces = new ArrayList<>();
        this.coversElements = new ArrayList<>();
    }
    public IfcCoveringTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcCoveringTypeEnum value) { this.predefinedType = value; } // optional
    public Collection<IfcRelCoversSpaces> getCoversSpaces() { return this.coversSpaces; }
    public void setCoversSpaces(Collection<IfcRelCoversSpaces> value) { this.coversSpaces = value; } // inverse
    public Collection<IfcRelCoversBldgElements> getCoversElements() { return this.coversElements; }
    public void setCoversElements(Collection<IfcRelCoversBldgElements> value) { this.coversElements = value; } // inverse

    
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