package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConversionBasedUnit
 * SUPERTYPE OF (ONEOF
 * (IfcConversionBasedUnitWithOffset))
 * SUBTYPE OF (IfcNamedUnit);
 * Name : IfcLabel;
 * ConversionFactor : IfcMeasureWithUnit;
 * INVERSE
 * HasExternalReference : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconversionbasedunitwithoffset.htm">IfcConversionBasedUnitWithOffset</a>
 */
public class IfcConversionBasedUnitWithOffset extends IfcConversionBasedUnit {
    protected IfcReal conversionOffset;

    protected IfcConversionBasedUnitWithOffset() { initCollections(); }
    /**
     * Constructs IfcConversionBasedUnitWithOffset with all required attributes.
     */
    public IfcConversionBasedUnitWithOffset(IfcDimensionalExponents dimensions,IfcUnitEnum unitType,IfcLabel name,IfcMeasureWithUnit conversionFactor,IfcReal conversionOffset) {
        super(dimensions,unitType,name,conversionFactor);
        this.conversionOffset = conversionOffset;
    }
    private void initCollections() {
    }
    public IfcReal getConversionOffset() { return this.conversionOffset; }
    public void setConversionOffset(IfcReal value) { this.conversionOffset = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(dimensions != null ? StepUtils.toStepValue(dimensions) : "$");
		parameters.add(StepUtils.toStepValue(unitType));
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(conversionFactor != null ? StepUtils.toStepValue(conversionFactor) : "$");
		parameters.add(conversionOffset != null ? StepUtils.toStepValue(conversionOffset) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}