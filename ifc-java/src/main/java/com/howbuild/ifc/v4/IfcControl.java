package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActionRequest
 * SUBTYPE OF (IfcControl);
 * PredefinedType : OPTIONAL IfcActionRequestTypeEnum;
 * Status : OPTIONAL IfcLabel;
 * LongDescription : OPTIONAL IfcText;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccontrol.htm">IfcControl</a>
 */
public abstract class IfcControl extends IfcObject {
    protected IfcIdentifier identification;
    protected Collection<IfcRelAssignsToControl> controls;

    protected IfcControl() { initCollections(); }
    /**
     * Constructs IfcControl with all required attributes.
     */
    public IfcControl(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.controls = new ArrayList<>();
    }
    /**
     * Constructs IfcControl with required and optional attributes.
     */
    public IfcControl(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification) {
        super(globalId,ownerHistory,name,description,objectType);
        this.controls = new ArrayList<>();
        this.identification = identification;
    }
    private void initCollections() {
        this.controls = new ArrayList<>();
    }
    public IfcIdentifier getIdentification() { return this.identification; }
    public void setIdentification(IfcIdentifier value) { this.identification = value; } // optional
    public Collection<IfcRelAssignsToControl> getControls() { return this.controls; }
    public void setControls(Collection<IfcRelAssignsToControl> value) { this.controls = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}