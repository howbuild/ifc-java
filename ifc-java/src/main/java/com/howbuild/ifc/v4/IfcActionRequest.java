package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActionRequest
 * SUBTYPE OF (IfcControl);
 * PredefinedType : OPTIONAL IfcActionRequestTypeEnum;
 * Status : OPTIONAL IfcLabel;
 * LongDescription : OPTIONAL IfcText;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcactionrequest.htm">IfcActionRequest</a>
 */
public class IfcActionRequest extends IfcControl {
    protected IfcActionRequestTypeEnum predefinedType;
    protected IfcLabel status;
    protected IfcText longDescription;

    protected IfcActionRequest() { initCollections(); }
    /**
     * Constructs IfcActionRequest with all required attributes.
     */
    public IfcActionRequest(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcActionRequest with required and optional attributes.
     */
    public IfcActionRequest(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcActionRequestTypeEnum predefinedType,IfcLabel status,IfcText longDescription) {
        super(globalId,ownerHistory,name,description,objectType,identification);
        this.predefinedType = predefinedType;
        this.status = status;
        this.longDescription = longDescription;
    }
    private void initCollections() {
    }
    public IfcActionRequestTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcActionRequestTypeEnum value) { this.predefinedType = value; } // optional
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