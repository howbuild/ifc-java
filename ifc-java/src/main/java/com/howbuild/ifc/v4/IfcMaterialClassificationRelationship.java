package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialClassificationRelationship;
 * MaterialClassifications : SET [1:?] OF IfcClassificationSelect;
 * ClassifiedMaterial : IfcMaterial;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialclassificationrelationship.htm">IfcMaterialClassificationRelationship</a>
 */
public class IfcMaterialClassificationRelationship extends BaseIfc {
    protected Collection<IfcClassificationSelect> materialClassifications;
    protected IfcMaterial classifiedMaterial;

    protected IfcMaterialClassificationRelationship() { initCollections(); }
    /**
     * Constructs IfcMaterialClassificationRelationship with all required attributes.
     */
    public IfcMaterialClassificationRelationship(Collection<IfcClassificationSelect> materialClassifications,IfcMaterial classifiedMaterial) {
        super();
        this.materialClassifications = materialClassifications;
        this.classifiedMaterial = classifiedMaterial;
    }
    private void initCollections() {
        this.materialClassifications = new ArrayList<>();
    }
    public Collection<IfcClassificationSelect> getMaterialClassifications() { return this.materialClassifications; }
    public void setMaterialClassifications(Collection<IfcClassificationSelect> value) { this.materialClassifications = value; }
    public IfcMaterial getClassifiedMaterial() { return this.classifiedMaterial; }
    public void setClassifiedMaterial(IfcMaterial value) { this.classifiedMaterial = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(materialClassifications != null ? StepUtils.toStepValue(materialClassifications) : "$");
		parameters.add(classifiedMaterial != null ? StepUtils.toStepValue(classifiedMaterial) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}