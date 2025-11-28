package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMonetaryUnit;
 * Currency : IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmonetaryunit.htm">IfcMonetaryUnit</a>
 */
public class IfcMonetaryUnit extends BaseIfc implements IfcUnit {
    protected IfcLabel currency;

    protected IfcMonetaryUnit() { initCollections(); }
    /**
     * Constructs IfcMonetaryUnit with all required attributes.
     */
    public IfcMonetaryUnit(IfcLabel currency) {
        super();
        this.currency = currency;
    }
    private void initCollections() {
    }
    public IfcLabel getCurrency() { return this.currency; }
    public void setCurrency(IfcLabel value) { this.currency = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(currency != null ? StepUtils.toStepValue(currency) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}