package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcElementQuantity
 * SUBTYPE OF (IfcQuantitySet);
 * MethodOfMeasurement : OPTIONAL IfcLabel;
 * Quantities : SET [1:?] OF IfcPhysicalQuantity;
 * WHERE
 * UniqueQuantityNames : IfcUniqueQuantityNames(Quantities);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcelementquantity.htm">IfcElementQuantity</a>
 */
public class IfcElementQuantity extends IfcQuantitySet {
    protected IfcLabel methodOfMeasurement;
    protected Collection<IfcPhysicalQuantity> quantities;

    protected IfcElementQuantity() { initCollections(); }
    /**
     * Constructs IfcElementQuantity with all required attributes.
     */
    public IfcElementQuantity(IfcGloballyUniqueId globalId,Collection<IfcPhysicalQuantity> quantities) {

        super(globalId);
        this.quantities = quantities;
    }
    /**
     * Constructs IfcElementQuantity with required and optional attributes.
     */
    public IfcElementQuantity(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel methodOfMeasurement,Collection<IfcPhysicalQuantity> quantities) {
        super(globalId,ownerHistory,name,description);
        this.methodOfMeasurement = methodOfMeasurement;
        this.quantities = quantities;
    }
    private void initCollections() {
        this.quantities = new ArrayList<>();
    }
    public IfcLabel getMethodOfMeasurement() { return this.methodOfMeasurement; }
    public void setMethodOfMeasurement(IfcLabel value) { this.methodOfMeasurement = value; } // optional
    public Collection<IfcPhysicalQuantity> getQuantities() { return this.quantities; }
    public void setQuantities(Collection<IfcPhysicalQuantity> value) { this.quantities = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(methodOfMeasurement != null ? StepUtils.toStepValue(methodOfMeasurement) : "$");
		parameters.add(quantities != null ? StepUtils.toStepValue(quantities) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}