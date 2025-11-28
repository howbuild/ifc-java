package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterial
 * SUBTYPE OF (IfcMaterialDefinition);
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * Category : OPTIONAL IfcLabel;
 * INVERSE
 * HasRepresentation : SET [0:1] OF IfcMaterialDefinitionRepresentation FOR RepresentedMaterial;
 * IsRelatedWith : SET [0:?] OF IfcMaterialRelationship FOR RelatedMaterials;
 * RelatesTo : SET [0:1] OF IfcMaterialRelationship FOR RelatingMaterial;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialdefinition.htm">IfcMaterialDefinition</a>
 */
public abstract class IfcMaterialDefinition extends BaseIfc implements IfcResourceObjectSelect, IfcObjectReferenceSelect, IfcMaterialSelect {
    protected Collection<IfcRelAssociatesMaterial> associatedTo;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReferences;
    protected Collection<IfcMaterialProperties> hasProperties;


    /**
     * Constructs IfcMaterialDefinition with all required attributes.
     */
    public IfcMaterialDefinition() {
        super();
        this.associatedTo = new ArrayList<>();
        this.hasExternalReferences = new ArrayList<>();
        this.hasProperties = new ArrayList<>();
        initCollections();
    }
    private void initCollections() {
        this.associatedTo = new ArrayList<>();
        this.hasExternalReferences = new ArrayList<>();
        this.hasProperties = new ArrayList<>();
    }
    public Collection<IfcRelAssociatesMaterial> getAssociatedTo() { return this.associatedTo; }
    public void setAssociatedTo(Collection<IfcRelAssociatesMaterial> value) { this.associatedTo = value; } // inverse
    public Collection<IfcExternalReferenceRelationship> getHasExternalReferences() { return this.hasExternalReferences; }
    public void setHasExternalReferences(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReferences = value; } // inverse
    public Collection<IfcMaterialProperties> getHasProperties() { return this.hasProperties; }
    public void setHasProperties(Collection<IfcMaterialProperties> value) { this.hasProperties = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}