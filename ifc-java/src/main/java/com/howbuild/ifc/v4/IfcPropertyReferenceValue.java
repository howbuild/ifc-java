package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPropertyReferenceValue
 * SUBTYPE OF (IfcSimpleProperty);
 * UsageName : OPTIONAL IfcText;
 * PropertyReference : OPTIONAL IfcObjectReferenceSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpropertyreferencevalue.htm">IfcPropertyReferenceValue</a>
 */
public class IfcPropertyReferenceValue extends IfcSimpleProperty {
    protected IfcText usageName;
    protected IfcObjectReferenceSelect propertyReference;

    protected IfcPropertyReferenceValue() { initCollections(); }
    /**
     * Constructs IfcPropertyReferenceValue with all required attributes.
     */
    public IfcPropertyReferenceValue(IfcIdentifier name) {

        super(name);
    }
    /**
     * Constructs IfcPropertyReferenceValue with required and optional attributes.
     */
    public IfcPropertyReferenceValue(IfcIdentifier name,IfcText description,IfcText usageName,IfcObjectReferenceSelect propertyReference) {
        super(name,description);
        this.usageName = usageName;
        this.propertyReference = propertyReference;
    }
    private void initCollections() {
    }
    public IfcText getUsageName() { return this.usageName; }
    public void setUsageName(IfcText value) { this.usageName = value; } // optional
    public IfcObjectReferenceSelect getPropertyReference() { return this.propertyReference; }
    public void setPropertyReference(IfcObjectReferenceSelect value) { this.propertyReference = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(usageName != null ? StepUtils.toStepValue(usageName) : "$");
		parameters.add(propertyReference != null ? StepUtils.toStepValue(propertyReference) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}