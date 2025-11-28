package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRecurrencePattern;
 * RecurrenceType : IfcRecurrenceTypeEnum;
 * DayComponent : OPTIONAL SET [1:?] OF IfcDayInMonthNumber;
 * WeekdayComponent : OPTIONAL SET [1:?] OF IfcDayInWeekNumber;
 * MonthComponent : OPTIONAL SET [1:?] OF IfcMonthInYearNumber;
 * Position : OPTIONAL IfcInteger;
 * Interval : OPTIONAL IfcInteger;
 * Occurrences : OPTIONAL IfcInteger;
 * TimePeriods : OPTIONAL LIST [1:?] OF IfcTimePeriod;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrecurrencepattern.htm">IfcRecurrencePattern</a>
 */
public class IfcRecurrencePattern extends BaseIfc {
    protected IfcRecurrenceTypeEnum recurrenceType;
    protected Collection<IfcDayInMonthNumber> dayComponent;
    protected Collection<IfcDayInWeekNumber> weekdayComponent;
    protected Collection<IfcMonthInYearNumber> monthComponent;
    protected IfcInteger position;
    protected IfcInteger interval;
    protected IfcInteger occurrences;
    protected Collection<IfcTimePeriod> timePeriods;

    protected IfcRecurrencePattern() { initCollections(); }
    /**
     * Constructs IfcRecurrencePattern with all required attributes.
     */
    public IfcRecurrencePattern(IfcRecurrenceTypeEnum recurrenceType) {

        super();
        this.dayComponent = new ArrayList<>();
        this.weekdayComponent = new ArrayList<>();
        this.monthComponent = new ArrayList<>();
        this.timePeriods = new ArrayList<>();
        this.recurrenceType = recurrenceType;
    }
    /**
     * Constructs IfcRecurrencePattern with required and optional attributes.
     */
    public IfcRecurrencePattern(IfcRecurrenceTypeEnum recurrenceType,Collection<IfcDayInMonthNumber> dayComponent,Collection<IfcDayInWeekNumber> weekdayComponent,Collection<IfcMonthInYearNumber> monthComponent,IfcInteger position,IfcInteger interval,IfcInteger occurrences,Collection<IfcTimePeriod> timePeriods) {
        super();
        this.recurrenceType = recurrenceType;
        this.dayComponent = dayComponent;
        this.weekdayComponent = weekdayComponent;
        this.monthComponent = monthComponent;
        this.position = position;
        this.interval = interval;
        this.occurrences = occurrences;
        this.timePeriods = timePeriods;
    }
    private void initCollections() {
        this.dayComponent = new ArrayList<>();
        this.weekdayComponent = new ArrayList<>();
        this.monthComponent = new ArrayList<>();
        this.timePeriods = new ArrayList<>();
    }
    public IfcRecurrenceTypeEnum getRecurrenceType() { return this.recurrenceType; }
    public void setRecurrenceType(IfcRecurrenceTypeEnum value) { this.recurrenceType = value; }
    public Collection<IfcDayInMonthNumber> getDayComponent() { return this.dayComponent; }
    public void setDayComponent(Collection<IfcDayInMonthNumber> value) { this.dayComponent = value; } // optional
    public Collection<IfcDayInWeekNumber> getWeekdayComponent() { return this.weekdayComponent; }
    public void setWeekdayComponent(Collection<IfcDayInWeekNumber> value) { this.weekdayComponent = value; } // optional
    public Collection<IfcMonthInYearNumber> getMonthComponent() { return this.monthComponent; }
    public void setMonthComponent(Collection<IfcMonthInYearNumber> value) { this.monthComponent = value; } // optional
    public IfcInteger getPosition() { return this.position; }
    public void setPosition(IfcInteger value) { this.position = value; } // optional
    public IfcInteger getInterval() { return this.interval; }
    public void setInterval(IfcInteger value) { this.interval = value; } // optional
    public IfcInteger getOccurrences() { return this.occurrences; }
    public void setOccurrences(IfcInteger value) { this.occurrences = value; } // optional
    public Collection<IfcTimePeriod> getTimePeriods() { return this.timePeriods; }
    public void setTimePeriods(Collection<IfcTimePeriod> value) { this.timePeriods = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(recurrenceType));
		parameters.add(dayComponent != null ? StepUtils.toStepValue(dayComponent) : "$");
		parameters.add(weekdayComponent != null ? StepUtils.toStepValue(weekdayComponent) : "$");
		parameters.add(monthComponent != null ? StepUtils.toStepValue(monthComponent) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(interval != null ? StepUtils.toStepValue(interval) : "$");
		parameters.add(occurrences != null ? StepUtils.toStepValue(occurrences) : "$");
		parameters.add(timePeriods != null ? StepUtils.toStepValue(timePeriods) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}