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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcderivedprofiledef.htm">IfcDerivedProfileDef</a>
 */
public class IfcDerivedProfileDef extends IfcProfileDef {
    protected IfcProfileDef parentProfile;
    protected IfcCartesianTransformationOperator2D operator;
    protected IfcLabel label;

    protected IfcDerivedProfileDef() { initCollections(); }
    /**
     * Constructs IfcDerivedProfileDef with all required attributes.
     */
    public IfcDerivedProfileDef(IfcProfileTypeEnum profileType,IfcProfileDef parentProfile,IfcCartesianTransformationOperator2D op) {

        super(profileType);
        this.parentProfile = parentProfile;
        this.operator = op;
    }
    /**
     * Constructs IfcDerivedProfileDef with required and optional attributes.
     */
    public IfcDerivedProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcProfileDef parentProfile,IfcCartesianTransformationOperator2D op,IfcLabel label) {
        super(profileType,profileName);
        this.parentProfile = parentProfile;
        this.operator = op;
        this.label = label;
    }
    private void initCollections() {
    }
    public IfcProfileDef getParentProfile() { return this.parentProfile; }
    public void setParentProfile(IfcProfileDef value) { this.parentProfile = value; }
    public IfcCartesianTransformationOperator2D getOperator() { return this.operator; }
    public void setOperator(IfcCartesianTransformationOperator2D value) { this.operator = value; }
    public IfcLabel getLabel() { return this.label; }
    public void setLabel(IfcLabel value) { this.label = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(parentProfile != null ? StepUtils.toStepValue(parentProfile) : "$");
		parameters.add(operator != null ? StepUtils.toStepValue(operator) : "$");
		parameters.add(label != null ? StepUtils.toStepValue(label) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}