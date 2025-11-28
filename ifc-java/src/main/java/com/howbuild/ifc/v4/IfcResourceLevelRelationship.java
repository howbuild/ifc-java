package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcApprovalRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingApproval : IfcApproval;
 * RelatedApprovals : SET [1:?] OF IfcApproval;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcresourcelevelrelationship.htm">IfcResourceLevelRelationship</a>
 */
public abstract class IfcResourceLevelRelationship extends BaseIfc {
    protected IfcLabel name;
    protected IfcText description;


    /**
     * Constructs IfcResourceLevelRelationship with all required attributes.
     */
    public IfcResourceLevelRelationship() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcResourceLevelRelationship with required and optional attributes.
     */
    public IfcResourceLevelRelationship(IfcLabel name,IfcText description) {
        super();
        this.name = name;
        this.description = description;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}