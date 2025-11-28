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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcworktime.htm">IfcWorkTime</a>
 */
public class IfcWorkTime extends IfcSchedulingTime {
    protected IfcRecurrencePattern recurrencePattern;
    protected IfcDate start;
    protected IfcDate finish;


    /**
     * Constructs IfcWorkTime with all required attributes.
     */
    public IfcWorkTime() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcWorkTime with required and optional attributes.
     */
    public IfcWorkTime(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcRecurrencePattern recurrencePattern,IfcDate start,IfcDate finish) {
        super(name,dataOrigin,userDefinedDataOrigin);
        this.recurrencePattern = recurrencePattern;
        this.start = start;
        this.finish = finish;
    }
    private void initCollections() {
    }
    public IfcRecurrencePattern getRecurrencePattern() { return this.recurrencePattern; }
    public void setRecurrencePattern(IfcRecurrencePattern value) { this.recurrencePattern = value; } // optional
    public IfcDate getStart() { return this.start; }
    public void setStart(IfcDate value) { this.start = value; } // optional
    public IfcDate getFinish() { return this.finish; }
    public void setFinish(IfcDate value) { this.finish = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(StepUtils.toStepValue(dataOrigin));
		parameters.add(userDefinedDataOrigin != null ? StepUtils.toStepValue(userDefinedDataOrigin) : "$");
		parameters.add(recurrencePattern != null ? StepUtils.toStepValue(recurrencePattern) : "$");
		parameters.add(start != null ? StepUtils.toStepValue(start) : "$");
		parameters.add(finish != null ? StepUtils.toStepValue(finish) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}