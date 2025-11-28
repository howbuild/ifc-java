package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcGeometricCurveSet
 * SUBTYPE OF (IfcGeometricSet);
 * WHERE
 * NoSurfaces : SIZEOF(QUERY(Temp <* SELF\IfcGeometricSet.Elements |
 * 'IFC4.IFCSURFACE' IN TYPEOF(Temp))) = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcgeometricset.htm">IfcGeometricSet</a>
 */
public class IfcGeometricSet extends IfcGeometricRepresentationItem {
    protected Collection<IfcGeometricSetSelect> elements;

    protected IfcGeometricSet() { initCollections(); }
    /**
     * Constructs IfcGeometricSet with all required attributes.
     */
    public IfcGeometricSet(Collection<IfcGeometricSetSelect> elements) {
        super();
        this.elements = elements;
    }
    private void initCollections() {
        this.elements = new ArrayList<>();
    }
    public Collection<IfcGeometricSetSelect> getElements() { return this.elements; }
    public void setElements(Collection<IfcGeometricSetSelect> value) { this.elements = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(elements != null ? StepUtils.toStepValue(elements) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}