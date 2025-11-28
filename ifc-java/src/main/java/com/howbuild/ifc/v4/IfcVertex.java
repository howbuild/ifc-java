package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTopologicalRepresentationItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcConnectedFaceSet
 * ,IfcEdge
 * ,IfcFace
 * ,IfcFaceBound
 * ,IfcLoop
 * ,IfcPath
 * ,IfcVertex))
 * SUBTYPE OF (IfcRepresentationItem);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvertex.htm">IfcVertex</a>
 */
public class IfcVertex extends IfcTopologicalRepresentationItem {


    /**
     * Constructs IfcVertex with all required attributes.
     */
    public IfcVertex() {
        super();
        initCollections();
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}