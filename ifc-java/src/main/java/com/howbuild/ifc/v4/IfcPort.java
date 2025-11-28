package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDistributionPort
 * SUBTYPE OF (IfcPort);
 * FlowDirection : OPTIONAL IfcFlowDirectionEnum;
 * PredefinedType : OPTIONAL IfcDistributionPortTypeEnum;
 * SystemType : OPTIONAL IfcDistributionSystemEnum;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcport.htm">IfcPort</a>
 */
public abstract class IfcPort extends IfcProduct {
    protected Collection<IfcRelConnectsPortToElement> containedIn;
    protected Collection<IfcRelConnectsPorts> connectedFrom;
    protected Collection<IfcRelConnectsPorts> connectedTo;

    protected IfcPort() { initCollections(); }
    /**
     * Constructs IfcPort with all required attributes.
     */
    public IfcPort(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.containedIn = new ArrayList<>();
        this.connectedFrom = new ArrayList<>();
        this.connectedTo = new ArrayList<>();
    }
    /**
     * Constructs IfcPort with required and optional attributes.
     */
    public IfcPort(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.containedIn = new ArrayList<>();
        this.connectedFrom = new ArrayList<>();
        this.connectedTo = new ArrayList<>();
    }
    private void initCollections() {
        this.containedIn = new ArrayList<>();
        this.connectedFrom = new ArrayList<>();
        this.connectedTo = new ArrayList<>();
    }
    public Collection<IfcRelConnectsPortToElement> getContainedIn() { return this.containedIn; }
    public void setContainedIn(Collection<IfcRelConnectsPortToElement> value) { this.containedIn = value; } // inverse
    public Collection<IfcRelConnectsPorts> getConnectedFrom() { return this.connectedFrom; }
    public void setConnectedFrom(Collection<IfcRelConnectsPorts> value) { this.connectedFrom = value; } // inverse
    public Collection<IfcRelConnectsPorts> getConnectedTo() { return this.connectedTo; }
    public void setConnectedTo(Collection<IfcRelConnectsPorts> value) { this.connectedTo = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}