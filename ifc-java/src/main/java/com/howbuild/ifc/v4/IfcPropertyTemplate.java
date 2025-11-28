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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertytemplate.htm">IfcPropertyTemplate</a>
 */
public abstract class IfcPropertyTemplate extends IfcPropertyTemplateDefinition {
    protected Collection<IfcComplexPropertyTemplate> partOfComplexTemplate;
    protected Collection<IfcPropertySetTemplate> partOfPsetTemplate;

    protected IfcPropertyTemplate() { initCollections(); }
    /**
     * Constructs IfcPropertyTemplate with all required attributes.
     */
    public IfcPropertyTemplate(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.partOfComplexTemplate = new ArrayList<>();
        this.partOfPsetTemplate = new ArrayList<>();
    }
    /**
     * Constructs IfcPropertyTemplate with required and optional attributes.
     */
    public IfcPropertyTemplate(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
        this.partOfComplexTemplate = new ArrayList<>();
        this.partOfPsetTemplate = new ArrayList<>();
    }
    private void initCollections() {
        this.partOfComplexTemplate = new ArrayList<>();
        this.partOfPsetTemplate = new ArrayList<>();
    }
    public Collection<IfcComplexPropertyTemplate> getPartOfComplexTemplate() { return this.partOfComplexTemplate; }
    public void setPartOfComplexTemplate(Collection<IfcComplexPropertyTemplate> value) { this.partOfComplexTemplate = value; } // inverse
    public Collection<IfcPropertySetTemplate> getPartOfPsetTemplate() { return this.partOfPsetTemplate; }
    public void setPartOfPsetTemplate(Collection<IfcPropertySetTemplate> value) { this.partOfPsetTemplate = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}