package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialProfileSetUsage
 * SUPERTYPE OF (ONEOF
 * (IfcMaterialProfileSetUsageTapering))
 * SUBTYPE OF (IfcMaterialUsageDefinition);
 * ForProfileSet : IfcMaterialProfileSet;
 * CardinalPoint : OPTIONAL IfcCardinalPointReference;
 * ReferenceExtent : OPTIONAL IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialprofilesetusage.htm">IfcMaterialProfileSetUsage</a>
 */
public class IfcMaterialProfileSetUsage extends IfcMaterialUsageDefinition {
    protected IfcMaterialProfileSet forProfileSet;
    protected IfcCardinalPointReference cardinalPoint;
    protected IfcPositiveLengthMeasure referenceExtent;

    protected IfcMaterialProfileSetUsage() { initCollections(); }
    /**
     * Constructs IfcMaterialProfileSetUsage with all required attributes.
     */
    public IfcMaterialProfileSetUsage(IfcMaterialProfileSet forProfileSet) {

        super();
        this.forProfileSet = forProfileSet;
    }
    /**
     * Constructs IfcMaterialProfileSetUsage with required and optional attributes.
     */
    public IfcMaterialProfileSetUsage(IfcMaterialProfileSet forProfileSet,IfcCardinalPointReference cardinalPoint,IfcPositiveLengthMeasure referenceExtent) {
        super();
        this.forProfileSet = forProfileSet;
        this.cardinalPoint = cardinalPoint;
        this.referenceExtent = referenceExtent;
    }
    private void initCollections() {
    }
    public IfcMaterialProfileSet getForProfileSet() { return this.forProfileSet; }
    public void setForProfileSet(IfcMaterialProfileSet value) { this.forProfileSet = value; }
    public IfcCardinalPointReference getCardinalPoint() { return this.cardinalPoint; }
    public void setCardinalPoint(IfcCardinalPointReference value) { this.cardinalPoint = value; } // optional
    public IfcPositiveLengthMeasure getReferenceExtent() { return this.referenceExtent; }
    public void setReferenceExtent(IfcPositiveLengthMeasure value) { this.referenceExtent = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(forProfileSet != null ? StepUtils.toStepValue(forProfileSet) : "$");
		parameters.add(cardinalPoint != null ? StepUtils.toStepValue(cardinalPoint) : "$");
		parameters.add(referenceExtent != null ? StepUtils.toStepValue(referenceExtent) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}