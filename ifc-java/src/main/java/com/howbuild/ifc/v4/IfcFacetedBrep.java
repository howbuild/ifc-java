package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFacetedBrep
 * SUPERTYPE OF (ONEOF
 * (IfcFacetedBrepWithVoids))
 * SUBTYPE OF (IfcManifoldSolidBrep);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfacetedbrep.htm">IfcFacetedBrep</a>
 */
public class IfcFacetedBrep extends IfcManifoldSolidBrep {

    protected IfcFacetedBrep() { initCollections(); }
    /**
     * Constructs IfcFacetedBrep with all required attributes.
     */
    public IfcFacetedBrep(IfcClosedShell outer) {
        super(outer);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(outer != null ? StepUtils.toStepValue(outer) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}