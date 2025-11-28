package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianPointList
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCartesianPointList2D
 * ,IfcCartesianPointList3D))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DERIVE
 * Dim : IfcDimensionCount := IfcPointListDim(SELF);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesianpointlist2d.htm">IfcCartesianPointList2D</a>
 */
public class IfcCartesianPointList2D extends IfcCartesianPointList {
    protected Collection<Collection<IfcLengthMeasure>> coordList;

    protected IfcCartesianPointList2D() { initCollections(); }
    /**
     * Constructs IfcCartesianPointList2D with all required attributes.
     */
    public IfcCartesianPointList2D(Collection<Collection<IfcLengthMeasure>> coordList) {
        super();
        this.coordList = coordList;
    }
    private void initCollections() {
        this.coordList = new ArrayList<>();
    }
    public Collection<Collection<IfcLengthMeasure>> getCoordList() { return this.coordList; }
    public void setCoordList(Collection<Collection<IfcLengthMeasure>> value) { this.coordList = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(coordList != null ? StepUtils.toStepValue(coordList) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}