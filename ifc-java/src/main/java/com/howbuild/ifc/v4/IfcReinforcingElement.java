package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementComponent
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBuildingElementPart
 * ,IfcDiscreteAccessory
 * ,IfcFastener
 * ,IfcMechanicalFastener
 * ,IfcReinforcingElement
 * ,IfcVibrationIsolator))
 * SUBTYPE OF (IfcElement);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcingelement.htm">IfcReinforcingElement</a>
 */
public abstract class IfcReinforcingElement extends IfcElementComponent {
    protected IfcLabel steelGrade;

    protected IfcReinforcingElement() { initCollections(); }
    /**
     * Constructs IfcReinforcingElement with all required attributes.
     */
    public IfcReinforcingElement(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcReinforcingElement with required and optional attributes.
     */
    public IfcReinforcingElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcIdentifier tag,IfcLabel steelGrade) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,tag);
        this.steelGrade = steelGrade;
    }
    private void initCollections() {
    }
    public IfcLabel getSteelGrade() { return this.steelGrade; }
    public void setSteelGrade(IfcLabel value) { this.steelGrade = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}