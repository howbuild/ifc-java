package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStyleModel
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStyledRepresentation))
 * SUBTYPE OF (IfcRepresentation);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstyledrepresentation.htm">IfcStyledRepresentation</a>
 */
public class IfcStyledRepresentation extends IfcStyleModel {

    protected IfcStyledRepresentation() { initCollections(); }
    /**
     * Constructs IfcStyledRepresentation with all required attributes.
     */
    public IfcStyledRepresentation(IfcRepresentationContext contextOfItems,Collection<IfcRepresentationItem> items) {

        super(contextOfItems,items);
    }
    /**
     * Constructs IfcStyledRepresentation with required and optional attributes.
     */
    public IfcStyledRepresentation(IfcRepresentationContext contextOfItems,IfcLabel representationIdentifier,IfcLabel representationType,Collection<IfcRepresentationItem> items) {
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