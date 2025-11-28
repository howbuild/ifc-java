package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcReference;
 * TypeIdentifier : OPTIONAL IfcIdentifier;
 * AttributeIdentifier : OPTIONAL IfcIdentifier;
 * InstanceName : OPTIONAL IfcLabel;
 * ListPositions : OPTIONAL LIST [1:?] OF IfcInteger;
 * InnerReference : OPTIONAL IfcReference;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcreference.htm">IfcReference</a>
 */
public class IfcReference extends BaseIfc implements IfcAppliedValueSelect, IfcMetricValueSelect {
    protected IfcIdentifier typeIdentifier;
    protected IfcIdentifier attributeIdentifier;
    protected IfcLabel instanceName;
    protected Collection<IfcInteger> listPositions;
    protected IfcReference innerReference;


    /**
     * Constructs IfcReference with all required attributes.
     */
    public IfcReference() {

        super();
        this.listPositions = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcReference with required and optional attributes.
     */
    public IfcReference(IfcIdentifier typeIdentifier,IfcIdentifier attributeIdentifier,IfcLabel instanceName,Collection<IfcInteger> listPositions,IfcReference innerReference) {
        super();
        this.typeIdentifier = typeIdentifier;
        this.attributeIdentifier = attributeIdentifier;
        this.instanceName = instanceName;
        this.listPositions = listPositions;
        this.innerReference = innerReference;
    }
    private void initCollections() {
        this.listPositions = new ArrayList<>();
    }
    public IfcIdentifier getTypeIdentifier() { return this.typeIdentifier; }
    public void setTypeIdentifier(IfcIdentifier value) { this.typeIdentifier = value; } // optional
    public IfcIdentifier getAttributeIdentifier() { return this.attributeIdentifier; }
    public void setAttributeIdentifier(IfcIdentifier value) { this.attributeIdentifier = value; } // optional
    public IfcLabel getInstanceName() { return this.instanceName; }
    public void setInstanceName(IfcLabel value) { this.instanceName = value; } // optional
    public Collection<IfcInteger> getListPositions() { return this.listPositions; }
    public void setListPositions(Collection<IfcInteger> value) { this.listPositions = value; } // optional
    public IfcReference getInnerReference() { return this.innerReference; }
    public void setInnerReference(IfcReference value) { this.innerReference = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(typeIdentifier != null ? StepUtils.toStepValue(typeIdentifier) : "$");
		parameters.add(attributeIdentifier != null ? StepUtils.toStepValue(attributeIdentifier) : "$");
		parameters.add(instanceName != null ? StepUtils.toStepValue(instanceName) : "$");
		parameters.add(listPositions != null ? StepUtils.toStepValue(listPositions) : "$");
		parameters.add(innerReference != null ? StepUtils.toStepValue(innerReference) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}