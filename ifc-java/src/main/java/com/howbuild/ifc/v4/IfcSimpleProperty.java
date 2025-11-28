package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcProperty
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcComplexProperty
 * ,IfcSimpleProperty))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * Name : IfcIdentifier;
 * Description : OPTIONAL IfcText;
 * INVERSE
 * PartOfPset : SET [0:?] OF IfcPropertySet FOR HasProperties;
 * PropertyForDependance : SET [0:?] OF IfcPropertyDependencyRelationship FOR DependingProperty;
 * PropertyDependsOn : SET [0:?] OF IfcPropertyDependencyRelationship FOR DependantProperty;
 * PartOfComplex : SET [0:?] OF IfcComplexProperty FOR HasProperties;
 * HasConstraints : SET [0:?] OF IfcResourceConstraintRelationship FOR RelatedResourceObjects;
 * HasApprovals : SET [0:?] OF IfcResourceApprovalRelationship FOR RelatedResourceObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsimpleproperty.htm">IfcSimpleProperty</a>
 */
public abstract class IfcSimpleProperty extends IfcProperty {

    protected IfcSimpleProperty() { initCollections(); }
    /**
     * Constructs IfcSimpleProperty with all required attributes.
     */
    public IfcSimpleProperty(IfcIdentifier name) {

        super(name);
    }
    /**
     * Constructs IfcSimpleProperty with required and optional attributes.
     */
    public IfcSimpleProperty(IfcIdentifier name,IfcText description) {
        super(name,description);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}