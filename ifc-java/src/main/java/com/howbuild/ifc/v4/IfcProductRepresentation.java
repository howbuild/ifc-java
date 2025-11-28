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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproductrepresentation.htm">IfcProductRepresentation</a>
 */
public abstract class IfcProductRepresentation extends BaseIfc {
    protected IfcLabel name;
    protected IfcText description;
    protected Collection<IfcRepresentation> representations;

    protected IfcProductRepresentation() { initCollections(); }
    /**
     * Constructs IfcProductRepresentation with all required attributes.
     */
    public IfcProductRepresentation(Collection<IfcRepresentation> representations) {

        super();
        this.representations = representations;
    }
    /**
     * Constructs IfcProductRepresentation with required and optional attributes.
     */
    public IfcProductRepresentation(IfcLabel name,IfcText description,Collection<IfcRepresentation> representations) {
        super();
        this.name = name;
        this.description = description;
        this.representations = representations;
    }
    private void initCollections() {
        this.representations = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcRepresentation> getRepresentations() { return this.representations; }
    public void setRepresentations(Collection<IfcRepresentation> value) { this.representations = value; }


    @Override public void finalizeRelationships() { this.setIfcProductRepresentationRelationship(); }
    private void setIfcProductRepresentationRelationship() {
		if (this.representations != null) {
		    for (Object x : this.representations) {
		        if (x instanceof IfcRepresentation)
		            ((IfcRepresentation)x).ofProductRepresentation.add(this);
		    }
		}
    }
}