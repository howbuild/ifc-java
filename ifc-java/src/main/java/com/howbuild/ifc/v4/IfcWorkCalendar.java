package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcControl
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcActionRequest
 * ,IfcCostItem
 * ,IfcCostSchedule
 * ,IfcPerformanceHistory
 * ,IfcPermit
 * ,IfcProjectOrder
 * ,IfcWorkCalendar
 * ,IfcWorkControl))
 * SUBTYPE OF (IfcObject);
 * Identification : OPTIONAL IfcIdentifier;
 * INVERSE
 * Controls : SET [0:?] OF IfcRelAssignsToControl FOR RelatingControl;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcworkcalendar.htm">IfcWorkCalendar</a>
 */
public class IfcWorkCalendar extends IfcControl {
    protected Collection<IfcWorkTime> workingTimes;
    protected Collection<IfcWorkTime> exceptionTimes;
    protected IfcWorkCalendarTypeEnum predefinedType;

    protected IfcWorkCalendar() { initCollections(); }
    /**
     * Constructs IfcWorkCalendar with all required attributes.
     */
    public IfcWorkCalendar(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.workingTimes = new ArrayList<>();
        this.exceptionTimes = new ArrayList<>();
    }
    /**
     * Constructs IfcWorkCalendar with required and optional attributes.
     */
    public IfcWorkCalendar(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,Collection<IfcWorkTime> workingTimes,Collection<IfcWorkTime> exceptionTimes,IfcWorkCalendarTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.workingTimes = workingTimes;
        this.exceptionTimes = exceptionTimes;
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
        this.workingTimes = new ArrayList<>();
        this.exceptionTimes = new ArrayList<>();
    }
    public Collection<IfcWorkTime> getWorkingTimes() { return this.workingTimes; }
    public void setWorkingTimes(Collection<IfcWorkTime> value) { this.workingTimes = value; } // optional
    public Collection<IfcWorkTime> getExceptionTimes() { return this.exceptionTimes; }
    public void setExceptionTimes(Collection<IfcWorkTime> value) { this.exceptionTimes = value; } // optional
    public IfcWorkCalendarTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcWorkCalendarTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(workingTimes != null ? StepUtils.toStepValue(workingTimes) : "$");
		parameters.add(exceptionTimes != null ? StepUtils.toStepValue(exceptionTimes) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}