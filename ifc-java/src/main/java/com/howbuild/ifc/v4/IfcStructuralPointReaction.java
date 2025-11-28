package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralPointReaction
 * SUBTYPE OF (IfcStructuralReaction);
 * WHERE
 * SuitableLoadType : SIZEOF(['IFC4.IFCSTRUCTURALLOADSINGLEFORCE', 'IFC4.IFCSTRUCTURALLOADSINGLEDISPLACEMENT'] * TYPEOF(SELF\IfcStructuralActivity.AppliedLoad)) = 1;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralpointreaction.htm">IfcStructuralPointReaction</a>
 */
public class IfcStructuralPointReaction extends IfcStructuralReaction {

    protected IfcStructuralPointReaction() { initCollections(); }
    /**
     * Constructs IfcStructuralPointReaction with all required attributes.
     */
    public IfcStructuralPointReaction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {

        super(globalId,appliedLoad,globalOrLocal);
    }
    /**
     * Constructs IfcStructuralPointReaction with required and optional attributes.
     */
    public IfcStructuralPointReaction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(appliedLoad != null ? StepUtils.toStepValue(appliedLoad) : "$");
		parameters.add(StepUtils.toStepValue(globalOrLocal));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}