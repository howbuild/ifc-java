package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSchedulingTime
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcEventTime
 * ,IfcLagTime
 * ,IfcResourceTime
 * ,IfcTaskTime
 * ,IfcWorkTime));
 * Name : OPTIONAL IfcLabel;
 * DataOrigin : OPTIONAL IfcDataOriginEnum;
 * UserDefinedDataOrigin : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctasktime.htm">IfcTaskTime</a>
 */
public class IfcTaskTime extends IfcSchedulingTime {
    protected IfcTaskDurationEnum durationType;
    protected IfcDuration scheduleDuration;
    protected IfcDateTime scheduleStart;
    protected IfcDateTime scheduleFinish;
    protected IfcDateTime earlyStart;
    protected IfcDateTime earlyFinish;
    protected IfcDateTime lateStart;
    protected IfcDateTime lateFinish;
    protected IfcDuration freeFloat;
    protected IfcDuration totalFloat;
    protected IfcBoolean isCritical;
    protected IfcDateTime statusTime;
    protected IfcDuration actualDuration;
    protected IfcDateTime actualStart;
    protected IfcDateTime actualFinish;
    protected IfcDuration remainingTime;
    protected IfcPositiveRatioMeasure completion;


    /**
     * Constructs IfcTaskTime with all required attributes.
     */
    public IfcTaskTime() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcTaskTime with required and optional attributes.
     */
    public IfcTaskTime(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcTaskDurationEnum durationType,IfcDuration scheduleDuration,IfcDateTime scheduleStart,IfcDateTime scheduleFinish,IfcDateTime earlyStart,IfcDateTime earlyFinish,IfcDateTime lateStart,IfcDateTime lateFinish,IfcDuration freeFloat,IfcDuration totalFloat,IfcBoolean isCritical,IfcDateTime statusTime,IfcDuration actualDuration,IfcDateTime actualStart,IfcDateTime actualFinish,IfcDuration remainingTime,IfcPositiveRatioMeasure completion) {
        super(name,dataOrigin,userDefinedDataOrigin);
        this.durationType = durationType;
        this.scheduleDuration = scheduleDuration;
        this.scheduleStart = scheduleStart;
        this.scheduleFinish = scheduleFinish;
        this.earlyStart = earlyStart;
        this.earlyFinish = earlyFinish;
        this.lateStart = lateStart;
        this.lateFinish = lateFinish;
        this.freeFloat = freeFloat;
        this.totalFloat = totalFloat;
        this.isCritical = isCritical;
        this.statusTime = statusTime;
        this.actualDuration = actualDuration;
        this.actualStart = actualStart;
        this.actualFinish = actualFinish;
        this.remainingTime = remainingTime;
        this.completion = completion;
    }
    private void initCollections() {
    }
    public IfcTaskDurationEnum getDurationType() { return this.durationType; }
    public void setDurationType(IfcTaskDurationEnum value) { this.durationType = value; } // optional
    public IfcDuration getScheduleDuration() { return this.scheduleDuration; }
    public void setScheduleDuration(IfcDuration value) { this.scheduleDuration = value; } // optional
    public IfcDateTime getScheduleStart() { return this.scheduleStart; }
    public void setScheduleStart(IfcDateTime value) { this.scheduleStart = value; } // optional
    public IfcDateTime getScheduleFinish() { return this.scheduleFinish; }
    public void setScheduleFinish(IfcDateTime value) { this.scheduleFinish = value; } // optional
    public IfcDateTime getEarlyStart() { return this.earlyStart; }
    public void setEarlyStart(IfcDateTime value) { this.earlyStart = value; } // optional
    public IfcDateTime getEarlyFinish() { return this.earlyFinish; }
    public void setEarlyFinish(IfcDateTime value) { this.earlyFinish = value; } // optional
    public IfcDateTime getLateStart() { return this.lateStart; }
    public void setLateStart(IfcDateTime value) { this.lateStart = value; } // optional
    public IfcDateTime getLateFinish() { return this.lateFinish; }
    public void setLateFinish(IfcDateTime value) { this.lateFinish = value; } // optional
    public IfcDuration getFreeFloat() { return this.freeFloat; }
    public void setFreeFloat(IfcDuration value) { this.freeFloat = value; } // optional
    public IfcDuration getTotalFloat() { return this.totalFloat; }
    public void setTotalFloat(IfcDuration value) { this.totalFloat = value; } // optional
    public IfcBoolean getIsCritical() { return this.isCritical; }
    public void setIsCritical(IfcBoolean value) { this.isCritical = value; } // optional
    public IfcDateTime getStatusTime() { return this.statusTime; }
    public void setStatusTime(IfcDateTime value) { this.statusTime = value; } // optional
    public IfcDuration getActualDuration() { return this.actualDuration; }
    public void setActualDuration(IfcDuration value) { this.actualDuration = value; } // optional
    public IfcDateTime getActualStart() { return this.actualStart; }
    public void setActualStart(IfcDateTime value) { this.actualStart = value; } // optional
    public IfcDateTime getActualFinish() { return this.actualFinish; }
    public void setActualFinish(IfcDateTime value) { this.actualFinish = value; } // optional
    public IfcDuration getRemainingTime() { return this.remainingTime; }
    public void setRemainingTime(IfcDuration value) { this.remainingTime = value; } // optional
    public IfcPositiveRatioMeasure getCompletion() { return this.completion; }
    public void setCompletion(IfcPositiveRatioMeasure value) { this.completion = value; } // optional

    
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
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}