package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcActor
 * SUPERTYPE OF (ONEOF
 * (IfcOccupant))
 * SUBTYPE OF (IfcObject);
 * TheActor : IfcActorSelect;
 * INVERSE
 * IsActingUpon : SET [0:?] OF IfcRelAssignsToActor FOR RelatingActor;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcoccupant.htm">IfcOccupant</a>
 */
public class IfcOccupant extends IfcActor {
    protected IfcOccupantTypeEnum predefinedType;

    protected IfcOccupant() { initCollections(); }
    /**
     * Constructs IfcOccupant with all required attributes.
     */
    public IfcOccupant(IfcGloballyUniqueId globalId,IfcActorSelect theActor) {

        super(globalId,theActor);
    }
    /**
     * Constructs IfcOccupant with required and optional attributes.
     */
    public IfcOccupant(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcActorSelect theActor,IfcOccupantTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,theActor);
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
    }
    public IfcOccupantTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcOccupantTypeEnum value) { this.predefinedType = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(theActor != null ? StepUtils.toStepValue(theActor) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}