package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMeasureWithUnit;
 * ValueComponent : IfcValue;
 * UnitComponent : IfcUnit;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmeasurewithunit.htm">IfcMeasureWithUnit</a>
 */
public class IfcMeasureWithUnit extends BaseIfc implements IfcAppliedValueSelect, IfcMetricValueSelect {
    protected IfcValue valueComponent;
    protected IfcUnit unitComponent;

    protected IfcMeasureWithUnit() { initCollections(); }
    /**
     * Constructs IfcMeasureWithUnit with all required attributes.
     */
    public IfcMeasureWithUnit(IfcValue valueComponent,IfcUnit unitComponent) {
        super();
        this.valueComponent = valueComponent;
        this.unitComponent = unitComponent;
    }
    private void initCollections() {
    }
    public IfcValue getValueComponent() { return this.valueComponent; }
    public void setValueComponent(IfcValue value) { this.valueComponent = value; }
    public IfcUnit getUnitComponent() { return this.unitComponent; }
    public void setUnitComponent(IfcUnit value) { this.unitComponent = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(valueComponent != null ? StepUtils.toStepValue(valueComponent) : "$");
		parameters.add(unitComponent != null ? StepUtils.toStepValue(unitComponent) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}