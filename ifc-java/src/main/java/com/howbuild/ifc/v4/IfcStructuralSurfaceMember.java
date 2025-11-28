package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralMember
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveMember
 * ,IfcStructuralSurfaceMember))
 * SUBTYPE OF (IfcStructuralItem);
 * INVERSE
 * ConnectedBy : SET [0:?] OF IfcRelConnectsStructuralMember FOR RelatingStructuralMember;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralsurfacemember.htm">IfcStructuralSurfaceMember</a>
 */
public class IfcStructuralSurfaceMember extends IfcStructuralMember {
    protected IfcStructuralSurfaceMemberTypeEnum predefinedType;
    protected IfcPositiveLengthMeasure thickness;

    protected IfcStructuralSurfaceMember() { initCollections(); }
    /**
     * Constructs IfcStructuralSurfaceMember with all required attributes.
     */
    public IfcStructuralSurfaceMember(IfcGloballyUniqueId globalId,IfcStructuralSurfaceMemberTypeEnum predefinedType) {

        super(globalId);
        this.predefinedType = predefinedType;
    }
    /**
     * Constructs IfcStructuralSurfaceMember with required and optional attributes.
     */
    public IfcStructuralSurfaceMember(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralSurfaceMemberTypeEnum predefinedType,IfcPositiveLengthMeasure thickness) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.predefinedType = predefinedType;
        this.thickness = thickness;
    }
    private void initCollections() {
    }
    public IfcStructuralSurfaceMemberTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcStructuralSurfaceMemberTypeEnum value) { this.predefinedType = value; }
    public IfcPositiveLengthMeasure getThickness() { return this.thickness; }
    public void setThickness(IfcPositiveLengthMeasure value) { this.thickness = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(thickness != null ? StepUtils.toStepValue(thickness) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}