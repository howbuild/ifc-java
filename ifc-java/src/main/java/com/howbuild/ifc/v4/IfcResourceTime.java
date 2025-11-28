package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcResourceTime
 * SUBTYPE OF (IfcSchedulingTime);
 * ScheduleWork : OPTIONAL IfcDuration;
 * ScheduleUsage : OPTIONAL IfcPositiveRatioMeasure;
 * ScheduleStart : OPTIONAL IfcDateTime;
 * ScheduleFinish : OPTIONAL IfcDateTime;
 * ScheduleContour : OPTIONAL IfcLabel;
 * LevelingDelay : OPTIONAL IfcDuration;
 * IsOverAllocated : OPTIONAL IfcBoolean;
 * StatusTime : OPTIONAL IfcDateTime;
 * ActualWork : OPTIONAL IfcDuration;
 * ActualUsage : OPTIONAL IfcPositiveRatioMeasure;
 * ActualStart : OPTIONAL IfcDateTime;
 * ActualFinish : OPTIONAL IfcDateTime;
 * RemainingWork : OPTIONAL IfcDuration;
 * RemainingUsage : OPTIONAL IfcPositiveRatioMeasure;
 * Completion : OPTIONAL IfcPositiveRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcresourcetime.htm">IfcResourceTime</a>
 */
public class IfcResourceTime extends IfcSchedulingTime {
    protected IfcDuration scheduleWork;
    protected IfcPositiveRatioMeasure scheduleUsage;
    protected IfcDateTime scheduleStart;
    protected IfcDateTime scheduleFinish;
    protected IfcLabel scheduleContour;
    protected IfcDuration levelingDelay;
    protected IfcBoolean isOverAllocated;
    protected IfcDateTime statusTime;
    protected IfcDuration actualWork;
    protected IfcPositiveRatioMeasure actualUsage;
    protected IfcDateTime actualStart;
    protected IfcDateTime actualFinish;
    protected IfcDuration remainingWork;
    protected IfcPositiveRatioMeasure remainingUsage;
    protected IfcPositiveRatioMeasure completion;


    /**
     * Constructs IfcResourceTime with all required attributes.
     */
    public IfcResourceTime() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcResourceTime with required and optional attributes.
     */
    public IfcResourceTime(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcDuration scheduleWork,IfcPositiveRatioMeasure scheduleUsage,IfcDateTime scheduleStart,IfcDateTime scheduleFinish,IfcLabel scheduleContour,IfcDuration levelingDelay,IfcBoolean isOverAllocated,IfcDateTime statusTime,IfcDuration actualWork,IfcPositiveRatioMeasure actualUsage,IfcDateTime actualStart,IfcDateTime actualFinish,IfcDuration remainingWork,IfcPositiveRatioMeasure remainingUsage,IfcPositiveRatioMeasure completion) {
        super(name,dataOrigin,userDefinedDataOrigin);
        this.scheduleWork = scheduleWork;
        this.scheduleUsage = scheduleUsage;
        this.scheduleStart = scheduleStart;
        this.scheduleFinish = scheduleFinish;
        this.scheduleContour = scheduleContour;
        this.levelingDelay = levelingDelay;
        this.isOverAllocated = isOverAllocated;
        this.statusTime = statusTime;
        this.actualWork = actualWork;
        this.actualUsage = actualUsage;
        this.actualStart = actualStart;
        this.actualFinish = actualFinish;
        this.remainingWork = remainingWork;
        this.remainingUsage = remainingUsage;
        this.completion = completion;
    }
    private void initCollections() {
    }
    public IfcDuration getScheduleWork() { return this.scheduleWork; }
    public void setScheduleWork(IfcDuration value) { this.scheduleWork = value; } // optional
    public IfcPositiveRatioMeasure getScheduleUsage() { return this.scheduleUsage; }
    public void setScheduleUsage(IfcPositiveRatioMeasure value) { this.scheduleUsage = value; } // optional
    public IfcDateTime getScheduleStart() { return this.scheduleStart; }
    public void setScheduleStart(IfcDateTime value) { this.scheduleStart = value; } // optional
    public IfcDateTime getScheduleFinish() { return this.scheduleFinish; }
    public void setScheduleFinish(IfcDateTime value) { this.scheduleFinish = value; } // optional
    public IfcLabel getScheduleContour() { return this.scheduleContour; }
    public void setScheduleContour(IfcLabel value) { this.scheduleContour = value; } // optional
    public IfcDuration getLevelingDelay() { return this.levelingDelay; }
    public void setLevelingDelay(IfcDuration value) { this.levelingDelay = value; } // optional
    public IfcBoolean getIsOverAllocated() { return this.isOverAllocated; }
    public void setIsOverAllocated(IfcBoolean value) { this.isOverAllocated = value; } // optional
    public IfcDateTime getStatusTime() { return this.statusTime; }
    public void setStatusTime(IfcDateTime value) { this.statusTime = value; } // optional
    public IfcDuration getActualWork() { return this.actualWork; }
    public void setActualWork(IfcDuration value) { this.actualWork = value; } // optional
    public IfcPositiveRatioMeasure getActualUsage() { return this.actualUsage; }
    public void setActualUsage(IfcPositiveRatioMeasure value) { this.actualUsage = value; } // optional
    public IfcDateTime getActualStart() { return this.actualStart; }
    public void setActualStart(IfcDateTime value) { this.actualStart = value; } // optional
    public IfcDateTime getActualFinish() { return this.actualFinish; }
    public void setActualFinish(IfcDateTime value) { this.actualFinish = value; } // optional
    public IfcDuration getRemainingWork() { return this.remainingWork; }
    public void setRemainingWork(IfcDuration value) { this.remainingWork = value; } // optional
    public IfcPositiveRatioMeasure getRemainingUsage() { return this.remainingUsage; }
    public void setRemainingUsage(IfcPositiveRatioMeasure value) { this.remainingUsage = value; } // optional
    public IfcPositiveRatioMeasure getCompletion() { return this.completion; }
    public void setCompletion(IfcPositiveRatioMeasure value) { this.completion = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(StepUtils.toStepValue(dataOrigin));
		parameters.add(userDefinedDataOrigin != null ? StepUtils.toStepValue(userDefinedDataOrigin) : "$");
		parameters.add(scheduleWork != null ? StepUtils.toStepValue(scheduleWork) : "$");
		parameters.add(scheduleUsage != null ? StepUtils.toStepValue(scheduleUsage) : "$");
		parameters.add(scheduleStart != null ? StepUtils.toStepValue(scheduleStart) : "$");
		parameters.add(scheduleFinish != null ? StepUtils.toStepValue(scheduleFinish) : "$");
		parameters.add(scheduleContour != null ? StepUtils.toStepValue(scheduleContour) : "$");
		parameters.add(levelingDelay != null ? StepUtils.toStepValue(levelingDelay) : "$");
		parameters.add(isOverAllocated != null ? StepUtils.toStepValue(isOverAllocated) : "$");
		parameters.add(statusTime != null ? StepUtils.toStepValue(statusTime) : "$");
		parameters.add(actualWork != null ? StepUtils.toStepValue(actualWork) : "$");
		parameters.add(actualUsage != null ? StepUtils.toStepValue(actualUsage) : "$");
		parameters.add(actualStart != null ? StepUtils.toStepValue(actualStart) : "$");
		parameters.add(actualFinish != null ? StepUtils.toStepValue(actualFinish) : "$");
		parameters.add(remainingWork != null ? StepUtils.toStepValue(remainingWork) : "$");
		parameters.add(remainingUsage != null ? StepUtils.toStepValue(remainingUsage) : "$");
		parameters.add(completion != null ? StepUtils.toStepValue(completion) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}