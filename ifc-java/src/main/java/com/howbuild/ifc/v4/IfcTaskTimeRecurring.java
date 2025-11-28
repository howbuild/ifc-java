package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTaskTime
 * SUPERTYPE OF (ONEOF
 * (IfcTaskTimeRecurring))
 * SUBTYPE OF (IfcSchedulingTime);
 * DurationType : OPTIONAL IfcTaskDurationEnum;
 * ScheduleDuration : OPTIONAL IfcDuration;
 * ScheduleStart : OPTIONAL IfcDateTime;
 * ScheduleFinish : OPTIONAL IfcDateTime;
 * EarlyStart : OPTIONAL IfcDateTime;
 * EarlyFinish : OPTIONAL IfcDateTime;
 * LateStart : OPTIONAL IfcDateTime;
 * LateFinish : OPTIONAL IfcDateTime;
 * FreeFloat : OPTIONAL IfcDuration;
 * TotalFloat : OPTIONAL IfcDuration;
 * IsCritical : OPTIONAL IfcBoolean;
 * StatusTime : OPTIONAL IfcDateTime;
 * ActualDuration : OPTIONAL IfcDuration;
 * ActualStart : OPTIONAL IfcDateTime;
 * ActualFinish : OPTIONAL IfcDateTime;
 * RemainingTime : OPTIONAL IfcDuration;
 * Completion : OPTIONAL IfcPositiveRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctasktimerecurring.htm">IfcTaskTimeRecurring</a>
 */
public class IfcTaskTimeRecurring extends IfcTaskTime {
    protected IfcRecurrencePattern recurrence;

    protected IfcTaskTimeRecurring() { initCollections(); }
    /**
     * Constructs IfcTaskTimeRecurring with all required attributes.
     */
    public IfcTaskTimeRecurring(IfcRecurrencePattern recurrence) {

        super();
        this.recurrence = recurrence;
    }
    /**
     * Constructs IfcTaskTimeRecurring with required and optional attributes.
     */
    public IfcTaskTimeRecurring(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcTaskDurationEnum durationType,IfcDuration scheduleDuration,IfcDateTime scheduleStart,IfcDateTime scheduleFinish,IfcDateTime earlyStart,IfcDateTime earlyFinish,IfcDateTime lateStart,IfcDateTime lateFinish,IfcDuration freeFloat,IfcDuration totalFloat,IfcBoolean isCritical,IfcDateTime statusTime,IfcDuration actualDuration,IfcDateTime actualStart,IfcDateTime actualFinish,IfcDuration remainingTime,IfcPositiveRatioMeasure completion,IfcRecurrencePattern recurrence) {
        super(name,dataOrigin,userDefinedDataOrigin,durationType,scheduleDuration,scheduleStart,scheduleFinish,earlyStart,earlyFinish,lateStart,lateFinish,freeFloat,totalFloat,isCritical,statusTime,actualDuration,actualStart,actualFinish,remainingTime,completion);
        this.recurrence = recurrence;
    }
    private void initCollections() {
    }
    public IfcRecurrencePattern getRecurrence() { return this.recurrence; }
    public void setRecurrence(IfcRecurrencePattern value) { this.recurrence = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(StepUtils.toStepValue(dataOrigin));
		parameters.add(userDefinedDataOrigin != null ? StepUtils.toStepValue(userDefinedDataOrigin) : "$");
		parameters.add(StepUtils.toStepValue(durationType));
		parameters.add(scheduleDuration != null ? StepUtils.toStepValue(scheduleDuration) : "$");
		parameters.add(scheduleStart != null ? StepUtils.toStepValue(scheduleStart) : "$");
		parameters.add(scheduleFinish != null ? StepUtils.toStepValue(scheduleFinish) : "$");
		parameters.add(earlyStart != null ? StepUtils.toStepValue(earlyStart) : "$");
		parameters.add(earlyFinish != null ? StepUtils.toStepValue(earlyFinish) : "$");
		parameters.add(lateStart != null ? StepUtils.toStepValue(lateStart) : "$");
		parameters.add(lateFinish != null ? StepUtils.toStepValue(lateFinish) : "$");
		parameters.add(freeFloat != null ? StepUtils.toStepValue(freeFloat) : "$");
		parameters.add(totalFloat != null ? StepUtils.toStepValue(totalFloat) : "$");
		parameters.add(isCritical != null ? StepUtils.toStepValue(isCritical) : "$");
		parameters.add(statusTime != null ? StepUtils.toStepValue(statusTime) : "$");
		parameters.add(actualDuration != null ? StepUtils.toStepValue(actualDuration) : "$");
		parameters.add(actualStart != null ? StepUtils.toStepValue(actualStart) : "$");
		parameters.add(actualFinish != null ? StepUtils.toStepValue(actualFinish) : "$");
		parameters.add(remainingTime != null ? StepUtils.toStepValue(remainingTime) : "$");
		parameters.add(completion != null ? StepUtils.toStepValue(completion) : "$");
		parameters.add(recurrence != null ? StepUtils.toStepValue(recurrence) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}