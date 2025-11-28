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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpermit.htm">IfcPermit</a>
 */
public class IfcPermit extends IfcControl {
    protected IfcPermitTypeEnum predefinedType;
    protected IfcLabel status;
    protected IfcText longDescription;

    protected IfcPermit() { initCollections(); }
    /**
     * Constructs IfcPermit with all required attributes.
     */
    public IfcPermit(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcPermit with required and optional attributes.
     */
    public IfcPermit(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcPermitTypeEnum predefinedType,IfcLabel status,IfcText longDescription) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.predefinedType = predefinedType;
        this.status = status;
        this.longDescription = longDescription;
    }
    private void initCollections() {
    }
    public IfcPermitTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcPermitTypeEnum value) { this.predefinedType = value; } // optional
    public IfcLabel getStatus() { return this.status; }
    public void setStatus(IfcLabel value) { this.status = value; } // optional
    public IfcText getLongDescription() { return this.longDescription; }
    public void setLongDescription(IfcText value) { this.longDescription = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(status != null ? StepUtils.toStepValue(status) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}