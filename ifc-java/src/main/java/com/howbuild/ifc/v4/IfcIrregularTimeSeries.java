package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcIrregularTimeSeries
 * SUBTYPE OF (IfcTimeSeries);
 * Values : LIST [1:?] OF IfcIrregularTimeSeriesValue;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcirregulartimeseries.htm">IfcIrregularTimeSeries</a>
 */
public class IfcIrregularTimeSeries extends IfcTimeSeries {
    protected Collection<IfcIrregularTimeSeriesValue> values;

    protected IfcIrregularTimeSeries() { initCollections(); }
    /**
     * Constructs IfcIrregularTimeSeries with all required attributes.
     */
    public IfcIrregularTimeSeries(IfcLabel name,IfcDateTime startTime,IfcDateTime endTime,IfcTimeSeriesDataTypeEnum timeSeriesDataType,IfcDataOriginEnum dataOrigin,Collection<IfcIrregularTimeSeriesValue> values) {

        super(name,startTime,endTime,timeSeriesDataType,dataOrigin);
        this.values = values;
    }
    /**
     * Constructs IfcIrregularTimeSeries with required and optional attributes.
     */
    public IfcIrregularTimeSeries(IfcLabel name,IfcText description,IfcDateTime startTime,IfcDateTime endTime,IfcTimeSeriesDataTypeEnum timeSeriesDataType,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcUnit unit,Collection<IfcIrregularTimeSeriesValue> values) {
        super(name,description,startTime,endTime,timeSeriesDataType,dataOrigin,userDefinedDataOrigin,unit);
        this.values = values;
    }
    private void initCollections() {
        this.values = new ArrayList<>();
    }
    public Collection<IfcIrregularTimeSeriesValue> getValues() { return this.values; }
    public void setValues(Collection<IfcIrregularTimeSeriesValue> value) { this.values = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(startTime != null ? StepUtils.toStepValue(startTime) : "$");
		parameters.add(endTime != null ? StepUtils.toStepValue(endTime) : "$");
		parameters.add(StepUtils.toStepValue(timeSeriesDataType));
		parameters.add(StepUtils.toStepValue(dataOrigin));
		parameters.add(userDefinedDataOrigin != null ? StepUtils.toStepValue(userDefinedDataOrigin) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(values != null ? StepUtils.toStepValue(values) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}