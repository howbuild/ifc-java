package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialList;
 * Materials : LIST [1:?] OF IfcMaterial;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmateriallist.htm">IfcMaterialList</a>
 */
public class IfcMaterialList extends BaseIfc implements IfcMaterialSelect {
    protected Collection<IfcMaterial> materials;

    protected IfcMaterialList() { initCollections(); }
    /**
     * Constructs IfcMaterialList with all required attributes.
     */
    public IfcMaterialList(Collection<IfcMaterial> materials) {
        super();
        this.materials = materials;
    }
    private void initCollections() {
        this.materials = new ArrayList<>();
    }
    public Collection<IfcMaterial> getMaterials() { return this.materials; }
    public void setMaterials(Collection<IfcMaterial> value) { this.materials = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(materials != null ? StepUtils.toStepValue(materials) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}