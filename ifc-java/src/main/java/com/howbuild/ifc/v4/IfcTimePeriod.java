package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTimePeriod;
 * StartTime : IfcTime;
 * EndTime : IfcTime;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctimeperiod.htm">IfcTimePeriod</a>
 */
public class IfcTimePeriod extends BaseIfc {
    protected IfcTime startTime;
    protected IfcTime endTime;

    protected IfcTimePeriod() { initCollections(); }
    /**
     * Constructs IfcTimePeriod with all required attributes.
     */
    public IfcTimePeriod(IfcTime startTime,IfcTime endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }
    private void initCollections() {
    }
    public IfcTime getStartTime() { return this.startTime; }
    public void setStartTime(IfcTime value) { this.startTime = value; }
    public IfcTime getEndTime() { return this.endTime; }
    public void setEndTime(IfcTime value) { this.endTime = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(startTime != null ? StepUtils.toStepValue(startTime) : "$");
		parameters.add(endTime != null ? StepUtils.toStepValue(endTime) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}