package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialLayer
 * SUPERTYPE OF (ONEOF
 * (IfcMaterialLayerWithOffsets))
 * SUBTYPE OF (IfcMaterialDefinition);
 * Material : OPTIONAL IfcMaterial;
 * LayerThickness : IfcNonNegativeLengthMeasure;
 * IsVentilated : OPTIONAL IfcLogical;
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * Category : OPTIONAL IfcLabel;
 * Priority : OPTIONAL IfcInteger;
 * INVERSE
 * ToMaterialLayerSet : IfcMaterialLayerSet FOR MaterialLayers;
 * WHERE
 * NormalizedPriority : NOT(EXISTS(Priority)) OR {0 <= Priority <= 100};
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmateriallayerwithoffsets.htm">IfcMaterialLayerWithOffsets</a>
 */
public class IfcMaterialLayerWithOffsets extends IfcMaterialLayer {
    protected IfcLayerSetDirectionEnum offsetDirection;
    protected Collection<IfcLengthMeasure> offsetValues;

    protected IfcMaterialLayerWithOffsets() { initCollections(); }
    /**
     * Constructs IfcMaterialLayerWithOffsets with all required attributes.
     */
    public IfcMaterialLayerWithOffsets(IfcNonNegativeLengthMeasure layerThickness,IfcLayerSetDirectionEnum offsetDirection,Collection<IfcLengthMeasure> offsetValues) {

        super(layerThickness);
        this.offsetDirection = offsetDirection;
        this.offsetValues = offsetValues;
    }
    /**
     * Constructs IfcMaterialLayerWithOffsets with required and optional attributes.
     */
    public IfcMaterialLayerWithOffsets(IfcMaterial material,IfcNonNegativeLengthMeasure layerThickness,IfcLogical isVentilated,IfcLabel name,IfcText description,IfcLabel category,IfcInteger priority,IfcLayerSetDirectionEnum offsetDirection,Collection<IfcLengthMeasure> offsetValues) {
        super(material,layerThickness,isVentilated,name,description,category,priority);
        this.offsetDirection = offsetDirection;
        this.offsetValues = offsetValues;
    }
    private void initCollections() {
        this.offsetValues = new ArrayList<>();
    }
    public IfcLayerSetDirectionEnum getOffsetDirection() { return this.offsetDirection; }
    public void setOffsetDirection(IfcLayerSetDirectionEnum value) { this.offsetDirection = value; }
    public Collection<IfcLengthMeasure> getOffsetValues() { return this.offsetValues; }
    public void setOffsetValues(Collection<IfcLengthMeasure> value) { this.offsetValues = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(material != null ? StepUtils.toStepValue(material) : "$");
		parameters.add(layerThickness != null ? StepUtils.toStepValue(layerThickness) : "$");
		parameters.add(isVentilated != null ? StepUtils.toStepValue(isVentilated) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(category != null ? StepUtils.toStepValue(category) : "$");
		parameters.add(priority != null ? StepUtils.toStepValue(priority) : "$");
		parameters.add(StepUtils.toStepValue(offsetDirection));
		parameters.add(offsetValues != null ? StepUtils.toStepValue(offsetValues) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}