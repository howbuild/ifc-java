package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcEventTime
 * SUBTYPE OF (IfcSchedulingTime);
 * ActualDate : OPTIONAL IfcDateTime;
 * EarlyDate : OPTIONAL IfcDateTime;
 * LateDate : OPTIONAL IfcDateTime;
 * ScheduleDate : OPTIONAL IfcDateTime;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifceventtime.htm">IfcEventTime</a>
 */
public class IfcEventTime extends IfcSchedulingTime {
    protected IfcDateTime actualDate;
    protected IfcDateTime earlyDate;
    protected IfcDateTime lateDate;
    protected IfcDateTime scheduleDate;


    /**
     * Constructs IfcEventTime with all required attributes.
     */
    public IfcEventTime() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcEventTime with required and optional attributes.
     */
    public IfcEventTime(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcDateTime actualDate,IfcDateTime earlyDate,IfcDateTime lateDate,IfcDateTime scheduleDate) {
        super(name,dataOrigin,userDefinedDataOrigin);
        this.actualDate = actualDate;
        this.earlyDate = earlyDate;
        this.lateDate = lateDate;
        this.scheduleDate = scheduleDate;
    }
    private void initCollections() {
    }
    public IfcDateTime getActualDate() { return this.actualDate; }
    public void setActualDate(IfcDateTime value) { this.actualDate = value; } // optional
    public IfcDateTime getEarlyDate() { return this.earlyDate; }
    public void setEarlyDate(IfcDateTime value) { this.earlyDate = value; } // optional
    public IfcDateTime getLateDate() { return this.lateDate; }
    public void setLateDate(IfcDateTime value) { this.lateDate = value; } // optional
    public IfcDateTime getScheduleDate() { return this.scheduleDate; }
    public void setScheduleDate(IfcDateTime value) { this.scheduleDate = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(StepUtils.toStepValue(dataOrigin));
		parameters.add(userDefinedDataOrigin != null ? StepUtils.toStepValue(userDefinedDataOrigin) : "$");
		parameters.add(actualDate != null ? StepUtils.toStepValue(actualDate) : "$");
		parameters.add(earlyDate != null ? StepUtils.toStepValue(earlyDate) : "$");
		parameters.add(lateDate != null ? StepUtils.toStepValue(lateDate) : "$");
		parameters.add(scheduleDate != null ? StepUtils.toStepValue(scheduleDate) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}