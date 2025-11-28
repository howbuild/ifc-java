package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDirection
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DirectionRatios : LIST [2:3] OF IfcReal;
 * DERIVE
 * Dim : IfcDimensionCount := HIINDEX(DirectionRatios);
 * WHERE
 * MagnitudeGreaterZero : SIZEOF(QUERY(Tmp <* DirectionRatios | Tmp <> 0.0)) > 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdirection.htm">IfcDirection</a>
 */
public class IfcDirection extends IfcGeometricRepresentationItem implements IfcGridPlacementDirectionSelect, IfcVectorOrDirection {
    protected Collection<IfcReal> directionRatios;

    protected IfcDirection() { initCollections(); }
    /**
     * Constructs IfcDirection with all required attributes.
     */
    public IfcDirection(Collection<IfcReal> directionRatios) {
        super();
        this.directionRatios = directionRatios;
    }
    private void initCollections() {
        this.directionRatios = new ArrayList<>();
    }
    public Collection<IfcReal> getDirectionRatios() { return this.directionRatios; }
    public void setDirectionRatios(Collection<IfcReal> value) { this.directionRatios = value; }
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(directionRatios != null ? StepUtils.toStepValue(directionRatios) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}