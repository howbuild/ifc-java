package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcIrregularTimeSeriesValue;
 * TimeStamp : IfcDateTime;
 * ListValues : LIST [1:?] OF IfcValue;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcirregulartimeseriesvalue.htm">IfcIrregularTimeSeriesValue</a>
 */
public class IfcIrregularTimeSeriesValue extends BaseIfc {
    protected IfcDateTime timeStamp;
    protected Collection<IfcValue> listValues;

    protected IfcIrregularTimeSeriesValue() { initCollections(); }
    /**
     * Constructs IfcIrregularTimeSeriesValue with all required attributes.
     */
    public IfcIrregularTimeSeriesValue(IfcDateTime timeStamp,Collection<IfcValue> listValues) {
        super();
        this.timeStamp = timeStamp;
        this.listValues = listValues;
    }
    private void initCollections() {
        this.listValues = new ArrayList<>();
    }
    public IfcDateTime getTimeStamp() { return this.timeStamp; }
    public void setTimeStamp(IfcDateTime value) { this.timeStamp = value; }
    public Collection<IfcValue> getListValues() { return this.listValues; }
    public void setListValues(Collection<IfcValue> value) { this.listValues = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(timeStamp != null ? StepUtils.toStepValue(timeStamp) : "$");
		parameters.add(listValues != null ? StepUtils.toStepValue(listValues) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}