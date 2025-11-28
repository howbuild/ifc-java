package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralSurfaceMember
 * SUPERTYPE OF (ONEOF
 * (IfcStructuralSurfaceMemberVarying))
 * SUBTYPE OF (IfcStructuralMember);
 * PredefinedType : IfcStructuralSurfaceMemberTypeEnum;
 * Thickness : OPTIONAL IfcPositiveLengthMeasure;
 * WHERE
 * HasObjectType : (PredefinedType <> IfcStructuralSurfaceMemberTypeEnum.USERDEFINED) OR EXISTS(SELF\IfcObject.ObjectType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralsurfacemembervarying.htm">IfcStructuralSurfaceMemberVarying</a>
 */
public class IfcStructuralSurfaceMemberVarying extends IfcStructuralSurfaceMember {

    protected IfcStructuralSurfaceMemberVarying() { initCollections(); }
    /**
     * Constructs IfcStructuralSurfaceMemberVarying with all required attributes.
     */
    public IfcStructuralSurfaceMemberVarying(IfcGloballyUniqueId globalId,IfcStructuralSurfaceMemberTypeEnum predefinedType) {

        super(globalId,predefinedType);
    }
    /**
     * Constructs IfcStructuralSurfaceMemberVarying with required and optional attributes.
     */
    public IfcStructuralSurfaceMemberVarying(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralSurfaceMemberTypeEnum predefinedType,IfcPositiveLengthMeasure thickness) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,predefinedType,thickness);
    }
    private void initCollections() {
    }

    
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