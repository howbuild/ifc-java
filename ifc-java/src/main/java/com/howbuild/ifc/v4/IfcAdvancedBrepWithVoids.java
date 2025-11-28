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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcadvancedbrepwithvoids.htm">IfcAdvancedBrepWithVoids</a>
 */
public class IfcAdvancedBrepWithVoids extends IfcAdvancedBrep {
    protected Collection<IfcClosedShell> voids;

    protected IfcAdvancedBrepWithVoids() { initCollections(); }
    /**
     * Constructs IfcAdvancedBrepWithVoids with all required attributes.
     */
    public IfcAdvancedBrepWithVoids(IfcClosedShell outer,Collection<IfcClosedShell> voids) {
        super(outer);
        this.voids = voids;
    }
    private void initCollections() {
        this.voids = new ArrayList<>();
    }
    public Collection<IfcClosedShell> getVoids() { return this.voids; }
    public void setVoids(Collection<IfcClosedShell> value) { this.voids = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(outer != null ? StepUtils.toStepValue(outer) : "$");
		parameters.add(voids != null ? StepUtils.toStepValue(voids) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}