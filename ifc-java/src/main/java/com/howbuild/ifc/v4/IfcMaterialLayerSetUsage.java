package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialLayerSetUsage
 * SUBTYPE OF (IfcMaterialUsageDefinition);
 * ForLayerSet : IfcMaterialLayerSet;
 * LayerSetDirection : IfcLayerSetDirectionEnum;
 * DirectionSense : IfcDirectionSenseEnum;
 * OffsetFromReferenceLine : IfcLengthMeasure;
 * ReferenceExtent : OPTIONAL IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmateriallayersetusage.htm">IfcMaterialLayerSetUsage</a>
 */
public class IfcMaterialLayerSetUsage extends IfcMaterialUsageDefinition {
    protected IfcMaterialLayerSet forLayerSet;
    protected IfcLayerSetDirectionEnum layerSetDirection;
    protected IfcDirectionSenseEnum directionSense;
    protected IfcLengthMeasure offsetFromReferenceLine;
    protected IfcPositiveLengthMeasure referenceExtent;

    protected IfcMaterialLayerSetUsage() { initCollections(); }
    /**
     * Constructs IfcMaterialLayerSetUsage with all required attributes.
     */
    public IfcMaterialLayerSetUsage(IfcMaterialLayerSet forLayerSet,IfcLayerSetDirectionEnum layerSetDirection,IfcDirectionSenseEnum directionSense,IfcLengthMeasure offsetFromReferenceLine) {

        super();
        this.forLayerSet = forLayerSet;
        this.layerSetDirection = layerSetDirection;
        this.directionSense = directionSense;
        this.offsetFromReferenceLine = offsetFromReferenceLine;
    }
    /**
     * Constructs IfcMaterialLayerSetUsage with required and optional attributes.
     */
    public IfcMaterialLayerSetUsage(IfcMaterialLayerSet forLayerSet,IfcLayerSetDirectionEnum layerSetDirection,IfcDirectionSenseEnum directionSense,IfcLengthMeasure offsetFromReferenceLine,IfcPositiveLengthMeasure referenceExtent) {
        super();
        this.forLayerSet = forLayerSet;
        this.layerSetDirection = layerSetDirection;
        this.directionSense = directionSense;
        this.offsetFromReferenceLine = offsetFromReferenceLine;
        this.referenceExtent = referenceExtent;
    }
    private void initCollections() {
    }
    public IfcMaterialLayerSet getForLayerSet() { return this.forLayerSet; }
    public void setForLayerSet(IfcMaterialLayerSet value) { this.forLayerSet = value; }
    public IfcLayerSetDirectionEnum getLayerSetDirection() { return this.layerSetDirection; }
    public void setLayerSetDirection(IfcLayerSetDirectionEnum value) { this.layerSetDirection = value; }
    public IfcDirectionSenseEnum getDirectionSense() { return this.directionSense; }
    public void setDirectionSense(IfcDirectionSenseEnum value) { this.directionSense = value; }
    public IfcLengthMeasure getOffsetFromReferenceLine() { return this.offsetFromReferenceLine; }
    public void setOffsetFromReferenceLine(IfcLengthMeasure value) { this.offsetFromReferenceLine = value; }
    public IfcPositiveLengthMeasure getReferenceExtent() { return this.referenceExtent; }
    public void setReferenceExtent(IfcPositiveLengthMeasure value) { this.referenceExtent = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(forLayerSet != null ? StepUtils.toStepValue(forLayerSet) : "$");
		parameters.add(StepUtils.toStepValue(layerSetDirection));
		parameters.add(StepUtils.toStepValue(directionSense));
		parameters.add(offsetFromReferenceLine != null ? StepUtils.toStepValue(offsetFromReferenceLine) : "$");
		parameters.add(referenceExtent != null ? StepUtils.toStepValue(referenceExtent) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}