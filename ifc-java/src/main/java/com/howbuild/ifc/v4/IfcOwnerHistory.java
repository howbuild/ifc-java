package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcOwnerHistory;
 * OwningUser : IfcPersonAndOrganization;
 * OwningApplication : IfcApplication;
 * State : OPTIONAL IfcStateEnum;
 * ChangeAction : OPTIONAL IfcChangeActionEnum;
 * LastModifiedDate : OPTIONAL IfcTimeStamp;
 * LastModifyingUser : OPTIONAL IfcPersonAndOrganization;
 * LastModifyingApplication : OPTIONAL IfcApplication;
 * CreationDate : IfcTimeStamp;
 * WHERE
 * CorrectChangeAction : (EXISTS(LastModifiedDate)) OR
 * (NOT(EXISTS(LastModifiedDate)) AND NOT(EXISTS(ChangeAction))) OR
 * (NOT(EXISTS(LastModifiedDate)) AND EXISTS(ChangeAction) AND ((ChangeAction = IfcChangeActionEnum.NOTDEFINED) OR (ChangeAction = IfcChangeActionEnum.NOCHANGE)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcownerhistory.htm">IfcOwnerHistory</a>
 */
public class IfcOwnerHistory extends BaseIfc {
    protected IfcPersonAndOrganization owningUser;
    protected IfcApplication owningApplication;
    protected IfcStateEnum state;
    protected IfcChangeActionEnum changeAction;
    protected IfcTimeStamp lastModifiedDate;
    protected IfcPersonAndOrganization lastModifyingUser;
    protected IfcApplication lastModifyingApplication;
    protected IfcTimeStamp creationDate;

    protected IfcOwnerHistory() { initCollections(); }
    /**
     * Constructs IfcOwnerHistory with all required attributes.
     */
    public IfcOwnerHistory(IfcPersonAndOrganization owningUser,IfcApplication owningApplication,IfcTimeStamp creationDate) {

        super();
        this.owningUser = owningUser;
        this.owningApplication = owningApplication;
        this.creationDate = creationDate;
    }
    /**
     * Constructs IfcOwnerHistory with required and optional attributes.
     */
    public IfcOwnerHistory(IfcPersonAndOrganization owningUser,IfcApplication owningApplication,IfcStateEnum state,IfcChangeActionEnum changeAction,IfcTimeStamp lastModifiedDate,IfcPersonAndOrganization lastModifyingUser,IfcApplication lastModifyingApplication,IfcTimeStamp creationDate) {
        super();
        this.owningUser = owningUser;
        this.owningApplication = owningApplication;
        this.state = state;
        this.changeAction = changeAction;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifyingUser = lastModifyingUser;
        this.lastModifyingApplication = lastModifyingApplication;
        this.creationDate = creationDate;
    }
    private void initCollections() {
    }
    public IfcPersonAndOrganization getOwningUser() { return this.owningUser; }
    public void setOwningUser(IfcPersonAndOrganization value) { this.owningUser = value; }
    public IfcApplication getOwningApplication() { return this.owningApplication; }
    public void setOwningApplication(IfcApplication value) { this.owningApplication = value; }
    public IfcStateEnum getState() { return this.state; }
    public void setState(IfcStateEnum value) { this.state = value; } // optional
    public IfcChangeActionEnum getChangeAction() { return this.changeAction; }
    public void setChangeAction(IfcChangeActionEnum value) { this.changeAction = value; } // optional
    public IfcTimeStamp getLastModifiedDate() { return this.lastModifiedDate; }
    public void setLastModifiedDate(IfcTimeStamp value) { this.lastModifiedDate = value; } // optional
    public IfcPersonAndOrganization getLastModifyingUser() { return this.lastModifyingUser; }
    public void setLastModifyingUser(IfcPersonAndOrganization value) { this.lastModifyingUser = value; } // optional
    public IfcApplication getLastModifyingApplication() { return this.lastModifyingApplication; }
    public void setLastModifyingApplication(IfcApplication value) { this.lastModifyingApplication = value; } // optional
    public IfcTimeStamp getCreationDate() { return this.creationDate; }
    public void setCreationDate(IfcTimeStamp value) { this.creationDate = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(owningUser != null ? StepUtils.toStepValue(owningUser) : "$");
		parameters.add(owningApplication != null ? StepUtils.toStepValue(owningApplication) : "$");
		parameters.add(StepUtils.toStepValue(state));
		parameters.add(StepUtils.toStepValue(changeAction));
		parameters.add(lastModifiedDate != null ? StepUtils.toStepValue(lastModifiedDate) : "$");
		parameters.add(lastModifyingUser != null ? StepUtils.toStepValue(lastModifyingUser) : "$");
		parameters.add(lastModifyingApplication != null ? StepUtils.toStepValue(lastModifyingApplication) : "$");
		parameters.add(creationDate != null ? StepUtils.toStepValue(creationDate) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}