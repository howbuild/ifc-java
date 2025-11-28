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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmanifoldsolidbrep.htm">IfcManifoldSolidBrep</a>
 */
public abstract class IfcManifoldSolidBrep extends IfcSolidModel {
    protected IfcClosedShell outer;

    protected IfcManifoldSolidBrep() { initCollections(); }
    /**
     * Constructs IfcManifoldSolidBrep with all required attributes.
     */
    public IfcManifoldSolidBrep(IfcClosedShell outer) {
        super();
        this.outer = outer;
    }
    private void initCollections() {
    }
    public IfcClosedShell getOuter() { return this.outer; }
    public void setOuter(IfcClosedShell value) { this.outer = value; }


    // inherits no-op finalizeRelationships from BaseIfc

}