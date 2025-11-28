package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcUnitAssignment;
 * Units : SET [1:?] OF IfcUnit;
 * WHERE
 * WR01 : IfcCorrectUnitAssignment(Units);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcunitassignment.htm">IfcUnitAssignment</a>
 */
public class IfcUnitAssignment extends BaseIfc {
    protected Collection<IfcUnit> units;

    protected IfcUnitAssignment() { initCollections(); }
    /**
     * Constructs IfcUnitAssignment with all required attributes.
     */
    public IfcUnitAssignment(Collection<IfcUnit> units) {
        super();
        this.units = units;
    }
    private void initCollections() {
        this.units = new ArrayList<>();
    }
    public Collection<IfcUnit> getUnits() { return this.units; }
    public void setUnits(Collection<IfcUnit> value) { this.units = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(units != null ? StepUtils.toStepValue(units) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}