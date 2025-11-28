package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDerivedUnitElement;
 * Unit : IfcNamedUnit;
 * Exponent : INTEGER;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcderivedunitelement.htm">IfcDerivedUnitElement</a>
 */
public class IfcDerivedUnitElement extends BaseIfc {
    protected IfcNamedUnit unit;
    protected Long exponent;

    protected IfcDerivedUnitElement() { initCollections(); }
    /**
     * Constructs IfcDerivedUnitElement with all required attributes.
     */
    public IfcDerivedUnitElement(IfcNamedUnit unit,Long exponent) {
        super();
        this.unit = unit;
        this.exponent = exponent;
    }
    private void initCollections() {
    }
    public IfcNamedUnit getUnit() { return this.unit; }
    public void setUnit(IfcNamedUnit value) { this.unit = value; }
    public Long getExponent() { return this.exponent; }
    public void setExponent(Long value) { this.exponent = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(exponent != null ? StepUtils.toStepValue(exponent) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}