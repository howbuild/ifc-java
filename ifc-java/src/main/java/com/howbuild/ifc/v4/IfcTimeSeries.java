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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctimeseries.htm">IfcTimeSeries</a>
 */
public abstract class IfcTimeSeries extends BaseIfc implements IfcResourceObjectSelect, IfcMetricValueSelect, IfcObjectReferenceSelect {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcDateTime startTime;
    protected IfcDateTime endTime;
    protected IfcTimeSeriesDataTypeEnum timeSeriesDataType;
    protected IfcDataOriginEnum dataOrigin;
    protected IfcLabel userDefinedDataOrigin;
    protected IfcUnit unit;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReference;

    protected IfcTimeSeries() { initCollections(); }
    /**
     * Constructs IfcTimeSeries with all required attributes.
     */
    public IfcTimeSeries(IfcLabel name,IfcDateTime startTime,IfcDateTime endTime,IfcTimeSeriesDataTypeEnum timeSeriesDataType,IfcDataOriginEnum dataOrigin) {

        super();
        this.hasExternalReference = new ArrayList<>();
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeSeriesDataType = timeSeriesDataType;
        this.dataOrigin = dataOrigin;
    }
    /**
     * Constructs IfcTimeSeries with required and optional attributes.
     */
    public IfcTimeSeries(IfcLabel name,IfcText description,IfcDateTime startTime,IfcDateTime endTime,IfcTimeSeriesDataTypeEnum timeSeriesDataType,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcUnit unit) {
        super();
        this.hasExternalReference = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeSeriesDataType = timeSeriesDataType;
        this.dataOrigin = dataOrigin;
        this.userDefinedDataOrigin = userDefinedDataOrigin;
        this.unit = unit;
    }
    private void initCollections() {
        this.hasExternalReference = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcDateTime getStartTime() { return this.startTime; }
    public void setStartTime(IfcDateTime value) { this.startTime = value; }
    public IfcDateTime getEndTime() { return this.endTime; }
    public void setEndTime(IfcDateTime value) { this.endTime = value; }
    public IfcTimeSeriesDataTypeEnum getTimeSeriesDataType() { return this.timeSeriesDataType; }
    public void setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum value) { this.timeSeriesDataType = value; }
    public IfcDataOriginEnum getDataOrigin() { return this.dataOrigin; }
    public void setDataOrigin(IfcDataOriginEnum value) { this.dataOrigin = value; }
    public IfcLabel getUserDefinedDataOrigin() { return this.userDefinedDataOrigin; }
    public void setUserDefinedDataOrigin(IfcLabel value) { this.userDefinedDataOrigin = value; } // optional
    public IfcUnit getUnit() { return this.unit; }
    public void setUnit(IfcUnit value) { this.unit = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReference() { return this.hasExternalReference; }
    public void setHasExternalReference(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReference = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}