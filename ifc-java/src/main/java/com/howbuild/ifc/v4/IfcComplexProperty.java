package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcComplexProperty
 * SUBTYPE OF (IfcProperty);
 * UsageName : IfcIdentifier;
 * HasProperties : SET [1:?] OF IfcProperty;
 * WHERE
 * WR21 : SIZEOF(QUERY(temp <* HasProperties | SELF :=: temp)) = 0;
 * WR22 : IfcUniquePropertyName(HasProperties);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccomplexproperty.htm">IfcComplexProperty</a>
 */
public class IfcComplexProperty extends IfcProperty {
    protected IfcIdentifier usageName;
    protected Collection<IfcProperty> hasProperties;

    protected IfcComplexProperty() { initCollections(); }
    /**
     * Constructs IfcComplexProperty with all required attributes.
     */
    public IfcComplexProperty(IfcIdentifier name,IfcIdentifier usageName,Collection<IfcProperty> hasProperties) {

        super(name);
        this.usageName = usageName;
        this.hasProperties = hasProperties;
    }
    /**
     * Constructs IfcComplexProperty with required and optional attributes.
     */
    public IfcComplexProperty(IfcIdentifier name,IfcText description,IfcIdentifier usageName,Collection<IfcProperty> hasProperties) {
        super(name,description);
        this.usageName = usageName;
        this.hasProperties = hasProperties;
    }
    private void initCollections() {
        this.hasProperties = new ArrayList<>();
    }
    public IfcIdentifier getUsageName() { return this.usageName; }
    public void setUsageName(IfcIdentifier value) { this.usageName = value; }
    public Collection<IfcProperty> getHasProperties() { return this.hasProperties; }
    public void setHasProperties(Collection<IfcProperty> value) { this.hasProperties = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(usageName != null ? StepUtils.toStepValue(usageName) : "$");
		parameters.add(hasProperties != null ? StepUtils.toStepValue(hasProperties) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcComplexPropertyRelationship(); }
    private void setIfcComplexPropertyRelationship() {
		if (this.hasProperties != null) {
		    for (Object x : this.hasProperties) {
		        if (x instanceof IfcProperty)
		            ((IfcProperty)x).partOfComplex.add(this);
		    }
		}
    }
}