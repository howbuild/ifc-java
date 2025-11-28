package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDerivedProfileDef
 * SUPERTYPE OF (ONEOF
 * (IfcMirroredProfileDef))
 * SUBTYPE OF (IfcProfileDef);
 * ParentProfile : IfcProfileDef;
 * Operator : IfcCartesianTransformationOperator2D;
 * Label : OPTIONAL IfcLabel;
 * WHERE
 * InvariantProfileType : SELF\IfcProfileDef.ProfileType = ParentProfile.ProfileType;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmirroredprofiledef.htm">IfcMirroredProfileDef</a>
 */
public class IfcMirroredProfileDef extends IfcDerivedProfileDef {

    protected IfcMirroredProfileDef() { initCollections(); }
    /**
     * Constructs IfcMirroredProfileDef with all required attributes.
     */
    public IfcMirroredProfileDef(IfcProfileTypeEnum profileType,IfcProfileDef parentProfile,IfcCartesianTransformationOperator2D op) {

        super(profileType,parentProfile,op);
    }
    /**
     * Constructs IfcMirroredProfileDef with required and optional attributes.
     */
    public IfcMirroredProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcProfileDef parentProfile,IfcCartesianTransformationOperator2D op,IfcLabel label) {
        super(profileType,profileName,parentProfile,op,label);
    }
    private void initCollections() {
    }
    public IfcCartesianTransformationOperator2D getOperator() { throw new UnsupportedOperationException("Derived property logic has been implemented for Operator."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(parentProfile != null ? StepUtils.toStepValue(parentProfile) : "$");
		parameters.add("*");
		parameters.add(label != null ? StepUtils.toStepValue(label) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}