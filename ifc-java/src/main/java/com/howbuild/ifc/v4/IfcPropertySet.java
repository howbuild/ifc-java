package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertySet
 * SUBTYPE OF (IfcPropertySetDefinition);
 * HasProperties : SET [1:?] OF IfcProperty;
 * WHERE
 * ExistsName : EXISTS(SELF\IfcRoot.Name);
 * UniquePropertyNames : IfcUniquePropertyName(HasProperties);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertyset.htm">IfcPropertySet</a>
 */
public class IfcPropertySet extends IfcPropertySetDefinition {
    protected Collection<IfcProperty> hasProperties;

    protected IfcPropertySet() { initCollections(); }
    /**
     * Constructs IfcPropertySet with all required attributes.
     */
    public IfcPropertySet(IfcGloballyUniqueId globalId,Collection<IfcProperty> hasProperties) {

        super(globalId);
        this.hasProperties = hasProperties;
    }
    /**
     * Constructs IfcPropertySet with required and optional attributes.
     */
    public IfcPropertySet(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,Collection<IfcProperty> hasProperties) {
        super(globalId,ownerHistory,name,description);
        this.hasProperties = hasProperties;
    }
    private void initCollections() {
        this.hasProperties = new ArrayList<>();
    }
    public Collection<IfcProperty> getHasProperties() { return this.hasProperties; }
    public void setHasProperties(Collection<IfcProperty> value) { this.hasProperties = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(hasProperties != null ? StepUtils.toStepValue(hasProperties) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPropertySetRelationship(); }
    private void setIfcPropertySetRelationship() {
		if (this.hasProperties != null) {
		    for (Object x : this.hasProperties) {
		        if (x instanceof IfcProperty)
		            ((IfcProperty)x).partOfPset.add(this);
		    }
		}
    }
}