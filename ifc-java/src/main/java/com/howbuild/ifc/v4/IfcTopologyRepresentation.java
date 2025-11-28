package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcShapeModel
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcShapeRepresentation
 * ,IfcTopologyRepresentation))
 * SUBTYPE OF (IfcRepresentation);
 * INVERSE
 * OfShapeAspect : SET [0:1] OF IfcShapeAspect FOR ShapeRepresentations;
 * WHERE
 * WR11 : (SIZEOF(SELF\IfcRepresentation.OfProductRepresentation) = 1) XOR
 * (SIZEOF(SELF\IfcRepresentation.RepresentationMap) = 1) XOR
 * (SIZEOF(OfShapeAspect) = 1);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctopologyrepresentation.htm">IfcTopologyRepresentation</a>
 */
public class IfcTopologyRepresentation extends IfcShapeModel {

    protected IfcTopologyRepresentation() { initCollections(); }
    /**
     * Constructs IfcTopologyRepresentation with all required attributes.
     */
    public IfcTopologyRepresentation(IfcRepresentationContext contextOfItems,Collection<IfcRepresentationItem> items) {

        super(contextOfItems,items);
    }
    /**
     * Constructs IfcTopologyRepresentation with required and optional attributes.
     */
    public IfcTopologyRepresentation(IfcRepresentationContext contextOfItems,IfcLabel representationIdentifier,IfcLabel representationType,Collection<IfcRepresentationItem> items) {
        super(contextOfItems,representationIdentifier,representationType,items);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(contextOfItems != null ? StepUtils.toStepValue(contextOfItems) : "$");
		parameters.add(representationIdentifier != null ? StepUtils.toStepValue(representationIdentifier) : "$");
		parameters.add(representationType != null ? StepUtils.toStepValue(representationType) : "$");
		parameters.add(items != null ? StepUtils.toStepValue(items) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}