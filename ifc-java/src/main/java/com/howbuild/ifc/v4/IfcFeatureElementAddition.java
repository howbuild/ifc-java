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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfeatureelementaddition.htm">IfcFeatureElementAddition</a>
 */
public abstract class IfcFeatureElementAddition extends IfcFeatureElement {
    protected IfcRelProjectsElement projectsElements;

    protected IfcFeatureElementAddition() { initCollections(); }
    /**
     * Constructs IfcFeatureElementAddition with all required attributes.
     */
    public IfcFeatureElementAddition(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcFeatureElementAddition with required and optional attributes.
     */
    public IfcFeatureElementAddition(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
    }
    private void initCollections() {
    }
    public IfcRelProjectsElement getProjectsElements() { return this.projectsElements; }
    public void setProjectsElements(IfcRelProjectsElement value) { this.projectsElements = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}