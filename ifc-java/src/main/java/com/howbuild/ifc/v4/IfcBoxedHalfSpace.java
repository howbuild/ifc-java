package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoxedHalfSpace
 * SUBTYPE OF (IfcHalfSpaceSolid);
 * Enclosure : IfcBoundingBox;
 * WHERE
 * UnboundedSurface : NOT ('IFC4.IFCCURVEBOUNDEDPLANE' IN TYPEOF(SELF\IfcHalfSpaceSolid.BaseSurface));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboxedhalfspace.htm">IfcBoxedHalfSpace</a>
 */
public class IfcBoxedHalfSpace extends IfcHalfSpaceSolid {
    protected IfcBoundingBox enclosure;

    protected IfcBoxedHalfSpace() { initCollections(); }
    /**
     * Constructs IfcBoxedHalfSpace with all required attributes.
     */
    public IfcBoxedHalfSpace(IfcSurface baseSurface,IfcBoolean agreementFlag,IfcBoundingBox enclosure) {
        super(baseSurface,agreementFlag);
        this.enclosure = enclosure;
    }
    private void initCollections() {
    }
    public IfcBoundingBox getEnclosure() { return this.enclosure; }
    public void setEnclosure(IfcBoundingBox value) { this.enclosure = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(baseSurface != null ? StepUtils.toStepValue(baseSurface) : "$");
		parameters.add(agreementFlag != null ? StepUtils.toStepValue(agreementFlag) : "$");
		parameters.add(enclosure != null ? StepUtils.toStepValue(enclosure) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}