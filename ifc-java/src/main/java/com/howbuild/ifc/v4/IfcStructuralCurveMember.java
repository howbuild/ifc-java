package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralCurveMember
 * SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveMemberVarying))
 * SUBTYPE OF (IfcStructuralMember);
 * PredefinedType : IfcStructuralCurveMemberTypeEnum;
 * Axis : IfcDirection;
 * WHERE
 * HasObjectType : (PredefinedType <> IfcStructuralCurveMemberTypeEnum.USERDEFINED) OR EXISTS(SELF\IfcObject.ObjectType);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralcurvemember.htm">IfcStructuralCurveMember</a>
 */
public class IfcStructuralCurveMember extends IfcStructuralMember {
    protected IfcStructuralCurveMemberTypeEnum predefinedType;
    protected IfcDirection axis;

    protected IfcStructuralCurveMember() { initCollections(); }
    /**
     * Constructs IfcStructuralCurveMember with all required attributes.
     */
    public IfcStructuralCurveMember(IfcGloballyUniqueId globalId,IfcStructuralCurveMemberTypeEnum predefinedType,IfcDirection axis) {

        super(globalId);
        this.predefinedType = predefinedType;
        this.axis = axis;
    }
    /**
     * Constructs IfcStructuralCurveMember with required and optional attributes.
     */
    public IfcStructuralCurveMember(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralCurveMemberTypeEnum predefinedType,IfcDirection axis) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.predefinedType = predefinedType;
        this.axis = axis;
    }
    private void initCollections() {
    }
    public IfcStructuralCurveMemberTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcStructuralCurveMemberTypeEnum value) { this.predefinedType = value; }
    public IfcDirection getAxis() { return this.axis; }
    public void setAxis(IfcDirection value) { this.axis = value; }

    
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
		parameters.add(axis != null ? StepUtils.toStepValue(axis) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}