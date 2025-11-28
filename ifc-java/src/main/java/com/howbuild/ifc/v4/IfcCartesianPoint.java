package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianPoint
 * SUBTYPE OF (IfcPoint);
 * Coordinates : LIST [1:3] OF IfcLengthMeasure;
 * DERIVE
 * Dim : IfcDimensionCount := HIINDEX(Coordinates);
 * WHERE
 * CP2Dor3D : HIINDEX(Coordinates) >= 2;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesianpoint.htm">IfcCartesianPoint</a>
 */
public class IfcCartesianPoint extends IfcPoint implements IfcTrimmingSelect {
    protected Collection<IfcLengthMeasure> coordinates;

    protected IfcCartesianPoint() { initCollections(); }
    /**
     * Constructs IfcCartesianPoint with all required attributes.
     */
    public IfcCartesianPoint(Collection<IfcLengthMeasure> coordinates) {
        super();
        this.coordinates = coordinates;
    }
    private void initCollections() {
        this.coordinates = new ArrayList<>();
    }
    public Collection<IfcLengthMeasure> getCoordinates() { return this.coordinates; }
    public void setCoordinates(Collection<IfcLengthMeasure> value) { this.coordinates = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordinates != null ? StepUtils.toStepValue(coordinates) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}