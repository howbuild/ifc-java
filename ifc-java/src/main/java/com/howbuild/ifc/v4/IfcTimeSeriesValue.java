package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTimeSeriesValue;
 * ListValues : LIST [1:?] OF IfcValue;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctimeseriesvalue.htm">IfcTimeSeriesValue</a>
 */
public class IfcTimeSeriesValue extends BaseIfc {
    protected Collection<IfcValue> listValues;

    protected IfcTimeSeriesValue() { initCollections(); }
    /**
     * Constructs IfcTimeSeriesValue with all required attributes.
     */
    public IfcTimeSeriesValue(Collection<IfcValue> listValues) {
        super();
        this.listValues = listValues;
    }
    private void initCollections() {
        this.listValues = new ArrayList<>();
    }
    public Collection<IfcValue> getListValues() { return this.listValues; }
    public void setListValues(Collection<IfcValue> value) { this.listValues = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(listValues != null ? StepUtils.toStepValue(listValues) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}