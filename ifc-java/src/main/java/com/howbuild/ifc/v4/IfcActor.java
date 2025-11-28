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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcactor.htm">IfcActor</a>
 */
public class IfcActor extends IfcObject {
    protected IfcActorSelect theActor;
    protected Collection<IfcRelAssignsToActor> isActingUpon;

    protected IfcActor() { initCollections(); }
    /**
     * Constructs IfcActor with all required attributes.
     */
    public IfcActor(IfcGloballyUniqueId globalId,IfcActorSelect theActor) {

        super(globalId);
        this.isActingUpon = new ArrayList<>();
        this.theActor = theActor;
    }
    /**
     * Constructs IfcActor with required and optional attributes.
     */
    public IfcActor(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcActorSelect theActor) {
        super(globalId,ownerHistory,name,description,objectType);
        this.isActingUpon = new ArrayList<>();
        this.theActor = theActor;
    }
    private void initCollections() {
        this.isActingUpon = new ArrayList<>();
    }
    public IfcActorSelect getTheActor() { return this.theActor; }
    public void setTheActor(IfcActorSelect value) { this.theActor = value; }
    public Collection<IfcRelAssignsToActor> getIsActingUpon() { return this.isActingUpon; }
    public void setIsActingUpon(Collection<IfcRelAssignsToActor> value) { this.isActingUpon = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(theActor != null ? StepUtils.toStepValue(theActor) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}