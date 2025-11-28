package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEdgeLoop
 * SUBTYPE OF (IfcLoop);
 * EdgeList : LIST [1:?] OF IfcOrientedEdge;
 * DERIVE
 * Ne : IfcInteger := SIZEOF(EdgeList);
 * WHERE
 * IsClosed : (EdgeList[1].EdgeStart) :=: (EdgeList[Ne].EdgeEnd);
 * IsContinuous : IfcLoopHeadToTail(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcloop.htm">IfcLoop</a>
 */
public class IfcLoop extends IfcTopologicalRepresentationItem {


    /**
     * Constructs IfcLoop with all required attributes.
     */
    public IfcLoop() {
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