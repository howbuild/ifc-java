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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralpointconnection.htm">IfcStructuralPointConnection</a>
 */
public class IfcStructuralPointConnection extends IfcStructuralConnection {
    protected IfcAxis2Placement3D conditionCoordinateSystem;

    protected IfcStructuralPointConnection() { initCollections(); }
    /**
     * Constructs IfcStructuralPointConnection with all required attributes.
     */
    public IfcStructuralPointConnection(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcStructuralPointConnection with required and optional attributes.
     */
    public IfcStructuralPointConnection(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcBoundaryCondition appliedCondition,IfcAxis2Placement3D conditionCoordinateSystem) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedCondition);
        this.conditionCoordinateSystem = conditionCoordinateSystem;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement3D getConditionCoordinateSystem() { return this.conditionCoordinateSystem; }
    public void setConditionCoordinateSystem(IfcAxis2Placement3D value) { this.conditionCoordinateSystem = value; } // optional

    
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
		parameters.add(conditionCoordinateSystem != null ? StepUtils.toStepValue(conditionCoordinateSystem) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}