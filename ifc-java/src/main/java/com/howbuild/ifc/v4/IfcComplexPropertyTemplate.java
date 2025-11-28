package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcComplexPropertyTemplate
 * SUBTYPE OF (IfcPropertyTemplate);
 * UsageName : OPTIONAL IfcLabel;
 * TemplateType : OPTIONAL IfcComplexPropertyTemplateTypeEnum;
 * HasPropertyTemplates : OPTIONAL SET [1:?] OF IfcPropertyTemplate;
 * WHERE
 * UniquePropertyNames : IfcUniquePropertyTemplateNames(HasPropertyTemplates);
 * NoSelfReference : SIZEOF(QUERY(temp <* HasPropertyTemplates | SELF :=: temp)) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccomplexpropertytemplate.htm">IfcComplexPropertyTemplate</a>
 */
public class IfcComplexPropertyTemplate extends IfcPropertyTemplate {
    protected IfcLabel usageName;
    protected IfcComplexPropertyTemplateTypeEnum templateType;
    protected Collection<IfcPropertyTemplate> hasPropertyTemplates;

    protected IfcComplexPropertyTemplate() { initCollections(); }
    /**
     * Constructs IfcComplexPropertyTemplate with all required attributes.
     */
    public IfcComplexPropertyTemplate(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.hasPropertyTemplates = new ArrayList<>();
    }
    /**
     * Constructs IfcComplexPropertyTemplate with required and optional attributes.
     */
    public IfcComplexPropertyTemplate(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel usageName,IfcComplexPropertyTemplateTypeEnum templateType,Collection<IfcPropertyTemplate> hasPropertyTemplates) {
        super(globalId,ownerHistory,name,description);
        this.usageName = usageName;
        this.templateType = templateType;
        this.hasPropertyTemplates = hasPropertyTemplates;
    }
    private void initCollections() {
        this.hasPropertyTemplates = new ArrayList<>();
    }
    public IfcLabel getUsageName() { return this.usageName; }
    public void setUsageName(IfcLabel value) { this.usageName = value; } // optional
    public IfcComplexPropertyTemplateTypeEnum getTemplateType() { return this.templateType; }
    public void setTemplateType(IfcComplexPropertyTemplateTypeEnum value) { this.templateType = value; } // optional
    public Collection<IfcPropertyTemplate> getHasPropertyTemplates() { return this.hasPropertyTemplates; }
    public void setHasPropertyTemplates(Collection<IfcPropertyTemplate> value) { this.hasPropertyTemplates = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(usageName != null ? StepUtils.toStepValue(usageName) : "$");
		parameters.add(StepUtils.toStepValue(templateType));
		parameters.add(hasPropertyTemplates != null ? StepUtils.toStepValue(hasPropertyTemplates) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcComplexPropertyTemplateRelationship(); }
    private void setIfcComplexPropertyTemplateRelationship() {
		if (this.hasPropertyTemplates != null) {
		    for (Object x : this.hasPropertyTemplates) {
		        if (x instanceof IfcPropertyTemplate)
		            ((IfcPropertyTemplate)x).partOfComplexTemplate.add(this);
		    }
		}
    }
}