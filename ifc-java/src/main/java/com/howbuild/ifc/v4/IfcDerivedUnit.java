package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDerivedUnit;
 * Elements : SET [1:?] OF IfcDerivedUnitElement;
 * UnitType : IfcDerivedUnitEnum;
 * UserDefinedType : OPTIONAL IfcLabel;
 * DERIVE
 * Dimensions : IfcDimensionalExponents := IfcDeriveDimensionalExponents(Elements);
 * WHERE
 * WR1 : (SIZEOF (Elements) > 1) OR ((SIZEOF (Elements) = 1) AND (Elements[1].Exponent <> 1 ));
 * WR2 : (UnitType <> IfcDerivedUnitEnum.USERDEFINED) OR
 * ((UnitType = IfcDerivedUnitEnum.USERDEFINED) AND
 * (EXISTS(SELF.UserDefinedType)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcderivedunit.htm">IfcDerivedUnit</a>
 */
public class IfcDerivedUnit extends BaseIfc implements IfcUnit {
    protected Collection<IfcDerivedUnitElement> elements;
    protected IfcDerivedUnitEnum unitType;
    protected IfcLabel userDefinedType;

    protected IfcDerivedUnit() { initCollections(); }
    /**
     * Constructs IfcDerivedUnit with all required attributes.
     */
    public IfcDerivedUnit(Collection<IfcDerivedUnitElement> elements,IfcDerivedUnitEnum unitType) {

        super();
        this.elements = elements;
        this.unitType = unitType;
    }
    /**
     * Constructs IfcDerivedUnit with required and optional attributes.
     */
    public IfcDerivedUnit(Collection<IfcDerivedUnitElement> elements,IfcDerivedUnitEnum unitType,IfcLabel userDefinedType) {
        super();
        this.elements = elements;
        this.unitType = unitType;
        this.userDefinedType = userDefinedType;
    }
    private void initCollections() {
        this.elements = new ArrayList<>();
    }
    public Collection<IfcDerivedUnitElement> getElements() { return this.elements; }
    public void setElements(Collection<IfcDerivedUnitElement> value) { this.elements = value; }
    public IfcDerivedUnitEnum getUnitType() { return this.unitType; }
    public void setUnitType(IfcDerivedUnitEnum value) { this.unitType = value; }
    public IfcLabel getUserDefinedType() { return this.userDefinedType; }
    public void setUserDefinedType(IfcLabel value) { this.userDefinedType = value; } // optional
    public IfcDimensionalExponents getDimensions() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dimensions."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(elements != null ? StepUtils.toStepValue(elements) : "$");
		parameters.add(StepUtils.toStepValue(unitType));
		parameters.add(userDefinedType != null ? StepUtils.toStepValue(userDefinedType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}