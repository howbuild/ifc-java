package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExtendedProperties
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMaterialProperties
 * ,IfcProfileProperties))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * Name : OPTIONAL IfcIdentifier;
 * Description : OPTIONAL IfcText;
 * Properties : SET [1:?] OF IfcProperty;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertyabstraction.htm">IfcPropertyAbstraction</a>
 */
public abstract class IfcPropertyAbstraction extends BaseIfc implements IfcResourceObjectSelect {
    protected Collection<IfcExternalReferenceRelationship> hasExternalReferences;


    /**
     * Constructs IfcPropertyAbstraction with all required attributes.
     */
    public IfcPropertyAbstraction() {
        super();
        this.hasExternalReferences = new ArrayList<>();
        initCollections();
    }
    private void initCollections() {
        this.hasExternalReferences = new ArrayList<>();
    }
    public Collection<IfcExternalReferenceRelationship> getHasExternalReferences() { return this.hasExternalReferences; }
    public void setHasExternalReferences(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReferences = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}