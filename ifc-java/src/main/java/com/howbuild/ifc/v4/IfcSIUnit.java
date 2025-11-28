package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcNamedUnit
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcContextDependentUnit
 * ,IfcConversionBasedUnit
 * ,IfcSIUnit));
 * Dimensions : IfcDimensionalExponents;
 * UnitType : IfcUnitEnum;
 * WHERE
 * WR1 : IfcCorrectDimensions (SELF.UnitType, SELF.Dimensions);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsiunit.htm">IfcSIUnit</a>
 */
public class IfcSIUnit extends IfcNamedUnit {
    protected IfcSIPrefix prefix;
    protected IfcSIUnitName name;

    protected IfcSIUnit() { initCollections(); }
    /**
     * Constructs IfcSIUnit with all required attributes.
     */
    public IfcSIUnit(IfcDimensionalExponents dimensions,IfcUnitEnum unitType,IfcSIUnitName name) {

        super(dimensions,unitType);
        this.name = name;
    }
    /**
     * Constructs IfcSIUnit with required and optional attributes.
     */
    public IfcSIUnit(IfcDimensionalExponents dimensions,IfcUnitEnum unitType,IfcSIPrefix prefix,IfcSIUnitName name) {
        super(dimensions,unitType);
        this.prefix = prefix;
        this.name = name;
    }
    private void initCollections() {
    }
    public IfcSIPrefix getPrefix() { return this.prefix; }
    public void setPrefix(IfcSIPrefix value) { this.prefix = value; } // optional
    public IfcSIUnitName getName() { return this.name; }
    public void setName(IfcSIUnitName value) { this.name = value; }
    public IfcDimensionalExponents getDimensions() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dimensions."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add("*");
		parameters.add(StepUtils.toStepValue(unitType));
		parameters.add(prefix != null ? StepUtils.toStepValue(prefix) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}