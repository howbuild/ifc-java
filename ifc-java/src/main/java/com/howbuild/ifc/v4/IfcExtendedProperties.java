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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcextendedproperties.htm">IfcExtendedProperties</a>
 */
public abstract class IfcExtendedProperties extends IfcPropertyAbstraction {
    protected IfcIdentifier name;
    protected IfcText description;
    protected Collection<IfcProperty> properties;

    protected IfcExtendedProperties() { initCollections(); }
    /**
     * Constructs IfcExtendedProperties with all required attributes.
     */
    public IfcExtendedProperties(Collection<IfcProperty> properties) {

        super();
        this.properties = properties;
    }
    /**
     * Constructs IfcExtendedProperties with required and optional attributes.
     */
    public IfcExtendedProperties(IfcIdentifier name,IfcText description,Collection<IfcProperty> properties) {
        super();
        this.name = name;
        this.description = description;
        this.properties = properties;
    }
    private void initCollections() {
        this.properties = new ArrayList<>();
    }
    public IfcIdentifier getName() { return this.name; }
    public void setName(IfcIdentifier value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcProperty> getProperties() { return this.properties; }
    public void setProperties(Collection<IfcProperty> value) { this.properties = value; }


    // inherits no-op finalizeRelationships from BaseIfc

}