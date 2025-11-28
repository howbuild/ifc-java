package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundedCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineCurve
 * ,IfcCompositeCurve
 * ,IfcIndexedPolyCurve
 * ,IfcPolyline
 * ,IfcTrimmedCurve))
 * SUBTYPE OF (IfcCurve);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctrimmedcurve.htm">IfcTrimmedCurve</a>
 */
public class IfcTrimmedCurve extends IfcBoundedCurve {
    protected IfcCurve basisCurve;
    protected Collection<IfcTrimmingSelect> trim1;
    protected Collection<IfcTrimmingSelect> trim2;
    protected IfcBoolean senseAgreement;
    protected IfcTrimmingPreference masterRepresentation;

    protected IfcTrimmedCurve() { initCollections(); }
    /**
     * Constructs IfcTrimmedCurve with all required attributes.
     */
    public IfcTrimmedCurve(IfcCurve basisCurve,Collection<IfcTrimmingSelect> trim1,Collection<IfcTrimmingSelect> trim2,IfcBoolean senseAgreement,IfcTrimmingPreference masterRepresentation) {
        super();
        this.basisCurve = basisCurve;
        this.trim1 = trim1;
        this.trim2 = trim2;
        this.senseAgreement = senseAgreement;
        this.masterRepresentation = masterRepresentation;
    }
    private void initCollections() {
        this.trim1 = new ArrayList<>();
        this.trim2 = new ArrayList<>();
    }
    public IfcCurve getBasisCurve() { return this.basisCurve; }
    public void setBasisCurve(IfcCurve value) { this.basisCurve = value; }
    public Collection<IfcTrimmingSelect> getTrim1() { return this.trim1; }
    public void setTrim1(Collection<IfcTrimmingSelect> value) { this.trim1 = value; }
    public Collection<IfcTrimmingSelect> getTrim2() { return this.trim2; }
    public void setTrim2(Collection<IfcTrimmingSelect> value) { this.trim2 = value; }
    public IfcBoolean getSenseAgreement() { return this.senseAgreement; }
    public void setSenseAgreement(IfcBoolean value) { this.senseAgreement = value; }
    public IfcTrimmingPreference getMasterRepresentation() { return this.masterRepresentation; }
    public void setMasterRepresentation(IfcTrimmingPreference value) { this.masterRepresentation = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(basisCurve != null ? StepUtils.toStepValue(basisCurve) : "$");
		parameters.add(trim1 != null ? StepUtils.toStepValue(trim1) : "$");
		parameters.add(trim2 != null ? StepUtils.toStepValue(trim2) : "$");
		parameters.add(senseAgreement != null ? StepUtils.toStepValue(senseAgreement) : "$");
		parameters.add(masterRepresentation != null ? StepUtils.toStepValue(masterRepresentation) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}