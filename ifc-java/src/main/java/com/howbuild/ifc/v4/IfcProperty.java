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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproperty.htm">IfcProperty</a>
 */
public abstract class IfcProperty extends IfcPropertyAbstraction {
    protected IfcIdentifier name;
    protected IfcText description;
    protected Collection<IfcPropertySet> partOfPset;
    protected Collection<IfcPropertyDependencyRelationship> propertyForDependance;
    protected Collection<IfcPropertyDependencyRelationship> propertyDependsOn;
    protected Collection<IfcComplexProperty> partOfComplex;
    protected Collection<IfcResourceConstraintRelationship> hasConstraints;
    protected Collection<IfcResourceApprovalRelationship> hasApprovals;

    protected IfcProperty() { initCollections(); }
    /**
     * Constructs IfcProperty with all required attributes.
     */
    public IfcProperty(IfcIdentifier name) {

        super();
        this.partOfPset = new ArrayList<>();
        this.propertyForDependance = new ArrayList<>();
        this.propertyDependsOn = new ArrayList<>();
        this.partOfComplex = new ArrayList<>();
        this.hasConstraints = new ArrayList<>();
        this.hasApprovals = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcProperty with required and optional attributes.
     */
    public IfcProperty(IfcIdentifier name,IfcText description) {
        super();
        this.partOfPset = new ArrayList<>();
        this.propertyForDependance = new ArrayList<>();
        this.propertyDependsOn = new ArrayList<>();
        this.partOfComplex = new ArrayList<>();
        this.hasConstraints = new ArrayList<>();
        this.hasApprovals = new ArrayList<>();
        this.name = name;
        this.description = description;
    }
    private void initCollections() {
        this.partOfPset = new ArrayList<>();
        this.propertyForDependance = new ArrayList<>();
        this.propertyDependsOn = new ArrayList<>();
        this.partOfComplex = new ArrayList<>();
        this.hasConstraints = new ArrayList<>();
        this.hasApprovals = new ArrayList<>();
    }
    public IfcIdentifier getName() { return this.name; }
    public void setName(IfcIdentifier value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcPropertySet> getPartOfPset() { return this.partOfPset; }
    public void setPartOfPset(Collection<IfcPropertySet> value) { this.partOfPset = value; } // inverse
    public Collection<IfcPropertyDependencyRelationship> getPropertyForDependance() { return this.propertyForDependance; }
    public void setPropertyForDependance(Collection<IfcPropertyDependencyRelationship> value) { this.propertyForDependance = value; } // inverse
    public Collection<IfcPropertyDependencyRelationship> getPropertyDependsOn() { return this.propertyDependsOn; }
    public void setPropertyDependsOn(Collection<IfcPropertyDependencyRelationship> value) { this.propertyDependsOn = value; } // inverse
    public Collection<IfcComplexProperty> getPartOfComplex() { return this.partOfComplex; }
    public void setPartOfComplex(Collection<IfcComplexProperty> value) { this.partOfComplex = value; } // inverse
    public Collection<IfcResourceConstraintRelationship> getHasConstraints() { return this.hasConstraints; }
    public void setHasConstraints(Collection<IfcResourceConstraintRelationship> value) { this.hasConstraints = value; } // inverse
    public Collection<IfcResourceApprovalRelationship> getHasApprovals() { return this.hasApprovals; }
    public void setHasApprovals(Collection<IfcResourceApprovalRelationship> value) { this.hasApprovals = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}