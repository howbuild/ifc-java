package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelDeclares
 * SUBTYPE OF (IfcRelationship);
 * RelatingContext : IfcContext;
 * RelatedDefinitions : SET [1:?] OF IfcDefinitionSelect;
 * WHERE
 * NoSelfReference : SIZEOF(QUERY(Temp <* RelatedDefinitions | RelatingContext :=: Temp)) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreldeclares.htm">IfcRelDeclares</a>
 */
public class IfcRelDeclares extends IfcRelationship {
    protected IfcContext relatingContext;
    protected Collection<IfcDefinitionSelect> relatedDefinitions;

    protected IfcRelDeclares() { initCollections(); }
    /**
     * Constructs IfcRelDeclares with all required attributes.
     */
    public IfcRelDeclares(IfcGloballyUniqueId globalId,IfcContext relatingContext,Collection<IfcDefinitionSelect> relatedDefinitions) {

        super(globalId);
        this.relatingContext = relatingContext;
        this.relatedDefinitions = relatedDefinitions;
    }
    /**
     * Constructs IfcRelDeclares with required and optional attributes.
     */
    public IfcRelDeclares(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcContext relatingContext,Collection<IfcDefinitionSelect> relatedDefinitions) {
        super(globalId,ownerHistory,name,description);
        this.relatingContext = relatingContext;
        this.relatedDefinitions = relatedDefinitions;
    }
    private void initCollections() {
        this.relatedDefinitions = new ArrayList<>();
    }
    public IfcContext getRelatingContext() { return this.relatingContext; }
    public void setRelatingContext(IfcContext value) { this.relatingContext = value; }
    public Collection<IfcDefinitionSelect> getRelatedDefinitions() { return this.relatedDefinitions; }
    public void setRelatedDefinitions(Collection<IfcDefinitionSelect> value) { this.relatedDefinitions = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingContext != null ? StepUtils.toStepValue(relatingContext) : "$");
		parameters.add(relatedDefinitions != null ? StepUtils.toStepValue(relatedDefinitions) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelDeclaresRelationship(); }
    private void setIfcRelDeclaresRelationship() {
		if (this.relatingContext != null) {
		    if (this.relatingContext instanceof IfcContext)
		        ((IfcContext)this.relatingContext).declares.add(this);
		}
		if (this.relatedDefinitions != null) {
		    for (Object x : this.relatedDefinitions) {
		        if (x instanceof IfcObjectDefinition)
		            ((IfcObjectDefinition)x).hasContext.add(this);
		    }
		}
		if (this.relatedDefinitions != null) {
		    for (Object x : this.relatedDefinitions) {
		        if (x instanceof IfcPropertyDefinition)
		            ((IfcPropertyDefinition)x).hasContext.add(this);
		    }
		}
    }
}