package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBSplineSurface
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineSurfaceWithKnots))
 * SUBTYPE OF (IfcBoundedSurface);
 * UDegree : IfcInteger;
 * VDegree : IfcInteger;
 * ControlPointsList : LIST [2:?] OF LIST [2:?] OF IfcCartesianPoint;
 * SurfaceForm : IfcBSplineSurfaceForm;
 * UClosed : IfcLogical;
 * VClosed : IfcLogical;
 * SelfIntersect : IfcLogical;
 * DERIVE
 * UUpper : IfcInteger := SIZEOF(ControlPointsList) - 1;
 * VUpper : IfcInteger := SIZEOF(ControlPointsList[1]) - 1;
 * ControlPoints : ARRAY [0:UUpper] OF ARRAY [0:VUpper] OF IfcCartesianPoint := IfcMakeArrayOfArray(ControlPointsList,
 * 0,UUpper,0,VUpper);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundedsurface.htm">IfcBoundedSurface</a>
 */
public abstract class IfcBoundedSurface extends IfcSurface {


    /**
     * Constructs IfcBoundedSurface with all required attributes.
     */
    public IfcBoundedSurface() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}