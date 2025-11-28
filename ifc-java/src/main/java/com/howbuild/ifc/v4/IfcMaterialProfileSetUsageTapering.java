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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialprofilesetusagetapering.htm">IfcMaterialProfileSetUsageTapering</a>
 */
public class IfcMaterialProfileSetUsageTapering extends IfcMaterialProfileSetUsage {
    protected IfcMaterialProfileSet forProfileEndSet;
    protected IfcCardinalPointReference cardinalEndPoint;

    protected IfcMaterialProfileSetUsageTapering() { initCollections(); }
    /**
     * Constructs IfcMaterialProfileSetUsageTapering with all required attributes.
     */
    public IfcMaterialProfileSetUsageTapering(IfcMaterialProfileSet forProfileSet,IfcMaterialProfileSet forProfileEndSet) {

        super(forProfileSet);
        this.forProfileEndSet = forProfileEndSet;
    }
    /**
     * Constructs IfcMaterialProfileSetUsageTapering with required and optional attributes.
     */
    public IfcMaterialProfileSetUsageTapering(IfcMaterialProfileSet forProfileSet,IfcCardinalPointReference cardinalPoint,IfcPositiveLengthMeasure referenceExtent,IfcMaterialProfileSet forProfileEndSet,IfcCardinalPointReference cardinalEndPoint) {
        super(forProfileSet,cardinalPoint,referenceExtent);
        this.forProfileEndSet = forProfileEndSet;
        this.cardinalEndPoint = cardinalEndPoint;
    }
    private void initCollections() {
    }
    public IfcMaterialProfileSet getForProfileEndSet() { return this.forProfileEndSet; }
    public void setForProfileEndSet(IfcMaterialProfileSet value) { this.forProfileEndSet = value; }
    public IfcCardinalPointReference getCardinalEndPoint() { return this.cardinalEndPoint; }
    public void setCardinalEndPoint(IfcCardinalPointReference value) { this.cardinalEndPoint = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(forProfileSet != null ? StepUtils.toStepValue(forProfileSet) : "$");
		parameters.add(cardinalPoint != null ? StepUtils.toStepValue(cardinalPoint) : "$");
		parameters.add(referenceExtent != null ? StepUtils.toStepValue(referenceExtent) : "$");
		parameters.add(forProfileEndSet != null ? StepUtils.toStepValue(forProfileEndSet) : "$");
		parameters.add(cardinalEndPoint != null ? StepUtils.toStepValue(cardinalEndPoint) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}