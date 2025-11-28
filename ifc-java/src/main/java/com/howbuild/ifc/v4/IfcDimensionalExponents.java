package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDimensionalExponents;
 * LengthExponent : INTEGER;
 * MassExponent : INTEGER;
 * TimeExponent : INTEGER;
 * ElectricCurrentExponent : INTEGER;
 * ThermodynamicTemperatureExponent : INTEGER;
 * AmountOfSubstanceExponent : INTEGER;
 * LuminousIntensityExponent : INTEGER;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdimensionalexponents.htm">IfcDimensionalExponents</a>
 */
public class IfcDimensionalExponents extends BaseIfc {
    protected Long lengthExponent;
    protected Long massExponent;
    protected Long timeExponent;
    protected Long electricCurrentExponent;
    protected Long thermodynamicTemperatureExponent;
    protected Long amountOfSubstanceExponent;
    protected Long luminousIntensityExponent;

    protected IfcDimensionalExponents() { initCollections(); }
    /**
     * Constructs IfcDimensionalExponents with all required attributes.
     */
    public IfcDimensionalExponents(Long lengthExponent,Long massExponent,Long timeExponent,Long electricCurrentExponent,Long thermodynamicTemperatureExponent,Long amountOfSubstanceExponent,Long luminousIntensityExponent) {
        super();
        this.lengthExponent = lengthExponent;
        this.massExponent = massExponent;
        this.timeExponent = timeExponent;
        this.electricCurrentExponent = electricCurrentExponent;
        this.thermodynamicTemperatureExponent = thermodynamicTemperatureExponent;
        this.amountOfSubstanceExponent = amountOfSubstanceExponent;
        this.luminousIntensityExponent = luminousIntensityExponent;
    }
    private void initCollections() {
    }
    public Long getLengthExponent() { return this.lengthExponent; }
    public void setLengthExponent(Long value) { this.lengthExponent = value; }
    public Long getMassExponent() { return this.massExponent; }
    public void setMassExponent(Long value) { this.massExponent = value; }
    public Long getTimeExponent() { return this.timeExponent; }
    public void setTimeExponent(Long value) { this.timeExponent = value; }
    public Long getElectricCurrentExponent() { return this.electricCurrentExponent; }
    public void setElectricCurrentExponent(Long value) { this.electricCurrentExponent = value; }
    public Long getThermodynamicTemperatureExponent() { return this.thermodynamicTemperatureExponent; }
    public void setThermodynamicTemperatureExponent(Long value) { this.thermodynamicTemperatureExponent = value; }
    public Long getAmountOfSubstanceExponent() { return this.amountOfSubstanceExponent; }
    public void setAmountOfSubstanceExponent(Long value) { this.amountOfSubstanceExponent = value; }
    public Long getLuminousIntensityExponent() { return this.luminousIntensityExponent; }
    public void setLuminousIntensityExponent(Long value) { this.luminousIntensityExponent = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(lengthExponent != null ? StepUtils.toStepValue(lengthExponent) : "$");
		parameters.add(massExponent != null ? StepUtils.toStepValue(massExponent) : "$");
		parameters.add(timeExponent != null ? StepUtils.toStepValue(timeExponent) : "$");
		parameters.add(electricCurrentExponent != null ? StepUtils.toStepValue(electricCurrentExponent) : "$");
		parameters.add(thermodynamicTemperatureExponent != null ? StepUtils.toStepValue(thermodynamicTemperatureExponent) : "$");
		parameters.add(amountOfSubstanceExponent != null ? StepUtils.toStepValue(amountOfSubstanceExponent) : "$");
		parameters.add(luminousIntensityExponent != null ? StepUtils.toStepValue(luminousIntensityExponent) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}