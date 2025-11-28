package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelConnectsStructuralMember
 * SUPERTYPE OF (ONEOF
 * (IfcRelConnectsWithEccentricity))
 * SUBTYPE OF (IfcRelConnects);
 * RelatingStructuralMember : IfcStructuralMember;
 * RelatedStructuralConnection : IfcStructuralConnection;
 * AppliedCondition : OPTIONAL IfcBoundaryCondition;
 * AdditionalConditions : OPTIONAL IfcStructuralConnectionCondition;
 * SupportedLength : OPTIONAL IfcLengthMeasure;
 * ConditionCoordinateSystem : OPTIONAL IfcAxis2Placement3D;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectswitheccentricity.htm">IfcRelConnectsWithEccentricity</a>
 */
public class IfcRelConnectsWithEccentricity extends IfcRelConnectsStructuralMember {
    protected IfcConnectionGeometry connectionConstraint;

    protected IfcRelConnectsWithEccentricity() { initCollections(); }
    /**
     * Constructs IfcRelConnectsWithEccentricity with all required attributes.
     */
    public IfcRelConnectsWithEccentricity(IfcGloballyUniqueId globalId,IfcStructuralMember relatingStructuralMember,IfcStructuralConnection relatedStructuralConnection,IfcConnectionGeometry connectionConstraint) {

        super(globalId,relatingStructuralMember,relatedStructuralConnection);
        this.connectionConstraint = connectionConstraint;
    }
    /**
     * Constructs IfcRelConnectsWithEccentricity with required and optional attributes.
     */
    public IfcRelConnectsWithEccentricity(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcStructuralMember relatingStructuralMember,IfcStructuralConnection relatedStructuralConnection,IfcBoundaryCondition appliedCondition,IfcStructuralConnectionCondition additionalConditions,IfcLengthMeasure supportedLength,IfcAxis2Placement3D conditionCoordinateSystem,IfcConnectionGeometry connectionConstraint) {
        super(globalId,ownerHistory,name,description,relatingStructuralMember,relatedStructuralConnection,appliedCondition,additionalConditions,supportedLength,conditionCoordinateSystem);
        this.connectionConstraint = connectionConstraint;
    }
    private void initCollections() {
    }
    public IfcConnectionGeometry getConnectionConstraint() { return this.connectionConstraint; }
    public void setConnectionConstraint(IfcConnectionGeometry value) { this.connectionConstraint = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingStructuralMember != null ? StepUtils.toStepValue(relatingStructuralMember) : "$");
		parameters.add(relatedStructuralConnection != null ? StepUtils.toStepValue(relatedStructuralConnection) : "$");
		parameters.add(appliedCondition != null ? StepUtils.toStepValue(appliedCondition) : "$");
		parameters.add(additionalConditions != null ? StepUtils.toStepValue(additionalConditions) : "$");
		parameters.add(supportedLength != null ? StepUtils.toStepValue(supportedLength) : "$");
		parameters.add(conditionCoordinateSystem != null ? StepUtils.toStepValue(conditionCoordinateSystem) : "$");
		parameters.add(connectionConstraint != null ? StepUtils.toStepValue(connectionConstraint) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}