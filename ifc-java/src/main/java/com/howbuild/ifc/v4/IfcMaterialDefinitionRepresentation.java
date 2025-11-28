package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialDefinitionRepresentation
 * SUBTYPE OF (IfcProductRepresentation);
 * RepresentedMaterial : IfcMaterial;
 * WHERE
 * OnlyStyledRepresentations : SIZEOF(QUERY(temp <* Representations |
 * (NOT('IFC4.IFCSTYLEDREPRESENTATION' IN TYPEOF(temp)))
 * )) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialdefinitionrepresentation.htm">IfcMaterialDefinitionRepresentation</a>
 */
public class IfcMaterialDefinitionRepresentation extends IfcProductRepresentation {
    protected IfcMaterial representedMaterial;

    protected IfcMaterialDefinitionRepresentation() { initCollections(); }
    /**
     * Constructs IfcMaterialDefinitionRepresentation with all required attributes.
     */
    public IfcMaterialDefinitionRepresentation(Collection<IfcRepresentation> representations,IfcMaterial representedMaterial) {

        super(representations);
        this.representedMaterial = representedMaterial;
    }
    /**
     * Constructs IfcMaterialDefinitionRepresentation with required and optional attributes.
     */
    public IfcMaterialDefinitionRepresentation(IfcLabel name,IfcText description,Collection<IfcRepresentation> representations,IfcMaterial representedMaterial) {
        super(name,description,representations);
        this.representedMaterial = representedMaterial;
    }
    private void initCollections() {
    }
    public IfcMaterial getRepresentedMaterial() { return this.representedMaterial; }
    public void setRepresentedMaterial(IfcMaterial value) { this.representedMaterial = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(representations != null ? StepUtils.toStepValue(representations) : "$");
		parameters.add(representedMaterial != null ? StepUtils.toStepValue(representedMaterial) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMaterialDefinitionRepresentationRelationship(); }
    private void setIfcMaterialDefinitionRepresentationRelationship() {
		if (this.representedMaterial != null) {
		    if (this.representedMaterial instanceof IfcMaterial)
		        ((IfcMaterial)this.representedMaterial).hasRepresentation.add(this);
		}
    }
}