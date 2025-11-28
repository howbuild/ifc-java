package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcContextDependentUnit
 * SUBTYPE OF (IfcNamedUnit);
 * Name : IfcLabel;
 * INVERSE
 * HasExternalReference : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccontextdependentunit.htm">IfcContextDependentUnit</a>
 */
public class IfcContextDependentUnit extends IfcNamedUnit implements IfcResourceObjectSelect {
    protected IfcLabel name;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReference;

    protected IfcContextDependentUnit() { initCollections(); }
    /**
     * Constructs IfcContextDependentUnit with all required attributes.
     */
    public IfcContextDependentUnit(IfcDimensionalExponents dimensions,IfcUnitEnum unitType,IfcLabel name) {
        super(dimensions,unitType);
        this.hasExternalReference = new ArrayList<>();
        this.name = name;
    }
    private void initCollections() {
        this.hasExternalReference = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public Collection<IfcExternalReferenceRelationship> getHasExternalReference() { return this.hasExternalReference; }
    public void setHasExternalReference(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReference = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(dimensions != null ? StepUtils.toStepValue(dimensions) : "$");
		parameters.add(StepUtils.toStepValue(unitType));
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}