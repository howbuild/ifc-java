package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedProperties
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcementBarProperties
 * ,IfcSectionProperties
 * ,IfcSectionReinforcementProperties))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsectionproperties.htm">IfcSectionProperties</a>
 */
public class IfcSectionProperties extends IfcPreDefinedProperties {
    protected IfcSectionTypeEnum sectionType;
    protected IfcProfileDef startProfile;
    protected IfcProfileDef endProfile;

    protected IfcSectionProperties() { initCollections(); }
    /**
     * Constructs IfcSectionProperties with all required attributes.
     */
    public IfcSectionProperties(IfcSectionTypeEnum sectionType,IfcProfileDef startProfile) {

        super();
        this.sectionType = sectionType;
        this.startProfile = startProfile;
    }
    /**
     * Constructs IfcSectionProperties with required and optional attributes.
     */
    public IfcSectionProperties(IfcSectionTypeEnum sectionType,IfcProfileDef startProfile,IfcProfileDef endProfile) {
        super();
        this.sectionType = sectionType;
        this.startProfile = startProfile;
        this.endProfile = endProfile;
    }
    private void initCollections() {
    }
    public IfcSectionTypeEnum getSectionType() { return this.sectionType; }
    public void setSectionType(IfcSectionTypeEnum value) { this.sectionType = value; }
    public IfcProfileDef getStartProfile() { return this.startProfile; }
    public void setStartProfile(IfcProfileDef value) { this.startProfile = value; }
    public IfcProfileDef getEndProfile() { return this.endProfile; }
    public void setEndProfile(IfcProfileDef value) { this.endProfile = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(sectionType));
		parameters.add(startProfile != null ? StepUtils.toStepValue(startProfile) : "$");
		parameters.add(endProfile != null ? StepUtils.toStepValue(endProfile) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}