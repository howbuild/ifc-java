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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifchalfspacesolid.htm">IfcHalfSpaceSolid</a>
 */
public class IfcHalfSpaceSolid extends IfcGeometricRepresentationItem implements IfcBooleanOperand {
    protected IfcSurface baseSurface;
    protected IfcBoolean agreementFlag;

    protected IfcHalfSpaceSolid() { initCollections(); }
    /**
     * Constructs IfcHalfSpaceSolid with all required attributes.
     */
    public IfcHalfSpaceSolid(IfcSurface baseSurface,IfcBoolean agreementFlag) {
        super();
        this.baseSurface = baseSurface;
        this.agreementFlag = agreementFlag;
    }
    private void initCollections() {
    }
    public IfcSurface getBaseSurface() { return this.baseSurface; }
    public void setBaseSurface(IfcSurface value) { this.baseSurface = value; }
    public IfcBoolean getAgreementFlag() { return this.agreementFlag; }
    public void setAgreementFlag(IfcBoolean value) { this.agreementFlag = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(baseSurface != null ? StepUtils.toStepValue(baseSurface) : "$");
		parameters.add(agreementFlag != null ? StepUtils.toStepValue(agreementFlag) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}