package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPhysicalComplexQuantity
 * SUBTYPE OF (IfcPhysicalQuantity);
 * HasQuantities : SET [1:?] OF IfcPhysicalQuantity;
 * Discrimination : IfcLabel;
 * Quality : OPTIONAL IfcLabel;
 * Usage : OPTIONAL IfcLabel;
 * WHERE
 * NoSelfReference : SIZEOF(QUERY(temp <* HasQuantities | SELF :=: temp)) = 0;
 * UniqueQuantityNames : IfcUniqueQuantityNames(HasQuantities);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcphysicalcomplexquantity.htm">IfcPhysicalComplexQuantity</a>
 */
public class IfcPhysicalComplexQuantity extends IfcPhysicalQuantity {
    protected Collection<IfcPhysicalQuantity> hasQuantities;
    protected IfcLabel discrimination;
    protected IfcLabel quality;
    protected IfcLabel usage;

    protected IfcPhysicalComplexQuantity() { initCollections(); }
    /**
     * Constructs IfcPhysicalComplexQuantity with all required attributes.
     */
    public IfcPhysicalComplexQuantity(IfcLabel name,Collection<IfcPhysicalQuantity> hasQuantities,IfcLabel discrimination) {

        super(name);
        this.hasQuantities = hasQuantities;
        this.discrimination = discrimination;
    }
    /**
     * Constructs IfcPhysicalComplexQuantity with required and optional attributes.
     */
    public IfcPhysicalComplexQuantity(IfcLabel name,IfcText description,Collection<IfcPhysicalQuantity> hasQuantities,IfcLabel discrimination,IfcLabel quality,IfcLabel usage) {
        super(name,description);
        this.hasQuantities = hasQuantities;
        this.discrimination = discrimination;
        this.quality = quality;
        this.usage = usage;
    }
    private void initCollections() {
        this.hasQuantities = new ArrayList<>();
    }
    public Collection<IfcPhysicalQuantity> getHasQuantities() { return this.hasQuantities; }
    public void setHasQuantities(Collection<IfcPhysicalQuantity> value) { this.hasQuantities = value; }
    public IfcLabel getDiscrimination() { return this.discrimination; }
    public void setDiscrimination(IfcLabel value) { this.discrimination = value; }
    public IfcLabel getQuality() { return this.quality; }
    public void setQuality(IfcLabel value) { this.quality = value; } // optional
    public IfcLabel getUsage() { return this.usage; }
    public void setUsage(IfcLabel value) { this.usage = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(hasQuantities != null ? StepUtils.toStepValue(hasQuantities) : "$");
		parameters.add(discrimination != null ? StepUtils.toStepValue(discrimination) : "$");
		parameters.add(quality != null ? StepUtils.toStepValue(quality) : "$");
		parameters.add(usage != null ? StepUtils.toStepValue(usage) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPhysicalComplexQuantityRelationship(); }
    private void setIfcPhysicalComplexQuantityRelationship() {
		if (this.hasQuantities != null) {
		    for (Object x : this.hasQuantities) {
		        if (x instanceof IfcPhysicalQuantity)
		            ((IfcPhysicalQuantity)x).partOfComplex.add(this);
		    }
		}
    }
}