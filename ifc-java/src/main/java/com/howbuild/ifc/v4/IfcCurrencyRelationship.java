package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurrencyRelationship
 * SUBTYPE OF (IfcResourceLevelRelationship);
 * RelatingMonetaryUnit : IfcMonetaryUnit;
 * RelatedMonetaryUnit : IfcMonetaryUnit;
 * ExchangeRate : IfcPositiveRatioMeasure;
 * RateDateTime : OPTIONAL IfcDateTime;
 * RateSource : OPTIONAL IfcLibraryInformation;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurrencyrelationship.htm">IfcCurrencyRelationship</a>
 */
public class IfcCurrencyRelationship extends IfcResourceLevelRelationship {
    protected IfcMonetaryUnit relatingMonetaryUnit;
    protected IfcMonetaryUnit relatedMonetaryUnit;
    protected IfcPositiveRatioMeasure exchangeRate;
    protected IfcDateTime rateDateTime;
    protected IfcLibraryInformation rateSource;

    protected IfcCurrencyRelationship() { initCollections(); }
    /**
     * Constructs IfcCurrencyRelationship with all required attributes.
     */
    public IfcCurrencyRelationship(IfcMonetaryUnit relatingMonetaryUnit,IfcMonetaryUnit relatedMonetaryUnit,IfcPositiveRatioMeasure exchangeRate) {

        super();
        this.relatingMonetaryUnit = relatingMonetaryUnit;
        this.relatedMonetaryUnit = relatedMonetaryUnit;
        this.exchangeRate = exchangeRate;
    }
    /**
     * Constructs IfcCurrencyRelationship with required and optional attributes.
     */
    public IfcCurrencyRelationship(IfcLabel name,IfcText description,IfcMonetaryUnit relatingMonetaryUnit,IfcMonetaryUnit relatedMonetaryUnit,IfcPositiveRatioMeasure exchangeRate,IfcDateTime rateDateTime,IfcLibraryInformation rateSource) {
        super(name,description);
        this.relatingMonetaryUnit = relatingMonetaryUnit;
        this.relatedMonetaryUnit = relatedMonetaryUnit;
        this.exchangeRate = exchangeRate;
        this.rateDateTime = rateDateTime;
        this.rateSource = rateSource;
    }
    private void initCollections() {
    }
    public IfcMonetaryUnit getRelatingMonetaryUnit() { return this.relatingMonetaryUnit; }
    public void setRelatingMonetaryUnit(IfcMonetaryUnit value) { this.relatingMonetaryUnit = value; }
    public IfcMonetaryUnit getRelatedMonetaryUnit() { return this.relatedMonetaryUnit; }
    public void setRelatedMonetaryUnit(IfcMonetaryUnit value) { this.relatedMonetaryUnit = value; }
    public IfcPositiveRatioMeasure getExchangeRate() { return this.exchangeRate; }
    public void setExchangeRate(IfcPositiveRatioMeasure value) { this.exchangeRate = value; }
    public IfcDateTime getRateDateTime() { return this.rateDateTime; }
    public void setRateDateTime(IfcDateTime value) { this.rateDateTime = value; } // optional
    public IfcLibraryInformation getRateSource() { return this.rateSource; }
    public void setRateSource(IfcLibraryInformation value) { this.rateSource = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingMonetaryUnit != null ? StepUtils.toStepValue(relatingMonetaryUnit) : "$");
		parameters.add(relatedMonetaryUnit != null ? StepUtils.toStepValue(relatedMonetaryUnit) : "$");
		parameters.add(exchangeRate != null ? StepUtils.toStepValue(exchangeRate) : "$");
		parameters.add(rateDateTime != null ? StepUtils.toStepValue(rateDateTime) : "$");
		parameters.add(rateSource != null ? StepUtils.toStepValue(rateSource) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}