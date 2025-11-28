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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcworkcontrol.htm">IfcWorkControl</a>
 */
public abstract class IfcWorkControl extends IfcControl {
    protected IfcDateTime creationDate;
    protected Collection<IfcPerson> creators;
    protected IfcLabel purpose;
    protected IfcDuration duration;
    protected IfcDuration totalFloat;
    protected IfcDateTime startTime;
    protected IfcDateTime finishTime;

    protected IfcWorkControl() { initCollections(); }
    /**
     * Constructs IfcWorkControl with all required attributes.
     */
    public IfcWorkControl(IfcGloballyUniqueId globalId,IfcDateTime creationDate,IfcDateTime startTime) {

        super(globalId);
        this.creators = new ArrayList<>();
        this.creationDate = creationDate;
        this.startTime = startTime;
    }
    /**
     * Constructs IfcWorkControl with required and optional attributes.
     */
    public IfcWorkControl(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcDateTime creationDate,Collection<IfcPerson> creators,IfcLabel purpose,IfcDuration duration,IfcDuration totalFloat,IfcDateTime startTime,IfcDateTime finishTime) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.creationDate = creationDate;
        this.creators = creators;
        this.purpose = purpose;
        this.duration = duration;
        this.totalFloat = totalFloat;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
    private void initCollections() {
        this.creators = new ArrayList<>();
    }
    public IfcDateTime getCreationDate() { return this.creationDate; }
    public void setCreationDate(IfcDateTime value) { this.creationDate = value; }
    public Collection<IfcPerson> getCreators() { return this.creators; }
    public void setCreators(Collection<IfcPerson> value) { this.creators = value; } // optional
    public IfcLabel getPurpose() { return this.purpose; }
    public void setPurpose(IfcLabel value) { this.purpose = value; } // optional
    public IfcDuration getDuration() { return this.duration; }
    public void setDuration(IfcDuration value) { this.duration = value; } // optional
    public IfcDuration getTotalFloat() { return this.totalFloat; }
    public void setTotalFloat(IfcDuration value) { this.totalFloat = value; } // optional
    public IfcDateTime getStartTime() { return this.startTime; }
    public void setStartTime(IfcDateTime value) { this.startTime = value; }
    public IfcDateTime getFinishTime() { return this.finishTime; }
    public void setFinishTime(IfcDateTime value) { this.finishTime = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}