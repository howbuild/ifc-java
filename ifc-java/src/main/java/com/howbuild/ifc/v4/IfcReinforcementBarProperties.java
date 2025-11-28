package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedProperties
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcReinforcementBarProperties
 * ,IfcSectionProperties
 * ,IfcSectionReinforcementProperties))
 * SUBTYPE OF (IfcPropertyAbstraction);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreinforcementbarproperties.htm">IfcReinforcementBarProperties</a>
 */
public class IfcReinforcementBarProperties extends IfcPreDefinedProperties {
    protected IfcAreaMeasure totalCrossSectionArea;
    protected IfcLabel steelGrade;
    protected IfcReinforcingBarSurfaceEnum barSurface;
    protected IfcLengthMeasure effectiveDepth;
    protected IfcPositiveLengthMeasure nominalBarDiameter;
    protected IfcCountMeasure barCount;

    protected IfcReinforcementBarProperties() { initCollections(); }
    /**
     * Constructs IfcReinforcementBarProperties with all required attributes.
     */
    public IfcReinforcementBarProperties(IfcAreaMeasure totalCrossSectionArea,IfcLabel steelGrade) {

        super();
        this.totalCrossSectionArea = totalCrossSectionArea;
        this.steelGrade = steelGrade;
    }
    /**
     * Constructs IfcReinforcementBarProperties with required and optional attributes.
     */
    public IfcReinforcementBarProperties(IfcAreaMeasure totalCrossSectionArea,IfcLabel steelGrade,IfcReinforcingBarSurfaceEnum barSurface,IfcLengthMeasure effectiveDepth,IfcPositiveLengthMeasure nominalBarDiameter,IfcCountMeasure barCount) {
        super();
        this.totalCrossSectionArea = totalCrossSectionArea;
        this.steelGrade = steelGrade;
        this.barSurface = barSurface;
        this.effectiveDepth = effectiveDepth;
        this.nominalBarDiameter = nominalBarDiameter;
        this.barCount = barCount;
    }
    private void initCollections() {
    }
    public IfcAreaMeasure getTotalCrossSectionArea() { return this.totalCrossSectionArea; }
    public void setTotalCrossSectionArea(IfcAreaMeasure value) { this.totalCrossSectionArea = value; }
    public IfcLabel getSteelGrade() { return this.steelGrade; }
    public void setSteelGrade(IfcLabel value) { this.steelGrade = value; }
    public IfcReinforcingBarSurfaceEnum getBarSurface() { return this.barSurface; }
    public void setBarSurface(IfcReinforcingBarSurfaceEnum value) { this.barSurface = value; } // optional
    public IfcLengthMeasure getEffectiveDepth() { return this.effectiveDepth; }
    public void setEffectiveDepth(IfcLengthMeasure value) { this.effectiveDepth = value; } // optional
    public IfcPositiveLengthMeasure getNominalBarDiameter() { return this.nominalBarDiameter; }
    public void setNominalBarDiameter(IfcPositiveLengthMeasure value) { this.nominalBarDiameter = value; } // optional
    public IfcCountMeasure getBarCount() { return this.barCount; }
    public void setBarCount(IfcCountMeasure value) { this.barCount = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(totalCrossSectionArea != null ? StepUtils.toStepValue(totalCrossSectionArea) : "$");
		parameters.add(steelGrade != null ? StepUtils.toStepValue(steelGrade) : "$");
		parameters.add(StepUtils.toStepValue(barSurface));
		parameters.add(effectiveDepth != null ? StepUtils.toStepValue(effectiveDepth) : "$");
		parameters.add(nominalBarDiameter != null ? StepUtils.toStepValue(nominalBarDiameter) : "$");
		parameters.add(barCount != null ? StepUtils.toStepValue(barCount) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}