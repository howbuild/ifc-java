package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPhysicalSimpleQuantity
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcQuantityArea
 * ,IfcQuantityCount
 * ,IfcQuantityLength
 * ,IfcQuantityTime
 * ,IfcQuantityVolume
 * ,IfcQuantityWeight))
 * SUBTYPE OF (IfcPhysicalQuantity);
 * Unit : OPTIONAL IfcNamedUnit;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcquantityvolume.htm">IfcQuantityVolume</a>
 */
public class IfcQuantityVolume extends IfcPhysicalSimpleQuantity {
    protected IfcVolumeMeasure volumeValue;
    protected IfcLabel formula;

    protected IfcQuantityVolume() { initCollections(); }
    /**
     * Constructs IfcQuantityVolume with all required attributes.
     */
    public IfcQuantityVolume(IfcLabel name,IfcVolumeMeasure volumeValue) {

        super(name);
        this.volumeValue = volumeValue;
    }
    /**
     * Constructs IfcQuantityVolume with required and optional attributes.
     */
    public IfcQuantityVolume(IfcLabel name,IfcText description,IfcNamedUnit unit,IfcVolumeMeasure volumeValue,IfcLabel formula) {
        super(name,description,unit);
        this.volumeValue = volumeValue;
        this.formula = formula;
    }
    private void initCollections() {
    }
    public IfcVolumeMeasure getVolumeValue() { return this.volumeValue; }
    public void setVolumeValue(IfcVolumeMeasure value) { this.volumeValue = value; }
    public IfcLabel getFormula() { return this.formula; }
    public void setFormula(IfcLabel value) { this.formula = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(volumeValue != null ? StepUtils.toStepValue(volumeValue) : "$");
		parameters.add(formula != null ? StepUtils.toStepValue(formula) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}