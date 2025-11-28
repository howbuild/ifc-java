package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLagTime
 * SUBTYPE OF (IfcSchedulingTime);
 * LagValue : IfcTimeOrRatioSelect;
 * DurationType : IfcTaskDurationEnum;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclagtime.htm">IfcLagTime</a>
 */
public class IfcLagTime extends IfcSchedulingTime {
    protected IfcTimeOrRatioSelect lagValue;
    protected IfcTaskDurationEnum durationType;

    protected IfcLagTime() { initCollections(); }
    /**
     * Constructs IfcLagTime with all required attributes.
     */
    public IfcLagTime(IfcTimeOrRatioSelect lagValue,IfcTaskDurationEnum durationType) {

        super();
        this.lagValue = lagValue;
        this.durationType = durationType;
    }
    /**
     * Constructs IfcLagTime with required and optional attributes.
     */
    public IfcLagTime(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin,IfcTimeOrRatioSelect lagValue,IfcTaskDurationEnum durationType) {
        super(name,dataOrigin,userDefinedDataOrigin);
        this.lagValue = lagValue;
        this.durationType = durationType;
    }
    private void initCollections() {
    }
    public IfcTimeOrRatioSelect getLagValue() { return this.lagValue; }
    public void setLagValue(IfcTimeOrRatioSelect value) { this.lagValue = value; }
    public IfcTaskDurationEnum getDurationType() { return this.durationType; }
    public void setDurationType(IfcTaskDurationEnum value) { this.durationType = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(StepUtils.toStepValue(dataOrigin));
		parameters.add(userDefinedDataOrigin != null ? StepUtils.toStepValue(userDefinedDataOrigin) : "$");
		parameters.add(lagValue != null ? StepUtils.toStepValue(lagValue) : "$");
		parameters.add(StepUtils.toStepValue(durationType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}