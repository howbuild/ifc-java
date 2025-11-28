package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcClassificationReference
 * SUBTYPE OF (IfcExternalReference);
 * ReferencedSource : OPTIONAL IfcClassificationReferenceSelect;
 * Description : OPTIONAL IfcText;
 * Sort : OPTIONAL IfcIdentifier;
 * INVERSE
 * ClassificationRefForObjects : SET [0:?] OF IfcRelAssociatesClassification FOR RelatingClassification;
 * HasReferences : SET [0:?] OF IfcClassificationReference FOR ReferencedSource;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcexternalreference.htm">IfcExternalReference</a>
 */
public abstract class IfcExternalReference extends BaseIfc implements IfcResourceObjectSelect, IfcObjectReferenceSelect, IfcLightDistributionDataSourceSelect {
    protected IfcURIReference location;
    protected IfcIdentifier identification;
    protected IfcLabel name;
    protected Collection<IfcExternalReferenceRelationship> externalReferenceForResources;


    /**
     * Constructs IfcExternalReference with all required attributes.
     */
    public IfcExternalReference() {

        super();
        this.externalReferenceForResources = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcExternalReference with required and optional attributes.
     */
    public IfcExternalReference(IfcURIReference location,IfcIdentifier identification,IfcLabel name) {
        super();
        this.externalReferenceForResources = new ArrayList<>();
        this.location = location;
        this.identification = identification;
        this.name = name;
    }
    private void initCollections() {
        this.externalReferenceForResources = new ArrayList<>();
    }
    public IfcURIReference getLocation() { return this.location; }
    public void setLocation(IfcURIReference value) { this.location = value; } // optional
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getExternalReferenceForResources() { return this.externalReferenceForResources; }
    public void setExternalReferenceForResources(Collection<IfcExternalReferenceRelationship> value) { this.externalReferenceForResources = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}