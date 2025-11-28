package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAssignsToGroup
 * SUPERTYPE OF (ONEOF
 * (IfcRelAssignsToGroupByFactor))
 * SUBTYPE OF (IfcRelAssigns);
 * RelatingGroup : IfcGroup;
 * WHERE
 * NoSelfReference : SIZEOF(QUERY(Temp <* SELF\IfcRelAssigns.RelatedObjects | RelatingGroup :=: Temp)) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassignstogroupbyfactor.htm">IfcRelAssignsToGroupByFactor</a>
 */
public class IfcRelAssignsToGroupByFactor extends IfcRelAssignsToGroup {
    protected IfcRatioMeasure factor;

    protected IfcRelAssignsToGroupByFactor() { initCollections(); }
    /**
     * Constructs IfcRelAssignsToGroupByFactor with all required attributes.
     */
    public IfcRelAssignsToGroupByFactor(IfcGloballyUniqueId globalId,Collection<IfcObjectDefinition> relatedObjects,IfcGroup relatingGroup,IfcRatioMeasure factor) {

        super(globalId,relatedObjects,relatingGroup);
        this.factor = factor;
    }
    /**
     * Constructs IfcRelAssignsToGroupByFactor with required and optional attributes.
     */
    public IfcRelAssignsToGroupByFactor(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcObjectDefinition> relatedObjects,IfcObjectTypeEnum relatedObjectsType,IfcGroup relatingGroup,IfcRatioMeasure factor) {
        super(globalId,ownerHistory,name,description,relatedObjects,relatedObjectsType,relatingGroup);
        this.factor = factor;
    }
    private void initCollections() {
    }
    public IfcRatioMeasure getFactor() { return this.factor; }
    public void setFactor(IfcRatioMeasure value) { this.factor = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(StepUtils.toStepValue(relatedObjectsType));
		parameters.add(relatingGroup != null ? StepUtils.toStepValue(relatingGroup) : "$");
		parameters.add(factor != null ? StepUtils.toStepValue(factor) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}