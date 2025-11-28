package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelAssociates
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcRelAssociatesApproval
 * ,IfcRelAssociatesClassification
 * ,IfcRelAssociatesConstraint
 * ,IfcRelAssociatesDocument
 * ,IfcRelAssociatesLibrary
 * ,IfcRelAssociatesMaterial))
 * SUBTYPE OF (IfcRelationship);
 * RelatedObjects : SET [1:?] OF IfcDefinitionSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelassociatesconstraint.htm">IfcRelAssociatesConstraint</a>
 */
public class IfcRelAssociatesConstraint extends IfcRelAssociates {
    protected IfcLabel intent;
    protected IfcConstraint relatingConstraint;

    protected IfcRelAssociatesConstraint() { initCollections(); }
    /**
     * Constructs IfcRelAssociatesConstraint with all required attributes.
     */
    public IfcRelAssociatesConstraint(IfcGloballyUniqueId globalId,Collection<IfcDefinitionSelect> relatedObjects,IfcConstraint relatingConstraint) {

        super(globalId,relatedObjects);
        this.relatingConstraint = relatingConstraint;
    }
    /**
     * Constructs IfcRelAssociatesConstraint with required and optional attributes.
     */
    public IfcRelAssociatesConstraint(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcDefinitionSelect> relatedObjects,IfcLabel intent,IfcConstraint relatingConstraint) {
        super(globalId,ownerHistory,name,description,relatedObjects);
        this.intent = intent;
        this.relatingConstraint = relatingConstraint;
    }
    private void initCollections() {
    }
    public IfcLabel getIntent() { return this.intent; }
    public void setIntent(IfcLabel value) { this.intent = value; } // optional
    public IfcConstraint getRelatingConstraint() { return this.relatingConstraint; }
    public void setRelatingConstraint(IfcConstraint value) { this.relatingConstraint = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatedObjects != null ? StepUtils.toStepValue(relatedObjects) : "$");
		parameters.add(intent != null ? StepUtils.toStepValue(intent) : "$");
		parameters.add(relatingConstraint != null ? StepUtils.toStepValue(relatingConstraint) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}