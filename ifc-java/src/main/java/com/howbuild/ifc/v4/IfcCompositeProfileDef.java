package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCompositeProfileDef
 * SUBTYPE OF (IfcProfileDef);
 * Profiles : SET [2:?] OF IfcProfileDef;
 * Label : OPTIONAL IfcLabel;
 * WHERE
 * InvariantProfileType : SIZEOF(QUERY(temp <* Profiles | temp.ProfileType <> Profiles[1].ProfileType)) = 0;
 * NoRecursion : SIZEOF(QUERY(temp <* Profiles | 'IFC4.IFCCOMPOSITEPROFILEDEF' IN TYPEOF(temp))) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccompositeprofiledef.htm">IfcCompositeProfileDef</a>
 */
public class IfcCompositeProfileDef extends IfcProfileDef {
    protected Collection<IfcProfileDef> profiles;
    protected IfcLabel label;

    protected IfcCompositeProfileDef() { initCollections(); }
    /**
     * Constructs IfcCompositeProfileDef with all required attributes.
     */
    public IfcCompositeProfileDef(IfcProfileTypeEnum profileType,Collection<IfcProfileDef> profiles) {

        super(profileType);
        this.profiles = profiles;
    }
    /**
     * Constructs IfcCompositeProfileDef with required and optional attributes.
     */
    public IfcCompositeProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,Collection<IfcProfileDef> profiles,IfcLabel label) {
        super(profileType,profileName);
        this.profiles = profiles;
        this.label = label;
    }
    private void initCollections() {
        this.profiles = new ArrayList<>();
    }
    public Collection<IfcProfileDef> getProfiles() { return this.profiles; }
    public void setProfiles(Collection<IfcProfileDef> value) { this.profiles = value; }
    public IfcLabel getLabel() { return this.label; }
    public void setLabel(IfcLabel value) { this.label = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(profiles != null ? StepUtils.toStepValue(profiles) : "$");
		parameters.add(label != null ? StepUtils.toStepValue(label) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}