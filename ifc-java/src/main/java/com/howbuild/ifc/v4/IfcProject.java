package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcContext
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcProject
 * ,IfcProjectLibrary))
 * SUBTYPE OF (IfcObjectDefinition);
 * ObjectType : OPTIONAL IfcLabel;
 * LongName : OPTIONAL IfcLabel;
 * Phase : OPTIONAL IfcLabel;
 * RepresentationContexts : OPTIONAL SET [1:?] OF IfcRepresentationContext;
 * UnitsInContext : OPTIONAL IfcUnitAssignment;
 * INVERSE
 * IsDefinedBy : SET [0:?] OF IfcRelDefinesByProperties FOR RelatedObjects;
 * Declares : SET [0:?] OF IfcRelDeclares FOR RelatingContext;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproject.htm">IfcProject</a>
 */
public class IfcProject extends IfcContext {

    protected IfcProject() { initCollections(); }
    /**
     * Constructs IfcProject with all required attributes.
     */
    public IfcProject(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcProject with required and optional attributes.
     */
    public IfcProject(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcLabel longName,IfcLabel phase,Collection<IfcRepresentationContext> representationContexts,IfcUnitAssignment unitsInContext) {
        super(globalId,ownerHistory,name,description,objectType,longName,phase,representationContexts,unitsInContext);
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
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
		parameters.add(phase != null ? StepUtils.toStepValue(phase) : "$");
		parameters.add(representationContexts != null ? StepUtils.toStepValue(representationContexts) : "$");
		parameters.add(unitsInContext != null ? StepUtils.toStepValue(unitsInContext) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}