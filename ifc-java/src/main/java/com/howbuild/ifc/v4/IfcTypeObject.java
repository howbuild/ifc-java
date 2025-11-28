package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcObjectDefinition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcContext
 * ,IfcObject
 * ,IfcTypeObject))
 * SUBTYPE OF (IfcRoot);
 * INVERSE
 * HasAssignments : SET [0:?] OF IfcRelAssigns FOR RelatedObjects;
 * Nests : SET [0:1] OF IfcRelNests FOR RelatedObjects;
 * IsNestedBy : SET [0:?] OF IfcRelNests FOR RelatingObject;
 * HasContext : SET [0:1] OF IfcRelDeclares FOR RelatedDefinitions;
 * IsDecomposedBy : SET [0:?] OF IfcRelAggregates FOR RelatingObject;
 * Decomposes : SET [0:1] OF IfcRelAggregates FOR RelatedObjects;
 * HasAssociations : SET [0:?] OF IfcRelAssociates FOR RelatedObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctypeobject.htm">IfcTypeObject</a>
 */
public class IfcTypeObject extends IfcObjectDefinition {
    protected IfcIdentifier applicableOccurrence;
    protected Collection<IfcPropertySetDefinition> hasPropertySets;
    protected Collection<IfcRelDefinesByType> types;

    protected IfcTypeObject() { initCollections(); }
    /**
     * Constructs IfcTypeObject with all required attributes.
     */
    public IfcTypeObject(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasPropertySets = new ArrayList<>();
        this.types = new ArrayList<>();
    }
    /**
     * Constructs IfcTypeObject with required and optional attributes.
     */
    public IfcTypeObject(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcIdentifier applicableOccurrence,Collection<IfcPropertySetDefinition> hasPropertySets) {
        super(globalId,ownerHistory,name,description);
        this.types = new ArrayList<>();
        this.applicableOccurrence = applicableOccurrence;
        this.hasPropertySets = hasPropertySets;
    }
    private void initCollections() {
        this.hasPropertySets = new ArrayList<>();
        this.types = new ArrayList<>();
    }
    public IfcIdentifier getApplicableOccurrence() { return this.applicableOccurrence; }
    public void setApplicableOccurrence(IfcIdentifier value) { this.applicableOccurrence = value; } // optional
    public Collection<IfcPropertySetDefinition> getHasPropertySets() { return this.hasPropertySets; }
    public void setHasPropertySets(Collection<IfcPropertySetDefinition> value) { this.hasPropertySets = value; } // optional
    public Collection<IfcRelDefinesByType> getTypes() { return this.types; }
    public void setTypes(Collection<IfcRelDefinesByType> value) { this.types = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(applicableOccurrence != null ? StepUtils.toStepValue(applicableOccurrence) : "$");
		parameters.add(hasPropertySets != null ? StepUtils.toStepValue(hasPropertySets) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcTypeObjectRelationship(); }
    private void setIfcTypeObjectRelationship() {
		if (this.hasPropertySets != null) {
		    for (Object x : this.hasPropertySets) {
		        if (x instanceof IfcPropertySetDefinition)
		            ((IfcPropertySetDefinition)x).definesType.add(this);
		    }
		}
    }
}