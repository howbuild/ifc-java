package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFeatureElement
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcFeatureElementAddition
 * ,IfcFeatureElementSubtraction
 * ,IfcSurfaceFeature))
 * SUBTYPE OF (IfcElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfeatureelementsubtraction.htm">IfcFeatureElementSubtraction</a>
 */
public abstract class IfcFeatureElementSubtraction extends IfcFeatureElement {
    protected IfcRelVoidsElement voidsElements;

    protected IfcFeatureElementSubtraction() { initCollections(); }
    /**
     * Constructs IfcFeatureElementSubtraction with all required attributes.
     */
    public IfcFeatureElementSubtraction(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFeatureElementSubtraction with required and optional attributes.
     */
    public IfcFeatureElementSubtraction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
    }
    private void initCollections() {
    }
    public IfcRelVoidsElement getVoidsElements() { return this.voidsElements; }
    public void setVoidsElements(IfcRelVoidsElement value) { this.voidsElements = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}