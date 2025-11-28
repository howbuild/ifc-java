package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRegularTimeSeries
 * SUBTYPE OF (IfcTimeSeries);
 * TimeStep : IfcTimeMeasure;
 * Values : LIST [1:?] OF IfcTimeSeriesValue;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcregulartimeseries.htm">IfcRegularTimeSeries</a>
 */
public class IfcRegularTimeSeries extends IfcTimeSeries {
    protected IfcTimeMeasure timeStep;
    protected Collection<IfcTimeSeriesValue> values;

    protected IfcRegularTimeSeries() { initCollections(); }
    /**
     * Constructs IfcRegularTimeSeries with all required attributes.
     */
    public IfcRegularTimeSeries(IfcLabel name,IfcDateTime startTime,IfcDateTime endTime,IfcTimeSeriesDataTypeEnum timeSeriesDataType,IfcDataOriginEnum dataOrigin,IfcTimeMeasure timeStep,Collection<IfcTimeSeriesValue> values) {

        super(name,startTime,endTime,timeSeriesDataType,dataOrigin);
        this.timeStep = timeStep;
        this.values = values;
    }
    /**
     * Constructs IfcRegularTimeSeries with required and optional attributes.
     */
    public IfcRegularTimeSeries(IfcLabel name,IfcText description,IfcDateTime startTime,IfcDateTime endTime,IfcTimeSeriesDataTypeEnum timeSeriesDataType,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcUnit unit,IfcTimeMeasure timeStep,Collection<IfcTimeSeriesValue> values) {
        super(name,description,startTime,endTime,timeSeriesDataType,dataOrigin,userDefinedDataOrigin,unit);
        this.timeStep = timeStep;
        this.values = values;
    }
    private void initCollections() {
        this.values = new ArrayList<>();
    }
    public IfcTimeMeasure getTimeStep() { return this.timeStep; }
    public void setTimeStep(IfcTimeMeasure value) { this.timeStep = value; }
    public Collection<IfcTimeSeriesValue> getValues() { return this.values; }
    public void setValues(Collection<IfcTimeSeriesValue> value) { this.values = value; }

    
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
		parameters.add(timeStep != null ? StepUtils.toStepValue(timeStep) : "$");
		parameters.add(values != null ? StepUtils.toStepValue(values) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}