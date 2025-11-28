package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertySetTemplate
 * SUBTYPE OF (IfcPropertyTemplateDefinition);
 * TemplateType : OPTIONAL IfcPropertySetTemplateTypeEnum;
 * ApplicableEntity : OPTIONAL IfcIdentifier;
 * HasPropertyTemplates : SET [1:?] OF IfcPropertyTemplate;
 * INVERSE
 * Defines : SET [0:?] OF IfcRelDefinesByTemplate FOR RelatingTemplate;
 * WHERE
 * ExistsName : EXISTS(SELF\IfcRoot.Name);
 * UniquePropertyNames : IfcUniquePropertyTemplateNames(HasPropertyTemplates);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertysettemplate.htm">IfcPropertySetTemplate</a>
 */
public class IfcPropertySetTemplate extends IfcPropertyTemplateDefinition {
    protected IfcPropertySetTemplateTypeEnum templateType;
    protected IfcIdentifier applicableEntity;
    protected Collection<IfcPropertyTemplate> hasPropertyTemplates;
    protected Collection<IfcRelDefinesByTemplate> defines;

    protected IfcPropertySetTemplate() { initCollections(); }
    /**
     * Constructs IfcPropertySetTemplate with all required attributes.
     */
    public IfcPropertySetTemplate(IfcGloballyUniqueId globalId,Collection<IfcPropertyTemplate> hasPropertyTemplates) {

        super(globalId);
        this.defines = new ArrayList<>();
        this.hasPropertyTemplates = hasPropertyTemplates;
    }
    /**
     * Constructs IfcPropertySetTemplate with required and optional attributes.
     */
    public IfcPropertySetTemplate(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcPropertySetTemplateTypeEnum templateType,IfcIdentifier applicableEntity,Collection<IfcPropertyTemplate> hasPropertyTemplates) {
        super(globalId,ownerHistory,name,description);
        this.defines = new ArrayList<>();
        this.templateType = templateType;
        this.applicableEntity = applicableEntity;
        this.hasPropertyTemplates = hasPropertyTemplates;
    }
    private void initCollections() {
        this.hasPropertyTemplates = new ArrayList<>();
        this.defines = new ArrayList<>();
    }
    public IfcPropertySetTemplateTypeEnum getTemplateType() { return this.templateType; }
    public void setTemplateType(IfcPropertySetTemplateTypeEnum value) { this.templateType = value; } // optional
    public IfcIdentifier getApplicableEntity() { return this.applicableEntity; }
    public void setApplicableEntity(IfcIdentifier value) { this.applicableEntity = value; } // optional
    public Collection<IfcPropertyTemplate> getHasPropertyTemplates() { return this.hasPropertyTemplates; }
    public void setHasPropertyTemplates(Collection<IfcPropertyTemplate> value) { this.hasPropertyTemplates = value; }
    public Collection<IfcRelDefinesByTemplate> getDefines() { return this.defines; }
    public void setDefines(Collection<IfcRelDefinesByTemplate> value) { this.defines = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(StepUtils.toStepValue(templateType));
		parameters.add(applicableEntity != null ? StepUtils.toStepValue(applicableEntity) : "$");
		parameters.add(hasPropertyTemplates != null ? StepUtils.toStepValue(hasPropertyTemplates) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPropertySetTemplateRelationship(); }
    private void setIfcPropertySetTemplateRelationship() {
		if (this.hasPropertyTemplates != null) {
		    for (Object x : this.hasPropertyTemplates) {
		        if (x instanceof IfcPropertyTemplate)
		            ((IfcPropertyTemplate)x).partOfPsetTemplate.add(this);
		    }
		}
    }
}