package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialProfile
 * SUPERTYPE OF (ONEOF
 * (IfcMaterialProfileWithOffsets))
 * SUBTYPE OF (IfcMaterialDefinition);
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * Material : OPTIONAL IfcMaterial;
 * Profile : IfcProfileDef;
 * Priority : OPTIONAL IfcInteger;
 * Category : OPTIONAL IfcLabel;
 * INVERSE
 * ToMaterialProfileSet : IfcMaterialProfileSet FOR MaterialProfiles;
 * WHERE
 * NormalizedPriority : NOT(EXISTS(Priority)) OR {0 <= Priority <= 100};
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialprofilewithoffsets.htm">IfcMaterialProfileWithOffsets</a>
 */
public class IfcMaterialProfileWithOffsets extends IfcMaterialProfile {
    protected Collection<IfcLengthMeasure> offsetValues;

    protected IfcMaterialProfileWithOffsets() { initCollections(); }
    /**
     * Constructs IfcMaterialProfileWithOffsets with all required attributes.
     */
    public IfcMaterialProfileWithOffsets(IfcProfileDef profile,Collection<IfcLengthMeasure> offsetValues) {

        super(profile);
        this.offsetValues = offsetValues;
    }
    /**
     * Constructs IfcMaterialProfileWithOffsets with required and optional attributes.
     */
    public IfcMaterialProfileWithOffsets(IfcLabel name,IfcText description,IfcMaterial material,IfcProfileDef profile,IfcInteger priority,IfcLabel category,Collection<IfcLengthMeasure> offsetValues) {
        super(name,description,material,profile,priority,category);
        this.offsetValues = offsetValues;
    }
    private void initCollections() {
        this.offsetValues = new ArrayList<>();
    }
    public Collection<IfcLengthMeasure> getOffsetValues() { return this.offsetValues; }
    public void setOffsetValues(Collection<IfcLengthMeasure> value) { this.offsetValues = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(material != null ? StepUtils.toStepValue(material) : "$");
		parameters.add(profile != null ? StepUtils.toStepValue(profile) : "$");
		parameters.add(priority != null ? StepUtils.toStepValue(priority) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
		parameters.add(offsetValues != null ? StepUtils.toStepValue(offsetValues) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}