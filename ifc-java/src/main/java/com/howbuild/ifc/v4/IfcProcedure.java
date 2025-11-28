package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcProcedure
 * SUBTYPE OF (IfcProcess);
 * PredefinedType : OPTIONAL IfcProcedureTypeEnum;
 * WHERE
 * HasName : EXISTS(SELF\IfcRoot.Name);
 * CorrectPredefinedType : NOT(EXISTS(PredefinedType)) OR (PredefinedType <> IfcProcedureTypeEnum.USERDEFINED) OR
 * ((PredefinedType = IfcProcedureTypeEnum.USERDEFINED) AND EXISTS(SELF\IfcObject.ObjectType));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcprocedure.htm">IfcProcedure</a>
 */
public class IfcProcedure extends IfcProcess {
    protected IfcProcedureTypeEnum predefinedType;

    protected IfcProcedure() { initCollections(); }
    /**
     * Constructs IfcProcedure with all required attributes.
     */
    public IfcProcedure(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcProcedure with required and optional attributes.
     */
    public IfcProcedure(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcIdentifier identification,IfcText longDescription,IfcProcedureTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,identification,longDescription);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcProcedureTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcProcedureTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(longDescription != null ? StepUtils.toStepValue(longDescription) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}