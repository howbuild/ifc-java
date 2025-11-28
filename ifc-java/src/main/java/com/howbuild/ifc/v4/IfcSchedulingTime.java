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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcschedulingtime.htm">IfcSchedulingTime</a>
 */
public abstract class IfcSchedulingTime extends BaseIfc {
    protected IfcLabel name;
    protected IfcDataOriginEnum dataOrigin;
    protected IfcLabel userDefinedDataOrigin;


    /**
     * Constructs IfcSchedulingTime with all required attributes.
     */
    public IfcSchedulingTime() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcSchedulingTime with required and optional attributes.
     */
    public IfcSchedulingTime(IfcLabel name,IfcDataOriginEnum dataOrigin,IfcLabel userDefinedDataOrigin) {
        super();
        this.name = name;
        this.dataOrigin = dataOrigin;
        this.userDefinedDataOrigin = userDefinedDataOrigin;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcDataOriginEnum getDataOrigin() { return this.dataOrigin; }
    public void setDataOrigin(IfcDataOriginEnum value) { this.dataOrigin = value; } // optional
    public IfcLabel getUserDefinedDataOrigin() { return this.userDefinedDataOrigin; }
    public void setUserDefinedDataOrigin(IfcLabel value) { this.userDefinedDataOrigin = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}