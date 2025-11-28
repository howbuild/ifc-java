package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAdvancedBrep
 * SUPERTYPE OF (ONEOF
 * (IfcAdvancedBrepWithVoids))
 * SUBTYPE OF (IfcManifoldSolidBrep);
 * WHERE
 * HasAdvancedFaces : SIZEOF(QUERY(Afs <* SELF\IfcManifoldSolidBrep.Outer.CfsFaces |
 * (NOT ('IFC4.IFCADVANCEDFACE' IN TYPEOF(Afs)))
 * )) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcadvancedbrep.htm">IfcAdvancedBrep</a>
 */
public class IfcAdvancedBrep extends IfcManifoldSolidBrep {

    protected IfcAdvancedBrep() { initCollections(); }
    /**
     * Constructs IfcAdvancedBrep with all required attributes.
     */
    public IfcAdvancedBrep(IfcClosedShell outer) {
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