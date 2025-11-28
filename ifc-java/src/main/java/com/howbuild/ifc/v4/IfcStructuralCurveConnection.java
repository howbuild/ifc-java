package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralConnection
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveConnection
 * ,IfcStructuralPointConnection
 * ,IfcStructuralSurfaceConnection))
 * SUBTYPE OF (IfcStructuralItem);
 * AppliedCondition : OPTIONAL IfcBoundaryCondition;
 * INVERSE
 * ConnectsStructuralMembers : SET [1:?] OF IfcRelConnectsStructuralMember FOR RelatedStructuralConnection;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralcurveconnection.htm">IfcStructuralCurveConnection</a>
 */
public class IfcStructuralCurveConnection extends IfcStructuralConnection {
    protected IfcDirection axis;

    protected IfcStructuralCurveConnection() { initCollections(); }
    /**
     * Constructs IfcStructuralCurveConnection with all required attributes.
     */
    public IfcStructuralCurveConnection(IfcGloballyUniqueId globalId,IfcDirection axis) {

        super(globalId);
        this.axis = axis;
    }
    /**
     * Constructs IfcStructuralCurveConnection with required and optional attributes.
     */
    public IfcStructuralCurveConnection(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcBoundaryCondition appliedCondition,IfcDirection axis) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedCondition);
        this.axis = axis;
    }
    private void initCollections() {
    }
    public IfcDirection getAxis() { return this.axis; }
    public void setAxis(IfcDirection value) { this.axis = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(appliedCondition != null ? StepUtils.toStepValue(appliedCondition) : "$");
		parameters.add(axis != null ? StepUtils.toStepValue(axis) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}