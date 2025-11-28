package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyTemplate
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcComplexPropertyTemplate
 * ,IfcSimplePropertyTemplate))
 * SUBTYPE OF (IfcPropertyTemplateDefinition);
 * INVERSE
 * PartOfComplexTemplate : SET [0:?] OF IfcComplexPropertyTemplate FOR HasPropertyTemplates;
 * PartOfPsetTemplate : SET [0:?] OF IfcPropertySetTemplate FOR HasPropertyTemplates;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsimplepropertytemplate.htm">IfcSimplePropertyTemplate</a>
 */
public class IfcSimplePropertyTemplate extends IfcPropertyTemplate {
    protected IfcSimplePropertyTemplateTypeEnum templateType;
    protected IfcLabel primaryMeasureType;
    protected IfcLabel secondaryMeasureType;
    protected IfcPropertyEnumeration enumerators;
    protected IfcUnit primaryUnit;
    protected IfcUnit secondaryUnit;
    protected IfcLabel expression;
    protected IfcStateEnum accessState;

    protected IfcSimplePropertyTemplate() { initCollections(); }
    /**
     * Constructs IfcSimplePropertyTemplate with all required attributes.
     */
    public IfcSimplePropertyTemplate(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcSimplePropertyTemplate with required and optional attributes.
     */
    public IfcSimplePropertyTemplate(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcSimplePropertyTemplateTypeEnum templateType,IfcLabel primaryMeasureType,IfcLabel secondaryMeasureType,IfcPropertyEnumeration enumerators,IfcUnit primaryUnit,IfcUnit secondaryUnit,IfcLabel expression,IfcStateEnum accessState) {
        super(globalId,ownerHistory,name,description);
        this.templateType = templateType;
        this.primaryMeasureType = primaryMeasureType;
        this.secondaryMeasureType = secondaryMeasureType;
        this.enumerators = enumerators;
        this.primaryUnit = primaryUnit;
        this.secondaryUnit = secondaryUnit;
        this.expression = expression;
        this.accessState = accessState;
    }
    private void initCollections() {
    }
    public IfcSimplePropertyTemplateTypeEnum getTemplateType() { return this.templateType; }
    public void setTemplateType(IfcSimplePropertyTemplateTypeEnum value) { this.templateType = value; } // optional
    public IfcLabel getPrimaryMeasureType() { return this.primaryMeasureType; }
    public void setPrimaryMeasureType(IfcLabel value) { this.primaryMeasureType = value; } // optional
    public IfcLabel getSecondaryMeasureType() { return this.secondaryMeasureType; }
    public void setSecondaryMeasureType(IfcLabel value) { this.secondaryMeasureType = value; } // optional
    public IfcPropertyEnumeration getEnumerators() { return this.enumerators; }
    public void setEnumerators(IfcPropertyEnumeration value) { this.enumerators = value; } // optional
    public IfcUnit getPrimaryUnit() { return this.primaryUnit; }
    public void setPrimaryUnit(IfcUnit value) { this.primaryUnit = value; } // optional
    public IfcUnit getSecondaryUnit() { return this.secondaryUnit; }
    public void setSecondaryUnit(IfcUnit value) { this.secondaryUnit = value; } // optional
    public IfcLabel getExpression() { return this.expression; }
    public void setExpression(IfcLabel value) { this.expression = value; } // optional
    public IfcStateEnum getAccessState() { return this.accessState; }
    public void setAccessState(IfcStateEnum value) { this.accessState = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(StepUtils.toStepValue(templateType));
		parameters.add(primaryMeasureType != null ? StepUtils.toStepValue(primaryMeasureType) : "$");
		parameters.add(secondaryMeasureType != null ? StepUtils.toStepValue(secondaryMeasureType) : "$");
		parameters.add(enumerators != null ? StepUtils.toStepValue(enumerators) : "$");
		parameters.add(primaryUnit != null ? StepUtils.toStepValue(primaryUnit) : "$");
		parameters.add(secondaryUnit != null ? StepUtils.toStepValue(secondaryUnit) : "$");
		parameters.add(expression != null ? StepUtils.toStepValue(expression) : "$");
		parameters.add(StepUtils.toStepValue(accessState));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}